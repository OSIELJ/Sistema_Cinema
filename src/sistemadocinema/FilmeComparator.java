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
public class FilmeComparator implements Comparator<Filme> {

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
