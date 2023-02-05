package br.com.clients.api.client;

import br.com.clients.api.adress.DataAdress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataClient(
        @NotBlank
        String name,
        @NotBlank
        String cpf,
        @NotBlank
        String number,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Valid
        DataAdress adress) {
}
