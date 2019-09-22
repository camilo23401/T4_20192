package model.data_structures;

public interface IArregloDinamico<T> {

	/**
	 * Retornar el numero de elementos maximo en el arreglo
	 * @return
	 */
	int darCapacidad( );

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int darTamano( );
	


	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */
	public void agregar( T dato );
		


}
