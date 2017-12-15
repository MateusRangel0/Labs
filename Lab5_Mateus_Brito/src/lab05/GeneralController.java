package lab05;

import java.util.ArrayList;

/**
 * Classe que controla os cenários e suas apostas.
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
	 * Cadastra novos cenários.
	 * 
	 * @param descricao
	 *            descrição da situação trabalhada no cenário
	 * @return retorna a numeração do cenário
	 */
	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenario.getNumeracao();
	}

	/**
	 * Retorna a representação textual de um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return retorna a representação textual do cenário
	 */
	public String exibirCenario(int numeracao) {
		return cenarios.get(numeracao).toString();
	}

	/**
	 * Retornar a representação textual de todos os cenários cadastrados no
	 * sistema.
	 * 
	 * @return retorna a representação textual dos cenários cadastrados
	 */
	public String listaCenarios() {
		String ret = "";
		for (Cenario cenario : cenarios) {
			ret += cenario.toString() + System.lineSeparator();
		}
		return ret;
	}

	/**
	 * Cadastrar uma nova aposta.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @param apostador
	 *            nome do apostador
	 * @param valor
	 *            quantia apostada
	 * @param previsao
	 *            previsão
	 */
	public void cadastrarApostas(int numeracao, String Apostador, int valor,
			String previsao) {
		cenarios.get(numeracao).cadastrarAposta(Apostador, valor, previsao);
	}

	/**
	 * Retornar o valor total das apostas feitas em um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return retorna o valor total das apostas
	 */
	public int valorTotalApostas(int numeracao) {
		return cenarios.get(numeracao).valorTotal();
	}

	/**
	 * Retornar o número de apostas feitas em um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return retorna o número de apostas do cenário
	 */
	public int totalApostas(int numeracao) {
		return cenarios.get(numeracao).numeroDeApostas();
	}

	/**
	 * Retorna a representação textual das apostas de um cenário.
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return retorna a representação textual das apostas do cenário
	 */
	public String exibeApostas(int numeracao) {
		return cenarios.get(numeracao).exibeApostas();
	}

	/**
	 * Encerra um cenário.
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @param ocorreu
	 *            indica se o cenário ocorreu ou não
	 */
	public void fecharApostas(int numeracao, boolean ocorreu) {
		cenarios.get(numeracao).fechaApostas(ocorreu);
	}

	/**
	 * Retorna o valor total de um cenário encerrado que será destinado ao caixa
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return retorna o valor total destinado ao caixa
	 */
	public int getCaixaCenario(int numeracao) {
		return cenarios.get(numeracao).getDestinadoCaixa();
	}

	/**
	 * Retorna o valor total de um cenário encerrado que será destinado a
	 * distribuição entre as apostas vencedoras
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return retorna o valor total destinado as apostas vencedoras
	 */
	public int getTotalRateioCenario(int numeracao) {
		return cenarios.get(numeracao).getDestinadoVencedores();
	}
}