/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import sistemadocinema.Alimenticios;
import sistemadocinema.Cliente;
import sistemadocinema.Filme;
import sistemadocinema.Produto;
import sistemadocinema.gereciamentoDeVendas.BalcaoDeAtendimento;
import sistemadocinema.gereciamentoDeVendas.Venda;

/**
 * Classe responsável por desserializar objetos do tipo Venda a partir de JSON.
 * Implementa a interface JsonDeserializer para personalizar o processo de desserialização.
 * 
 * @author Osiel
 */
public class VendaDeserializer implements JsonDeserializer<Venda> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Desserializa um objeto Venda a partir de um elemento JSON.
     * 
     * @param json O elemento JSON a ser desserializado.
     * @param typeOfT O tipo do objeto de origem.
     * @param context O contexto de desserialização.
     * @return O objeto Venda desserializado.
     * @throws JsonParseException Se ocorrer um erro durante a desserialização.
     */
    @Override
    public Venda deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String clienteNome = jsonObject.get("cliente").getAsString();
        String clienteCpf = jsonObject.get("cpf").getAsString();
        Cliente cliente = new Cliente(clienteNome, clienteCpf);

        String dataHoraStr = jsonObject.get("dataHora").getAsString();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);

        int balcaoId = jsonObject.get("balcao").getAsInt();
        BalcaoDeAtendimento balcao = new BalcaoDeAtendimento(balcaoId);

        List<Produto> itensVendidos = new ArrayList<>();
        JsonArray itensVendidosArray = jsonObject.getAsJsonArray("itensVendidos");
        for (JsonElement itemElement : itensVendidosArray) {
            JsonObject itemJson = itemElement.getAsJsonObject();
            String nome = itemJson.get("nome").getAsString();
            double valor = itemJson.get("valor").getAsDouble();
 
            Produto produto;
            if (itemJson.has("periodoExibicao")) {
                String estilo = itemJson.get("estilo").getAsString();
                String periodoExibicao = itemJson.get("periodoExibicao").getAsString();
                produto = new Filme(nome, estilo, dataHora.toLocalDate(), valor, 0, periodoExibicao);
            } else {
                produto = new Alimenticios(nome, dataHora.toLocalDate(), valor, 0);
            }
            itensVendidos.add(produto);
        }

        double valorTotal = jsonObject.get("total").getAsDouble();

        Venda venda = new Venda(cliente, balcao);
        venda.setItensVendidos(itensVendidos);
        venda.setDataHora(dataHora);
        venda.setValorTotal(valorTotal);

        return venda;
    }
}
