package cloudmark.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(max = 50)
    private String address;

    @Size(max = 10)
    private String cap;

    @Size(max = 20)
    private String city;

    @Size(min = 27, max = 27)
    private String iban;

    @Size(max = 20)
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Size(max = 50)
    @Column(nullable = false)
    private String email;

    @Column(name = "contract_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "employee_job",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Job> jobs;

    public enum ContractType {
        indeterminato,
        determinato,
        apprendistato,
        tirocinio
    }

    @Column(name = "contract_start", nullable = false)
    private Date contractStart;

}
