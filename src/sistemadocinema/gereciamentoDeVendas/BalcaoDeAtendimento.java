/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import Arquivo.Json;
import java.util.ArrayList;
import java.util.List;
import sistemadocinema.Filme;
import sistemadocinema.Funcionario;

/**
 * Representa um balcão de atendimento no sistema de cinema.
 * 
 * @author Osiel Junior e Daniel Rodrigues
 */
public class BalcaoDeAtendimento {
    protected int id;
    protected Funcionario funcionarioResponsavel;
    protected List<Filme> filmesEmCartaz;
    GerenciarVendas gerenciadorVendas;

    /**
     * Construtor da classe BalcaoDeAtendimento.
     * 
     * @param id Identificador do balcão.
     * @param funcionarioResponsavel Funcionário responsável pelo balcão.
     * @param gerenciadorVendas Gerenciador de vendas associado ao balcão.
     */
    public BalcaoDeAtendimento(int id, Funcionario funcionarioResponsavel, GerenciarVendas gerenciadorVendas) {
        this.id = id;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.filmesEmCartaz = new ArrayList<>();
        this.gerenciadorVendas = gerenciadorVendas;
    }
    
    
        public BalcaoDeAtendimento(int id) {
        this.id = id;

    }
    

    /**
     * Obtém o identificador do balcão.
     * 
     * @return O identificador do balcão.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o funcionário responsável pelo balcão.
     * 
     * @return O funcionário responsável pelo balcão.
     */
    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    /**
     * Obtém a lista de filmes em cartaz no balcão.
     * 
     * @return A lista de filmes em cartaz.
     */
    public List<Filme> getFilmesEmCartaz() {
        return filmesEmCartaz;
    }

    /**
     * Adiciona um filme à lista de filmes em cartaz no balcão.
     * 
     * @param filme O filme a ser adicionado.
     */
    public void adicionarFilme(Filme filme) {
        filmesEmCartaz.add(filme);
        System.out.println("Filme adicionado com sucesso!");
    }

    /**
     * Remove um filme da lista de filmes em cartaz no balcão.
     * 
     * @param filme O filme a ser removido.
     */
    public void removerFilme(Filme filme) {
        filmesEmCartaz.remove(filme);
        System.out.println("Filme removido com sucesso!");
    }

    /**
     * Calcula o rendimento diário do balcão.
     * 
     * @return O rendimento diário do balcão.
     */
    public double calcularRendimentoDiario() {
        return gerenciadorVendas.calcularRendimentoDiario();
    }

    /**
     * Imprime o relatório de vendas do balcão.
     */
    public void imprimirRelatorioVendas() {
        gerenciadorVendas.imprimirRelatorioVendas();
    }

    /**
     * Confirma uma venda realizada no balcão.
     * 
     * @param venda A venda a ser confirmada.
     */
    public void confirmarVenda(Venda venda) {
        gerenciadorVendas.confirmarVenda(venda);
    }

    /**
     * Cancela uma venda realizada no balcão.
     * 
     * @param venda A venda a ser cancelada.
     */
    public void cancelarVenda(Venda venda) {
        gerenciadorVendas.cancelarVenda(venda);
    }

    /**
     * Retorna uma representação em string do objeto BalcaoDeAtendimento.
     * 
     * @return Uma string representando o balcão de atendimento.
     */
    @Override
    public String toString() {
        return "BalcaoDeAtendimento{" + "id=" + id + ", funcionarioResponsavel=" + funcionarioResponsavel + ", filmesEmCartaz=" + filmesEmCartaz + ", gerenciadorVendas=" + gerenciadorVendas + '}';
    }
    
    
}
