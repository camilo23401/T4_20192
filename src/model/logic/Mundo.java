package model.logic;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;

public class Mundo 
{

	private CSVReader lector;
	private MaxColaCP<TravelTime> colaCP;
	private MaxHeapCP<TravelTime>colaHeap;
	public Mundo() throws IOException
	{
		colaCP = new MaxColaCP<TravelTime>();
		colaHeap= new MaxHeapCP<TravelTime>(30000000);
		this.LoadTravelTimes();
	}
	//Comentario a monitores:  cargar los viajes se demora un poco menos de 1 minuto hay que darle un poco de tiempo :)

	public void LoadTravelTimes() throws IOException
	{
		TravelTime viaje = null;
		int contador = 0;
		String ruta1 = "data/bogota-cadastral-2018-1-All-HourlyAggregate.csv";
		lector = new CSVReader(new FileReader(ruta1));
		String [] siguiente;
		while ((siguiente = lector.readNext()) != null) 
		{
			if(contador!=0)
			{
				viaje = new TravelTime(1, Integer.parseInt(siguiente[0]), Integer.parseInt(siguiente[1]), Integer.parseInt(siguiente[2]), Double.parseDouble(siguiente[3]),Double.parseDouble(siguiente[4]));
				colaCP.agregar(viaje);
				colaHeap.agregar(viaje);
				
			}
			
			contador++;
		}
		lector.close();
		String ruta2 = "data/bogota-cadastral-2018-2-All-HourlyAggregate.csv";
		int contador2 = 0;
		lector = new CSVReader(new FileReader(ruta2));
		String [] siguiente2;
		while ((siguiente2 = lector.readNext()) != null) 
		{
			if(contador2!=0)
			{
				viaje = new TravelTime(2, Integer.parseInt(siguiente2[0]), Integer.parseInt(siguiente2[1]), Integer.parseInt(siguiente2[2]), Double.parseDouble(siguiente2[3]),Double.parseDouble(siguiente2[4]));
				colaCP.agregar(viaje);
				colaHeap.agregar(viaje);
			}
			contador2++;
		}
		System.out.println("Se terminaron de cargar todos los viajes, el numero total fue: "+colaCP.darNumElementos());
		lector.close();
	}

	public MaxColaCP<TravelTime>generarMuestra(int cantidad){
		MaxColaCP<TravelTime>muestra=new MaxColaCP<TravelTime>();	
		while(cantidad>0) {
			double x = (Math.random()*((colaCP.darNumElementos()+1))); 
			int pos=(int) Math.round(x);
			System.out.println(pos);
			muestra.agregar(colaCP.darElemento(pos));
			cantidad--;
		}
		return muestra;
	}
	
	public MaxHeapCP<TravelTime>generarMuestraHeap(int cantidad){
		MaxHeapCP<TravelTime>muestra=new MaxHeapCP<TravelTime>(cantidad);	
		while(cantidad>0) {
			double x = (Math.random()*((colaCP.darNumElementos()+1))); 
			int pos=(int) Math.round(x);
			System.out.println(pos);
			muestra.agregar(colaCP.darElemento(pos));
			cantidad--;
		}
		return muestra;
	}
	
	public MaxColaCP<TravelTime> darColaCP() {
		return colaCP;
	}
	
	public MaxHeapCP<TravelTime> darColaHeap() {
		return colaHeap;
	}
	
	public MaxColaCP<TravelTime>viajesEntreHorasCP(int hInicial,int hFinal) {
		MaxColaCP<TravelTime>retorno=new MaxColaCP<TravelTime>();
		for (int i = 0; i < colaCP.darNumElementos(); i++) {
			TravelTime actual=colaCP.darElemento(i);
			if(actual.darHod()>hInicial&&actual.darHod()<hFinal) {
				retorno.agregar(actual);
			}
		}
		return retorno;
	}
	public MaxColaCP<TravelTime>viajesEntreHorasCola(int hInicial,int hFinal) {
		MaxColaCP<TravelTime>retorno=new MaxColaCP<TravelTime>();
		for (int i = 0; i < colaCP.darNumElementos(); i++) {
			TravelTime actual=colaCP.darElemento(i);
			if(actual.darHod()>hInicial&&actual.darHod()<hFinal) {
				retorno.agregar(actual);
			}
		}
		return retorno;
	}
	public MaxHeapCP<TravelTime>viajesEntreHorasHeap(int hInicial,int hFinal) {
		MaxHeapCP<TravelTime>retorno=new MaxHeapCP<TravelTime>(2000000);
		for (int i = 0; i < colaHeap.darNumElementos(); i++) {
			TravelTime actual=colaHeap.darElementoPos(i);
			if(actual.darHod()>hInicial&&actual.darHod()<hFinal) {
				retorno.agregar(actual);
			}
		}
		return retorno;
	}
	
	public MaxColaCP <TravelTime> crearMaxColaCP (int N,int hInicial, int hFinal){
		MaxColaCP<TravelTime>lista=this.viajesEntreHorasCola(hInicial, hFinal);
		MaxColaCP<TravelTime>retorno=new MaxColaCP<TravelTime>();
		ArregloDinamico<TravelTime> organizado=lista.pasarAArregloDinamico(lista.darCabeza());
		organizado.shellSort();
		for(int i=0;i<N;i++) {
			retorno.agregar(organizado.darElemento(i));
		}
		return retorno;
	}
	public MaxHeapCP <TravelTime> crearMaxHeapCP (int N,int hInicial, int hFinal){
		
		MaxHeapCP<TravelTime>lista=this.viajesEntreHorasHeap(hInicial, hFinal);
		MaxHeapCP<TravelTime>retorno=new MaxHeapCP<TravelTime>(2000000);
		ArregloDinamico<TravelTime> organizado=lista.pasarAArregloDinamico();
		organizado.shellSort();
		for(int i=0;i<N;i++) {
			retorno.agregar(organizado.darElemento(i));
		}
		return retorno;
		
		
	} 


}
