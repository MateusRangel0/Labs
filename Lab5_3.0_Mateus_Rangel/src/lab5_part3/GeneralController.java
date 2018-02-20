package lab5_part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que controla os cenarios e suas apostas.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class GeneralController {

	private int caixa;
	private double taxa;
	private List<Cenario> cenarios;

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
		}
		if (taxa < 0) {
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
		Cenario cenario = new Cenario(this.cenarios.size()+1, descricao);
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
			throw new IllegalArgumentException("Bônus de cenário é maior do que dinheiro em caixa do sistema");
		}
		Cenario cenario = new CenarioComBonus(this.cenarios.size()+1, descricao, bonus);
		this.cenarios.add(cenario);
		this.caixa -= bonus;
		return cenarios.size();

	}

	public String exibirCenario(int numeracao) {
		if (numeracao < 1) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (numeracao > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return numeracao + " - " + cenarios.get(numeracao - 1).toString();
	}

	/**
	 * Retornar a representacao textual de todos os cenarios cadastrados no sistema.
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
	public int cadastrarApostas(int numeracao, String apostador, int valor, String previsao) {
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}

		cenarios.get(numeracao - 1).cadastrarAposta(apostador, valor, previsao);
		return cenarios.get(numeracao - 1).getApostas().size();
	}

	/**
	 * Cadastra as apostas asseguradas por valor.
	 * 
	 * @param numeracao
	 * @param apostador
	 * @param previsao
	 * @param valor
	 * @param seguro
	 * @param custo
	 * @return
	 */
	public int cadastrarApostaSeguraValor(int numeracao, String apostador, String previsao, int valor, int seguro,
			int custo) {
		this.caixa += custo;
		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().equals("") || previsao == null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}

		else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		cenarios.get(numeracao - 1).cadastrarApostaSeguraValor(apostador, previsao, valor, seguro);
		return cenarios.get(numeracao - 1).getAsseguradas().size();
	}

	/**
	 * Cadastra as apostas asseguradas por taxa.
	 * 
	 * @param numeracao
	 * @param apostador
	 * @param previsao
	 * @param valor
	 * @param seguro
	 * @param custo
	 * @return
	 */
	public int cadastraApostaAsseguradaTaxa(int numeracao, String apostador, String previsao, int valor, double seguro,
			int custo) {
		this.caixa += custo;	

		if (numeracao - 1 < 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		if (previsao == null || previsao.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");

		}
		cenarios.get(numeracao - 1).cadastrarApostaSeguraTaxa(apostador, previsao, valor, seguro);
		return cenarios.get(numeracao - 1).getAsseguradas().size();
	}

	/**
	 * Altera o tipo de seguro valor.
	 * 
	 * @param numeracao
	 * @param apostaAssegurada
	 * @param valor
	 */
	public void alteraSeguroValor(int numeracao, int apostaAssegurada, int valor) {
		Tipo novo = new ApostaAsseguradaVal(valor);

		cenarios.get(numeracao - 1).getAsseguradas().get(apostaAssegurada - 1).mudaTipo(novo);
	}

	/**
	 * Altera o tipo de seguro taxa.
	 * 
	 * @param numeracao
	 * @param apostaAssegurada
	 * @param taxa
	 */
	public void alteraSeguroTaxa(int numeracao, int apostaAssegurada, double taxa) {
		Tipo novo = new ApostaAsseguradaTaxa(taxa,
				cenarios.get(numeracao - 1).getAsseguradas().get(apostaAssegurada - 1).getValorAposta());
		cenarios.get(numeracao - 1).getAsseguradas().get(apostaAssegurada - 1).mudaTipo(novo);
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
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
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
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
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
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		cenarios.get(numeracao - 1).fechaApostas(ocorreu);
		this.caixa += getCaixaCenario(numeracao);
		this.caixa -= cenarios.get(numeracao-1).perdedores();
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
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		if (cenarios.get(numeracao - 1).getEstado().equals("Nao finalizado"))
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
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
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (numeracao - 1 >= cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		if (cenarios.get(numeracao - 1).getEstado().equals("Nao finalizado"))
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		
		return cenarios.get(numeracao - 1).getDestinadoCaixa() + cenarios.get(numeracao - 1).getDestinadoVencedores()
				- getCaixaCenario(numeracao);
	}
	
	public void alterarOrdem(String ordem) {
		if (ordem.trim().equals("") || ordem == null) {
			throw new IllegalArgumentException(
			"Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		if (ordem.equals("cadastro")) {
			Collections.sort(cenarios);
		}
		else if (ordem.equals("nome")) {
			Collections.sort(cenarios, new NomeComparator());
		}
		else if (ordem.equals("apostas")) {
			Collections.sort(cenarios, new ApostasComparator());
		}
		else {
			throw new IllegalArgumentException(
					"Erro ao alterar ordem: Ordem invalida");
		}
	}
	public String exibirCenarioOrdenado(int numeracao) {
		return cenarios.get(numeracao-1).getIndice() + " - " + cenarios.get(numeracao-1).toString();
		
	}
	
}