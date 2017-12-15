
package lab05;

public class Aposta {
	
	private String nomeApostador;
	private int valorAposta;
	private String previsao;
	
	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}

	public String getNomeApostador() {
		return nomeApostador;
	}

	public int getValorAposta() {
		return valorAposta;
	}

	public String getPrevisao() {
		return previsao;
	}
	
	public String toString() {
		return nomeApostador + " - " + valorAposta + " - " + previsao;
	}
}