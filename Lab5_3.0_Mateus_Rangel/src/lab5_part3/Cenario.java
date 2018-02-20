package lab5_part3;

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
	private int soma_ocorre;
	private int soma_nao_ocorre;
	private int destinadoVencedores;
	private ArrayList<Aposta> apostas;
	private ArrayList<ApostaAssegurada> asseguradas;
	private int totalValor = 0;

	/**
	 * Construtor da classe Cenario.
	 * 
	 * @param descricao
	 *            descricao do cenario
	 */
	public Cenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Parametro nulo!");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.apostas = new ArrayList<Aposta>();
		this.asseguradas = new ArrayList<ApostaAssegurada>();
		this.estado = "Nao finalizado";
		this.soma_nao_ocorre = 0;
		this.soma_ocorre = 0;
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
		Aposta aposta = new Aposta(nomeApostador, valor, previsao);
		if (previsao.equals("N VAI ACONTECER")) {
			this.soma_nao_ocorre += valor;
		} else {
			this.soma_ocorre += valor;
		}
		this.apostas.add(aposta);
	}

	/**
	 * Metodo interno do cenario que cadastra apostas asseguradas por valor no
	 * array de apostas e no array de asseguradas.
	 * 
	 * @param apostador
	 * @param previsao
	 * @param valor
	 * @param seguro
	 */
	public void cadastrarApostaSeguraValor(String apostador,
			String previsao, int valor, int seguro) {
		Tipo seguroValor = new ApostaAsseguradaVal(seguro);
		ApostaAssegurada aposta = new ApostaAssegurada(apostador, valor,
				previsao, seguroValor);

		if (previsao.equals("N VAI ACONTECER")) {
			this.soma_nao_ocorre += valor;
		} else {
			this.soma_ocorre += valor;
		}
		this.asseguradas.add(aposta);
		this.apostas.add(aposta);
	}

	/**
	 * Metodo interno do cenario que cadastra apostas asseguradas por taxa no
	 * array de apostas e no array de asseguradas.
	 * 
	 * @param apostador
	 * @param previsao
	 * @param valor
	 * @param seguro
	 */
	public void cadastrarApostaSeguraTaxa(String apostador,
			String previsao, int valor, double seguro) {
		Tipo seguroTaxa = new ApostaAsseguradaTaxa(seguro, valor);
		ApostaAssegurada aposta = new ApostaAssegurada(apostador, valor,
				previsao, seguroTaxa);

		if (previsao.equals("N VAI ACONTECER")) {
			this.soma_nao_ocorre += valor;
		} else {
			this.soma_ocorre += valor;
		}
		this.asseguradas.add(aposta);
		this.apostas.add(aposta);

	}

	/**
	 * Método interno que calcula o valor das apostas cadastradas ate entao.
	 * 
	 * @return retorna o valor total das apostas
	 */
	public int valorTotal() {

		if (apostas.size() == 0) {
			throw new IllegalArgumentException(
					"Nao erro na consulta do valor total de apostas: Cenario nao cadastradoxistem apostas cadastradas!");
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
			throw new IllegalArgumentException(
					"Nao existem apostas cadastradas!");
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
			throw new IllegalArgumentException(
					"Erro ao fechar aposta: Cenario ja esta fechado");
		}

		this.estado = "finalizado";
	}

	/**
	 * Retorna a quantidadedestinadoCaixa; de apostas feitas.
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
		if (ocorreu) {
			return this.soma_nao_ocorre;
		}
		return this.soma_ocorre;
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

	/**
	 * Getter para a lista de apostas asseguradas.
	 * 
	 * @return
	 */
	public ArrayList<ApostaAssegurada> getAsseguradas() {
		return asseguradas;
	}

	@Override
	public String toString() {
		return descricao + " - " + estado;
	}
}