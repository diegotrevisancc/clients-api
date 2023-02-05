package br.com.clients.api.client;

import br.com.clients.api.adress.DataAdress;
import jakarta.validation.constraints.NotNull;

public record NewClientData(
        @NotNull
        Long id,
        String email,
        String number,
        DataAdress adress) {
}
