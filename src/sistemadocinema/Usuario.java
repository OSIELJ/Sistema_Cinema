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
    private final String nomeUsuario;
    private String senha;
    private String nome;
    private String cpf;

    public Usuario(String nome,String cpf, String nomeUsuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    
        public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
        
        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
    
}
