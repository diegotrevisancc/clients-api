package br.com.clients.api.controller;

import br.com.clients.api.client.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;
    @PostMapping
    @Transactional
    public void registrateClient(@RequestBody @Valid  DataClient client) { //CREATE
        System.out.println("Success");
        repository.save(new Client(client));
    }
    @GetMapping
    public Page<DataGetClient> getClients(@PageableDefault(size=10, page=0, sort="name") Pageable paginator) { //READ
        return repository.findAll(paginator).map(DataGetClient::new);
    }

    @PutMapping
    @Transactional
    public void updateClient(@RequestBody @Valid NewClientData data) {
        var client = repository.getReferenceById(data.id());
        client.updateInfo(data);
    }


}
