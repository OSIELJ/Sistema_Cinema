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
   
    // private List<String> preferencias;
    protected static int contadorClientes = 0;
    private static int totalClientes = 0;

    public Cliente() {

    }


    public Cliente(String nome, String sobrenome, String cpf, String endereco, String telefone) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        // this.preferencias = preferencias;
        totalClientes++;
        contadorClientes++;
    }

    //public List<String> getPreferencias() {
    //   return preferencias;
    //  }
    // public void setPreferencias(List<String> preferencias) {
    // this.preferencias = preferencias;
    //}
    public static int getTotalClientes() {
        return totalClientes;
    }

    public static void setTotalClientes(int totalClientes) {
        Cliente.totalClientes = totalClientes;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Cliente.ultimoId = ultimoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
