package br.com.clients.api.controller;

import br.com.clients.api.client.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @PostMapping
    public void registrateClient(@RequestBody Client client) {
        System.out.println(client.adress().zip());
    }
}
