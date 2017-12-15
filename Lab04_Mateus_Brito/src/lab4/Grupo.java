package lab4;
 
import java.util.HashMap;
 
/**
 * Classe que representa o grupo
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Grupo {
    private String nomeGrupo;
    private HashMap<String, Aluno> alunos;
 
    /**
     * Construtor da classe Grupo.
     * 
     * @param nomeGrupo
     *            o nome do grupo
     */
    public Grupo(String nomeGrupo) {
        this.alunos = new HashMap<>();
        this.nomeGrupo = nomeGrupo;
    }
 
    /**
     * Adiciona o aluno em determinado grupo.
     * 
     * @param aluno
     *            o aluno
     * @return
     */
    public boolean adicionaAluno(Aluno aluno) {
        alunos.put(nomeGrupo, aluno);
        return true;
    }
 
    /**
     * Lista os alunos do grupo.
     * 
     * @return
     */
    public String listaAlunos() {
        return toString();
    }
 
    @Override
    public String toString() {
        String ret = "Alunos do grupo " + this.nomeGrupo + ":"
                + System.lineSeparator();
        for (Aluno aluno : alunos.values()) {
            ret += "* " + aluno.toString() + System.lineSeparator();
        }
        return ret;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
        result = prime * result
                + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) obj;
        if (alunos == null) {
            if (other.alunos != null) {
                return false;
            }
        } else if (!alunos.equals(other.alunos)) {
            return false;
        }
        if (nomeGrupo == null) {
            if (other.nomeGrupo != null) {
                return false;
            }
        } else if (!nomeGrupo.equals(other.nomeGrupo)) {
            return false;
        }
        return true;
    }
}