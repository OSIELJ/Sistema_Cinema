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
public class ComparatorCpfCliente implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        String cpf1 = cliente1.getCpf();
        String cpf2 = cliente2.getCpf();

        int minLength = Math.min(cpf1.length(), cpf2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = cpf1.charAt(i);
            char c2 = cpf2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return cpf1.length() - cpf2.length();
    }
}