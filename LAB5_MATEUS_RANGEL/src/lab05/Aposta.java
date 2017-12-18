package lab05;

/**
 * Classe que representa uma aposta.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Aposta {

	private String nomeApostador;
	private int valorAposta;
	private boolean previsao;
	String previsaoLocal;

	/**
	 * Contrutor da classe Aposta.
	 * 
	 * @param nomeApostador
	 *            nome do apostador
	 * @param valorAposta
	 *            valor apostado
	 * @param previsao
	 *            previsão do cenário
	 */
	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;

		palavraValida(nomeApostador);
		palavraValida(previsao);

		if (this.valorAposta < 0) {
			throw new IllegalArgumentException("Aposta com valor negativo!");
		} else if (this.valorAposta == 0) {
			throw new IllegalArgumentException("Aposta com valor zero!");
		}

		if (previsao.equals("VAI ACONTECER")) {
			this.previsao = true;
			previsaoLocal = "VAI ACONTECER";
		} else if (previsao.equals("N VAI ACONTECER")) {
			this.previsao = false;
			previsaoLocal = "N VAI ACONTECER";
		} else {
			throw new IllegalArgumentException("Previsão diferente!");
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
	 * @return retorna a previsão do cenário
	 */
	public boolean getPrevisao() {
		return previsao;
	}

	/**
	 * Testa se as palavras usadas são válidas
	 * 
	 * @param palavra
	 */
	private void palavraValida(String palavra) {
		if (palavra == null) {
			throw new NullPointerException("Parâmetro null!");
		} else if (palavra.trim().equals("")) {
			throw new IllegalArgumentException("Palavra vazia!");
		}
	}

	@Override
	public String toString() {
		return nomeApostador + " - " + "R$" + String.format("%.2f", (valorAposta / 100.)) + " - " + previsaoLocal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeApostador == null) ? 0 : nomeApostador.hashCode());
		result = prime * result + (previsao ? 1231 : 1237);
		result = prime * result + valorAposta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Aposta)) {
			return false;
		}
		Aposta other = (Aposta) obj;
		if (nomeApostador == null) {
			if (other.nomeApostador != null) {
				return false;
			}
		} else if (!nomeApostador.equals(other.nomeApostador)) {
			return false;
		}
		if (previsao != other.previsao) {
			return false;
		}
		if (valorAposta != other.valorAposta) {
			return false;
		}
		return true;
	}
}