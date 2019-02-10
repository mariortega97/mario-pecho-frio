import java.util.Arrays;

/**
 * Implementar un almacen de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 * @author mario ortega
 *
 */
public class almacen {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;

	/**
	 * Constructor sin parámetros creo una tabla de 10 elementos
	 */
	public almacen() {
		this(10); // Llamo al constructor con parámetros
	}

	
	/**
	 * @param tamaño del array
	 */
	public almacen(int tamaño) {
		tvalores = new int[tamaño];
		init();
	}

	
	/**
	 * libera todas las posiciones
	 */
	public void init() {
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}

	
	/**
	 * Muestra una cadena con los valores de la tabla 
	 */
	public String toString() {
		return Arrays.toString(tvalores);
	}

	
	/**
	 * @return el numero de posiciones libres
	 */
	public int numPosicionesLibres() {
		return tvalores.length - valoresAlmacenados;
	}

	
	/**
	 * @return el numero de posiciones ocupadas
	 */
	public int numPosicionesOcupadas() {
		return valoresAlmacenados;
	}

	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	
	/**
	 * Indica si el valor se encuentra en la tabla
	 * @param num que se quiere buscar en la tabla
	 * @return true si esta, false si no
	 */
	public boolean estaValor(int num) {
		boolean esta = false;
		
		for (int i = 0; i < tvalores.length; i++) {
			if (tvalores[i] == num) {
				esta = true;
				break;
			}
		}
		return esta;
	}

	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	/**
	 * Introduce un valor en ta tabla
	 * @return devuelve true si puede almacenarlo, devuelve false si no
	 */
	public boolean ponValor (int num){
		boolean pon = false;
		for (int i = 0; i < tvalores.length; i++) {
			  if ( tvalores[i] == LIBRE){
				  tvalores[i] = num;
				  valoresAlmacenados++;
			      pon = true;
				  break;
			  }
		}			
	return pon;
	}

	// Elimina el elemento de la tabla, si no esta devuelve false
	/**
	 * Elimina el elemento de la tabla
	 * @return si saca el valor return true
	 */
	public boolean sacarValor(int num) {
		boolean sacar = false;
		for (int i = 0; i < tvalores.length; i++) {
			if (tvalores[i] == num) {
				tvalores[i] = LIBRE;
				valoresAlmacenados--;
				sacar = true;
				break;
			}
		}
		return sacar;
	}

	// Indica si el almacén esta lleno
	/**
	 * Comprueba si la tabla esta llena
	 * @return true o false
	 */
	public boolean estaLleno() {
		return (valoresAlmacenados == tvalores.length);
	}
	
	// Elimina los huecos intermedios
	/**
	 * Empaquete la tabla eliminando los huecos intermedios
	 */
	public void empaquetar (){
		int prim = 0;
		int tot = tvalores.length -1;
		/*@param prim es el principio de la tabla y total lo que ocupa
		 * si se cumple el if, se añade un hueco desde el principio
		 * y se quite del final para eliminar los intermedios
		 */
			if ( (tvalores [prim] == LIBRE) && (tvalores[tot] != LIBRE)){
				tvalores[prim] = tvalores[tot];
				tvalores[prim] = LIBRE;
				prim++;
				tot--;
			}
		}
}