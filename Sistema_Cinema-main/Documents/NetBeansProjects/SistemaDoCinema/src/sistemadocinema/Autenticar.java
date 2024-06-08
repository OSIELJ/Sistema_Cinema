/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osiel Junior
 */  
     
public class Autenticar {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public  void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public  Usuario autenticar(String nomeUsuario, String senha) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.verificarSenha(senha)) {
                if (usuario instanceof Gerente) {
                    System.out.println("O usuário é um gerente.");
                } else if (usuario instanceof Funcionario) {
                    System.out.println("O usuário é um funcionário.");
                }
                return usuario;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Usuários Autenticados:\n");
        for (Usuario usuario : listaUsuarios) {
            sb.append(usuario.getNomeUsuario()).append("\n");
        }
        return sb.toString();
    }
}
