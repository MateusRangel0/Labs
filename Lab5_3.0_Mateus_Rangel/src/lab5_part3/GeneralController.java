package lab5_part3;

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
			throw new IllegalArgumentException(
					"Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException(
					"Erro na inicializacao: Taxa nao pode ser inferior a 0");
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
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenarios.size();
	}

	/**
	 * Retorna a representacao textual de um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna a representacao textual do cenario
	 */

	public int cadastraCenario(String descricao, int bonus) {
		if (this.caixa < bonus) {
			throw new IllegalArgumentException(
					"Bônus de cenário é maior do que dinheiro em caixa do sistema");
		}
		Cenario cenario = new CenarioComBonus(descricao, bonus);
		this.cenarios.add(cenario);
		this.caixa -= bonus;
		return cenarios.size();

	}

	public String exibirCenario(int numeracao) {
		if (numeracao < 1) {
			throw new IllegalArgumentException(
					"Erro na consulta de cenario: Cenario invalido");
		} else if (numeracao > cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return numeracao + " - " + cenarios.get(numeracao - 1).toString();
	}

	/**
	 * Retornar a representacao textual de todos os cenarios cadastrados no
	 * sistema.
	 * 
	 * @return retorna a representacao textual dos cenarios cadastrados
	 */
	public String listaCenarios() {
		if (cenarios.size() == 0) {
			throw new IllegalArgumentException(
					"Nao existem cenarios cadastrados!");
		}
		String ret = "";
		int aux = 1;
		for (Cenario cenario : cenarios) {
			ret += aux + " - " + cenario.toString() + System.lineSeparator();
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
	public int cadastrarApostas(int numeracao, String apostador, int valor,
			String previsao) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Cenario nao cadastrado");
		}

		cenarios.get(numeracao - 1).cadastrarAposta(apostador, valor, previsao);
		return cenarios.get(numeracao - 1).getApostas().size();
	}

	public int cadastrarApostaSeguraValor(int numeracao, String apostador,
			String previsao, int valor, int seguro, int custo) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		cenarios.get(numeracao - 1).cadastrarApostaSeguraValor(apostador,
				previsao, valor, seguro);
		this.caixa += custo;
		return cenarios.get(numeracao - 1).getAsseguradas().size();
	}

	public int cadastraApostaAsseguradaTaxa(int numeracao, String apostador,
			String previsao, int valor, double seguro, int custo) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		cenarios.get(numeracao - 1).cadastrarApostaSeguraTaxa(apostador,
				previsao, valor, seguro);
		this.caixa += custo;
		return cenarios.get(numeracao - 1).getAsseguradas().size();
	}

	public void alteraSeguroValor(int numeracao, int apostaAssegurada, int valor) {
		Tipo novo = new ApostaAsseguradaVal(valor);

		cenarios.get(numeracao - 1).getAsseguradas().get(apostaAssegurada - 1)
				.mudaTipo(novo);
	}

	public void alteraSeguroTaxa(int numeracao, int apostaAssegurada,
			double taxa) {
		Tipo novo = new ApostaAsseguradaTaxa(taxa, cenarios.get(numeracao - 1)
				.getAsseguradas().get(apostaAssegurada - 1).getValorAposta());
		cenarios.get(numeracao - 1).getAsseguradas().get(apostaAssegurada - 1)
				.mudaTipo(novo);
	}

	/**
	 * Retornar o valor total das apostas feitas em um cenario.
	 * 
	 * @param numeracao
	 *            numerasao do cenario
	 * @return retorna o valor total das apostas
	 */
	public int valorTotalDeApostas(int numeracao) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return cenarios.get(numeracao - 1).valorTotal();
	}

	/**
	 * Retornar o numero de apostas feitas em um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna o numero de apostas do cenario
	 */
	public int totalApostas(int numeracao) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de apostas: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return cenarios.get(numeracao - 1).numeroDeApostas();
	}

	/**
	 * Retorna a representaacao textual das apostas de um cenario.
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna a representacao textual das apostas do cenario
	 */
	public String exibeApostas(int numeracao) {
		numeracaoValida(numeracao - 1);
		return cenarios.get(numeracao - 1).exibeApostas();
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
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro ao fechar aposta: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro ao fechar aposta: Cenario nao cadastrado");
		}
		cenarios.get(numeracao - 1).fechaApostas(ocorreu);
		this.caixa += getCaixaCenario(numeracao);
	}

	/**
	 * Retorna o valor total de um cenario encerrado que sera destinado ao caixa
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna o valor total destinado ao caixa
	 */
	public int getCaixaCenario(int numeracao) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		if (cenarios.get(numeracao - 1).getEstado().equals("Nao finalizado"))
			throw new IllegalArgumentException(
					"Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		int destinadoCaixa = cenarios.get(numeracao - 1).getDestinadoCaixa();
		return (int) (destinadoCaixa * this.taxa);
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
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		if (cenarios.get(numeracao - 1).getEstado().equals("Nao finalizado"))
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		return cenarios.get(numeracao - 1).getDestinadoCaixa() + cenarios.get(numeracao-1).getDestinadoVencedores()
				- getCaixaCenario(numeracao);
	}
}