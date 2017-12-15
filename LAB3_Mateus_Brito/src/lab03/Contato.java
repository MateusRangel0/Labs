package lab03;
   
/**
 * Representação de contato. O sistema permite a criação de um objeto do tipo contato.
 * 
 * @author Mateus Brito de Sousa Rangel
 *
 */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
     
    /**
     * Construtor que cria o objeto contato a partir do nome, sobrenome e telefone, além de testar os mesmos.
     *    
     * @param nome o nome do contato
     * @param sobrenome o sobrenome do contato
     * @param telefone o telefone do contato
     */
    public Contato(String nome, String sobrenome, String telefone) {
        if((nome.trim().equals("")) || (sobrenome.trim().equals("")) || (telefone.trim().equals(""))) {
            throw new IllegalArgumentException();
        }
           
        if((nome == null) || (sobrenome == null) || telefone == null) {
            throw new NullPointerException();
        }
           
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;       
    }
     
    /**
     * Retorna o nome.
     * 
     * @return
     */
    public String getNome() {
        return nome;
    }
     
    /**
     * Retorna o sobrenome.
     * 
     * @return
     */
    public String getSobrenome() {
        return sobrenome;
    }
     
    /**
     * Retorna o telefone.
     * 
     * @return
     */
    public String getTelefone() {
        return telefone;
    }
     
    /**
     * Retorna a representação em String do contato.
     * 
     * @return
     */
    public String toString() {
        return nome + " " + sobrenome + " - " + telefone + "\n";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	/**
	 * Compara o objeto pelos atributos especificados.
	 * 
	 * @return retorna um boolean de acordo com a verocidade da condição
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
			
		} else if (!nome.equals(other.nome))
			return false;
		
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
			
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		
		return true;
	} 
}