package lab5_part3;

/**
 * Classe que representa uma aposta.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Aposta {
	
	private String previsao;
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
	
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		
		this.previsao = previsao;
		
		if (previsao.equals("VAI ACONTECER")) {
			this.ocorreu = true;
			previsaoLocal = "VAI ACONTECER";
		} else if (previsao.equals("N VAI ACONTECER")) {
			this.ocorreu = false;
			previsaoLocal = "N VAI ACONTECER";
		}
	}

	/**
	 * Getter do Nome do Apostador.
	 * 
	 * @return retorna o nome do apostador
	 */
	public String getNomeApostador() {
		return this.nomeApostador;
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