/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;
import Arquivo.Json;

/**
 * Gerencia os cadastros de clientes e funcionários no sistema.
 * 
 * @author Osiel Junior
 */
public class GerenciarCadastros {

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;

    /**
     * Construtor padrão da classe.
     */
    public GerenciarCadastros() {
    }

    /**
     * Construtor que inicializa as listas de clientes e funcionários.
     *
     * @param listaClientes    Lista de clientes
     * @param listaFuncionarios    Lista de funcionários
     */
    public GerenciarCadastros(List<Cliente> listaClientes, List<Funcionario> listaFuncionarios) {
        this.listaClientes = new ArrayList<>();
        this.listaFuncionarios = new ArrayList<>();
    }

    /**
     * Verifica se um cliente já está cadastrado.
     *
     * @param cpf    CPF do cliente a ser verificado
     * @param cliente    Objeto Cliente
     * @return true se o cliente já está cadastrado, false caso contrário
     */
    public boolean existe(String cpf, Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se um funcionário já está cadastrado.
     *
     * @param cpf    CPF do funcionário a ser verificado
     * @param funcionario    Objeto Funcionário
     * @return true se o funcionário já está cadastrado, false caso contrário
     */
    public boolean existe(String cpf, Funcionario funcionario) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cadastra um novo cliente.
     *
     * @param cliente    Objeto Cliente a ser cadastrado
     */
    public void cadastrarCliente(Cliente cliente) {
        if (!existe(cliente.getCpf(), cliente)) {
            listaClientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Cliente já está cadastrado!");
        }
    }

    /**
     * Exclui um cliente do cadastro.
     *
     * @param cpf    CPF do cliente a ser excluído
     */
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

    /**
     * Edita os dados de um cliente cadastrado.
     *
     * @param cpf    CPF do cliente a ser editado
     * @param novoTelefone    Novo telefone do cliente
     * @param novoEndereco    Novo endereço do cliente
     */
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

    /**
     * Cadastra um novo funcionário.
     *
     * @param funcionario    Objeto Funcionário a ser cadastrado
     */
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (!existe(funcionario.getCpf(), funcionario)) {
            listaFuncionarios.add(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Funcionário já está cadastrado!");
        }
    }

    /**
     * Exclui um funcionário do cadastro.
     *
     * @param cpf    CPF do funcionário a ser excluído
     */
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

    /**
     * Edita os dados de um funcionário cadastrado.
     *
     * @param cpf    CPF do funcionário a ser editado
     * @param novaSenha    Nova senha do funcionário
     * @param novoNome    Novo nome do funcionário
     */
    public void editarFuncionario(String cpf, String novaSenha, String novoNome) {
        boolean funcionarioEncontrado = false;
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                
                if (novaSenha != null && !novaSenha.isEmpty()) {
                    funcionario.setSenha(novaSenha);
                }
                if (novoNome != null && !novoNome.isEmpty()) {
                    funcionario.setNome(novoNome);
                }
                funcionarioEncontrado = true;
                System.out.println("Cadastro do funcionário atualizado com sucesso!");
                break; 
            }
        }
        if (!funcionarioEncontrado) {
            System.out.println("Funcionário não encontrado!");
        }
    }
    
    /**
     * Imprime a lista de funcionários cadastrados.
     */
    public void imprimirListaFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Senha: " + funcionario.getSenha());
        }
    }
    
    /**
     * Imprime a lista de clientes cadastrados.
     */
    public void imprimirListaClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println("Nome: " + cliente.getNome() + ", telefone: " + cliente.getTelefone() + ",Endereço: " + cliente.getEndereco());      
        }
    }

    @Override
    public String toString() {
        return "GerenciarCadastros{" + "listaClientes=" + listaClientes + ", listaFuncionarios=" + listaFuncionarios + '}';
    }
}
