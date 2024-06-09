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
     * 
     */
    public Relatorio(List<Venda> vendas) {
        this.vendas = vendas;
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
     * Calcula o rendimento total do relatório.
     * 
     * @return O rendimento total.
     */
    public double calcularRendimentoTotal() {
        return rendimento;
    }

    /**
     * Lista todas as vendas no relatório.
     * 
     * @return A lista de vendas.
     */
    public List<Venda> listarVendas() {
        return vendas;
    }

    /**
     * Lista as vendas dentro de um período mensal.
     * 
     * @param mes O mês desejado (1 para Janeiro, 2 para Fevereiro, etc.).
     * @param ano O ano desejado.
     * @return A lista de vendas dentro do período mensal especificado.
     */
    public List<Venda> listarVendasMensais(int mes, int ano) {
        List<Venda> vendasMensais = vendas;
        for (Venda venda : vendas) {
            if (venda.getDataHora().getMonthValue() == mes && venda.getDataHora().getYear() == ano) {
                vendasMensais.add(venda);
            }
        }
        return vendasMensais;
    }

    /**
     * Lista as vendas dentro de um período anual.
     * 
     * @param ano O ano desejado.
     * @return A lista de vendas dentro do período anual especificado.
     */
    public List<Venda> listarVendasAnuais(int ano) {
        List<Venda> vendasAnuais = vendas;
        for (Venda venda : vendas) {
            if (venda.getDataHora().getYear() == ano) {
                vendasAnuais.add(venda);
            }
        }
        return vendasAnuais;
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
