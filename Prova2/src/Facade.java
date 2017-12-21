
public class Facade {
	private SiPlaFle sistema;

	public Facade() {
		this.sistema = new SiPlaFle();
	}

	public void cadastraPlano(String nomePlano, String descricao, int prioridade) {
		sistema.cadastraPlano(nomePlano, descricao, prioridade);
	}

	public String recuperaPlano(String nomePlano) {
		return sistema.recuperaPlano(nomePlano);
	}

	public String maiorPrioridade() {
		return sistema.maiorPrioridade();
	}
}
