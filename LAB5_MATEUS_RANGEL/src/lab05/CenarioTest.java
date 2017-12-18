package lab05;

import static org.junit.Assert.*;

import org.junit.Test;

public class CenarioTest {
	
	private Cenario cenario;
	
	public CenarioTest() {
		cenario = new Cenario("situacao");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaNomeApostadorVazio() {
		cenario.cadastrarAposta("", 100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaNomeApostadorEspacos() {
		cenario.cadastrarAposta("    ", 100, "VAI ACONTECER");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaNomeApostadorNull() {
		cenario.cadastrarAposta(null, 100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorNegativo() {
		cenario.cadastrarAposta("Mateus", -100, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorZero() {
		cenario.cadastrarAposta("Mateus", 0, "VAI ACONTECER");
	}
	
	@Test
	public void testValorTotal() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		assertEquals("Não esta igual", 200, cenario.valorTotal());
	}
	
	@Test
	public void testExibeApostas() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.cadastrarAposta("Rangel", 200, "N VAI ACONTECER");
		String expected = "Mateus - R$1,00 - VAI ACONTECER\n" + "Rangel - R$2,00 - N VAI ACONTECER\n";
		assertEquals("Não esta igual", expected, cenario.exibeApostas());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaJaFinalizado() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.fechaApostas(true);
		cenario.fechaApostas(true);	
	}
}
