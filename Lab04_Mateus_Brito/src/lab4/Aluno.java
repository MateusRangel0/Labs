package lab4;
 
/**
 * Classe que representa um aluno.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Aluno {
    private String matricula;
    private String nomeAluno;
    private String curso;
 
    /**
     * Construtor da classe Aluno.
     * 
     * @param matricula
     *            a matricula do aluno
     * @param nomeAluno
     *            o nome do aluno
     * @param curso
     *            o curso do aluno
     */
    public Aluno(String matricula, String nomeAluno, String curso) {
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.curso = curso;
    }
 
    /**
     * Retorna a matricula do aluno.
     * 
     * @return
     */
    public String getMatricula() {
        return this.matricula;
    }
 
    /**
     * Retorna o nome do aluno.
     * 
     * @return
     */
    public String getNome() {
        return this.nomeAluno;
    }
 
    /**
     * Retorna o curso do aluno.
     * 
     * @return
     */
    public String getCurso() {
        return this.curso;
    }
 
    /**
     * Retorna a represantação em String do aluno, no formato: MATRICULA - NOME
     * DO ALUNO - CURSO.
     */
    @Override
    public String toString() {
        return matricula + " - " + nomeAluno + " - " + curso;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((matricula == null) ? 0 : matricula.hashCode());
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
        if (!(obj instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) obj;
        if (matricula == null) {
            if (other.matricula != null) {
                return false;
            }
        } else if (!matricula.equals(other.matricula)) {
            return false;
        }
        return true;
    }
 
}