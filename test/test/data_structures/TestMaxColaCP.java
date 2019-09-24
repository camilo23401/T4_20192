package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;

public class TestMaxColaCP {

	private MaxHeapCP<Integer> arreglo;


	@Before
	public void setUp1() {
		arreglo=new MaxHeapCP<Integer>(20);
		arreglo.agregar(1);
		arreglo.agregar(5);
		arreglo.agregar(2);
		arreglo.agregar(3);
		arreglo.agregar(8);
		arreglo.agregar(4);

	}

	@Test
	public void testArregloDinamico() {
		assertTrue(arreglo!=null);
		assertEquals(6, arreglo.darNumElementos());
		for (int i = 1; i <= arreglo.darNumElementos(); i++) {
			System.out.println(arreglo.darElementoPos(i));
		}
		
		
	}
}
