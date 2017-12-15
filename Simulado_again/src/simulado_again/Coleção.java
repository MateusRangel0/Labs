package simulado_again;

import java.util.Arrays;

public class Coleção {

	private String tituloColecao;
	private Bluray[] colecao;
	private int numeroBlurays;
	private int duracaoTotal;
	
	public Coleção(String tituloColecao, int numeroBlurays, int duracaoTotal) {
		this.tituloColecao = tituloColecao;
		this.colecao = new Bluray[100];
		this.numeroBlurays = numeroBlurays;
		this.duracaoTotal = duracaoTotal;
	}
	
	public void adicionaBluray(String titulo, int numeroBlurays, int duracao) {
		this.duracaoTotal += duracao;
		
		for (int i = 0; i < colecao.length; i++) {
			if (colecao[i] == null) {
				this.colecao[i] = new Bluray(titulo, duracao);
			}
		}
	}
	
	public int duracaoTotal() {
		return duracaoTotal;
	}
	
	public String listaBluray(String titulo) {
		boolean existe = false;
		String ret = "";
		for (int i = 0; i < colecao.length; i++) {
			if (colecao[i].getTitulo().equals(titulo)) {
				existe = true;
				ret = colecao[i].getTitulo() + " / " + colecao[i].getDuracao();
			}
		}
		if (existe == false) {
			ret = null;
		}
		return ret;
	}
	
	public String toString() {
		return "";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Coleção.hashCode(colecao);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Coleção other = (Coleção) obj;
		if (!Arrays.deepEquals(colecao, other.colecao))
			return false;
		
		return true;
	}
}
