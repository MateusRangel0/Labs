/**
 * Classe que representa uma aposta assegurada por taxa.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class ApostaAsseguradaTaxa extends Tipo {
	private double taxa;
	private double saque;

	/**
	 * Contrutor para a aposta assegurada por taxa.
	 * 
	 * @param taxa
	 * @param total
	 */
	public ApostaAsseguradaTaxa(double taxa, int total) {
		this.taxa = taxa;
		this.saque = total * taxa;
	}

	@Override
	public int saque() {
		return (int) this.saque;
	}

	@Override
	public String toString() {
		return String.format("- ASSEGURADA (TAXA) - %.2f", taxa);
	}
}
