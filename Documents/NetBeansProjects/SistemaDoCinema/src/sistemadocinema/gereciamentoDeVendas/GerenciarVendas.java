/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osiel
 */
public class GerenciarVendas {
    private final List<Venda> vendasConfirmadas;

    public GerenciarVendas() {
        this.vendasConfirmadas = new ArrayList<>();
    }

    public void confirmarVenda(Venda venda) {
        venda.calcularTotal(); // Calcula o total da venda
        this.vendasConfirmadas.add(venda);
        System.out.println(venda.getExtrato());
        System.out.println("Venda realizada com sucesso!");
    }

    public void cancelarVenda(Venda venda) {
        if (this.vendasConfirmadas.remove(venda)) {
            System.out.println("Venda cancelada com sucesso!");
        } else {
            System.out.println("Venda não encontrada!");
        }
    }

    public void imprimirRelatorioVendas() {
        System.out.println("Relatório de Vendas:");
        for (Venda venda : vendasConfirmadas) {
            System.out.println(venda.getExtrato());
        }
    }

    public double calcularRendimentoDiario() {
        double rendimento = 0.0;
        for (Venda venda : vendasConfirmadas) {
            rendimento += venda.getValorTotal();
        }
        return rendimento;
    }
}