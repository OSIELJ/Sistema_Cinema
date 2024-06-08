/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para mudar esta licença
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package sistemadocinema;

/**
 * A classe Sala representa uma sala de cinema que exibe um filme específico e possui um número determinado de poltronas disponíveis.
 * 
 * @autor Osiel Junior e Daniel Rodrigues
 */
public class Sala {
    private Filme filme;
    private int poltronasDisponiveis;

    /**
     * Construtor da classe Sala.
     * 
     * @param filme O filme que será exibido na sala.
     * @param poltronasDisponiveis O número de poltronas disponíveis na sala.
     */
    public Sala(Filme filme, int poltronasDisponiveis) {
        this.filme = filme;
        this.poltronasDisponiveis = poltronasDisponiveis;
    }

    /**
     * Obtém o filme que está sendo exibido na sala.
     * 
     * @return O filme exibido na sala.
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Define o filme a ser exibido na sala.
     * 
     * @param filme O novo filme a ser exibido.
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * Obtém o número de poltronas disponíveis na sala.
     * 
     * @return O número de poltronas disponíveis.
     */
    public int getPoltronasDisponiveis() {
        return poltronasDisponiveis;
    }

    /**
     * Define o número de poltronas disponíveis na sala.
     * 
     * @param poltronasDisponiveis O novo número de poltronas disponíveis.
     */
    public void setPoltronasDisponiveis(int poltronasDisponiveis) {
        this.poltronasDisponiveis = poltronasDisponiveis;
    }

    /**
     * Reserva uma poltrona na sala, se houver poltronas disponíveis.
     */
    public void reservarPoltrona() {
        if (poltronasDisponiveis > 0) {
            poltronasDisponiveis--;
            System.out.println("Poltrona reservada com sucesso.");
        } else {
            System.out.println("Não há poltronas disponíveis para reserva.");
        }
    }

    /**
     * Libera uma poltrona na sala, aumentando o número de poltronas disponíveis.
     */
    public void liberarPoltrona() {
        poltronasDisponiveis++;
        System.out.println("Poltrona liberada com sucesso.");
    }

    /**
     * Retorna uma representação em String da sala.
     * 
     * @return Uma string representando a sala.
     */
    @Override
    public String toString() {
        return "Sala{" +
                "filme=" + filme +
                ", poltronasDisponiveis=" + poltronasDisponiveis +
                '}';
    }
}
