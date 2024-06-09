/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistemadocinema.Alimenticios;

import sistemadocinema.Cliente;
import sistemadocinema.Estoque;
import sistemadocinema.Produto;
import sistemadocinema.Filme;
import sistemadocinema.Funcionario;

import sistemadocinema.gereciamentoDeVendas.Venda;

/**
 *Classe responsável por gerenciar operações de leitura e escrita de dados em arquivos JSON.
 * 
 * @author Osiel Junior
 */
public class Json {

    public static final String arqCliente = "./src/Arquivo/cliente.json";
    public static final String arqProdutos = "./src/main/java/Arquivo/produtos.json";
    public static final String arqFilmes = "./src/Arquivo/filmes.json";
    public static final String arqExtratoVenda = "./src/Arquivo/extratoVenda.json";
    public static final String arqFuncionario = "./src/Arquivo/funcionario.json";
    public static final String arqVenda = "./src/Arquivo/venda.json";
    public static final String arqAlimenticios = "./src/Arquivo/alimenticios.json";
    public static final String arqEstoque = "./src/Arquivo/estoque.json";

    public Json() {

    }

    /**
     * Salva uma lista de clientes em um arquivo JSON.
     * 
     * @param listaCliente A lista de clientes a ser salva.
     */
    public static void salvarClientes(List<Cliente> listaCliente) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaCliente);

        try (FileWriter writer = new FileWriter(arqCliente)) {
            writer.write(json);
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("Clientes salvos com Sucesso. ");
    }



     /**
     * Lê uma lista de clientes de um arquivo JSON.
     * 
     * @return A lista de clientes lida do arquivo.
     */
    public static List<Cliente> lerClientes() {
        ArrayList<Cliente> listaCliente = new ArrayList();

        try (FileReader reader = new FileReader(arqCliente)) {
            Gson gson = new Gson();
            Type tipoListaClientes = new TypeToken<List<Cliente>>() {
            }.getType();
            listaCliente = gson.fromJson(reader, tipoListaClientes);
        } catch (IOException e) {
        }

        return listaCliente;
    }

    /**
     * Salva uma lista de produtos em um arquivo JSON.
     * 
     * @param listaProduto A lista de produtos a ser salva.
    */
    public static void salvarProdutos(List<Produto> listaProduto) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaProduto);

        try (FileWriter writer = new FileWriter(arqProdutos)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Produtos salvos. ");
    }
    /**
     * Lê uma lista de produtos de um arquivo JSON.
     * 
     * @return A lista de produtos lida do arquivo.
     */
    public static List<Produto> lerProdutos() {
        ArrayList<Produto> listaProduto = new ArrayList();

        try (FileReader reader = new FileReader(arqProdutos)) {
            Gson gson = new Gson();
            Type tipoListaProduto = new TypeToken<List<Produto>>() {
            }.getType();
            listaProduto = gson.fromJson(reader, tipoListaProduto);
        } catch (IOException e) {
        }

        return listaProduto;
    }

    /**
     * Salva uma lista de filmes em um arquivo JSON.
     * 
     * @param listaFilmes A lista de filmes a ser salva.
     */
    public static void salvarFilme(List<Filme> listaFilmes) {
        // Register the custom FilmeAdapter
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Filme.class, new FilmeAdapter())
                .setPrettyPrinting()
                .create();
        
        String json = gson.toJson(listaFilmes);

        try (FileWriter writer = new FileWriter(arqFilmes)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for better error visibility
        }

        System.out.println("Filmes salvos.");
    }

    /**
     * Lê uma lista de filmes de um arquivo JSON.
     * 
     * @return A lista de filmes lida do arquivo.
     */
    public static List<Filme> lerFilmes() {
        ArrayList<Filme> listaFilme = new ArrayList();

        try (FileReader reader = new FileReader(arqFilmes)) {
            Gson gson = new Gson();
            Type tipoListaNotaFiscal = new TypeToken<List<Filme>>() {
            }.getType();
            listaFilme = gson.fromJson(reader, tipoListaNotaFiscal);
        } catch (IOException e) {
        }

        return listaFilme;
    }

    /**
     * Salva o extrato de uma venda em um arquivo JSON.
     * 
     * @param extrato O extrato da venda a ser salvo.
     */
    public static void salvarExtratoVenda(String extrato) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<String> extratos = new ArrayList<>();

        try {
            // Verifica se o arquivo existe e não está vazio
            if (Files.exists(Paths.get(arqExtratoVenda)) && Files.size(Paths.get(arqExtratoVenda)) > 0) {
                try (FileReader reader = new FileReader(arqExtratoVenda)) {
                    // Tenta ler o conteúdo atual como um array de strings
                    String[] existentes = gson.fromJson(reader, String[].class);
                    if (existentes != null) {
                        extratos.addAll(Arrays.asList(existentes));
                    }
                } catch (com.google.gson.JsonSyntaxException e) {
                    // Se houver um erro de sintaxe (não um array), ignore e continue
                    e.printStackTrace();
                }
            }

            // Adiciona o novo extrato à lista
            extratos.add(extrato);

            // Grava a lista atualizada de volta no arquivo
            try (FileWriter writer = new FileWriter(arqExtratoVenda)) {
                gson.toJson(extratos, writer);
            }

            System.out.println("Extrato da venda salvo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Salva uma lista de funcionários em um arquivo JSON.
     * 
     * @param listaFuncionarios A lista de funcionários a ser salva.
     */
        public static void salvarFuncionario(List<Funcionario> listaFuncionarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaFuncionarios);

        try (FileWriter writer = new FileWriter(arqFuncionario)) {
            writer.write(json);
        } catch (IOException e) {
        }
        System.out.println("Funcionarios salvos com sucesso ");
    }
        
        
    /**
     * Lê a lista de funcionários de um arquivo JSON.
     * 
     * @return A lista de funcionários lida do arquivo.
     */
    public static List<Funcionario> lerFuncionarios() {
        Gson gson = new Gson();
        List<Funcionario> listaFuncionarios = null;

        try (FileReader reader = new FileReader(arqFuncionario)) {
            Type tipoListaFuncionario = new TypeToken<List<Funcionario>>() {}.getType();
            listaFuncionarios = gson.fromJson(reader, tipoListaFuncionario);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Funcionarios lidos com sucesso ");
        return listaFuncionarios;
    }        
       
    /**
     * Salva uma lista de vendas em um arquivo JSON.
     * 
     * @param listaVendas A lista de vendas a ser salva.
 */
    public static void salvarVendas(List<Venda> listaVendas) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Venda.class, new VendaAdapter())
                .create();
        
        String json = gson.toJson(listaVendas);

        try (FileWriter writer = new FileWriter(arqVenda)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Vendas salvas com sucesso.");
    }
    
    
     /**
     * Salva uma lista de produtos alimentícios em um arquivo JSON.
     * 
     * @param listaAlimenticios A lista de produtos alimentícios a ser salva.
     */
        public static void salvarAlimenticios(List<Alimenticios> listaAlimenticios) {
        
            
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Alimenticios.class, new AlimenticiosAdapter())
                .setPrettyPrinting()
                .create();
        
        String json = gson.toJson(listaAlimenticios);

        try (FileWriter writer = new FileWriter(arqAlimenticios)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for better error visibility
        }

        System.out.println("Alimenticios salvos.");
    }
        
    /**
     * Salva o estoque em um arquivo JSON.
     * 
     * @param estoque O estoque a ser salvo.
     */
        
    public static void salvarEstoque(Estoque estoque) {
        
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Produto.class, new ProdutoAdapter())
                .registerTypeAdapter(Filme.class, new FilmeAdapter())
                .registerTypeAdapter(Alimenticios.class, new AlimenticiosAdapter())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(estoque);

        try (FileWriter writer = new FileWriter(arqEstoque)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        System.out.println("Estoque salvo com sucesso.");
    }
    
    
    /**
     * Lê uma lista de vendas de um arquivo JSON usando o VendaDeserializer.
     * 
     * @return A lista de vendas lida do arquivo.
     */
    public static List<Venda> lerVendas() {
        List<Venda> listaVendas = new ArrayList<>();

        try (FileReader reader = new FileReader(arqVenda)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Venda.class, new VendaDeserializer())
                    .create();
            Type tipoListaVendas = new TypeToken<List<Venda>>() {}.getType();
            listaVendas = gson.fromJson(reader, tipoListaVendas);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaVendas;
    }
    

    /**
     * Sobrescreve o método toString para retornar uma representação textual da classe Json.
     * 
     * @return A representação textual da classe Json.
     */
        @Override
    public String toString() {
        return "Json{" + '}';
    }

}
