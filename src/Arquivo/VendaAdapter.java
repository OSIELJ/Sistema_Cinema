/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;

import sistemadocinema.Produto;
import sistemadocinema.gereciamentoDeVendas.Venda;

/**
 * Classe responsável por adaptar objetos do tipo Venda para JSON utilizando o Gson.
 * Implementa JsonSerializer para fornecer uma forma personalizada de serializar Venda.
 * 
 * @author Osiel Junior
 */
public class VendaAdapter implements JsonSerializer<Venda> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

     /**
     * Serializa um objeto Venda em seu formato JSON.
     * 
     * @param venda O objeto Venda a ser serializado.
     * @param typeOfSrc O tipo do objeto de origem.
     * @param context O contexto de serialização.
     * @return O JsonElement que representa o objeto Venda em formato JSON.
     */
    @Override
    public JsonElement serialize(Venda venda, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("cliente", venda.getCliente().getNome());
        json.addProperty("cpf", venda.getCliente().getCpf());
        json.addProperty("dataHora", formatter.format(venda.getDataHora()));
        json.addProperty("balcao", venda.getBalcao().getId());

        JsonArray itensVendidosArray = new JsonArray();
        for (Produto produto : venda.getItensVendidos()) {
            JsonObject itemJson = new JsonObject();
            itemJson.addProperty("nome", produto.getNome());
            itemJson.addProperty("valor", produto.getValor());
            itensVendidosArray.add(itemJson);
        }
        json.add("itensVendidos", itensVendidosArray);

        json.addProperty("total", venda.getValorTotal());

        return json;
    }
}