/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.Comparator;

/**
 *
 * @author Osiel
 */
public class ComparatorEstiloFilme implements Comparator<Filme> {
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
