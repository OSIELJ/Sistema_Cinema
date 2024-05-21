/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.time.LocalDate;

/**
 *
 * @author Osiel
 */
public class Alimenticios extends Produto {

    public Alimenticios(String nome, LocalDate dataValidade, double valor, int quantidadeEmEstoque) {
        super(nome, dataValidade, valor, quantidadeEmEstoque);
    }
    
    @Override
    public String toString() {
        return "Alimento: " + this.getNome() + ", Data de Validade: " + this.getDataValidade() + ", Valor: " + this.getValor() + ", Quantidade em Estoque: " + this.getQuantidadeEmEstoque();
    }
}
