/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;

/**
 *
 * @author Osiel Junior
 */
public class Relatorio {
    
        private String tipo; // Diário, Mensal, Anual
    private double rendimento;
    private List<Venda> vendas;

    public Relatorio(String tipo, List<Venda> vendas) {
        this.tipo = tipo;
        this.vendas = vendas;
        this.rendimento = calcularRendimento();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getRendimento() {
        return rendimento;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
        this.rendimento = calcularRendimento();
    }

    private double calcularRendimento() {
        double total = 0.0;
        for (Venda venda : vendas) {
            total += venda.calcularTotal();
        }
        return total;
    }

    public void imprimirRelatorio() {
        System.out.println("Tipo de Relatório: " + tipo);
        System.out.println("Rendimento: " + rendimento);
        System.out.println("Detalhes das Vendas:");
        for (Venda venda : vendas) {
            System.out.println(venda.toString());
        }
    }
}
