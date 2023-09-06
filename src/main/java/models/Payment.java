package models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String referenceId;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentProvider paymentProvider;
}
