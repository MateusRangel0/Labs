package prova1;

public class Cardapio {
	private String nomeEstabelecimento;
	private Item[] cardapio;
	private int tamanhoCardapio;
	
	public Cardapio(String nomeEstabelecimento, int tamanhoCardapio) {
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.cardapio = new Item[tamanhoCardapio];
	}
	
	public Cardapio(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
		this.cardapio = new Item[5];
	}
	
	public void adicionaItem(String nome, int calorias) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < cardapio.length; i++) {
			if (cardapio[i] == null) {
				this.cardapio[i] = new Item(nome, calorias);
				return;
			}
		}
	}
	
	public String listaCardapio() {
		String ret = "";
		for (int i = 0; i < cardapio.length; i++) {
			ret += (i + 1) + " - " + cardapio[i].getNome() + " " + cardapio[i].getCalorias() + System.lineSeparator();
		}
		return ret;
	}
	
	public int calculaCalorias(String[] refeicao, String tamanhoRefeicao) {
		int caloriaTotal = 0;
		
		for (int i = 0; i < refeicao.length; i++) {
			
			if (refeicao[i].equals("arroz branco")) {
				caloriaTotal += 100;				
			}
			else if (refeicao[i].equals("arroz a grega")) {
				caloriaTotal += 200;
			}
			else if (refeicao[i].equals("macarrao")) {
				caloriaTotal += 200;
			}
			else if (refeicao[i].equals("feijoada")) {
				caloriaTotal += 150;
			}
			else if (refeicao[i].equals("feijao verde")) {
				caloriaTotal += 90;
			}
			else if (refeicao[i].equals("frango assado")) {
				caloriaTotal += 90;
			}
			else if (refeicao[i].equals("bife")) {
				caloriaTotal += 100;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		if (tamanhoRefeicao.equals("grande")) {
			caloriaTotal = caloriaTotal * 2;
		}
		else if (tamanhoRefeicao.equals("mega")) {
			caloriaTotal = caloriaTotal * 3;
		}
		return caloriaTotal;
	}
}
