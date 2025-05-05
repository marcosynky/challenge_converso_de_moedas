package services;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversaoService {

    private static final String API_KEY = "cb25cd6a06b7c4b2a31e92cb";  // Substitua pela sua chave da API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Faz a requisição à API para obter a taxa de câmbio e exibe o resultado
    public void converterEExibir(String moedaOrigem, double valor, String moedaDestino) {
        try {
            String urlString = API_URL + moedaOrigem;
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

            // Parse o JSON da resposta usando Gson
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
            double taxa = rates.get(moedaDestino).getAsDouble();

            // Realiza a conversão e exibe o resultado
            double valorConvertido = valor * taxa;
            System.out.println("Valor " + valor + " [" + moedaOrigem + "] corresponde ao valor final de >>> " + valorConvertido + " [" + moedaDestino + "]\n");

        } catch (Exception e) {
            System.out.println("Erro ao fazer a requisição para a API de câmbio.");
            e.printStackTrace();
        }
    }
}
