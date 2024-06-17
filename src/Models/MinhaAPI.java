package Models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

public class MinhaAPI {

    public String ConverterMoeda(String moedaRecebida, String moedaConvertida, double valorConversao)
            throws ConnectException {
        final String chaveApiKey = "03104c139207c9e2a1b9b337";

        try {
            final URI uri = URI
                    .create("https://v6.exchangerate-api.com/v6/" + chaveApiKey + "/latest/" + moedaRecebida);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() != 200) {
                throw new ConnectException("Erro ao conectar com a API: Status: " + response.statusCode());
            }

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            MoedaRecebida moedaRecebidaObj = gson.fromJson(json, MoedaRecebida.class);
            double moedaValor = getMoedaValor(moedaConvertida, valorConversao, moedaRecebidaObj);
            String moedaValorFinal = formatoValor(moedaValor);
            String valorFinal = formatoValor(valorConversao);

            return "O valor de " + moedaRecebida + " " + valorFinal +
                    " é equivalente a " + moedaConvertida + " " + moedaValorFinal + ".";

        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O ao acessar a API: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("A operação de conexão foi interrompida: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Erro inesperado: " + e.getMessage(), e);
        }

    }

    private static double getMoedaValor(String moedaConvertida, double valorConversao, MoedaRecebida moedaRecebidaObj) {
        Map<String, Double> conversorMoedas = moedaRecebidaObj.conversionRates();

        if (conversorMoedas == null || conversorMoedas.isEmpty()) {
            throw new RuntimeException("Erro de conversão não disponiveis");
        }

        Double taxaConversao = conversorMoedas.get(moedaConvertida);
        if (taxaConversao == null) {
            throw new RuntimeException("Erro: Taxa de conversão para o tipo de moeda especificada não disponivel");

        }

        return taxaConversao * valorConversao;

    }

    private String formatoValor(Double valorConversao) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(valorConversao);

    }

}
