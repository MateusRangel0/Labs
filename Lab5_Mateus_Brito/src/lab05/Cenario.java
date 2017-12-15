package lab05;

public class Cenario {
	private int numeracao;
	private String descricao;
	private String estado;
	
	
	public Cenario(String descricao) {
			this.descricao = descricao;
			this.estado = "Não finalizado";
	}

	public int getNumeracao() {
		return numeracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEstado() {
		return estado;
	}
	
	public String toString() {
		return numeracao + " - " + descricao + " - " + estado;
	}
}