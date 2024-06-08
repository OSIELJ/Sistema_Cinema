/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.time.LocalDate;

/**
 * Representa um produto alimentício no sistema de cinema.
 * 
 * <p>A classe {@code Alimenticios} é uma subclasse de {@link Produto} e representa um tipo específico de produto
 * disponível no sistema de cinema. Ela inclui informações sobre o nome do produto, data de validade, valor e quantidade
 * em estoque. Além disso, mantém um contador de produtos alimentícios criados no sistema.</p>
 * 
 * <p>Os métodos definidos nesta classe são:</p>
 * <ul>
 *     <li>{@code getContadorProdutos}: retorna o número total de produtos alimentícios criados no sistema.</li>
 *     <li>{@code setContadorProdutos}: define o número total de produtos alimentícios criados no sistema.</li>
 *     <li>{@code toString}: retorna uma representação em string do objeto {@code Alimenticios}.</li>
 * </ul>
 * 
 * <p>Esta classe fornece uma maneira de gerenciar e interagir com produtos alimentícios específicos dentro do sistema de cinema.</p>
 * 
 * @author Osiel
 */
public class Alimenticios extends Produto {
    private static int contadorProdutos = 0;

    /**
     * Construtor da classe Alimenticios.
     * 
     * @param nome O nome do produto alimentício.
     * @param dataValidade A data de validade do produto alimentício.
     * @param valor O valor do produto alimentício.
     * @param quantidadeEmEstoque A quantidade disponível em estoque do produto alimentício.
     */
    public Alimenticios(String nome, LocalDate dataValidade, double valor, int quantidadeEmEstoque) {
        super(nome, dataValidade, valor, quantidadeEmEstoque);
        contadorProdutos++;
    }

    /**
     * Obtém o número total de produtos alimentícios criados no sistema.
     * 
     * @return O número total de produtos alimentícios criados no sistema.
     */
    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    /**
     * Define o número total de produtos alimentícios criados no sistema.
     * 
     * @param contadorProdutos O número total de produtos alimentícios criados no sistema.
     */
    public static void setContadorProdutos(int contadorProdutos) {
        Alimenticios.contadorProdutos = contadorProdutos;
    }

    /**
     * Retorna uma representação em string do objeto Alimenticios.
     * 
     * @return Uma representação em string do objeto Alimenticios.
     */
    @Override
    public String toString() {
        return "Alimenticios{}";
    }
}
