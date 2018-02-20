package lab5_part3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CenarioTest {

	private Cenario cenario;

	public CenarioTest() {
		cenario = new Cenario(1, "situacao");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCenarioSituacaoStringVazia() {
		cenario = new Cenario(1, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCenarioSituacaoStringSoEspacos() {
		cenario = new Cenario(1, "     ");
	}

	@Test(expected = NullPointerException.class)
	public void testCenarioSituacaoStringNull() {
		cenario = new Cenario(1, null);
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

	@Test
	public void testValorTotal() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		assertEquals("Não esta igual", 200, cenario.valorTotal());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalZero() {
		cenario.valorTotal();
	}

	@Test
	public void testExibeApostas() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.cadastrarAposta("Rangel", 200, "N VAI ACONTECER");
		String expected = "Mateus - R$1,00 - VAI ACONTECER" + System.lineSeparator()
				+ "Rangel - R$2,00 - N VAI ACONTECER" + System.lineSeparator();
		assertEquals("Nao esta igual", expected, cenario.exibeApostas());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasZero() {
		cenario.exibeApostas();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFechaApostaJaFinalizado() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.fechaApostas(true);
		cenario.fechaApostas(true);
	}

	@Test
	public void testNumeroDeApostas() {
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		cenario.cadastrarAposta("Mateus", 100, "VAI ACONTECER");
		assertEquals("Não esta igual", 2, cenario.numeroDeApostas());
	}

	@Test
	public void testNumeroDeApostasZero() {
		assertEquals("Nao esta igual", 0, cenario.numeroDeApostas());
	}

	@Test
	public void testToString() {
		Cenario cenario = new Cenario(1, "descricao");
		assertEquals("Nao esta igual", "descricao - Nao finalizado", cenario.toString());
	}

	@Test
	public void testToStringFinalizado() {
		Cenario cenario = new Cenario(1, "descricao");
		cenario.fechaApostas(true);
		assertEquals("Nao esta igual", "descricao - finalizado", cenario.toString());
	}
}
