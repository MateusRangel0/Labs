package lab05;

import java.util.ArrayList;

/**
 * Classe que representa um cenario.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Cenario {
	private String descricao;
	private String estado;
	private boolean ocorreu;
	private int destinadoCaixa;
	private int destinadoVencedores;
	private ArrayList<Aposta> apostas;
	private int totalValor = 0;

	/**
	 * Construtor da classe Cenario.
	 * 
	 * @param descricao
	 *            descricao do cenario
	 */
	public Cenario(String descricao) {
		palavraValida(descricao);
		this.descricao = descricao;
		this.apostas = new ArrayList<>();
		this.estado = "Nao finalizado";
		
	}
	
	/**
	 * Testa se as palavras usadas sao validas
	 * 
	 * @param palavra
	 */
	private void palavraValida(String palavra) {
		if (palavra == null) {
			throw new NullPointerException("Parametro null!");
		} else if (palavra.trim().equals("")) {
			throw new IllegalArgumentException("Palavra vazia!");
		}
	}

	/**
	 * Metodo interno do cenario que cadastra as apostas no array de apostas.
	 * 
	 * @param nomeApostador
	 *            nome do apostador
	 * @param valor
	 *            valor apostado
	 * @param previsao
	 *            previsao do cenario
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao) {
		palavraValida(nomeApostador);
		palavraValida(previsao);
		
		if (valor < 0) {
			throw new IllegalArgumentException("Aposta com valor negativo!");
		}
		else if (valor == 0) {
			throw new IllegalArgumentException("Aposta com valor zero!");
		}
		Aposta aposta = new Aposta(nomeApostador, valor, previsao);
		this.apostas.add(aposta);
	}

	/**
	 * MÃ©todo interno que calcula o valor das apostas cadastradas ate entao.
	 * 
	 * @return retorna o valor total das apostas
	 */
	public int valorTotal() {
		
		if (apostas.size() == 0) {
			throw new IllegalArgumentException("Não existem apostas cadastradas!");
		}
		totalValor = 0;
		for (Aposta aposta : apostas) {
			totalValor += aposta.getValorAposta();
		}
		return totalValor;
	}

	/**
	 * Metodo interno que soma as representacoes textuais dos cenarios em uma
	 * variavel.
	 * 
	 * @return retorna a variavel com as representacoes textuais dos cenarios
	 */
	public String exibeApostas() {
		if (apostas.size() == 0) {
			throw new IllegalArgumentException("Não existem apostas cadastradas!");
		}
		String ret = "";
		for (Aposta aposta : apostas) {
			ret += aposta.toString() + System.lineSeparator();
		}
		return ret;
	}

	/**
	 * Metodo interno que fecha as apostas e e soma os valores ao caixa ou aos
	 * vencedores. Tambem classifica o estado do cenario como finalizado.
	 * 
	 * @param ocorreu
	 *            boolean que representa se ocorreu ou nao
	 */
	public void fechaApostas(boolean ocorreu) {
		this.ocorreu = ocorreu;
		
		if (this.estado == "finalizado") {
			throw new IllegalArgumentException("Cenario ja esta finalizado!");
		}
		
		for (Aposta aposta : apostas) {
			if (aposta.getPrevisao() == this.ocorreu) {
				this.destinadoVencedores += aposta.getValorAposta();
			}
			this.destinadoCaixa += aposta.getValorAposta();
		}
		this.estado = "finalizado";
	}

	/**
	 * Retorna a quantidade de apostas feitas.
	 * 
	 * @return retorna o total de apostas
	 */
	public int numeroDeApostas() {
		return this.apostas.size();
	}

	/**
	 * Getter para descricao.
	 * 
	 * @return retorna a descricao do cenario
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Getter para o estado.
	 * 
	 * @return retorna o estado do cenario
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Getter para o valor destinado ao caixa.
	 * 
	 * @return retorna o valor destinado ao caixa
	 */
	public int getDestinadoCaixa() {
		return destinadoCaixa;
	}
	
	/**
	 * Getter para o valor destinado aos apostadores vencedores.
	 * 
	 * @return retorna o valor destinado aos vencedores
	 */
	public int getDestinadoVencedores() {
		return destinadoVencedores;
	}
	
	/**
	 * Getter para a lista de apostas.
	 * 
	 * @return retorna a lista de apostas
	 */
	public ArrayList<Aposta> getApostas() {
		return apostas;
	}
	
	@Override
	public String toString() {
		return descricao + " - " + estado;
	}
}