package lab5_part3;

/**
 * Classe que representa uma aposta.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Aposta {

	private String nomeApostador;
	private int valorAposta;
	private boolean ocorreu;
	private String previsaoLocal;

	/**
	 * Contrutor da classe Aposta.
	 * 
	 * @param nomeApostador
	 *            nome do apostador
	 * @param valorAposta
	 *            valor apostado
	 * @param previsao
	 *            previsao do cenario
	 */
	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		if (nomeApostador == null) {
			throw new NullPointerException(
					"Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (nomeApostador.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}

		if (valorAposta <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}

		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;

		if (previsao == null) {
			throw new NullPointerException(
					"Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (previsao.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}

		if (previsao.equals("VAI ACONTECER")) {
			this.ocorreu = true;
			previsaoLocal = "VAI ACONTECER";
		} else if (previsao.equals("N VAI ACONTECER")) {
			this.ocorreu = false;
			previsaoLocal = "N VAI ACONTECER";
		} else {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Previsao invalida");
		}
	}

	/**
	 * Getter do Nome do Apostador.
	 * 
	 * @return retorna o nome do apostador
	 */
	public String getNomeApostador() {
		return nomeApostador;
	}

	/**
	 * Getter do Valor da Aposta.
	 * 
	 * @return retorna o valor da aposta
	 */
	public int getValorAposta() {
		return valorAposta;
	}

	/**
	 * Getter da Previsão.
	 * 
	 * @return retorna a previsao do cenario
	 */
	public String getPrevisao() {
		return this.previsaoLocal;
	}

	@Override
	public String toString() {
		return nomeApostador + " - " + "R$"
				+ String.format("%.2f", (valorAposta / 100.)) + " - "
				+ previsaoLocal;
	}
}