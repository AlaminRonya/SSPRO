package com.alamin.cbs.model;

import java.time.LocalDateTime;

public class PaymentHistory {
    private int paymentId;
    private int accountId;
    private int userId;
    private String beneficiary;
    private String beneficiary_acc_no;
    private double amount;
    private String status;
    private String referenceNo;
    private String reasonCode;
    private LocalDateTime created_at;
}
