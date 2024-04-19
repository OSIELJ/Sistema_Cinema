/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

/**
 *
 * @author Osiel Junior
 */
public abstract class Usuario {
    private String nomeUsuario;
    private String senha;
    private String nome;
    private String cpf;

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}
