
public class PlanoDeFerias {

	private String nomePlano;
	private String descricao;
	private int prioridade;

	public PlanoDeFerias(String nomePlano, String descricao, int prioridade) {
		if (prioridade <= 0) {
			throw new IllegalArgumentException(
					"Nao e possivel cadastrar um plano com prioridade menor ou igual a zero.");
		}
		if (nomePlano.trim().equals("") || nomePlano == null) {
			throw new IllegalArgumentException("Nao e possivel cadastrar um plano com nome vazio ou nulas");
		}
		if (descricao.trim().equals("") || descricao == null) {
			throw new IllegalArgumentException("Nao e possivel cadastrar um plano com descricao vazia ou nulas");
		}

		this.nomePlano = nomePlano;
		this.descricao = descricao;
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return nomePlano + " (" + prioridade + ")" + " - " + descricao;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}
}
