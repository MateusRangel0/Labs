package lab5_part3;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralControllerTest {

	private GeneralController gc;

	public GeneralControllerTest() {
		gc = new GeneralController(100, 2.5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCaixaValorNegativo() {
		GeneralController controlador = new GeneralController(-100, 2.5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTaxaValorNegativo() {
		GeneralController controlador = new GeneralController(100, -2.5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioDescricaoVazia() {
		gc.cadastraCenario("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioDescricaoSoEspacos() {
		gc.cadastraCenario("    ");
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraCenarioDescricaoNull() {
		gc.cadastraCenario(null);
	}

	@Test
	public void testCadastraCenario() {
		assertEquals("Nao esta igual", 1, gc.cadastraCenario("descricao"));
	}

	@Test
	public void testCadastraCenario2() {
		gc.cadastraCenario("descricao");
		assertEquals("Nao esta igual", 2, gc.cadastraCenario("descricao"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioInvalido() {
		gc.cadastraCenario("descricao");
		gc.exibirCenario(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioNumeroNegativo() {
		gc.cadastraCenario("descricao");
		gc.exibirCenario(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testListaCenariosZero() {
		gc.listaCenarios();
	}

	@Test
	public void testListaCenarios() {
		gc.cadastraCenario("descricao");
		assertEquals("Nao esta igual", "1 - descricao - Nao finalizado" + System.lineSeparator(), gc.listaCenarios());
	}

	@Test
	public void testListaCenarios2() {
		gc.cadastraCenario("bla");
		gc.cadastraCenario("bla bla");
		String expected = "1 - bla - Nao finalizado" + System.lineSeparator() + "2 - bla bla - Nao finalizado"
				+ System.lineSeparator();
		assertEquals("Nao esta igual", expected, gc.listaCenarios());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasNumeracaoInvalida() {
		gc.cadastrarApostas(0, "Mateus", 100, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasNumeracaoInvalida2() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(3, "Mateus", 100, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasNomeApostadorVazio() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "", 100, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasNomeApostadorSoEspacos() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "    ", 100, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasValorZero() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 0, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasValorNegativo() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", -100, "VAI ACONTECER");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasStringPrevisaoVazia() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasStringPrevisaoSoEspacos() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "    ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostasStringPrevisaoInvalida() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "ACHO QUE VAI ACONTECER");
	}

	@Test(expected = NullPointerException.class)
	public void testCadastrarApostasStringPrevisaoNull() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasNumeracaoZero() {
		gc.valorTotalDeApostas(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasNumeracaoNegativo() {
		gc.valorTotalDeApostas(-100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasNumeracaoInvalida() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		gc.valorTotalDeApostas(8);
	}

	@Test
	public void testValorTotalDeApostas() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		assertEquals("Nao esta igual", 100, gc.valorTotalDeApostas(1));
	}

	@Test
	public void testValorTotalDeApostas2() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		gc.cadastrarApostas(1, "Rangel", 200, "VAI ACONTECER");
		assertEquals("Nao esta igual", 300, gc.valorTotalDeApostas(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTotalApostasNumeracaoNegativa() {
		gc.totalApostas(-12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTotalApostasNumeracaoZero() {
		gc.totalApostas(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTotalApostasNumeracaoInvalida() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		gc.totalApostas(5);
	}

	@Test
	public void testTotalApostas() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		assertEquals("Nao esta igual", 1, gc.totalApostas(1));
	}

	@Test
	public void testTotalApostas2() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		gc.cadastrarApostas(1, "Rangel", 100, "VAI ACONTECER");
		assertEquals("Nao esta igual", 2, gc.totalApostas(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasNumeracaoNegativa() {
		gc.exibeApostas(-100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasNumeracaoZero() {
		gc.exibeApostas(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibeApostasNumeracaoInvalida() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		gc.exibeApostas(5);
	}

	@Test
	public void testExibeApostas() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		assertEquals("Nao esta igual", "Mateus - R$1,00 - VAI ACONTECER" + System.lineSeparator(), gc.exibeApostas(1));
	}

	@Test
	public void testExibeApostas2() {
		gc.cadastraCenario("descricao");
		gc.cadastrarApostas(1, "Mateus", 100, "VAI ACONTECER");
		gc.cadastrarApostas(1, "Rangel", 200, "VAI ACONTECER");
		String expected = "Mateus - R$1,00 - VAI ACONTECER" + System.lineSeparator() + "Rangel - R$2,00 - VAI ACONTECER" + System.lineSeparator();
		assertEquals("Nao esta igual", expected, gc.exibeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostasNumeracaoNegativa() {
		gc.fecharApostas(-100, true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostasNumeracaoZero() {
		gc.fecharApostas(-100, true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioNumeracaoNegativa() {
		gc.getCaixaCenario(-100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioNumeracaoZero() {
		gc.getCaixaCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioNumeracaoNegativa() {
		gc.getTotalRateioCenario(-100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioNumeracaoZero() {
		gc.getTotalRateioCenario(0);
	}
}
