/**
 * Laboratório de Programação - Lab 3
 *  
 * @author Mateus Brito de Sousa Rangel - 117110914
 */
 
package lab03;
 
import java.util.Scanner;
 
/**
 * Classe principal do terceiro laboratório de P2, usada para testar o
 * funcionamento correto do programa e, consequentemente, de suas classes.
 * 
 * @author Mateus Brito de Sousa Rangel
 */
 
public class CLI {
 
     
    /**
     * Retorna para o usuário as opções disponíveis.
     * 
     */
    public static void retornaOpcoes() {
        System.out.println("(C)adastrar Contato");
        System.out.println("(L)istar Contatos");
        System.out.println("(E)xibir Contato");
        System.out.println("(S)air");
        System.out.println();
        System.out.println("Opção>");
    }
     
    /**
     * Cadastra os contatos, com a posição, nome, sobrenome e telefone do usuáro.
     * 
     * @param agenda a agenda que será cadastrado o contato
     * @param scanf o scanner que será usado
     */
    public static void cadastrarContato(Agenda agenda, Scanner scanf) {
        System.out.print("Posição: ");
        int posicao = scanf.nextInt();
        scanf.nextLine();
 
        if (posicao < 1 || posicao > 100) {
            System.out.print("POSIÇÃO INVÁLIDA!\n\n");
            return;
        } else {
            System.out.print("Nome: ");
            String nome = scanf.nextLine();
 
            System.out.print("Sobrenome: ");
            String sobrenome = scanf.nextLine();
 
            System.out.print("Telefone: ");
            String telefone = scanf.nextLine();
 
            agenda.cadastrar(posicao, nome, sobrenome, telefone);
 
            System.out.println("CADASTRO REALIZADO!\n");
        }
    }
     
    /**
     * Exibe o contato cadastrado em determinada posição.
     * 
     * @param agenda a agenda que o contato se localiza
     * @param scanf o scanner que será usado
     */
    private static void exibirContatos(Agenda agenda, Scanner scanf) {
        System.out.println("Contato> ");
 
        int contato = scanf.nextInt();
        scanf.nextLine();
 
        if ((contato < 1 || contato > 100) || agenda.getContato(contato) == null) {
            System.out.println("POSIÇÃO INVÁLIDA!\n");
        } else {
            System.out.println(agenda.exibir(contato));
        }
    }
     
    /**
     * Lista todos os contatos cadastrados.
     * 
     * @param agenda a agenda em que os contatos se localizam
     * @param scanf o scanner que será usado
     */
    private static void listarContatos(Agenda agenda, Scanner scanf) {
        System.out.println(agenda.listar());
 
    }
     
    /**
     * Para cada opção dada pelo usuario, retorna sua correspondente função. 
     * 
     * @param args
     */
    public static void main(String[] args) {
        String opcao;
        Scanner scanf = new Scanner(System.in);
        Agenda agenda = new Agenda();
 
        do {
            retornaOpcoes();
            opcao = scanf.nextLine();
 
            if (opcao.equals("C")) {
                cadastrarContato(agenda, scanf);
            } else if (opcao.equals("L")) {
                listarContatos(agenda, scanf);
            } else if (opcao.equals("E")) {
                exibirContatos(agenda, scanf);
            } else if (opcao.equals("S")) {
                break;
            } else {
                System.out.println("OPÇÃO INVÁLIDA!");
            }
        } while (!opcao.equals("S"));
    }
}