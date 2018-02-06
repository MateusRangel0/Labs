/**
 * Laboratario de Programacao - Lab 5
 * 
 * @author Mateus Brito de Sousa Rangel - 117110914
 */


import easyaccept.EasyAccept;

public class Facade {
	
	private GeneralController controlador;
	
	public static void main (String[] args) {
		String[] ar3 = new String[] {"lab05.Facade", "acceptance_test/us3_test.txt"};
		EasyAccept.main(ar3);
	}

	public Facade() {
		this.controlador = new GeneralController(0, 0.1);
	}
	
	/**
	 * Inicializa o sistema com um valor na caixa e uma taxa.
	 * 
	 * @param caixa
	 *            Quantidade atual do dinheiro (em centavos)
	 * @param taxa
	 *            porcentagem que deve ser retirada de cada aposta perdedora
	 */
	public void inicializa(int caixa, double taxa) {
		controlador = new GeneralController(caixa, taxa);
	}

	/**
	 * Recupera o valor em caixa do sistema.
	 * 
	 * @return retorna o valor em caixa
	 */
	public int getCaixa() {
		return controlador.getCaixa();
	}

	/**
	 * Cadastra novos cenarios.
	 * 
	 * @param descricao
	 *            descricao da situacao trabalhada no cenario
	 * @return retorna a numeracao do cenario
	 */
	public int cadastrarCenario(String descricao) {
		return controlador.cadastraCenario(descricao);
	}

	/**
	 * Retorna a representacao textual de um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna a representacao textual do cenario
	 */
	public String exibirCenario(int numeracao) {
		return controlador.exibirCenario(numeracao);
	}

	/**
	 * Retornar a representacao textual de todos os cenarios cadastrados no sistema.
	 * 
	 * @return retorna a representacao textual dos cenarios cadastrados
	 */
	public String listaCenarios() {
		return controlador.listaCenarios();
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
	public void cadastrarAposta(int numeracao, String apostador, int valor, String previsao) {
		controlador.cadastrarApostas(numeracao, apostador, valor, previsao);
	}

	/**
	 * Retornar o valor total das apostas feitas em um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna o valor total das apostas
	 */
	public int valorTotalDeApostas(int numeracao) {
		return controlador.valorTotalDeApostas(numeracao);
	}

	/**
	 * Retornar o numero de apostas feitas em um cenario.
	 * 
	 * @param numeracao
	 *            numeracao do cenario
	 * @return retorna o numero de apostas do cenario
	 */
	public int totalDeApostas(int numeracao) {
		return controlador.totalApostas(numeracao);
	}

	/**
	 * Retorna a representacao textual das apostas de um cenario
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna a representacao textual do cenario
	 */
	public String exibeApostas(int numeracao) {
		return controlador.exibeApostas(numeracao);
	}

	/**
	 * Encerra um cenario.
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @param ocorreu
	 *            indica se o cenario ocorreu ou nao
	 */
	public void fecharAposta(int numeracao, boolean ocorreu) {
		controlador.fecharApostas(numeracao, ocorreu);
	}

	/**
	 * Retorna o valor total de um cenario encerrado que sera destinado ao caixa
	 * 
	 * @param numeracao
	 *            numeracao de um cenario
	 * @return retorna o valor total destinado ao caixa
	 */
	public int getCaixaCenario(int numeracao) {
		return controlador.getCaixaCenario(numeracao);
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
		return controlador.getTotalRateioCenario(numeracao);
	}
}