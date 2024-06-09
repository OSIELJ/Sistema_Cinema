/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 * ComparatorDataHoraVenda é uma classe que implementa a interface Comparator,
 * usada para comparar duas vendas com base na data e hora em que foram realizadas.
 * 
 * @author Osiel Junior
 */
public class ComparatorDataHoraVenda implements Comparator<Venda> {

    /**
     * Compara duas vendas com base na data e hora em que foram realizadas.
     * 
     * @param venda1 A primeira venda a ser comparada.
     * @param venda2 A segunda venda a ser comparada.
     * @return Um valor negativo se a primeira venda ocorrer antes da segunda,
     *         um valor positivo se ocorrer depois e zero se forem iguais.
     */
    @Override
    public int compare(Venda venda1, Venda venda2) {
        LocalDateTime dataHora1 = venda1.getDataHora();
        LocalDateTime dataHora2 = venda2.getDataHora();

        if (dataHora1.isBefore(dataHora2)) {
            return -1;
        } else if (dataHora1.isAfter(dataHora2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
