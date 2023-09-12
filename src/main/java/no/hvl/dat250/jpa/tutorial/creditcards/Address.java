package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.model.internal.CopyIdentifierComponentSecondPass;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private Integer number;

    @Getter
    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners = new HashSet<>();


    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public Address() {

    }
}
