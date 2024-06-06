/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import sistemadocinema.Funcionario;

/**
 *s
 * @author Osiel Junior
 */
public class BalcaoAutomatico extends BalcaoDeAtendimento {

    public BalcaoAutomatico(int id, Funcionario funcionarioResponsavel, GerenciarVendas gerenciadorVendas) {
        super(id, funcionarioResponsavel, gerenciadorVendas);
    }



    @Override
    public String toString() {
        return "BalcaoAutomatico{" + '}';
    }
    
    
}