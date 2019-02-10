import java.util.Scanner;

/**
 * test almacen
 * @author Mario Ortega
 *
 */
public class TestAlmacen {

	static public void main(String[] argv) {

		almacen prueba = new almacen();
		Scanner sc = new Scanner(System.in);
		int opcion;

		mostrarMenu();
		opcion = sc.nextInt();
		while (opcion != 0) {
			procesarOpcion(opcion, prueba);
			mostrarMenu();
			opcion = sc.nextInt();
		}
		sc.close();

	}

	static void mostrarMenu() {
		System.out.println("--- MENÚ DE  CONTROL DEL ALMACÉN -----");
		System.out.println(" 1.- Mostrar contenido del Almacén");
		System.out.println(" 2.- Poner un Valor  ");
		System.out.println(" 3.- Buscar un Valor ");
		System.out.println(" 4.- Borrar un Valor");
		System.out.println(" 5.- Contar posiciones ocupadas.");
		System.out.println(" 6.- Contar posiciones libres.");
		System.out.println(" 7.- Empaquetar");
		System.out.println(" 0.- Terminar");
		System.out.print(" Introduzca una opción:[1-6]:");
	}

	// Procesa la opción introducida operando sobre el objeto almacen
	static void procesarOpcion(int opcion, almacen paralmacen) {
		Scanner entrada = new Scanner(System.in);
		int valor;
		/*un switch para que se ejecuten las opciones del menu
		 */

		switch (opcion) {
		case 1:
			System.out.println("Almacen = " + paralmacen);
			break;
		case 2:
			System.out.print("Introduzca un valor:");
			valor = entrada.nextInt();
			if (paralmacen.ponValor(valor)) {
				System.out.println(" Valor introducido.");
			} else {
				System.out.println(" Error");
			}
			break;
		case 3:
			System.out.print("Valor a buscar:");
			valor = entrada.nextInt();
			if (paralmacen.estaValor(valor)) {
				System.out.println(" El valor se encuentra en la tabla.");
			} else {
				System.out.println(" El valor no se encuentra en la tabla.");
			}
			break;
		case 4:
			System.out.print("Valor a Eliminar:");
			valor = entrada.nextInt();
			if (paralmacen.sacarValor(valor)) {
				System.out.println(" Valor Eliminado.");
			} else {
				System.out.println(" Error");
			}
			break;
		case 5:
			System.out.println("Posiciones Ocupadas" + paralmacen.numPosicionesOcupadas());
			break;
		case 6:
			System.out.println("Posiciones libres" + paralmacen.numPosicionesLibres());
			break;
		case 7:
			 paralmacen.empaquetar();
			break;
		}

	}

}