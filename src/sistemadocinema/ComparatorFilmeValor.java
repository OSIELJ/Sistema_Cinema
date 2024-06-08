/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.util.Comparator;

/**
 * Esta classe implementa um Comparator personalizado para comparar objetos do tipo Filme com base em seus valores.
 * O método compare compara dois objetos Filme com base em seus valores.
 * 
 */
public class ComparatorFilmeValor implements Comparator<Filme> {

    /**
     * Compara dois objetos Filme com base em seus valores.
     * 
     * @param filme1 O primeiro objeto Filme a ser comparado
     * @param filme2 O segundo objeto Filme a ser comparado
     * @return Um valor negativo se o valor do filme1 for considerado menor que o valor do filme2,
     *         um valor positivo se o valor do filme1 for considerado maior que o valor do filme2,
     *         e zero se os valores forem iguais.
     */
    @Override
    public int compare(Filme filme1, Filme filme2) {
        double diferencaValor = filme1.getValor() - filme2.getValor();
        if (diferencaValor != 0) {
            return diferencaValor > 0 ? 1 : -1;
        } else {
            return 0;
        }
    }
}
