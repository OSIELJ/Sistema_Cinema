/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;



import com.google.gson.*;
import sistemadocinema.Alimenticios;
import sistemadocinema.Filme;
import sistemadocinema.Produto;

import java.lang.reflect.Type;

/**
 * Adaptador para serialização e desserialização de objetos do tipo Produto.
 * Este adaptador trata especificamente os subtipos Filme e Alimenticios.
 * 
 * @author Osiel Junior
 * 
 */
public class ProdutoAdapter implements JsonSerializer<Produto>, JsonDeserializer<Produto> {
    
     /**
     * Serializa um objeto Produto para seu formato JSON correspondente.
     * 
     * @param produto O objeto Produto a ser serializado.
     * @param typeOfSrc O tipo do objeto fonte.
     * @param context O contexto de serialização.
     * @return O JsonElement que representa o objeto Produto.
     */
    @Override
    public JsonElement serialize(Produto produto, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", produto.getClass().getSimpleName());
        jsonObject.add("properties", context.serialize(produto, produto.getClass()));
        return jsonObject;
    }

     /**
     * Desserializa um JsonElement para um objeto Produto.
     * Este método identifica o subtipo de Produto (Filme ou Alimenticios)
     * com base no campo "type" do JSON e desserializa para o tipo apropriado.
     * 
     * @param json O elemento JSON a ser desserializado.
     * @param typeOfT O tipo do objeto destino.
     * @param context O contexto de desserialização.
     * @return O objeto Produto desserializado.
     * @throws JsonParseException Se ocorrer um erro durante a desserialização.
     */
    @Override
    public Produto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            switch (type) {
                case "Filme":
                    return context.deserialize(element, Filme.class);
                case "Alimenticios":
                    return context.deserialize(element, Alimenticios.class);
                default:
                    throw new JsonParseException("Unknown element type: " + type);
            }
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
