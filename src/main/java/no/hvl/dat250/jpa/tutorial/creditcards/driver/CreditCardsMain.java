package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {

    // Initialize objects with data and persist to database
    Customer customer = new Customer("Max Mustermann");
    em.persist(customer);

    Address address = new Address("Inndalsveien", 28);
    em.persist(address);

    Pincode pincode = new Pincode("123", 1);
    em.persist(pincode);

    Bank bank = new Bank("Pengebank");
    em.persist(bank);

    CreditCard creditCard1 = new CreditCard(12345, -5000, -10000, pincode, bank);
    CreditCard creditCard2 = new CreditCard(123, 1, 2000, pincode, bank);
    em.persist(creditCard1);
    em.persist(creditCard2);

    // Add objects to customer and bank
    customer.addAddress(address);
    customer.addCreditCard(creditCard1);
    customer.addCreditCard(creditCard2);


    bank.addCreditCard(creditCard1);
    bank.addCreditCard(creditCard2);

    // Merge
    em.merge(customer);
    em.merge(bank);
  }
}
