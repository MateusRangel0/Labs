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
	 * @return
	 */
	public int getCaixa() {
		return controlador.getCaixa();
	}

	/**
	 * Cadastra novos cenários.
	 * 
	 * @param descricao
	 *            descrição da situação trabalhada no cenário
	 * @return
	 */
	public int cadastrarCenario(String descricao) {
		return 0;
	}

	/**
	 * Retorna a representação textual de um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return
	 */
	public String exibirCenario(int numeracao) {
		return "";
	}

	/**
	 * Retornar a representação textual de todos os cenários cadastrados no
	 * sistema.
	 * 
	 * @return
	 */
	public String listaCenarios() {
		return "";
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
	public void cadastrarAposta(int numeracao, String apostador, int valor,
			String previsao) {

	}

	/**
	 * Retornar o valor total das apostas feitas em um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return
	 */
	public int valorTotalApostas(int numeracao) {
		return 0;
	}

	/**
	 * Retornar o número de apostas feitas em um cenário.
	 * 
	 * @param numeracao
	 *            numeração do cenário
	 * @return
	 */
	public int totalApostas(int numeracao) {
		return 0;
	}

	/**
	 * Retorna a representação textual das apostas de um cenário.
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return
	 */
	public String exibeApostas(int numeracao) {
		return "";
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
	 * Retorna o valor total de um cenário encerrado que será destinado ao
	 * caixa
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return
	 */
	public int getCaixaCenario(int numeracao) {
		return 0;
	}

	/**
	 * Retorna o valor total de um cenário encerrado que será destinado a
	 * distribuição entre as apostas vencedoras
	 * 
	 * @param numeracao
	 *            numeração de um cenário
	 * @return
	 */
	public int getTotalRateioCenario(int numeracao) {
		return 0;
	}
}