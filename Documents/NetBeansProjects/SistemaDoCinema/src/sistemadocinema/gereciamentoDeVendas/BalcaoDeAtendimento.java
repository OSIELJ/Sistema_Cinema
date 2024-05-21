/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;


import java.util.ArrayList;
import java.util.List;
import sistemadocinema.Filme;
import sistemadocinema.Funcionario;
/**
 *
 * @author Osiel Junior e Daniel Rodrigues
 */
public class BalcaoDeAtendimento {
    
    protected int id;
    protected Funcionario funcionarioResponsavel;
    protected List<Venda> vendas;
    protected List<Filme> filmesEmCartaz;

    public BalcaoDeAtendimento(int id, Funcionario funcionarioResponsavel) {
        this.id = id;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.vendas = new ArrayList<>();
        this.filmesEmCartaz = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Filme> getFilmesEmCartaz() {
        return filmesEmCartaz;
    }

    public void confirmarVenda(Venda venda) {
        vendas.add(venda);
        System.out.println("Venda realizada com sucesso!");
        venda.gerarExtrato();
    }

    public void cancelarVenda(Venda venda) {
        vendas.remove(venda);
        System.out.println("Venda cancelada com sucesso!");
    }

    public void adicionarFilme(Filme filme) {
        filmesEmCartaz.add(filme);
        System.out.println("Filme adicionado com sucesso!");
    }

    public void removerFilme(Filme filme) {
        filmesEmCartaz.remove(filme);
        System.out.println("Filme removido com sucesso!");
    }

    public double calcularRendimentoDiario() {
        double rendimento = 0.0;
        for (Venda venda : vendas) {
            rendimento += venda.calcularTotal();
        }
        return rendimento;
    }

    public void imprimirRelatorioVendas() {
        System.out.println("Relatório de Vendas:");
        for (Venda venda : vendas) {
            System.out.println(venda.toString());
        }
    }
}

