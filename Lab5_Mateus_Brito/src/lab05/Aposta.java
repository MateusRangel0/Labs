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

		if (previsao.equals("VAI ACONTECER")) {
			this.previsao = true;
		} else if (previsao.equals("N VAI ACONTECER")) {
			this.previsao = false;
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

	@Override
	public String toString() {
		return nomeApostador + " - " + "R$" + valorAposta / 100. + " - "
				+ previsao;
	}
}