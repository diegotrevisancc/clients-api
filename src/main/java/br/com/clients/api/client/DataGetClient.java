package br.com.clients.api.client;

public record DataGetClient(Long id, String name, String email) {
    public DataGetClient(Client client) {
        this(client.getId(), client.getName(), client.getEmail());
    }
}
