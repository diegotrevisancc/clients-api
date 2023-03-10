package br.com.clients.api.adress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter //lombok autogenerates getters
@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
public class Adress {
    private String street;
    private String zip;
    private String state;
    private String city;
    private String country;

    public Adress(DataAdress adress) {
        this.street = adress.street();
        this.zip = adress.zip();
        this.state = adress.state();
        this.city = adress.zip();
        this.country = adress.country();
    }

    public void updateAdress(DataAdress adress) {
        if (adress.street() != null) {
            this.street = adress.street();
        }
        if (adress.zip() != null) {
            this.zip = adress.zip();
        }
        if (adress.state() != null) {
            this.state = adress.state();
        }
        if (adress.city() != null) {
            this.city = adress.city();
        }
        if (adress.country() != null) {
            this.country = adress.country();
        }
    }
}

