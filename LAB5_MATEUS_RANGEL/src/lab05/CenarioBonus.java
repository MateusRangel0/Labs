package lab05;

public class CenarioBonus extends Cenario {
	private int bonus;

	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return getDescricao() + " - " + getEstado() + " - " + bonus;
	}	
}
