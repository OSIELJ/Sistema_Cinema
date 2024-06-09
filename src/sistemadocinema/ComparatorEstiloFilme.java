/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.util.Comparator;

/**
 * Esta classe implementa um Comparator personalizado para comparar objetos do tipo Filme com base em seus estilos.
 * O método compare compara dois objetos Filme com base em seus estilos.
 * 
 * @author Osiel Junior
 */
public class ComparatorEstiloFilme implements Comparator<Filme> {
    
    /**
     * Compara dois objetos Filme com base em seus estilos.
     * 
     * @param filme1 O primeiro objeto Filme a ser comparado
     * @param filme2 O segundo objeto Filme a ser comparado
     * @return Um valor negativo se o estilo do filme1 for considerado menor que o estilo do filme2,
     *         um valor positivo se o estilo do filme1 for considerado maior que o estilo do filme2,
     *         e zero se os estilos forem iguais.
     */
    @Override
    public int compare(Filme filme1, Filme filme2) {
        String estilo1 = filme1.getEstilo();
        String estilo2 = filme2.getEstilo();

        int minLength = Math.min(estilo1.length(), estilo2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = estilo1.charAt(i);
            char c2 = estilo2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return estilo1.length() - estilo2.length();
    }
}
