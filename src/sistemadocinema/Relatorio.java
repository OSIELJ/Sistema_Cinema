/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import sistemadocinema.gereciamentoDeVendas.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osiel Junior
 */
public class Relatorio {
    private String tipo; // Diário, Mensal, Anual
    private double rendimento;
    private List<Venda> vendas;

    public Relatorio(String tipo) {
        this.tipo = tipo;
        this.vendas = new ArrayList<>();
        this.rendimento = 0.0;
    }

    // Método para adicionar uma venda ao relatório
    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
        rendimento += venda.calcularTotal();
    }

    public void imprimirRelatorio() {
        System.out.println("Tipo de Relatório: " + tipo);
        System.out.println("Rendimento: " + rendimento);
        System.out.println("Detalhes das Vendas:");
        for (Venda venda : vendas) {
            System.out.println(venda.toString());
        }
    }

    @Override
    public String toString() {
        return "Relatorio{" + "tipo=" + tipo + ", rendimento=" + rendimento + ", vendas=" + vendas + '}';
    }
    
    
}
