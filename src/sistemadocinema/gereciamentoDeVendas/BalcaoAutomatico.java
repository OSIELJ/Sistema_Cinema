/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import sistemadocinema.Funcionario;

/**
 * Representa um balcão de atendimento automático no sistema de cinema.
 * Herda os atributos e métodos da classe BalcaoDeAtendimento.
 * 
 * @author Osiel Junior
 */
public class BalcaoAutomatico extends BalcaoDeAtendimento {

    /**
     * Construtor da classe BalcaoAutomatico.
     * 
     * @param id Identificador do balcão automático.
     * @param funcionarioResponsavel Funcionário responsável pelo balcão.
     * @param gerenciadorVendas Gerenciador de vendas associado ao balcão.
     */
    public BalcaoAutomatico(int id, Funcionario funcionarioResponsavel, GerenciarVendas gerenciadorVendas) {
        super(id, funcionarioResponsavel, gerenciadorVendas);
    }

    /**
     * Retorna uma representação em string do objeto BalcaoAutomatico.
     * 
     * @return Uma string representando o balcão automático.
     */
    @Override
    public String toString() {
        return "BalcaoAutomatico{}";
    }
    
}
