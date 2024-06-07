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
 *
 * @author Osiel
 */
public class ProdutoAdapter implements JsonSerializer<Produto>, JsonDeserializer<Produto> {
    
    @Override
    public JsonElement serialize(Produto produto, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", produto.getClass().getSimpleName());
        jsonObject.add("properties", context.serialize(produto, produto.getClass()));
        return jsonObject;
    }

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
