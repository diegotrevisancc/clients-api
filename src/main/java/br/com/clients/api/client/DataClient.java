package br.com.clients.api.client;

import br.com.clients.api.adress.DataAdress;

public record DataClient(String name, String cpf, String number, String email, DataAdress adress) {
}
