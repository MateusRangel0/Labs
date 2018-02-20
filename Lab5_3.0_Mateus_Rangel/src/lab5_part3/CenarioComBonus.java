package lab5_part3;

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
	public CenarioComBonus(int indice, String descricao, int bonus) {
		super(indice, descricao);
		if (bonus == 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = bonus;
	}

	@Override
	public int getDestinadoVencedores() {
		return super.getDestinadoVencedores() + this.bonus;
	}

	@Override
	public String toString() {
		return String.format("%s - R$ %.2f", super.toString(), (this.bonus / 100.));
	}
}
