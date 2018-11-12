import java.util.Random;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] meses = new String[12]; // estamos creando un objeto array. string empieza con mayuscula porque es un
											// objeto.

		meses[0] = "Enero";
		meses[1] = "Febrero";
		meses[2] = "Marzo";
		meses[3] = "Abril";
		meses[4] = "Mayo";
		meses[5] = "Junio";
		meses[6] = "Julio";
		meses[7] = "Agosto";
		meses[8] = "Septiembre";
		meses[9] = "Octubre";
		meses[10] = "Noviembre";
		meses[11] = "Dicembre";

		for (int i = 0; i < meses.length; i++) {
			System.out.println("El mes " + (i + 1) + " es " + meses[i]);
		}

		for (String unMes : meses) { // Iteracion sobre variabl etmeporal. Para cada uno de lso elementos de meses,se
										// guarda en la variable temporal "unmes, es como un forEach "
			System.out.println("Un mes: " + unMes);

		}

		String[] mascotas = new String[100];

		// Llenamos el array, asignadole un valor
		for (int i = 0; i < mascotas.length; i++) {
			mascotas[i] = generarNombre(); //aqui estamos invocando al m�todo
		}

		// Escupimos los valores de cada posici�n del array
		for (int i = 0; i < mascotas.length; i++) {
			System.out.println("El nombre de la mascota es: " + mascotas[i]);
		}

		// Tambi�n lo podr�amos hacer con un for tipo "forEach"

		for (String unaMascota : mascotas) {
			System.out.println(unaMascota);
		}

	} // FIN DEL MAIN
		// vAMOA CREAR UN M�TODO PARA CREAR NOMBRES PARA LAS MASCOTAS DE MANERA
		// ALEATORIA UNIENDO DOS PALABRAS.
		// Definimos un nuevo m�todo

	public static String generarNombre() {// generarNombre es un m�todo, es como si fuera una func�n dentro de la
											// clase, le indicamos que nos va a devolver un valor tipo String (return), en caso contrario dar� error

		String[] nombresSueltos = new String[20];

		nombresSueltos[0] = "paco";
		nombresSueltos[1] = "ronaldo";
		nombresSueltos[2] = "pepe";
		nombresSueltos[3] = "coco";
		nombresSueltos[4] = "vegeta";
		nombresSueltos[5] = "muerde";
		nombresSueltos[6] = "come";
		nombresSueltos[7] = "ben";
		nombresSueltos[8] = "pokemon";
		nombresSueltos[9] = "goku";

		Random rand = new Random(); // hemos importado la clase Random
		int n1 = rand.nextInt(10);
		int n2 = rand.nextInt(10);

		String nombreADevolver = nombresSueltos[n1] + " " + nombresSueltos[n2];

		return nombreADevolver; //nombreADevolver es un tipo String, en caso contrario nos dar�a error.
	}

}