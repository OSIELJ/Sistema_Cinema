/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Osiel Junior e Daniel Rodrigues
 */

public class Venda {
    private int id;
    private Date dataHora;
    private Cliente cliente;
    private List<Produto> produtosVendidos;


    public Venda(int id, Date dataHora, Cliente cliente, List<Produto> produtosVendidos) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.produtosVendidos = produtosVendidos;
    }

   
    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtosVendidos) {
            total += produto.getValor();
        }
        return total;
    }
   
    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", cliente=" + cliente +
                ", produtosVendidos=" + produtosVendidos +
                '}';
    }
}

