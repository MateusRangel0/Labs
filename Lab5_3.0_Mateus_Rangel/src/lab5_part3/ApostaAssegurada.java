package lab5_part3;

/**
 * Classe que representa uma aposta assegurada.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class ApostaAssegurada extends Aposta {
	private Tipo seguro;

	/**
	 * Contrutor da classe de aposta assegurada.
	 * 
	 * @param nomeApostador
	 * @param valorAposta
	 * @param previsao
	 * @param seguro
	 */
	public ApostaAssegurada(String nomeApostador, int valorAposta,
			String previsao, Tipo seguro) {
		super(nomeApostador, valorAposta, previsao);
		this.seguro = seguro;
	}

	/**
	 * Muda o tipo para o desejado.
	 * 
	 * @param seguro
	 */
	public void mudaTipo(Tipo seguro) {
		this.seguro = seguro;
	}

	/**
	 * Getter para o saque.
	 * 
	 * @return
	 */
	public int getSaque() {
		return this.seguro.saque();
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.seguro.toString();
	}
}
