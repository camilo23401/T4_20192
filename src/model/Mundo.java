package model;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.MaxColaCP;

public class Mundo 
{

	private CSVReader lector;
	private MaxColaCP<TravelTime> colaCP;

	public Mundo()
	{
		colaCP = new MaxColaCP<TravelTime>();
	}

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
				System.out.println("Añadí");
			}
			contador++;
		}
		lector.close();
		System.out.println(colaCP.darNumElementos());
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
			}
			contador2++;
		}
		System.out.println(colaCP.darNumElementos());
		lector.close();
	}
}
