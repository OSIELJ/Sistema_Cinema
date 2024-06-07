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
public class ComparatorNomeCliente implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        String nome1 = cliente1.getNome();
        String nome2 = cliente2.getNome();

        int minLength = Math.min(nome1.length(), nome2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = nome1.charAt(i);
            char c2 = nome2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return nome1.length() - nome2.length();
    }
}
