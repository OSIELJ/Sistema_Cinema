/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import Arquivo.Json;
import java.util.ArrayList;
import java.util.List;

/**
 * GerenciarVendas é uma classe responsável por gerenciar as vendas realizadas no sistema,
 * incluindo a confirmação e o cancelamento de vendas, a impressão de relatórios de vendas
 * e o cálculo do rendimento diário.
 * 
 * @author Osiel Junior
 */
public class GerenciarVendas {
    private final List<Venda> vendasConfirmadas;

    /**
     * Construtor da classe GerenciarVendas.
     * 
     * @param vendasConfirmadas A lista de vendas confirmadas.
     */
    public GerenciarVendas(List<Venda> vendasConfirmadas) {
        this.vendasConfirmadas = vendasConfirmadas;
    }

    /**
     * Método para confirmar uma venda.
     * 
     * @param venda A venda a ser confirmada.
     */
public void confirmarVenda(Venda venda) {
    // Verifica se uma venda semelhante já foi confirmada anteriormente
    for (Venda vendaConfirmada : vendasConfirmadas) {
        if (vendaConfirmada.equals(venda)) {
            System.out.println("Esta venda já foi confirmada anteriormente!");
            return;
        }
    }
    
    venda.calcularTotal(); // Calcula o total da venda
    this.vendasConfirmadas.add(venda);
    System.out.println("Venda realizada com sucesso!");
    Json.salvarExtratoVenda(venda.getExtrato());
}

    /**
     * Método para cancelar uma venda.
     * 
     * @param venda A venda a ser cancelada.
     */
    public void cancelarVenda(Venda venda) {
        if (this.vendasConfirmadas.remove(venda)) {
            System.out.println("Venda cancelada com sucesso!");
        } else {
            System.out.println("Venda não encontrada!");
        }
    }

    /**
     * Método para imprimir o relatório de vendas.
     */
public void imprimirRelatorioVendas() {
    System.out.println("Relatório de Vendas:");
    List<Venda> vendasImpressas = new ArrayList<>();
    for (Venda venda : vendasConfirmadas) {
        if (!vendasImpressas.contains(venda)) {
            System.out.println(venda.getExtrato());
            vendasImpressas.add(venda);
        }
    }
}

    /**
     * Método para calcular o rendimento diário das vendas.
     * 
     * @return O rendimento diário das vendas.
     */
    public double calcularRendimentoDiario() {
        double rendimento = 0.0;
        for (Venda venda : vendasConfirmadas) {
            rendimento += venda.getValorTotal();
        }
        return rendimento;
    }

    @Override
    public String toString() {
        return "GerenciarVendas{" + "vendasConfirmadas=" + vendasConfirmadas + '}';
    }
}
