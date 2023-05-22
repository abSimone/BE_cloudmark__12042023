package cloudmark.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    @NotEmpty(message = "companyName cannot be empty")
    @Size(max = 50)
    private String companyName;

    @Column(name = "vat_number")
    @NotEmpty(message = "vatNumber cannot be empty")
    @Size(min = 11, max = 11)
    private String vatNumber;

    @NotEmpty(message = "address cannot be empty")
    @Size(max = 50)
    private String address;

    @NotEmpty(message = "iban cannot be empty")
    @Size(min = 27, max = 27)
    private String iban;

    @Column(name = "phone_number")
    @NotEmpty(message = "phoneNumber cannot be empty")
    @Size(max = 50)
    private String phoneNumber;

    @NotEmpty(message = "email cannot be empty")
    @Size(max = 50)
    private String email;

    @NotEmpty(message = "pec cannot be empty")
    @Size(max = 50)
    private String pec;

    @Nullable
    @Size(max = 50)
    private String fax;

    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "company_customer",
        joinColumns = @JoinColumn(name = "company_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;




}