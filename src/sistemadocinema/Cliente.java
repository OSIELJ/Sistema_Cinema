/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package sistemadocinema;

/**
 * Representa um cliente do sistema de cinema.
 * 
 * <p>A classe {@code Cliente} representa um cliente do sistema de cinema. Cada cliente possui um identificador único,
 * nome, sobrenome, CPF, endereço e número de telefone.</p>
 * 
 * <p>Os métodos definidos nesta classe são:</p>
 * <ul>
 *     <li>{@code Cliente}: construtor padrão.</li>
 *     <li>{@code Cliente}: construtor que inicializa os atributos do cliente.</li>
 *     <li>{@code getTotalClientes}: retorna o número total de clientes.</li>
 *     <li>{@code setTotalClientes}: define o número total de clientes.</li>
 *     <li>{@code getUltimoId}: retorna o último identificador de cliente gerado.</li>
 *     <li>{@code setUltimoId}: define o último identificador de cliente gerado.</li>
 *     <li>{@code getId}: retorna o identificador do cliente.</li>
 *     <li>{@code setId}: define o identificador do cliente.</li>
 *     <li>{@code getNome}: retorna o nome do cliente.</li>
 *     <li>{@code setNome}: define o nome do cliente.</li>
 *     <li>{@code getSobrenome}: retorna o sobrenome do cliente.</li>
 *     <li>{@code setSobrenome}: define o sobrenome do cliente.</li>
 *     <li>{@code getCpf}: retorna o CPF do cliente.</li>
 *     <li>{@code setCpf}: define o CPF do cliente.</li>
 *     <li>{@code getEndereco}: retorna o endereço do cliente.</li>
 *     <li>{@code setEndereco}: define o endereço do cliente.</li>
 *     <li>{@code getTelefone}: retorna o número de telefone do cliente.</li>
 *     <li>{@code setTelefone}: define o número de telefone do cliente.</li>
 *     <li>{@code toString}: retorna uma representação em string do objeto {@code Cliente}.</li>
 * </ul>
 * 
 * <p>Esta classe fornece uma maneira de representar informações sobre clientes no sistema de cinema e gerenciar
 * atributos relacionados a esses clientes.</p>
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
   
    protected static int contadorClientes = 0;
    private static int totalClientes = 0;

    /**
     * Construtor padrão para a classe Cliente.
     */
    public Cliente() {

    }

    /**
     * Construtor para inicializar os atributos do cliente.
     * 
     * @param nome O nome do cliente.
     * @param sobrenome O sobrenome do cliente.
     * @param cpf O CPF do cliente.
     * @param endereco O endereço do cliente.
     * @param telefone O número de telefone do cliente.
     */
    public Cliente(String nome, String sobrenome, String cpf, String endereco, String telefone) {
        this.id = ++ultimoId;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        totalClientes++;
        contadorClientes++;
    }

    /**
     * Retorna o número total de clientes.
     * 
     * @return O número total de clientes.
     */
    public static int getTotalClientes() {
        return totalClientes;
    }

    /**
     * Define o número total de clientes.
     * 
     * @param totalClientes O número total de clientes.
     */
    public static void setTotalClientes(int totalClientes) {
        Cliente.totalClientes = totalClientes;
    }

    /**
     * Retorna o último identificador de cliente gerado.
     * 
     * @return O último identificador de cliente gerado.
     */
    public static int getUltimoId() {
        return ultimoId;
    }

    /**
     * Define o último identificador de cliente gerado.
     * 
     * @param ultimoId O último identificador de cliente gerado.
     */
    public static void setUltimoId(int ultimoId) {
        Cliente.ultimoId = ultimoId;
    }

    /**
     * Retorna o identificador do cliente.
     * 
     * @return O identificador do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do cliente.
     * 
     * @param id O identificador do cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do cliente.
     * 
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * 
     * @param nome O nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o sobrenome do cliente.
     * 
     * @return O sobrenome do cliente.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o sobrenome do cliente.
     * 
     * @param sobrenome O sobrenome do cliente.
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Retorna o CPF do cliente.
     * 
     * @return O CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     * 
     * @param cpf O CPF do cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o endereço do cliente.
     * 
     * @return O endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     * 
     * @param endereco O endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o número de telefone do cliente.
     * 
     * @return O número de telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o número de telefone do cliente.
     * 
     * @param telefone O número de telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna uma representação em string do objeto Cliente.
     * 
     * @return Uma representação em string do objeto Cliente.
     */
    @Override
    public String toString() {
    return "Cliente{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", sobrenome='" + sobrenome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", endereco='" + endereco + '\'' +
            ", telefone='" + telefone + '\'' +
            '}';
}
}
