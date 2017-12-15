package lab05;

import java.util.ArrayList;

public class ControllerCenario {
	
	private ArrayList<Cenario> cenarios;

	public ControllerCenario() {
		this.cenarios = new ArrayList<Cenario>();
	}
	
	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenario.getNumeracao();
		
	}
	
	public String exibirCenario(int numeracao) {
		return cenarios.get(numeracao).toString();
	}
	
	public String listaCenarios() {
		String ret = "";
		for (Cenario cenario : cenarios) {
			ret += cenario.toString() + System.lineSeparator();			
		}
		return ret;
	}
}