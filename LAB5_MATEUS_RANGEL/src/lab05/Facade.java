/**
 * Laboratório de Programação - Lab 5
 * 
 * @author Mateus Brito de Sousa Rangel - 117110914
 */

package lab05;

public class Facade {

	private GeneralController controlador;

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
	 * Cadastra novos cenários.
	 * 
	 * @param descricao
	 *            descrição da situação trabalhada no cenário
	 * @return retorna a numeração do cenário
	 */
	public int cadastrarCenario(String descricao) {
		return controlador.cadastraCenario(descricao);
	}

	/**
	 * Retorna a representação textual de um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return retorna a representação textual do cenário
	 */
	public String exibirCenario(int numeracao) {
		return controlador.exibirCenario(numeracao);
	}

	/**
	 * Retornar a representação textual de todos os cenários cadastrados no sistema.
	 * 
	 * @return retorna a representação textual dos cenários cadastrados
	 */
	public String listaCenarios() {
		return controlador.listaCenarios();
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
	public void cadastrarAposta(int numeracao, String apostador, int valor, String previsao) {

	}

	/**
	 * Retornar o valor total das apostas feitas em um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return retorna o valor total das apostas
	 */
	public int valorTotalApostas(int numeracao) {
		return controlador.valorTotalApostas(numeracao);
	}

	/**
	 * Retornar o número de apostas feitas em um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return retorna o número de apostas do cenário
	 */
	public int totalApostas(int numeracao) {
		return controlador.totalApostas(numeracao);
	}

	/**
	 * Retorna a representação textual das apostas de um cenário.
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return retorna a representação textual do cenário
	 */
	public String exibeApostas(int numeracao) {
		return controlador.exibeApostas(numeracao);
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

	}

	/**
	 * Retorna o valor total de um cenário encerrado que será destinado ao caixa
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return retorna o valor total destinado ao caixa
	 */
	public int getCaixaCenario(int numeracao) {
		return controlador.getCaixaCenario(numeracao);
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
		return controlador.getTotalRateioCenario(numeracao);
	}
}