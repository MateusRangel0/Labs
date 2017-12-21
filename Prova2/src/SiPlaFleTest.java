import static org.junit.Assert.*;

import org.junit.Test;

public class SiPlaFleTest {

	private SiPlaFle sistema;

	public SiPlaFleTest() {
		sistema = new SiPlaFle();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoNomePlanoVazio() {
		sistema.cadastraPlano("", "descricao", 8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoNomePlanoSoEspacos() {
		sistema.cadastraPlano("    ", "descricao", 8);
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraPlanoNomePlanoNull() {
		sistema.cadastraPlano(null, "descricao", 8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoNomeJaCadastrado() {
		sistema.cadastraPlano("nome", "descricao", 8);
		sistema.cadastraPlano("nome", "descricao2", 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoDescricaoVazia() {
		sistema.cadastraPlano("nome", "", 8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoDescricaoSoEspacos() {
		sistema.cadastraPlano("nome", "    ", 8);
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraPlanoDescricaoNull() {
		sistema.cadastraPlano("nome", null, 8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoPrioridadeZero() {
		sistema.cadastraPlano("nome", "descricao", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPlanoPrioridadeNegativa() {
		sistema.cadastraPlano("nome", "descricao", -8);
	}

	@Test
	public void testCadastraPlano() {
		sistema.cadastraPlano("nome", "descricao", 8);
	}

	@Test
	public void testRecuperaAluno() {
		sistema.cadastraPlano("nome", "descricao", 8);
		assertEquals("nao esta igual", "nome (8) - descricao", sistema.recuperaPlano("nome"));
	}

	@Test
	public void testRecuperaAluno2() {
		sistema.cadastraPlano("nome", "descricao", 8);
		sistema.cadastraPlano("nome2", "descricao2", 9);
		sistema.cadastraPlano("nome3", "descricao3", 10);
		assertEquals("nao esta igual", "nome2 (9) - descricao2", sistema.recuperaPlano("nome2"));
	}

	@Test
	public void testRecuperaALuno3() {
		assertEquals("nao esta igual", "", sistema.recuperaPlano("nome"));
	}

	@Test
	public void testMaiorPrioridade() {
		sistema.cadastraPlano("nome", "descricao", 8);
		sistema.cadastraPlano("nome2", "descricao2", 10);
		sistema.cadastraPlano("nome3", "descricao3", 9);
		assertEquals("nao esta igual", "nome2 (10) - descricao2", sistema.maiorPrioridade());
	}

	@Test
	public void testMaiorPrioridade2() {
		assertEquals("nao esta igual", "", sistema.maiorPrioridade());
	}

}
