/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.time.LocalDate;

/**
 *
 * @author Osiel
 */
public class Alimenticios extends Produto {
    private static int contadorProdutos = 0;

    public Alimenticios(String nome, LocalDate dataValidade, double valor, int quantidadeEmEstoque) {
        
        super(nome, dataValidade, valor, quantidadeEmEstoque);
        contadorProdutos++;
      
    }

    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    public static void setContadorProdutos(int contadorProdutos) {
        Alimenticios.contadorProdutos = contadorProdutos;
    }

    @Override
    public String toString() {
        return "Alimenticios{" + '}';
    }
        
    
    }