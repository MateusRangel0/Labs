import static org.junit.Assert.*;

import org.junit.Test;

public class PlanoDeFeriasTest {

	@Test(expected = IllegalArgumentException.class)
	public void testPlanoDeFeriasNomePlanoVazio() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("", "descricao", 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlanoDeFeriasNomePlanoSoEspacos() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("    ", "descricao", 8);
	}
	
	@Test(expected = NullPointerException.class)
	public void testPlanoDeFeriasNomePlanoNull() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias(null, "descricao", 8);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void testPlanoDeFeriasDescricaoVazia() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("nome", "", 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlanoDeFeriasDescricaoSoEspacos() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("nome", "     ", 8);
	}
	
	@Test(expected = NullPointerException.class)
	public void testPlanoDeFeriasDescricaoNull() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("nome", null, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlanoDeFeriasPrioridadeZero() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("nome", "descricao", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlanoDeFeriasPrioridadeNegativa() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("nome", "descricao", -8);
	}
	
	@Test
	public void testPlanoDeFerias() {
		PlanoDeFerias planoDeFerias = new PlanoDeFerias("nome", "descricao", 8);
	}
	
}
