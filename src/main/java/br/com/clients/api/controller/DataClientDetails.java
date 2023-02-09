package br.com.clients.api.controller;

import br.com.clients.api.adress.Adress;
import br.com.clients.api.client.Client;

public record DataClientDetails(Long id, String name, String cpf, String number, String email, Adress adress) {
    public DataClientDetails(Client client) {
        this(client.getId(), client.getName(), client.getNumber(), client.getNumber(), client.getEmail(), client.getAdress());
    }
}
