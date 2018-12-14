package com.netmind.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import com.netmind.DAO.DAOFactory;
import com.netmind.DAO.UsuarioDAO;
import com.netmind.modelos.StatusMessage;
import com.netmind.modelos.Usuario;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/json")
public class JSONService {
	private static Logger logger = Logger.getLogger("JSONService");
	static List<JsonWebKey> jwkList = null;

	static { //generamos las claves y las metemos en JsonwebKey
		logger.info("Inside static initializer...");
		jwkList = new LinkedList<>();
		// Creating three keys, will use one now
		for (int kid = 1; kid <= 3; kid++) {
			JsonWebKey jwk = null;
			try {
				jwk = RsaJwkGenerator.generateJwk(2048); //generamos un código de 20148 bits
				logger.info("PUBLIC KEY (" + kid + "): " + jwk.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY));
			} catch (JoseException e) {
				e.printStackTrace();
			}
			jwk.setKeyId(String.valueOf(kid));
			jwkList.add(jwk);
		}

	}

	@Path("/authenticate")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateCredentials(@HeaderParam("username") String username,
			@HeaderParam("password") String password)
			throws JsonGenerationException, JsonMappingException, IOException {
		logger.info("Authenticating User Credentials...");

		if (username == null) {
			StatusMessage statusMessage = new StatusMessage();
			statusMessage.setStatus(Status.PRECONDITION_FAILED.getStatusCode()); //412
			statusMessage.setMessage("Username value is missing!!!");
			return Response.status(Status.PRECONDITION_FAILED.getStatusCode()).entity(statusMessage).build();
		}

		if (password == null) {
			StatusMessage statusMessage = new StatusMessage();
			statusMessage.setStatus(Status.PRECONDITION_FAILED.getStatusCode());
			statusMessage.setMessage("Password value is missing!!!");
			return Response.status(Status.PRECONDITION_FAILED.getStatusCode()).entity(statusMessage).build();
		}

		Usuario user = null; //inicializamos el usuario
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = (UsuarioDAO) DAOFactory.getDao("usuario"); //Obtenemos una instancia de usuarioDAO
			user = usuarioDAO.getUsuario(username, password); //utilizamos en esa instanci ael método getUsuario
			logger.log(Level.INFO, "user:" + user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user == null) {
			StatusMessage statusMessage = new StatusMessage();
			statusMessage.setStatus(Status.FORBIDDEN.getStatusCode());
			statusMessage.setMessage("Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}

		RsaJsonWebKey senderJwk = (RsaJsonWebKey) jwkList.get(0); //Obtenemos una clave. Va a ser la 1

		senderJwk.setKeyId("1"); //Estamos metiendo la clave 1.
		logger.info("JWK (1) ===> " + senderJwk.toJson());

		// Create the Claims, which will be the content of the JWT
		JwtClaims claims = new JwtClaims(); 
		claims.setIssuer("netmind.com"); // who creates the token and signs it   //Issuer es el que genera la clave, el dueño del token
		claims.setExpirationTimeMinutesInTheFuture(10); // token will expire (10
														// minutes from now)
		claims.setGeneratedJwtId(); // a unique identifier for the token
		claims.setIssuedAtToNow(); // when the token was issued/created (now)
		claims.setNotBeforeMinutesInThePast(2); // time before which the token
												// is not yet valid (2 minutes
												// ago)
		claims.setSubject(user.getEmail()); // the subject/principal is whom //nos permite identificar al usuario en las futuras peticiones que haga
											// the token is about
		claims.setStringListClaim("roles", "client"); //
		// multi-valued claims for roles
		JsonWebSignature jws = new JsonWebSignature();

		jws.setPayload(claims.toJson());

		jws.setKeyIdHeaderValue(senderJwk.getKeyId());
		jws.setKey(senderJwk.getPrivateKey());

		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

		String jwt = null;
		try {
			jwt = jws.getCompactSerialization(); 
		} catch (JoseException e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(jwt).build(); //Nos vevuelve un String (jwt), que es el token
	}

	@GET
	@Path("/owndata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwnData(@HeaderParam("token") String token) {
		logger.log(Level.INFO, "token:" + token);
		String userEmail = "";

		userEmail = this.getUserEmailFromToken(token); //Este metodo nos va adevolver un email y sino exite devuelve un forbidden

		if (userEmail == null) {
			StatusMessage statusMessage = new StatusMessage();
			statusMessage.setStatus(Status.FORBIDDEN.getStatusCode());
			statusMessage.setMessage("Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}

		Usuario user = null;
		UsuarioDAO userDAO;
		int uid = 0;

		try { //Si exite accdemos al DAO y le pedimos el email
			userDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			user = userDAO.getUsuarioByMail(userEmail);
			uid = user.getUid();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(user).build();
	}

	/* AUX */
	private String getUserEmailFromToken(String token) {
		if (token == null)
			return null;

		String userEmail = null;

		try {

			JsonWebKeySet jwks = new JsonWebKeySet(jwkList);
			JsonWebKey jwk = jwks.findJsonWebKey("1", null, null, null); //LA clave privads1 se utiliza para desencriptar el token
			logger.log(Level.INFO, "JWK (1) ===> " + jwk.toJson());
//Claim es cada una de las entradas
			// Validate Token's authenticity and check claims
			JwtConsumer jwtConsumer = new JwtConsumerBuilder().setRequireExpirationTime()
					.setAllowedClockSkewInSeconds(30).setRequireSubject().setExpectedIssuer("netmind.com")
					.setVerificationKey(jwk.getKey()).build();

			// Validate the JWT and process it to the Claims
			JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
			logger.log(Level.INFO, "JWT validation succeeded! " + jwtClaims.getSubject().toString()); //utilizamos el subject porque es la entrada que contiene al email y es el que es ççúnico por cada usuario, lo identifica
			userEmail = jwtClaims.getSubject().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userEmail;
	}

}