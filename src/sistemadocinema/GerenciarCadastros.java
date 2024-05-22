/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;
import Arquivo.Json;

/**
 *
 * @author Osiel
 */
public class GerenciarCadastros {

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;

    public GerenciarCadastros() {
    }

    
    public GerenciarCadastros(List<Cliente> listaClientes, List<Funcionario> listaFuncionarios) {
        this.listaClientes = new ArrayList<>();
        this.listaFuncionarios = new ArrayList<>();
    }

    /*public boolean Existe(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
     */
    public boolean existe(String cpf, Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean existe(String cpf, Funcionario funcionario) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (!existe(cliente.getCpf(), cliente)) {
            listaClientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Cliente já esta cadastrado!");
        }
    }

    public void excluirCliente(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                listaClientes.remove(cliente);        
                System.out.println("Cliente removido com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    public void editarCliente(String cpf, String novoTelefone, String novoEndereco) {
        boolean clienteEncontrado = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {

                if (novoTelefone != null && !novoTelefone.isEmpty()) {
                    cliente.setTelefone(novoTelefone);
                }
                if (novoEndereco != null && !novoEndereco.isEmpty()) {
                    cliente.setEndereco(novoEndereco);
                }
                clienteEncontrado = true;
                System.out.println("Cadastro do cliente atualizado com sucesso!");
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (!existe(funcionario.getCpf(), funcionario)) {
            listaFuncionarios.add(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Funcionário já está cadastrado!");
        }
    }

    public void excluirFuncionario(String cpf) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                listaFuncionarios.remove(funcionario);
                System.out.println("Funcionário removido com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    public void editarFuncionario(String cpf, String novaSenha, String novoNome) {
        boolean funcionarioEncontrado = false;
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                // Atualiza os atributos apenas se as novas informações não forem nulas
                if (novaSenha != null && !novaSenha.isEmpty()) {
                    funcionario.setSenha(novaSenha);
                }
                if (novoNome != null && !novoNome.isEmpty()) {
                    funcionario.setNome(novoNome);
                }
                funcionarioEncontrado = true;
                System.out.println("Cadastro do funcionário atualizado com sucesso!");
                break; // Encerra o loop assim que o funcionário é encontrado e atualizado
            }
        }
        if (!funcionarioEncontrado) {
            System.out.println("Funcionário não encontrado!");
        }
    }
    
    


    public void imprimirListaFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Senha: " + funcionario.getSenha());
        }
    }

}
