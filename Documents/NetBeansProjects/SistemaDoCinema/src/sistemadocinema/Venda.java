/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Osiel Junior e Daniel Rodrigues
 */

public class Venda {

    private Cliente cliente;
    private List<Produto> itensVendidos;
    private double valorTotal;
    private LocalDateTime dataHora;
    private String extrato;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itensVendidos = new ArrayList<>();
        this.dataHora = LocalDateTime.now();
        this.extrato = "Extrato da venda:";
    }

    public void adicionarItem(Produto produto) {
        itensVendidos.add(produto);
        extrato += "\n" + produto.getNome() + " - R$" + produto.getValor();
    }

    public double calcularTotal() {
        valorTotal = 0.0;
        for (Produto produto : itensVendidos) {
            valorTotal += produto.getValor();
        }
        return valorTotal; 
    }

    public List<Produto> getItensVendidos() {
        return itensVendidos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getExtrato() {
        return extrato;
    }

    @Override
    public String toString() {
        return "Venda{"
                + "cliente=" + cliente
                + ", itensVendidos=" + itensVendidos
                + ", valorTotal=" + valorTotal
                + ", dataHora=" + dataHora
                + '}';
    }
}
