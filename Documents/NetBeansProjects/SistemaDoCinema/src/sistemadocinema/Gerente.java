/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;

/**
 *
 * @author Osiel Junior
 */
public class Gerente extends Usuario{
    
    private Relatorio relatorioDiario;
    private Relatorio relatorioMensalAnual;
    private List<Gerente> listaGerentes;
    
    public Gerente(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }
    
    
            public String getNome() {
        return super.getNome();
    }
        
        public String getCpf() {
        return super.getCpf();
    }
        

    
}
