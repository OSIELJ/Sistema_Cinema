/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;



import java.util.Date;
import java.util.List;
/**
 *@author Osiel Junior e Daniel Rodrigues
 */

public class Produto {
    private String nome;
    private String tipo;
    private Date dataValidade;
    private double valor;
    private int quantidadeEmEstoque;

    // Construtor
    public Produto(String nome, String tipo, Date dataValidade, double valor, int quantidadeEmEstoque) {
        this.nome = nome;
        this.tipo = tipo;
        this.dataValidade = dataValidade;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Getters e Setters
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

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
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

    // Método para verificar se o produto está vencido
    public boolean estaVencido() {
        Date dataAtual = new Date();
        return dataAtual.after(dataValidade);
    }

    // Método para vender uma quantidade específica do produto
    public void vender(int quantidade) {
        if (quantidade > quantidadeEmEstoque) {
            System.out.println("Quantidade insuficiente em estoque.");
        } else {
            quantidadeEmEstoque -= quantidade;
            System.out.println("Venda realizada com sucesso.");
        }
    }

    // Método para adicionar quantidade ao estoque
    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
        System.out.println("Estoque atualizado com sucesso!");
    }

    // Método para calcular o valor total de uma determinada quantidade de produtos
    public double calcularTotal(int quantidade) {
        return valor * quantidade;
    }

    // Método toString para representação em string do objeto
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
