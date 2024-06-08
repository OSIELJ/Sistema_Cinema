/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

/**
 * Classe abstrata que representa um usuário do sistema.
 * Um usuário possui um nome de usuário, uma senha, um nome e um CPF.
 * Esta classe serve como base para a criação de usuários específicos, como Clientes, Funcionários e Gerentes.
 * 
 * @author Osiel Junior
 */
public abstract class Usuario {
    private final String nomeUsuario;
    private String senha;
    private String nome;
    private String cpf;

    /**
     * Construtor da classe Usuario.
     * 
     * @param nome O nome do usuário.
     * @param cpf O CPF do usuário.
     * @param nomeUsuario O nome de usuário do usuário.
     * @param senha A senha do usuário.
     */
    public Usuario(String nome, String cpf, String nomeUsuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    /**
     * Obtém o nome de usuário do usuário.
     * 
     * @return O nome de usuário do usuário.
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    
    /**
     * Obtém o CPF do usuário.
     * 
     * @return O CPF do usuário.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param senha A nova senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o nome do usuário.
     * 
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     * 
     * @param nome O novo nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o CPF do usuário.
     * 
     * @param cpf O novo CPF do usuário.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Verifica se a senha fornecida corresponde à senha do usuário.
     * 
     * @param senha A senha a ser verificada.
     * @return true se a senha fornecida corresponder à senha do usuário, false caso contrário.
     */
    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }    
}
