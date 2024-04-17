/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Osiel Junior
 */
public class Cliente {
    
    private static int ultimoId = 0;
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String telefone;
    static List<Cliente> listaCliente;
   // private List<String> preferencias;
    
    
     public Cliente(String nome, String sobrenome, String cpf, String endereco, String telefone) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
       // this.preferencias = preferencias;
    }
    
    

    //public List<String> getPreferencias() {
     //   return preferencias;
  //  }

   // public void setPreferencias(List<String> preferencias) {
       // this.preferencias = preferencias;
    //}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   
    
    
}
