package lab03;
 
import java.util.Arrays;
 
/**
 * Representação de um sistema que cadastra, gerencia e exibe contatos.
 *
 * @author mateusbsr
 */
public class Agenda {
   
    private Contato[] agenda;
   
    /**
     * Construtor que cria uma agenda em forma de array.
     */
    public Agenda() {
        this.agenda = new Contato[100];
    }
    
    /**
     * Cadastra um contato na posição desejada da agenda.
     * 
     * @param posicao a posição da agenda a qual o contato será inserido
     * @param nome o nome do contato
     * @param sobrenome o sobrenome do contato
     * @param telefone o telefone do contato
     */
    public void cadastrar(int posicao, String nome, String sobrenome, String telefone) {
        this.agenda[posicao - 1] = new Contato(nome, sobrenome, telefone);

    }
    
    /**
     * Exibe o contato cadastrado na posição pedida.
     * 
     * @param contato
     * @return
     */
    public String exibir(int contato) {
        return this.agenda[contato - 1].toString();
    }
    
    /**
     * Lista todos os contatos cadastrados.
     * 
     * @return
     */
    public String listar() {
        String ret = "";
        for (int i = 0; i < 100; i++) {
            if (agenda[i] != null) {
                ret += (i + 1) + " - " + agenda[i].getNome() + " " + agenda[i].getSobrenome() + "\n";
            }
        }
        return ret;
    }

    public Contato getContato(int posicao) {
        return this.agenda[posicao - 1];
    }
   
    public String toString() {
        return listar();
    }
    
     /**
      * Compara o objeto de acordo com as especificações.
      * 
      * @return retorna um boolean dependendo da veracidade da comparação
      */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) obj;
        if (!Arrays.deepEquals(agenda, other.agenda)) {
            return false;
        }
        return true;
    }    
}