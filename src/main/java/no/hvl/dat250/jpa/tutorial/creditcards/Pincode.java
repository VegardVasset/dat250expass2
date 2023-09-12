package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pincode {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    @Getter
    @Setter
    private Integer count;

    public Pincode(String pincode, int count) {
        this.pincode = pincode;
        this.count = count;
    }

    public Pincode() {

    }

    public String getCode() {
        return pincode;
    }
    

}
