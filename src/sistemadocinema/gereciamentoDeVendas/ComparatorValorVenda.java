/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import java.util.Comparator;
import sistemadocinema.Filme;

/**
 * ComparatorValorVenda é uma classe que implementa a interface Comparator,
 * usada para comparar duas vendas com base no valor total da venda.
 * 
 * @author Osiel Junior
 */
public class ComparatorValorVenda implements Comparator<Venda> {

    /**
     * Compara duas vendas com base no valor total da venda.
     * 
     * @param venda1 A primeira venda a ser comparada.
     * @param venda2 A segunda venda a ser comparada.
     * @return Um valor negativo se a primeira venda tiver um valor total menor,
     *         um valor positivo se tiver um valor total maior e zero se forem iguais.
     */
    @Override
    public int compare(Venda venda1, Venda venda2) {
        double diferencaPrecoVenda = venda1.getValorTotal() - venda2.getValorTotal();
        if (diferencaPrecoVenda != 0) {
            return diferencaPrecoVenda > 0 ? 1 : -1;
        } else {
            return 0;
        }
    }
}
