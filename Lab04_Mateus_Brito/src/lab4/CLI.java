/**
 * Laboratório de Programação - Lab 4
 *  
 * @author Mateus Brito de Sousa Rangel - 117110914
 */
 
package lab4;
 
import java.util.Scanner;
 
/**
 * Classe principal do quarto laboratório de P2, usada para testar o
 * funcionamento correto do programa e, consequentemente, de suas classes.
 * 
 * @author Mateus Brito de Sousa Rangel
 * 
 */
public class CLI {
 
    /**
     * Retorna para o usuário as opções disponíveis.
     * 
     */
    public static void retornaOpcoes() {
        System.out.print(System.lineSeparator() + "(C)adastrar Aluno"
                + System.lineSeparator() + "(E)xibir Aluno"
                + System.lineSeparator() + "(N)ovo Grupo"
                + System.lineSeparator() + "(A)locar Aluno no Grupo e Imprimir Grupos"
                + System.lineSeparator() + "(R)egistrar Resposta de Aluno"
                + System.lineSeparator() + "(I)mprimir Alunos que Responderam"
                + System.lineSeparator() + "(O)ra, vamos fechar o programa!"
                + System.lineSeparator() + "Opção> ");
    }
 
    /**
     * Para cada opção dada pelo usuario, retorna sua correspondente função.
     * 
     * @param args
     */
    public static void main(String[] args) {
 
        String opcao;
        Scanner scanf = new Scanner(System.in);
        Sistema sistema = new Sistema();
         
        do {
             
            retornaOpcoes();
            opcao = scanf.nextLine();
     
            if (opcao == null) {
                throw new NullPointerException();
            }
     
            if (opcao.trim() == "") {
                throw new IllegalArgumentException();
            }
            try {
                switch (opcao.toUpperCase()) {
                case "C":
                    cadastraAluno(scanf, sistema);
                    break;
                case "E":
                    exibeAluno(scanf, sistema);
                    break;
                case "N":
                    cadastraGrupo(scanf, sistema);
                    break;
                case "A":
                    alocaAlunosEmGrupos(scanf, sistema);
                    break;
                case "R":
                    cadastrarRespondoes(scanf, sistema);
                    break;
                case "I":
                    imprimeRespondoes(scanf, sistema);
                    break;
                case "O":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
                }
             
            }catch(IllegalArgumentException erro) {
             System.out.println(erro.getMessage());
            }
             
        }
        while (!opcao.equals("O"));
    }
 
    /**
     * Cadastra um aluno recebendo sua matricula, seu nome e seu curso.
     * 
     * @param scanf
     *            o scanner utilizado
     * @param sistema
     *            o sistema utilizado
     */
    public static void cadastraAluno(Scanner scanf, Sistema sistema) {
        System.out.print("Matrícula: ");
        String matricula = scanf.nextLine();
 
        System.out.print("Nome: ");
        String nomeAluno = scanf.nextLine();
 
        System.out.print("Curso: ");
        String curso = scanf.nextLine();
 
        sistema.cadastraAluno(matricula, nomeAluno, curso);
        System.out.println("CADASTRADO REALIZADO!");
    }
 
    /**
     * Exibe o aluno de acordo com a matrícula dada.
     * 
     * @param scanf
     *            o scanner utilizado
     * @param sistema
     *            o sistema utilizado
     */
    public static void exibeAluno(Scanner scanf, Sistema sistema) {
        System.out.print("Matrícula: ");
        String matricula = scanf.nextLine();
        System.out.println(sistema.exibeAluno(matricula));
    }
 
    /**
     * Cadastra um novo grupo.
     * 
     * @param scanf
     *            o scanner utilizado
     * @param sistema
     *            o sistema utilizado
     */
    public static void cadastraGrupo(Scanner scanf, Sistema sistema) {
        System.out.print("Grupo: ");
        String nomeGrupo = scanf.nextLine();
 
        sistema.cadastraGrupo(nomeGrupo);
        System.out.println("CADASTRO REALIZADO!");
 
    }
 
    /**
     * Aloca um aluno, pela sua matricula, em um grupo já existente.
     * 
     * @param scanf
     *            o scanner utilizado
     * @param sistema
     *            o sistema utilizado
     */
    public static void alocaAlunosEmGrupos(Scanner scanf, Sistema sistema) {
        System.out.print("(A)locar Aluno ou (I)mprimir Grupo?");
        String escolha = scanf.nextLine();
 
        switch (escolha.toUpperCase()) {
        case "A":
            System.out.print("Matricula: ");
            String matricula = scanf.nextLine();
 
            System.out.print("Grupo: ");
            String nomeGrupo = scanf.nextLine();
 
            sistema.alocaAluno(matricula, nomeGrupo);
            System.out.println("Aluno alocado");
            break;
 
        case "I":
            System.out.print("Grupo: ");
            String nome = scanf.nextLine();
 
            System.out.println(sistema.listaGrupo(nome));
            break;
 
        }
    }
 
    /**
     * Cadastra os alunos, pela matricula, que responderam questões no quadro.
     * 
     * @param scanf
     *            o scanner utilizado
     * @param sistema
     *            o sistema utilizado
     */
    public static void cadastrarRespondoes(Scanner scanf, Sistema sistema) {
        System.out.print("Matricula: ");
        String matricula = scanf.nextLine();
        sistema.respondeQuadro(matricula);
        System.out.println("ALUNO REGISTRADO!");
    }
 
    /**
     * Imprime os alunos cadastrados que responderam as questões no quadro.
     * 
     * @param scanf
     *            o scanner utilizado
     * @param sistema
     *            o sistema utilizado
     */
    public static void imprimeRespondoes(Scanner scanf, Sistema sistema) {
        System.out.println(sistema.listaRespondoes());
    }
}