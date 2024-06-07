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
 *
 * @author Osiel Junior
 */
public class Json {

    public static final String arqCliente = "./src/Arquivo/cliente.json";
    public static final String arqProdutos = "./src/main/java/Arquivo/produtos.json";
    public static final String arqFilmes = "./src/Arquivo/filmes.json";
    public static final String arqExtratoVenda = "C:/Users/Osiel/Documents/NetBeansProjects/Sistema_Cinema/src/Arquivo/extratoVenda.json";
    public static final String arqFuncionario = "./src/Arquivo/funcionario.json";
    public static final String arqVenda = "./src/Arquivo/venda.json";
    public static final String arqAlimenticios = "./src/Arquivo/alimenticios.json";
    public static final String arqEstoque = "./src/Arquivo/estoque.json";

    public Json() {

    }

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
    
    
    
    
        public static void salvarFuncionario(List<Funcionario> listaFuncionarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaFuncionarios);

        try (FileWriter writer = new FileWriter(arqFuncionario)) {
            writer.write(json);
        } catch (IOException e) {
        }
        System.out.println("Funcionarios salvos com sucesso ");
    }
        

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



    
    
    
        @Override
    public String toString() {
        return "Json{" + '}';
    }

}
