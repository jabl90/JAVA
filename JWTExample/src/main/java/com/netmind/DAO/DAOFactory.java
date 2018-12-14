package com.netmind.DAO;
//Para instanciar el DAO
public class DAOFactory {

	public static final DAO getDao(String tipo) throws Exception {
		switch (tipo) {
		case "usuario":
			UsuarioDAO uDao = UsuarioDAOImpl.getInstance();
			return uDao;
		}

		return null;
	}

}