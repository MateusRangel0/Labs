/**
 * Classe que representa um Cenario com bonus.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class CenarioComBonus extends Cenario {

	private int bonus;

	/**
	 * Construtor para o cenario com bonus.
	 * 
	 * @param descricao
	 * @param bonus
	 */
	public CenarioComBonus(String descricao, int bonus) {
		super(descricao);
		this.bonus = bonus;
	}

	@Override
	public int getDestinadoVencedores() {
		return super.getDestinadoVencedores() + this.bonus;
	}

	@Override
	public String toString() {
		return String.format("%s - R$ %.2f", super.toString(),
				(this.bonus / 100.));
	}
}
