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
    protected List<Filme> filmesEmCartaz;
    GerenciarVendas gerenciadorVendas;

    public BalcaoDeAtendimento(int id, Funcionario funcionarioResponsavel, GerenciarVendas gerenciadorVendas) {
        this.id = id;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.filmesEmCartaz = new ArrayList<>();
        this.gerenciadorVendas = gerenciadorVendas;
    }

    public int getId() {
        return id;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public List<Filme> getFilmesEmCartaz() {
        return filmesEmCartaz;
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
        return gerenciadorVendas.calcularRendimentoDiario();
    }

    public void imprimirRelatorioVendas() {
        gerenciadorVendas.imprimirRelatorioVendas();
        
    }

    public void confirmarVenda(Venda venda) {
        gerenciadorVendas.confirmarVenda(venda);
    }

    public void cancelarVenda(Venda venda) {
        gerenciadorVendas.cancelarVenda(venda);
    }

    @Override
    public String toString() {
        return "BalcaoDeAtendimento{" + "id=" + id + ", funcionarioResponsavel=" + funcionarioResponsavel + ", filmesEmCartaz=" + filmesEmCartaz + ", gerenciadorVendas=" + gerenciadorVendas + '}';
    }
    
    
}

