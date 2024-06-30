package com.alamin.cbs.model;

import java.time.LocalDateTime;

public class TransactionHistory {
    private int transaction_id;
    private int account_id;
    private int user_id;
    private String transaction_type;
    private double amount;
    private String  source;
    private String  status;
    private String  reason_code;
    private LocalDateTime created_at;
}