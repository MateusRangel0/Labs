/**
 * Classe filha que representa uma aposta assegurada por valor.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class ApostaAsseguradaVal extends Tipo {
	private int valor;

	/**
	 * Construtor da classe de aposta assegurada por valor.
	 * 
	 * @param valor
	 */
	public ApostaAsseguradaVal(int valor) {
		this.valor = valor;
	}

	public int saque() {
		return this.valor;
	}

	@Override
	public String toString() {
		return String.format("- ASSEGURADA (VALOR) - R$ %.2f", valor);
	}
}
