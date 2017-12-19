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
			throw new IllegalArgumentException("Previsao invalida!");
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
	 * @return retorna a previssao do cenario
	 */
	public boolean getPrevisao() {
		return previsao;
	}

	/**
	 * Testa se as palavras usadas sao validas
	 * 
	 * @param palavra
	 */
	private void palavraValida(String palavra) {
		if (palavra == null) {
			throw new NullPointerException("Parametro null!");
		} else if (palavra.trim().equals("")) {
			throw new IllegalArgumentException("Palavra vazia!");
		}
	}

	@Override
	public String toString() {
		return nomeApostador + " - " + "R$" + String.format("%.2f", (valorAposta / 100.)) + " - " + previsaoLocal;
	}
}