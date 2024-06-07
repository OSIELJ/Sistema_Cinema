/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import java.util.Comparator;
import sistemadocinema.Filme;

/**
 *
 * @author Osiel
 */
public class ComparatorValorVenda implements Comparator<Venda> {

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
