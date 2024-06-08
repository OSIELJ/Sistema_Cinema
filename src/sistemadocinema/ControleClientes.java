/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/**
 * Classe responsável por controlar uma lista de clientes.
 * Permite encontrar um cliente com base em um comparador personalizado.
 */
public class ControleClientes {
    private final List<Cliente> clientes;

        /**
     * Constrói um novo controle de clientes com a lista fornecida.
     *
     * @param clientes A lista de clientes a ser controlada.
     */
    public ControleClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

        /**
     * Encontra e retorna um cliente com base no comparador fornecido.
     * Retorna o primeiro cliente encontrado que corresponde ao critério do comparador.
     *
     * @param comparator O comparador usado para determinar a ordem dos clientes.
     * @return O cliente encontrado, ou null se a lista de clientes for nula ou vazia.
     */
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
