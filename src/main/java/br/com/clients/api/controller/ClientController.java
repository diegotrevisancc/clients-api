package br.com.clients.api.controller;

import br.com.clients.api.client.Client;
import br.com.clients.api.client.ClientRepository;
import br.com.clients.api.client.DataClient;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;
    @PostMapping
    @Transactional
    public void registrateClient(@RequestBody @Valid  DataClient client) {
        System.out.println("Success");
        repository.save(new Client(client));
    }
}
