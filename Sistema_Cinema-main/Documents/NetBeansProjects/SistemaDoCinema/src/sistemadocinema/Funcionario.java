/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;

/**
 *
 * @author Daniel Rodrigues e Osiel Junior
 */


public class Funcionario extends Usuario {
    

    public Funcionario(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }
    
    public String setSenha(){
        
        return super.getSenha();
    }
    
    @Override
    public String getNome() {
        return super.getNome();
    }
        
    public String getCpf() {
        return super.getCpf();
    }
    
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", nomeUsuario='" + getNomeUsuario() + '\'' +
                ", senha='" + getSenha() + '\'' +
                '}';
    }

}
