package lab03;
 
import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class AgendaTest {
 
    @Test(expected = IllegalArgumentException.class)
    public void cadastraNomeSoEspacos() {
        String nome = "    ";
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com nome feito só de espaços");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraNomeVazio() {
        String nome = "";
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com nome vazio");
    }
      
    @Test(expected = NullPointerException.class)
    public void cadastraNomeNull() {
        String nome = null;
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com nome null");   
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraSobrenomeSoEspacos() {
        String nome = "Mateus";
        String sobrenome = "    ";
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com sobrenome feito só de espaços");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraSobrenomeVazio() {
        String nome = "Mateus";
        String sobrenome = "";
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com sobrenome vazio");
    }
      
    @Test(expected = NullPointerException.class)
    public void cadastraSobrenomeNull() {
        String nome = "Mateus";
        String sobrenome = null;
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com sobrenome null");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraTelefoneSoEspacos() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = "    ";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com telefone feito só de espaços");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraTelefoneVazio() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = "";
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com telefone vazio");
    }
      
    @Test(expected = NullPointerException.class)
    public void cadastraTelefoneNull() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = null;
        int posicao = 1;
        Agenda agenda = new Agenda();
        agenda.cadastrar(posicao, nome, sobrenome, telefone);
        fail("Contato foi criado com telefone null");
    }
       
    @Test
    public void equalsContatosDiferentes() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Agenda agenda1 = new Agenda();
        agenda1.cadastrar(posicao, nome, sobrenome, telefone);
        String nome2 = "Sousa";
        String sobrenome2 = "Rangel";
        String telefone2 = "2222";
        int posicao2 = 2;
        Agenda agenda2 = new Agenda();
        agenda2.cadastrar(posicao2, nome2, sobrenome2, telefone2);
        
        if (agenda1.equals(agenda2)) {
        	fail("Contatos considerados iguais sendo diferentes");
        }    
    }
}