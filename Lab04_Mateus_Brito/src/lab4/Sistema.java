package lab4;
 
import java.util.ArrayList;
import java.util.HashMap;
 
/**
 * Classe que administra os alunos e seus grupos.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class Sistema {
 
    private HashMap<String, Aluno> alunos;
    private HashMap<String, Grupo> grupos;
    private ArrayList<Aluno> alunosResponderam;
 
    /**
     * Construtor da classe sistema.
     */
    public Sistema() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosResponderam = new ArrayList<Aluno>();
    }
 
    /**
     * Checa se o aluno esta cadastrado.
     * 
     * @param matricula
     *            a matricula do aluno
     * @return
     */
    public boolean existeAluno(String matricula) {
        return this.alunos.containsKey(matricula);
    }
 
    /**
     * Checa se o grupo esta cadastrado.
     * 
     * @param nomeGrupo
     *            o nome do grupo
     * @return
     */
    public boolean existeGrupo(String nomeGrupo) {
        return this.grupos.containsKey(nomeGrupo.toLowerCase());
    }
 
    /**
     * 
     * @param palavra
     */
    private void palavraValida(String palavra) {
        if (palavra == null) {
            throw new NullPointerException("Parâmetro null!");
        }
        else if (palavra.trim().equals("")) {
            throw new IllegalArgumentException("Palavra vazia!");
        }
    }
 
    /**
     * Cadastra o aluno pela sua matricula, nome e curso, além de checar se a
     * entrada é valida e se o aluno já foi cadastrado
     * 
     * @param matricula
     *            a matricula do aluno
     * @param nomeAluno
     *            o nome do aluno
     * @param curso
     *            o curso do aluno
     * @return
     */
    public void cadastraAluno(String matricula, String nomeAluno, String curso) {
        palavraValida(matricula);
        palavraValida(nomeAluno);
        palavraValida(curso);
        if (existeAluno(matricula)) {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
        }
 
        else {
            Aluno aluno = new Aluno(matricula, nomeAluno, curso);
            this.alunos.put(matricula, aluno);
        }
    }
 
    /**
     * Exibe o aluno de acordo com a matricula.
     * 
     * @param matricula
     *            a matricula do aluno
     * @return
     */
    public String exibeAluno(String matricula) {
        palavraValida(matricula);
        if (existeAluno(matricula)) {
            return "Aluno: " + this.alunos.get(matricula).toString();
        } else {
            return "ALUNO NÃO CADASTRADO!";
        }
    }
 
    /**
     * Cadastra o grupo, além de checar se o nome é invalido ou se já foi
     * cadastrado.
     * 
     * @param nomeGrupo
     *            o nome do grupo
     * @return
     */
    public void cadastraGrupo(String nomeGrupo) {
        palavraValida(nomeGrupo);
        if (existeGrupo(nomeGrupo.toLowerCase())) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
        }
        else {
            Grupo grupo = new Grupo(nomeGrupo);
            this.grupos.put(nomeGrupo, grupo);
        }
    }
 
    /**
     * Lista os alunos de determinado grupo.
     * 
     * @param nomeGrupo
     *            o nome do grupo
     * @return
     */
    public String listaGrupo(String nomeGrupo) {
        palavraValida(nomeGrupo);
        if (!grupos.containsKey(nomeGrupo)) {
            return "Grupo não cadastrado.";
        } else {
            return grupos.get(nomeGrupo).listaAlunos();
        }
    }
 
    /**
     * Aloca um aluno, pela sua matricula, em determinado grupo.
     * 
     * @param matricula
     *            a matricula do aaluno
     * @param nomeGrupo
     *            o nome do grupo
     * 
     */
    public void alocaAluno(String matricula, String nomeGrupo) {
        palavraValida(matricula);
        palavraValida(nomeGrupo);
        if (existeGrupo(nomeGrupo)) {
            if (existeAluno(matricula)) {
                this.grupos.get(nomeGrupo).adicionaAluno(alunos.get(matricula));
                 
            }
        } else {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO!");
        }
    }
 
    /**
     * Adiciona um aluno, pela sua matricula, no grupo de alunos que responderam
     * questões no quadro, além de checar se o aluno existe.
     * 
     * @param matricula
     *            a matricula do aluno
     * @return
     */
    public void respondeQuadro(String matricula) {
        palavraValida(matricula);
        if (existeAluno(matricula)) {
            alunosResponderam.add(this.alunos.get(matricula));
        } else {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO!");
        }
    }
 
    /**
     * Lista os alunos que responderam questões no quadro
     * 
     * @return retorna a lista de pessoas que respoderam
     */
    public String listaRespondoes() {
        String listagem = "Alunos: " + System.lineSeparator();
        for (int i = 0; i < alunosResponderam.size(); i++) {
            listagem += (i + 1) + "." + " "
                    + alunosResponderam.get(i).toString()
                    + System.lineSeparator();
        }
        return listagem;
    }
}