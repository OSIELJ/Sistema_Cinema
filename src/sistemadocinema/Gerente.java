/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;

/**
 * A classe Gerente representa um gerente no sistema de cinema.
 * Herda propriedades da classe Funcionario e inclui funcionalidades adicionais específicas para gerentes,
 * como a geração de relatórios e a gestão de outros gerentes.
 * 
 * @see Funcionario
 * 
 * @author Osiel Junior
 */
public class Gerente extends Funcionario {
    
    private Relatorio relatorioDiario;
    private Relatorio relatorioMensalAnual;
    private List<Gerente> listaGerentes;

    /**
     * Construtor da classe Gerente.
     * 
     * @param nome O nome do gerente.
     * @param cpf O CPF do gerente.
     * @param nomeUsuario O nome de usuário do gerente.
     * @param senha A senha do gerente.
     */
    public Gerente(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }
    
    /**
     * Método para adicionar um novo gerente à lista de gerentes.
     * 
     * @param novoGerente O novo gerente a ser adicionado.
     */
    public void adicionarGerente(Gerente novoGerente) {
        listaGerentes.add(novoGerente);
    }
    
    /**
     * Método para remover um gerente da lista de gerentes.
     * 
     * @param gerenteRemover O gerente a ser removido.
     */
    public void removerGerente(Gerente gerenteRemover) {
        listaGerentes.remove(gerenteRemover);
    }
    
    /**
     * Método para gerar o relatório diário.
     * 
     * @return O relatório diário gerado.
     */
    public Relatorio gerarRelatorioDiario() {
        // Lógica para gerar o relatório diário
        return relatorioDiario;
    }
    
    /**
     * Método para gerar o relatório mensal/anual.
     * 
     * @return O relatório mensal/anual gerado.
     */
    public Relatorio gerarRelatorioMensalAnual() {
        // Lógica para gerar o relatório mensal/anual
        return relatorioMensalAnual;
    }
    
    /**
     * Método para obter a lista de gerentes.
     * 
     * @return A lista de gerentes.
     */
    public List<Gerente> getListaGerentes() {
        return listaGerentes;
    }

    @Override
    public String toString() {
        return "Gerente{" + "relatorioDiario=" + relatorioDiario + ", relatorioMensalAnual=" + relatorioMensalAnual + ", listaGerentes=" + listaGerentes + '}';
    }
}
