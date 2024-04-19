/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Osiel Junior e Daniel Rodrigues
 */

public class Venda {
    private int id;
    private Date dataHora;
    private Cliente cliente;
    private List<Produto> produtosVendidos;

    // Construtor
    public Venda(int id, Date dataHora, Cliente cliente, List<Produto> produtosVendidos) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.produtosVendidos = produtosVendidos;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    // Método para calcular o valor total da venda
    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtosVendidos) {
            total += produto.getValor();
        }
        return total;
    }

    // Método toString para representação em string do objeto
    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", cliente=" + cliente +
                ", produtosVendidos=" + produtosVendidos +
                '}';
    }
}

