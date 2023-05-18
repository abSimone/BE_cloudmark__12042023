package cloudmark.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class CompanyCustomerPK implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name="company_id")
    private Integer companyId;
	
    @Column(name="customer_id")
    private Integer customerId;

}