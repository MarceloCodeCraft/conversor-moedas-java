package com.conversor;

import com.conversor.api.ApiClient;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {
            "USD para BRL",
            "BRL para USD",
            "EUR para BRL",
            "BRL para EUR",
            "GBP para BRL",
            "BRL para GBP"
        };

        System.out.println("Escolha a conversão:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        int choice = scanner.nextInt();
        System.out.print("Digite o valor para converter: ");
        double amount = scanner.nextDouble();

        String from = "", to = "";
        switch (choice) {
            case 1 -> { from = "USD"; to = "BRL"; }
            case 2 -> { from = "BRL"; to = "USD"; }
            case 3 -> { from = "EUR"; to = "BRL"; }
            case 4 -> { from = "BRL"; to = "EUR"; }
            case 5 -> { from = "GBP"; to = "BRL"; }
            case 6 -> { from = "BRL"; to = "GBP"; }
            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        String response = ApiClient.getRates(from);
        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        if (json.has("conversion_rates")) {
            JsonObject rates = json.getAsJsonObject("conversion_rates");
            if (rates.has(to)) {
                double rate = rates.get(to).getAsDouble();
                System.out.printf("%.2f %s equivalem a %.2f %s%n", amount, from, amount * rate, to);
            } else {
                System.out.println("Moeda de destino não encontrada.");
            }
        } else {
            System.out.println("Erro ao obter taxas de câmbio.");
        }
    }
}