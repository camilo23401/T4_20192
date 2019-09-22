package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = newArray(max);
		tamanoMax = max;
		tamanoAct = 0;
	}

	@SuppressWarnings("unchecked")
	private T[] newArray(int size)
	{
		return (T[]) new Comparable[size]; 	
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos =newArray(tamanoMax);
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public void shellSort() 
	{ 
		int n = tamanoAct; 

		for (int intervalo = n/2; intervalo > 0; intervalo /= 2) 
		{ 
			for (int i = intervalo; i < n; i += 1) 
			{ 
				T temp = elementos[i]; 
				int j; 
				for (j = i; j >= intervalo &&this.darElemento(j-intervalo).compareTo(temp)<0; j -= intervalo) {
					elementos[j] = elementos[j - intervalo]; 
				}

				elementos[j] = temp; 
			} 
		} 

	}
	public T darElemento(int i) {

		return elementos[i];
	}

}
