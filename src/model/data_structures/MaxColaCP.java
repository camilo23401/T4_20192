package model.data_structures;

public class MaxColaCP<T extends Comparable<T>> implements IMaxColaCP<T>{

	private int tamanio;

	private NodoColaPrioritaria<T>cabeza;

	private ArregloDinamico<T> listaOrganizada;
	private  NodoColaPrioritaria<T> ultimoAgregado;
	private  NodoColaPrioritaria<T> primerNodo;
	public MaxColaCP() {
		cabeza=null;
		tamanio=0;
	}
	public boolean esVacia() {
		return cabeza==null;
	}

	public int darNumElementos() {
		return tamanio;
	}

	public void agregar(T elem) {
		if(primerNodo==null){
			primerNodo=new NodoColaPrioritaria<T>(elem);
			ultimoAgregado = primerNodo;
			tamanio++;
		}
		else{
			if(ultimoAgregado.darSiguiente()==null)
			{
				NodoColaPrioritaria<T> nuevo = new NodoColaPrioritaria<T>(elem);
				ultimoAgregado.cambiarSiguiente(nuevo);
				ultimoAgregado = nuevo;
				tamanio++;	
			}
		}
	}
	public T sacarMax() {
		ArregloDinamico<T> ordenado=this.pasarAArregloDinamico(cabeza);
		ordenado.shellSort();
		T eliminado=ordenado.darElemento(0);
		this.eliminar(eliminado);
		return eliminado;

	}
	
	public T darMax() {
		ArregloDinamico<T> ordenado=this.pasarAArregloDinamico(cabeza);
		ordenado.shellSort();
		T eliminado=ordenado.darElemento(0);
		return eliminado;

	}
	public ArregloDinamico<T> pasarAArregloDinamico(NodoColaPrioritaria<T>actual) {
		ArregloDinamico<T> nuevo=new ArregloDinamico<T>(10000000);
		while(actual!=null)
		{
			T viajeActual = actual.getLlave();

			nuevo.agregar(viajeActual);

			actual = actual.darSiguiente();
		}
		return nuevo;
	}
	public T eliminar(T dato) {
		NodoColaPrioritaria<T>actual=cabeza;
		NodoColaPrioritaria<T>buscado=null;
		T eliminado=null;

		if(cabeza.getLlave().equals(dato)){
			cabeza=cabeza.darSiguiente();
			tamanio--;
		}
		else{
			while(actual!=null&&!actual.getLlave().equals(dato)){
				buscado=actual;
				actual=actual.darSiguiente();

			}
			eliminado=actual.getLlave();
			buscado.cambiarSiguiente(actual.darSiguiente());
			tamanio--;

		}
		return eliminado;
	}

}
