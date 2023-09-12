package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private Integer number;

    @Getter
    @Setter
    private Integer balance;

    @Getter
    @Setter
    private Integer creditLimit;
    @Getter
    @ManyToOne
    @Setter
    private Pincode pincode;
    @ManyToOne
    @Setter
    private Bank bank;

    public CreditCard(int number, int balance, int creditLimit, Pincode pincode, Bank bank) {
        this.number = number;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.pincode = pincode;
        this.bank = bank;
    }

    public CreditCard() {

    }


    public Bank getOwningBank() {
        return bank;
    }


}
