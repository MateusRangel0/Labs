import static org.junit.Assert.*;

import org.junit.Test;

public class SemaforoTest {
	
	@Test
	public void testeToString() {
		Semaforo sinal = new Semaforo(1);
		assertEquals("Não esta igual", "Sinal -- 0 -- VERMELHO", sinal.toString());
	}

	@Test
	public void testeMudar1() {
		Semaforo sinal = new Semaforo(1);
		sinal.mudar();
		assertEquals("Não esta igual", "Sinal -- 1 -- VERDE", sinal.toString());
		
	}
	
	@Test
	public void testeMudar2() {
		Semaforo sinal = new Semaforo(2);
		sinal.mudar();
		sinal.mudar();
		assertEquals("Não esta igual", "Sinal -- 2 -- AMARELO", sinal.toString());
		
	}
	
	@Test
	public void testeMudar3() {
		Semaforo sinal = new Semaforo(2);
		sinal.mudar();
		sinal.mudar();
		sinal.mudar();
		assertEquals("Não esta igual", "Sinal -- 3 -- VERMELHO", sinal.toString());
		
	}
	@Test
	public void testeMudar4() {
		Semaforo sinal = new Semaforo(2);
		sinal.mudar();
		sinal.mudar();
		sinal.mudar();
		sinal.mudar();
		assertEquals("Não esta igual", "Sinal -- 4 -- VERDE", sinal.toString());
		
	}
	
}
