/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change esta licença
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package sistemadocinema;

import java.time.LocalDate;

/**
 * A classe Produto representa um produto genérico no sistema do cinema.
 * Esta classe inclui atributos comuns a todos os produtos, como nome, data de validade,
 * valor e quantidade em estoque.
 * 
 */
public abstract class Produto {

    private static int contadorProdutos = 0;
    private String nome;
    private LocalDate dataValidade;
    private double valor;
    private int quantidadeEmEstoque;

    /**
     * Construtor da classe Produto.
     *
     * @param nome O nome do produto.
     * @param dataValidade A data de validade do produto.
     * @param valor O valor do produto.
     * @param quantidadeEmEstoque A quantidade em estoque do produto.
     */
    public Produto(String nome, LocalDate dataValidade, double valor, int quantidadeEmEstoque) {
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        contadorProdutos++;
    }

    /**
     * Obtém o contador total de produtos.
     *
     * @return O contador de produtos.
     */
    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    /**
     * Define o contador total de produtos.
     *
     * @param contadorProdutos O novo valor do contador de produtos.
     */
    public static void setContadorProdutos(int contadorProdutos) {
        Produto.contadorProdutos = contadorProdutos;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a data de validade do produto.
     *
     * @return A data de validade do produto.
     */
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    /**
     * Define a data de validade do produto.
     *
     * @param dataValidade A nova data de validade do produto.
     */
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Obtém o valor do produto.
     *
     * @return O valor do produto.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor do produto.
     *
     * @param valor O novo valor do produto.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém a quantidade em estoque do produto.
     *
     * @return A quantidade em estoque do produto.
     */
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    /**
     * Define a quantidade em estoque do produto.
     *
     * @param quantidadeEmEstoque A nova quantidade em estoque do produto.
     */
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    /**
     * Verifica se o produto está vencido.
     *
     * @return true se o produto estiver vencido, false caso contrário.
     */
    public boolean estaVencido() {
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.isAfter(dataValidade);
    }

    /**
     * Realiza a venda de uma quantidade especificada do produto.
     *
     * @param quantidade A quantidade a ser vendida.
     */
    public void vender(int quantidade) {
        if (quantidade > quantidadeEmEstoque) {
            System.out.println("Quantidade insuficiente em estoque.");
        } else {
            quantidadeEmEstoque -= quantidade;
            System.out.println("Venda realizada com sucesso.");
        }
    }

    /**
     * Adiciona uma quantidade especificada ao estoque do produto.
     *
     * @param quantidade A quantidade a ser adicionada ao estoque.
     */
    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
        System.out.println("Estoque atualizado com sucesso!");
    }

    /**
     * Calcula o valor total para uma quantidade especificada do produto.
     *
     * @param quantidade A quantidade do produto.
     * @return O valor total.
     */
    public double calcularTotal(int quantidade) {
        return valor * quantidade;
    }

    /**
     * Retorna uma representação em String do produto.
     *
     * @return Uma string representando o produto.
     */
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", dataValidade=" + dataValidade +
                ", valor=" + valor +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }
}
