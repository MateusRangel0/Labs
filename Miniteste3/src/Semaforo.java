public class Semaforo {

    public final int ESTADO_VERMELHO = 0;
    public final int ESTADO_AMARELO = 1;
    public final int ESTADO_VERDE = 2;

    private final String[] estados = new String[] { "VERMELHO", "AMARELO", "VERDE" };

    private int estado;
    private int alteracoes;
    private int identificador;

    public Semaforo(int identificador) {
        this.estado = ESTADO_VERMELHO;
        this.alteracoes = 0;
        this.identificador = identificador;
    }

    public void mudar() {
        this.alteracoes += 1;
        if (this.estado == ESTADO_VERMELHO) {
            this.estado = ESTADO_VERDE;
        } else if (this.estado == ESTADO_AMARELO) {
            this.estado = ESTADO_VERMELHO;
        } else if (this.estado == ESTADO_VERDE) {
            this.estado = ESTADO_AMARELO;
        }
    }

    @Override
    public String toString() {
        return "Sinal -- " + this.alteracoes + " -- " + this.estados[this.estado];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + identificador;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Semaforo other = (Semaforo) obj;
        if (identificador != other.identificador)
            return false;
        return true;
    }
}