package lab05;

import java.util.ArrayList;

/**
 * Classe que controla os cenarios e suas apostas.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class GeneralController {

	private int caixa;
	private double taxa;
	private ArrayList<Cenario> cenarios;

	/**
	 * Construtor da classe GeneralController
	 * 
	 * @param caixa
	 *            quantidade atual de dinheiro
	 * @param taxa
	 *            porcentagem que deve ser retirada de cada aposta perdedora
	 */
	public GeneralController(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		} if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<Cenario>();
	}

	/**
	 * Recuperar o valor em caixa do sistema.
	 * 
	 * @return retorna o valor em caixa
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Testa se as palavras usadas sao validas.
	 * 
	 * @param palavra
	 */
	private void palavraValida(String palavra) {
		if (palavra == null) {
			throw new NullPointerException("Parametro nulo!");
		} else if (palavra.trim().equals("")) {
			throw new IllegalArgumentException("Palavra vazia!");
		}
	}
	
	/**
	 * Testa se a numeracao usada e valida.
	 */
	private void numeracaoValida(int numeracao) {
		if (numeracao < 0 || numeracao >= cenarios.size()) {
			throw new IllegalArgumentException("Numeracao do cenario invalida!");
		}
	}

	/**
	 * Cadastra novos cenarios.
	 * 
	 * @param descricao
	 *            descricao da situacao trabalhada no cenario
	 * @return retorna a numeracao do cenario
	 */
	public int cadastraCenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Parametro nulo!");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenarios.size();
	}

	/**
	 * * Retorna a representacao textual de um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna a representacao textual do cenario
	 */
	public String exibirCenario(int numeracao) {
		if (numeracao < 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (numeracao >= cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return numeracao + " - " + cenarios.get(numeracao-1).toString();
	}

	/**
	 * Retornar a representacao textual de todos os cenarios cadastrados no
	 * sistema.
	 * 
	 * @return retorna a representacao textual dos cenarios cadastrados
	 */
	public String listaCenarios() {
		if (cenarios.size() == 0) {
			throw new IllegalArgumentException("Nao existem cenarios cadastrados!");
		}
		String ret = "";
		int aux = 1;
		for (Cenario cenario : cenarios) {
			ret += aux + " - " +  cenario.toString() + System.lineSeparator();
			aux++;
		}
		return ret;
	}

	/**
	 * Cadastrar uma nova aposta.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @param apostador
	 *            nome do apostador
	 * @param valor
	 *            quantia apostada
	 * @param previsao
	 *            previsao
	 */
	public void cadastrarApostas(int numeracao, String Apostador, int valor,
			String previsao) {
		numeracaoValida(numeracao-1);
		palavraValida(Apostador);
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor invalido!");
		}
		cenarios.get(numeracao-1).cadastrarAposta(Apostador, valor, previsao);
	}

	/**
	 * Retornar o valor total das apostas feitas em um cenario.
	 * 
	 * @param numeracao
	 *            numerasao do cenario
	 * @return retorna o valor total das apostas
	 */
	public int valorTotalDeApostas(int numeracao) {
		numeracaoValida(numeracao);
		return cenarios.get(numeracao-1).valorTotal();
	}

	/**
	 * Retornar o numero de apostas feitas em um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna o numero de apostas do cenario
	 */
	public int totalApostas(int numeracao) {
		numeracaoValida(numeracao-1);
		return cenarios.get(numeracao-1).numeroDeApostas();
	}

	/**
	 * Retorna a representaacao textual das apostas de um cenario.
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna a representacao textual das apostas do cenario
	 */
	public String exibeApostas(int numeracao) {
		numeracaoValida(numeracao-1);
		return cenarios.get(numeracao-1).exibeApostas();
	}

	/**
	 * Encerra um cenario.
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @param ocorreu
	 *            indica se o cenario ocorreu ou nao
	 */
	public void fecharApostas(int numeracao, boolean ocorreu) {
		numeracaoValida(numeracao-1);
		cenarios.get(numeracao-1).fechaApostas(ocorreu);
		this.caixa += cenarios.get(numeracao-1).getDestinadoCaixa() * this.taxa;
	}

	/**
	 * Retorna o valor total de um cenario encerrado que sera destinado ao caixa
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna o valor total destinado ao caixa
	 */
	public int getCaixaCenario(int numeracao) {
		numeracaoValida(numeracao-1);
		return cenarios.get(numeracao-1).getDestinadoCaixa();
	}

	/**
	 * Retorna o valor total de um cenario encerrado que sera destinado a
	 * distribuicao entre as apostas vencedoras
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna o valor total destinado as apostas vencedoras
	 */
	public int getTotalRateioCenario(int numeracao) {
		numeracaoValida(numeracao-1);
		return cenarios.get(numeracao-1).getDestinadoVencedores() - ((int)(cenarios.get(numeracao-1).getDestinadoCaixa() * taxa));
	}
}