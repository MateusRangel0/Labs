package simulado_again;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColeçãoTest {

	@Test(expected = IllegalArgumentException.class)
	public void adicionaBlurayTituloSoEspacos() {
		String titulo = "    ";
		int duracao = 100;
		Bluray bluray = new Bluray(titulo, duracao);
		fail("Bluray foi criado com titulo feito apenas de espaços");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void adicionaBlurayTituloVazio() {
		String titulo = "";
		int duracao = 100;
		Bluray bluray = new Bluray(titulo, duracao);
		fail("Bluray doi criado com titulo vazio");
	}

}
