/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Osiel
 */
public class ControleClientes {
    private final List<Cliente> clientes;

    public ControleClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente find(Comparator<Cliente> comparator) {
        if (clientes == null || clientes.isEmpty()) {
            return null;
        }

        Iterator<Cliente> iterator = clientes.iterator();
        Cliente primeiro = iterator.next();
        
        while (iterator.hasNext()) {
            Cliente current = iterator.next();
            if (comparator.compare(current, primeiro) < 0) {
                primeiro = current;
            }
        }
        return primeiro;
    }
}
