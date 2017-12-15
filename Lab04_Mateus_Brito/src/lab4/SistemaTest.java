package lab4;
 
import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class SistemaTest {
     
    private Sistema sistema;
 
    public SistemaTest() {
        sistema = new Sistema();
    }
     
    @Test(expected=NullPointerException.class)
    public void testeCadastraAlunoMatriculaNull() {
        sistema.cadastraAluno(null ,"Mateus", "CC");
    }
     
    @Test(expected=NullPointerException.class)
    public void testeCadastraAlunoNomeNull() {
        sistema.cadastraAluno("150", null, "CC");
    }
     
    @Test(expected=NullPointerException.class)
    public void testeCadastraAlunoCursoNull() {
        sistema.cadastraAluno("150", "Mateus", null);
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeCadastraAlunoMatriculaVazia() {
        sistema.cadastraAluno("   ", "Mateus", "CC");
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeCadastraAlunoNomeVazio() {
        sistema.cadastraAluno("150", "    ", "CC");
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeCadastraAlunoCursoVazio() {
        sistema.cadastraAluno("150", "Mateus", "   ");
    }
     
    @Test
    public void testeExibeAluno() {
        sistema.cadastraAluno("100", "Mateus", "CC");
        assertEquals("ALUNO NÃO CADASTRADO!", "Aluno: 100 - Mateus - CC", sistema.exibeAluno("100"));
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeExibeAlunoMatriculaVazia() {
        sistema.cadastraAluno("100", "Mateus", "CC");
        sistema.exibeAluno("  ");
    }
     
    @Test(expected=NullPointerException.class)
    public void testeExibeAlunoMatriculaNull() {
        sistema.exibeAluno(null);
    }
     
     
    @Test(expected=IllegalArgumentException.class)
    public void testeCadastraGrupoNomeVazio() {
        sistema.cadastraGrupo("   ");
    }
     
    @Test(expected=NullPointerException.class)
    public void testeCadastraGrupoNomeNull() {
        sistema.cadastraGrupo(null);
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeCadastraGrupoJáCadastrado() {
        sistema.cadastraGrupo("apcc");
        sistema.cadastraGrupo("apcc");
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeAlocaAluno() {
        sistema.cadastraAluno("100", "Mateus", "CC");
        sistema.cadastraGrupo("apcc");
        sistema.alocaAluno("100", "sasaas");
    }
     
    @Test(expected=NullPointerException.class)
    public void testeAlocaAlunoNull() {
        sistema.cadastraAluno("100", "Mateus", "CC");
        sistema.cadastraGrupo("apcc");
        sistema.alocaAluno(null, "apcc");
         
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeAlocaAlunoVazio() {
        sistema.cadastraAluno("100", "Mateus", "CC");
        sistema.cadastraGrupo("apcc");
        sistema.alocaAluno("    ", "apcc");
    }
     
    @Test(expected=IllegalArgumentException.class)
    public void testeRespondeQuadroVazio() {
        sistema.respondeQuadro("   ");
    }
     
    @Test(expected=NullPointerException.class)
    public void testeRespondeQuadroNull() {
        sistema.respondeQuadro(null);
    }   
}