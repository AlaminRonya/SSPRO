package com.alamin.cbs.model;

import java.time.LocalDateTime;

public class Payment {
    private int payment_id;
    private int account_id;
    private String beneficiary;
    private String beneficiary_acc_no;
    private double amount;
    private String reference_no;
    private String status;
    private String reason_code;
    private LocalDateTime createdAt;
}
