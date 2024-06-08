/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import sistemadocinema.Funcionario;

/**
 * Representa um balcão de atendimento manual no sistema de cinema.
 * 
 */
public class BalcaoManual extends BalcaoDeAtendimento {

    /**
     * Construtor da classe BalcaoManual.
     * 
     * @param id Identificador do balcão.
     * @param funcionarioResponsavel Funcionário responsável pelo balcão.
     * @param gerenciadorVendas Gerenciador de vendas associado ao balcão.
     */
    public BalcaoManual(int id, Funcionario funcionarioResponsavel, GerenciarVendas gerenciadorVendas) {
        super(id, funcionarioResponsavel, gerenciadorVendas);
    }

    /**
     * Retorna uma representação em string do objeto BalcaoManual.
     * 
     * @return Uma string representando o balcão manual.
     */
    @Override
    public String toString() {
        return "BalcaoManual{" + '}';
    }   
}
