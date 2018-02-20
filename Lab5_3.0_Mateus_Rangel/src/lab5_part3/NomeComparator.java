package lab5_part3;

import java.util.Comparator;

public class NomeComparator implements Comparator<Cenario> {

	public int compare(Cenario cenario, Cenario outroCenario) {
		return cenario.getDescricao().compareTo(outroCenario.getDescricao());
	}
}
