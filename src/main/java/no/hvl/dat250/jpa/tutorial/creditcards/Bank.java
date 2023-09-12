package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @OneToMany(mappedBy = "bank")
    @Setter
    private Set<CreditCard> ownedCards = new HashSet<>();

    public Bank(String name) {
        this.name = name;
    }

    public Bank() {

    }


    public void addCreditCard(CreditCard creditCard) {
        ownedCards.add(creditCard);
    }
}
