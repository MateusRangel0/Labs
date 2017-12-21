import java.util.ArrayList;

public class SiPlaFle {

	private ArrayList<PlanoDeFerias> planos;

	public SiPlaFle() {
		this.planos = new ArrayList<PlanoDeFerias>();
	}

	public void cadastraPlano(String nomePlano, String descricao, int prioridade) {

		for (PlanoDeFerias planoDeFerias : planos) {
			if (planoDeFerias.getNomePlano() == nomePlano) {
				throw new IllegalArgumentException(
						"Nao e possivel cadastrar um plano cujo nome já pertence a outro plano.");
			}
		}

		PlanoDeFerias plano = new PlanoDeFerias(nomePlano, descricao, prioridade);
		planos.add(plano);
	}

	public String recuperaPlano(String nomePlano) {
		for (PlanoDeFerias planoDeFerias : planos) {
			if (planoDeFerias.getNomePlano() == nomePlano) {
				return planoDeFerias.toString();
			}
		}
		return "";
	}

	public String maiorPrioridade() {
		int maior = 0;
		String ret = "";
		for (PlanoDeFerias planoDeFerias : planos) {
			if (planoDeFerias.getPrioridade() >= maior) {
				maior = planoDeFerias.getPrioridade();
				ret = planoDeFerias.toString();
			}
		}
		return ret;
	}
}
