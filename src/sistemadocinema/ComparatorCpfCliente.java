/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.util.Comparator;

/**
 * Esta classe implementa um Comparator personalizado para comparar objetos do tipo Cliente com base em seus números de CPF.
 * O método compare compara dois objetos Cliente com base em seus CPFs.
 * 
 * @author Osiel
 */
public class ComparatorCpfCliente implements Comparator<Cliente> {
    
    /**
     * Compara dois objetos Cliente com base em seus números de CPF.
     * 
     * @param cliente1 O primeiro objeto Cliente a ser comparado
     * @param cliente2 O segundo objeto Cliente a ser comparado
     * @return Um valor negativo se o CPF do cliente1 for considerado menor que o CPF do cliente2,
     *         um valor positivo se o CPF do cliente1 for considerado maior que o CPF do cliente2,
     *         e zero se os CPFs forem iguais.
     */
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
