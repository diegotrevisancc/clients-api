package br.com.clients.api.client;
import br.com.clients.api.adress.Adress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="clients")
@Entity(name="client")
@Embeddable
@Getter //lombok autogenerates getters
@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String number;
    private String email;
    @Embedded
    private Adress adress;
    private boolean active;

    public Client(DataClient client) {
        this.name = client.name();
        this.cpf = client.cpf();
        this.number = client.number();
        this.email = client.email();
        this.adress = new Adress(client.adress());
        this.active = true;
    }

    public void updateInfo(NewClientData data) {
        if (data.email() != null) {
            this.email = data.email();
        }
        if (data.number() != null) {
            this.number = data.number();
        }
        if (data.adress() != null) {
            this.adress.updateAdress(data.adress());
        }
    }
    public void delete() {
        this.active = false;
    }
}
