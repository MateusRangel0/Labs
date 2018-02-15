import static org.junit.Assert.*;

import org.junit.Test;

public class ApostaTest {

	@Test(expected = IllegalArgumentException.class)
	public void testApostaNomeApostadorVazio() {
		Aposta aposta = new Aposta("", 100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaNomeApostadorEspacos() {
		Aposta aposta = new Aposta("    ", 100, "VAI ACONTECER");
	}

	@Test(expected = NullPointerException.class)
	public void testApostaNomeApostadorNull() {
		Aposta aposta = new Aposta(null, 100, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testApostaValorNegativo() {
		Aposta aposta = new Aposta("Mateus", -100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaValorZero() {
		Aposta aposta = new Aposta("Mateus", 0, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoVazia() {
		Aposta aposta = new Aposta("Mateus", 100, "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoEspacos() {
		Aposta aposta = new Aposta("Mateus", 100, "    ");
	}

	@Test(expected = NullPointerException.class)
	public void testApostaPrevisaoNull() {
		Aposta aposta = new Aposta("Mateus", 100, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testApostaPrevisaoDiferente() {
		Aposta aposta = new Aposta("Mateus", 100, "ACHO QUE PODE ACONTECER");
	}
	
	@Test
	public void testToString() {
		Aposta aposta = new Aposta("Mateus", 10054, "VAI ACONTECER");
		assertEquals("Não esta igual", "Mateus - R$100,54 - VAI ACONTECER", aposta.toString());
	}
}
