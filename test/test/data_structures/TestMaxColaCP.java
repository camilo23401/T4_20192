package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.data_structures.MaxColaCP;

public class TestMaxColaCP {

	private MaxColaCP<String> arreglo;

	
	@Before
	public void setUp1() {
		arreglo=new MaxColaCP<String>();
		arreglo.agregar("c");
		arreglo.agregar("z");
		arreglo.agregar("y");
		arreglo.agregar("l");
		arreglo.agregar("x");
		arreglo.agregar("b");
		arreglo.agregar("c");
		arreglo.agregar("d");
	}
	
	@Test
	public void testArregloDinamico() {
		assertTrue(arreglo!=null);
		assertEquals(8, arreglo.darNumElementos());
		assertEquals("z", arreglo.darMax());
		
	}
}
