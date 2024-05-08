/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

/**
 *
 * @author Osiel
 */
public class Sala {
    private Filme filme;
    private int poltronasDisponiveis;

    public Sala(Filme filme, int poltronasDisponiveis) {
        this.filme = filme;
        this.poltronasDisponiveis = poltronasDisponiveis;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getPoltronasDisponiveis() {
        return poltronasDisponiveis;
    }

    public void setPoltronasDisponiveis(int poltronasDisponiveis) {
        this.poltronasDisponiveis = poltronasDisponiveis;
    }

    public void reservarPoltrona() {
        if (poltronasDisponiveis > 0) {
            poltronasDisponiveis--;
            System.out.println("Poltrona reservada com sucesso.");
        } else {
            System.out.println("Não há poltronas disponíveis para reserva.");
        }
    }

    public void liberarPoltrona() {
        poltronasDisponiveis++;
        System.out.println("Poltrona liberada com sucesso.");
    }

    @Override
    public String toString() {
        return "Sala{" +
                "filme=" + filme +
                ", poltronasDisponiveis=" + poltronasDisponiveis +
                '}';
    }
}

