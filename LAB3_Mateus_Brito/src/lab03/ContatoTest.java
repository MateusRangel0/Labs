package lab03;
  
import static org.junit.Assert.*;
  
import org.junit.Test;
  
public class ContatoTest {
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraNomeSoEspacos() {
        String nome = "    ";
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com nome feito só de espaços");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraNomeVazio() {
        String nome = "";
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com nome vazio");
    }
      
    @Test(expected = NullPointerException.class)
    public void cadastraNomeNull() {
        String nome = null;
        String sobrenome = "Brito";
        String telefone = "1111";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com nome null");   
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraSobrenomeSoEspacos() {
        String nome = "Mateus";
        String sobrenome = "    ";
        String telefone = "1111";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com sobrenome feito só de espaços");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraSobrenomeVazio() {
        String nome = "Mateus";
        String sobrenome = "";
        String telefone = "1111";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com sobrenome vazio");
    }
      
    @Test(expected = NullPointerException.class)
    public void cadastraSobrenomeNull() {
        String nome = "Mateus";
        String sobrenome = null;
        String telefone = "1111";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com sobrenome null");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraTelefoneSoEspacos() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = "    ";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com telefone feito só de espaços");
    }
      
    @Test(expected = IllegalArgumentException.class)
    public void cadastraTelefoneVazio() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = "";
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com telefone vazio");
    }
      
    @Test(expected = NullPointerException.class)
    public void cadastraTelefoneNull() {
        String nome = "Mateus";
        String sobrenome = "Brito";
        String telefone = null;
        int posicao = 1;
        Contato contato = new Contato(nome, sobrenome, telefone);
        fail("Contato foi criado com telefone null");
    }
     
    @Test
    public void equalsNomeDiferente() {
        Contato contato1 = new Contato("Mateus", "Brito", "1111");
        Contato contato2 = new Contato("Rangel", "Brito", "1111");
        if (contato1.equals(contato2)) {
            fail("Contatos considerados iguais com nomes diferentes");
        }
    }
     
    @Test
    public void equalsSobrenomeDiferente() {
        Contato contato1 = new Contato("Mateus", "Brito", "1111");
        Contato contato2 = new Contato("Mateus", "Rangel", "1111");
        if (contato1.equals(contato2)) {
            fail("Contatos considerados iguais com sobrenomes diferentes");
        }
    }
}