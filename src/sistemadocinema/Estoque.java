/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Osiel Junior
 */
public class Estoque {

    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }
    
    


    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }
    
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println("Produto removido com sucesso!");
    }

    public void verificarValidadeProdutos() {
        LocalDate dataAtual = LocalDate.now();
        for (Produto produto : produtos) {
            LocalDate dataValidadeProduto = produto.getDataValidade();
            if (dataValidadeProduto.isBefore(dataAtual)) {
                System.out.println("O produto " + produto.getNome() + " esta vencido!");
            }
        }
    }

    public void listarFilmesDisponivel() {
        System.out.println("Filmes disponíveis:");
        for (Produto produto : produtos) {
            if (produto instanceof Filme filme) {
                System.out.println(filme.getTitulo());
            } else {
            }
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Estoque{" + "produtos=" + produtos + '}';
    }
    
    
}
