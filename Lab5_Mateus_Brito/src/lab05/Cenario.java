package lab05;

import java.util.ArrayList;

/**
 * Classe que representa um cenário.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Cenario {
	private int numeracao;
	private String descricao;
	private String estado;
	private boolean ocorreu;
	private int destinadoCaixa;
	private int destinadoVencedores;
	private ArrayList<Aposta> apostas;

	/**
	 * Construtor da classe Cenario.
	 * 
	 * @param descricao
	 *            descrição do cenário
	 */
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.apostas = new ArrayList<>();
		this.estado = "Não finalizado";
	}

	/**
	 * Método interno do cenário que cadastra as apostas no array de apostas.
	 * 
	 * @param nomeApostador
	 *            nome do apostador
	 * @param valor
	 *            valor apostado
	 * @param previsao
	 *            previsão do cenário
	 */
	public void cadastrarAposta(String nomeApostador, int valor, String previsao) {
		Aposta aposta = new Aposta(nomeApostador, valor, previsao);
		this.apostas.add(aposta);
	}

	/**
	 * Método interno que calcula o valor das apostas cadastradas até então.
	 * 
	 * @return retorna o valor total das apostas
	 */
	public int valorTotal() {
		int total = 0;
		for (Aposta aposta : apostas) {
			total += aposta.getValorAposta();
		}
		return total;
	}

	/**
	 * Método interno que soma as representações textuais dos cenários em uma
	 * variável.
	 * 
	 * @return retorna a variável com as representações textuais dos cenários
	 */
	public String exibeApostas() {
		String ret = "";
		for (Aposta aposta : apostas) {
			ret += aposta.toString() + System.lineSeparator();
		}
		return ret;
	}

	/**
	 * Método interno que fecha as apostas e e soma os valores ao caixa ou aos
	 * vencedores.
	 * 
	 * @param ocorreu
	 *            boolean que representa se ocorreu ou não
	 */
	public void fechaApostas(boolean ocorreu) {
		this.ocorreu = ocorreu;
		for (Aposta aposta : apostas) {
			if (aposta.getPrevisao() != this.ocorreu) {
				this.destinadoCaixa += aposta.getValorAposta();
			} else {
				this.destinadoVencedores += aposta.getValorAposta();
			}
		}
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
	 * Getter para numeração.
	 * 
	 * @return retorna a numeração do cenário
	 */
	public int getNumeracao() {
		return numeracao;
	}

	/**
	 * Getter para descrição.
	 * 
	 * @return retorna a descrição do cenário
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Getter para o estado.
	 * 
	 * @return retorna o estado do cenário
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
		return numeracao + " - " + descricao + " - " + estado;
	}
}