/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import sistemadocinema.gereciamentoDeVendas.Venda;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa um relatório de vendas no sistema de cinema.
 * Pode ser do tipo Diário, Mensal ou Anual.
 * 
 * @author Osiel Junior
 */
public class Relatorio {
    private String tipo; // Diário, Mensal, Anual
    private double rendimento;
    private List<Venda> vendas;

    /**
     * Construtor da classe Relatório.
     * 
     * @param tipo O tipo de relatório (Diário, Mensal, Anual).
     */
    public Relatorio(String tipo) {
        this.tipo = tipo;
        this.vendas = new ArrayList<>();
        this.rendimento = 0.0;
    }

    /**
     * Adiciona uma venda ao relatório.
     * 
     * @param venda A venda a ser adicionada ao relatório.
     */
    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
        rendimento += venda.calcularTotal();
    }

    /**
     * Imprime o relatório de vendas.
     */
    public void imprimirRelatorio() {
        System.out.println("Tipo de Relatório: " + tipo);
        System.out.println("Rendimento: " + rendimento);
        System.out.println("Detalhes das Vendas:");
        for (Venda venda : vendas) {
            System.out.println(venda.toString());
        }
    }

    /**
     * Retorna uma representação em string do relatório.
     * 
     * @return Uma string representando o relatório.
     */
    @Override
    public String toString() {
        return "Relatorio{" + "tipo=" + tipo + ", rendimento=" + rendimento + ", vendas=" + vendas + '}';
    }
}
