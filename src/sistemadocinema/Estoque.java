/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe representa o estoque de produtos do sistema de cinema.
 * Permite adicionar, remover, verificar a validade de produtos e listar os filmes disponíveis.
 * Também fornece métodos para acessar e modificar a lista de produtos.
 * 
 * @author Osiel Junior
 */
public class Estoque {

    private List<Produto> produtos;

    /**
     * Construtor padrão que inicializa a lista de produtos.
     */
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao estoque.
     * 
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }
    
    /**
     * Remove um produto do estoque.
     * 
     * @param produto O produto a ser removido.
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println("Produto removido com sucesso!");
    }

    /**
     * Verifica a validade dos produtos no estoque e imprime os produtos vencidos.
     */
    public void verificarValidadeProdutos() {
        LocalDate dataAtual = LocalDate.now();
        for (Produto produto : produtos) {
            LocalDate dataValidadeProduto = produto.getDataValidade();
            if (dataValidadeProduto.isBefore(dataAtual)) {
                System.out.println("O produto " + produto.getNome() + " está vencido!");
            }
        }
    }

    /**
     * Lista os filmes disponíveis no estoque.
     */
    public void listarFilmesDisponivel() {
        System.out.println("Filmes disponíveis:");
        for (Produto produto : produtos) {
            if (produto instanceof Filme filme) {
                System.out.println(filme.getTitulo());
            }
        }
    }

    /**
     * Obtém a lista de produtos do estoque.
     * 
     * @return A lista de produtos.
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Define a lista de produtos do estoque.
     * 
     * @param produtos A lista de produtos a ser definida.
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Estoque{" + "produtos=" + produtos + '}';
    }
}
