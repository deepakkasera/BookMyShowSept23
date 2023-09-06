package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {
    private String referenceId;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentProvider paymentProvider;
}
