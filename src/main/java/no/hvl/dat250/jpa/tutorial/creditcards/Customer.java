package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;
    @Getter
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Address> addresses = new ArrayList<>();
    @Getter
    @ManyToMany
    private Collection<CreditCard> creditCards = new HashSet<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {

    }


    public void addAddress(Address address) {
        addresses.add(address);
    }


    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }
}
