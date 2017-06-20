package com.example;

import lombok.Data;

/**
 * @author Zoltan Altfatter
 */
@Data
public class BankTransfer {

    private final String fromAccount;
    private final String toAccount;
    private final Long amount;

}
