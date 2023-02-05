package br.com.clients.api.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAdress(
        @NotBlank
        String street,
        @NotBlank
        @Pattern(regexp="\\d{8}")
        String zip,
        @NotBlank
        String state,
        @NotBlank
        String city,
        @NotBlank
        String country) {
}
