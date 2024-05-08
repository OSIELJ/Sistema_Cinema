/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;

/**
 *
 * @author Daniel Rodrigues
 */
public class Gerente extends Funcionario {
    
    private Relatorio relatorioDiario;
    private Relatorio relatorioMensalAnual;
    private List<Gerente> listaGerentes;
    
    public Gerente(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }
    
    // Método para adicionar um novo gerente à lista de gerentes
    public void adicionarGerente(Gerente novoGerente) {
        listaGerentes.add(novoGerente);
    }
    
    // Método para remover um gerente da lista de gerentes
    public void removerGerente(Gerente gerenteRemover) {
        listaGerentes.remove(gerenteRemover);
    }
    
    // Método para gerar o relatório diário
    public Relatorio gerarRelatorioDiario() {
        // Lógica para gerar o relatório diário
        return relatorioDiario;
    }
    
    // Método para gerar o relatório mensal/anual
    public Relatorio gerarRelatorioMensalAnual() {
        // Lógica para gerar o relatório mensal/anual
        return relatorioMensalAnual;
    }
    
    // Método para obter a lista de gerentes
    public List<Gerente> getListaGerentes() {
        return listaGerentes;
    }
    
    @Override
    public String toString() {
        return "Gerente{" +
                "relatorioDiario=" + relatorioDiario +
                ", relatorioMensalAnual=" + relatorioMensalAnual +
                ", listaGerentes=" + listaGerentes +
                '}';
    }
}
