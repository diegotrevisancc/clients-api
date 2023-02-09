package br.com.clients.api.client;

import br.com.clients.api.client.*;
import br.com.clients.api.controller.DataClientDetails;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity registrateClient(@RequestBody @Valid  DataClient clientData, UriComponentsBuilder uriBuilder) { //CREATE
        var client = new Client(clientData);

        repository.save(client);

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri(); //store the location where data was saved inside header HTTP

        return ResponseEntity.created(uri).body(new DataClientDetails(client));
    }
    @GetMapping
    public ResponseEntity<Page<DataGetClient>> getClients(@PageableDefault(size=10, page=0, sort="name") Pageable paginator) { //READ
        var page = repository.findAllByActiveTrue(paginator).map(DataGetClient::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody @Valid NewClientData data) { //UPDATE
        var client = repository.getReferenceById(data.id());
        client.updateInfo(data);
        return ResponseEntity.ok(new DataClientDetails(client));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable Long id) { //DELETE
        var client = repository.getReferenceById(id);
        client.delete();
        return ResponseEntity.noContent().build();
    }


}
