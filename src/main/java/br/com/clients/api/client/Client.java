package br.com.clients.api.client;

import br.com.clients.api.adress.Adress;

public record Client(String name, String cpf, String number, String email, Adress adress) {
}
