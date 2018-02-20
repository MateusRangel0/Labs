package lab5_part3;

import java.util.Comparator;

public class ApostasComparator implements Comparator<Cenario>{
	
	public int compare(Cenario cenario, Cenario outroCenario) {
		if (cenario.getApostas().size() > outroCenario.getApostas().size()) {
			return -1;
		}
		else if (cenario.getApostas().size() < outroCenario.getApostas().size()) {
			return 1;
		}
		return cenario.compareTo(outroCenario);
	}
}
