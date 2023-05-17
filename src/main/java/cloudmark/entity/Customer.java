package cloudmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @Column(name = "vat_number", nullable = false)
    @Size(max = 50)
    private String vatNumber;

    @Size(max = 50)
    @Column(nullable = false)
    private String address;

    @Size(max = 10)
    @Column(nullable = false)
    private String cap;

    @Size(max = 20)
    @Column(nullable = false)
    private String city;

    @Size(max = 50)
    @Column(nullable = false)
    private String iban;

    @Size(max = 20)
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Size(max = 50)
    @Column(nullable = false)
    private String email;

    @Size(max = 50)
    @Column(nullable = false)
    private String pec;


    @Size(max = 20)
    @Column(nullable = true)
    private String fax;

}
