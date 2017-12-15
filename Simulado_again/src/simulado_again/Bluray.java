package simulado_again;

public class Bluray {
	private String titulo;
	private int duracao;

	public Bluray(String titulo, int duracao) {

		if (titulo.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		
		if (titulo == null) {
			throw new NullPointerException();
		}
		
		this.titulo = titulo;
		this.duracao = duracao;
	}

	public String toString() {
		return titulo + " / " + duracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracao() {
		return duracao;
	}
}
