/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;

/**
 * Realiza a autenticação de usuários no sistema de cinema.
 * 
 * <p>A classe {@code Autenticar} é responsável por gerenciar a autenticação de usuários no sistema de cinema. Ela
 * mantém uma lista de usuários registrados e fornece métodos para adicionar novos usuários e autenticar usuários
 * existentes.</p>
 * 
 * <p>Os métodos definidos nesta classe são:</p>
 * <ul>
 *     <li>{@code adicionarUsuario}: adiciona um novo usuário à lista de usuários registrados.</li>
 *     <li>{@code autenticar}: autentica um usuário com base no nome de usuário e senha fornecidos.</li>
 *     <li>{@code toString}: retorna uma representação em string do objeto {@code Autenticar}.</li>
 * </ul>
 * 
 * <p>Esta classe fornece uma maneira de controlar o acesso ao sistema de cinema, garantindo que apenas usuários
 * autorizados possam fazer login e usar os recursos disponíveis.</p>
 * 
 * @author Osiel Junior
 */  
public class Autenticar {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    /**
     * Adiciona um novo usuário à lista de usuários registrados.
     * 
     * @param usuario O usuário a ser adicionado à lista.
     */
    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    /**
     * Autentica um usuário com base no nome de usuário e senha fornecidos.
     * 
     * @param nomeUsuario O nome de usuário do usuário a ser autenticado.
     * @param senha A senha do usuário a ser autenticado.
     * @return O usuário autenticado, ou {@code null} se a autenticação falhar.
     */
    public Usuario autenticar(String nomeUsuario, String senha) {
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

    /**
     * Retorna uma representação em string do objeto Autenticar.
     * 
     * @return Uma representação em string do objeto Autenticar.
     */
    @Override
    public String toString() {
        return "Autenticar{}";
    }
}
