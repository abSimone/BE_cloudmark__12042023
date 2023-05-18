package cloudmark.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "company_customer")
public class CompanyCustomer {
    
    @EmbeddedId
    private CompanyCustomerPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId")
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerId")
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}