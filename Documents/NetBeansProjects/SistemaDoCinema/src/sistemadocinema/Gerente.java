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
    
    public Gerente(String nomeUsuario, String senha) {
        super(nomeUsuario, senha);
    }
    
}
