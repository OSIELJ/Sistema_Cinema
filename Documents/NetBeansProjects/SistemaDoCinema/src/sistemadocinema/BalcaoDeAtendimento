/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;


import java.util.List;
/**
 *
 * @author Osiel Junior e Daniel Rodrigues
 */
public class BalcaoDeAtendimento {
    
    private Cliente cliente;
    private int id;
    private Funcionario funcionarioResponsavel;
    private List<Venda> vendas;
    private List<Filme> filmes;

    // Construtor
    public BalcaoDeAtendimento(Cliente cliente) {
        this.cliente = cliente;
    }
    
    // Método de boas-vindas
    public void bemVindo() {
        if (this.cliente != null) {
            System.out.println("Bem-vindo, " + cliente.getNome() + "!");
        }
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    // Método toString para representação em string do objeto
    @Override
    public String toString() {
        return "BalcaoDeAtendimento{" +
                "cliente=" + cliente +
                ", id=" + id +
                ", funcionarioResponsavel=" + funcionarioResponsavel +
                ", vendas=" + vendas +
                ", filmes=" + filmes +
                '}';
    }
}
