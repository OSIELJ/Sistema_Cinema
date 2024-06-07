/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 *
 * @author Osiel
 */
public class ComparatorDataHoraVenda implements Comparator<Venda> {

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