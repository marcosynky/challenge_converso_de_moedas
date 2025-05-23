package services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import configuration.ApiConfig;

import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConverseService {

    private static final String API_KEY = ApiConfig.API_KEY;  // Chave da API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";  // USD como base

    // Método que realiza a conversão e exibe o resultado
    public void converterEExibir(String moedaOrigem, double valor, String moedaDestino) {
        try {
            // Construa a URL para pegar a taxa de câmbio
            String urlString = API_URL;  // Utilizando USD como base
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            connection.setRequestMethod("GET");

            // Lê a resposta da API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse da resposta JSON com Gson
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

            // Conversão em duas etapas:
            // 1. Converter moedaOrigem para USD
            double taxaOrigemParaUSD = rates.get(moedaOrigem).getAsDouble();
            double valorEmUSD = valor / taxaOrigemParaUSD;  // Convertendo o valor da moeda de origem para USD

            // 2. Converter o valor em USD para a moeda de destino
            double taxaUSDFinalParaDestino = rates.get(moedaDestino).getAsDouble();
            double valorConvertido = valorEmUSD * taxaUSDFinalParaDestino;

            // Formatação do resultado para duas casas decimais
            DecimalFormat df = new DecimalFormat("#.##");
            String valorFormatado = df.format(valorConvertido);

            // Exibe o resultado com duas casas decimais
            System.out.println("O valor  de >>> " + valor + " [" + moedaOrigem + "] corresponde ao valor final de >>> " + valorFormatado + " [" + moedaDestino + "]\n");

        } catch (Exception e) {
            System.out.println("Erro ao fazer a requisição para a API de câmbio.");
            e.printStackTrace();
        }
    }
}
