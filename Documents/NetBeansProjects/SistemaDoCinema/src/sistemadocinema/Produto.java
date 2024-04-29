/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;



import java.util.Date;
import java.util.List;
import java.time.LocalDate;
/**
 *@author Osiel Junior e Daniel Rodrigues
 */

public class Produto {
    private String nome;
    private String tipo;
    private LocalDate dataValidade;
    private double valor;
    private int quantidadeEmEstoque;

    public Produto(String nome, String tipo, LocalDate dataValidade, double valor, int quantidadeEmEstoque) {
        this.nome = nome;
        this.tipo = tipo;
        this.dataValidade = dataValidade;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }



    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

public boolean estaVencido() {
    LocalDate dataAtual = LocalDate.now();
    return dataAtual.isAfter(dataValidade);
}

    public void vender(int quantidade) {
        if (quantidade > quantidadeEmEstoque) {
            System.out.println("Quantidade insuficiente em estoque.");
        } else {
            quantidadeEmEstoque -= quantidade;
            System.out.println("Venda realizada com sucesso.");
        }
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
        System.out.println("Estoque atualizado com sucesso!");
    }

    public double calcularTotal(int quantidade) {
        return valor * quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", dataValidade=" + dataValidade +
                ", valor=" + valor +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }
}
