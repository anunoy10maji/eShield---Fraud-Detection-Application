package org.proj.Dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerData {

    private String customerId;
    @NotBlank(message = "Name is required")
    private String customerName;
    @NotBlank(message = "Account number is required")
    @Size(min = 14, max = 14, message = "Account number must be exactly 14 characters long")
    private String accountNo;
    @Email(message = "Enter valid email format")
    private String email;
    private String customerAddress;
    @NotBlank(message = "Country is required")
    private String country;
    private String functionCode;
    @NotBlank(message = "Transaction amount is required")
    private String transactionAmount;
    private String getTransactionType;
}
