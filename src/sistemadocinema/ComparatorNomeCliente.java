/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.util.Comparator;

/**
 * Esta classe implementa um Comparator personalizado para comparar objetos do tipo Cliente com base em seus nomes.
 * O método compare compara dois objetos Cliente com base em seus nomes.
 */
public class ComparatorNomeCliente implements Comparator<Cliente> {
    
    /**
     * Compara dois objetos Cliente com base em seus nomes.
     * 
     * @param cliente1 O primeiro objeto Cliente a ser comparado
     * @param cliente2 O segundo objeto Cliente a ser comparado
     * @return Um valor negativo se o nome do cliente1 for considerado menor que o nome do cliente2,
     *         um valor positivo se o nome do cliente1 for considerado maior que o nome do cliente2,
     *         e zero se os nomes forem iguais.
     */
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
