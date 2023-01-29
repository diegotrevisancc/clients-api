package br.com.clients.api.client;
import br.com.clients.api.adress.Adress;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter //lombok autogenerates getters
@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
public class Client {
    private String name;
    private String cpf;
    private String number;
    private String email;
    @Embedded
    private Adress adress;

    public Client(DataClient client) {
        this.name = client.name();
        this.cpf = client.cpf();
        this.number = client.number();
        this.email = client.email();
        this.adress = new Adress(client.adress());
    }

}
