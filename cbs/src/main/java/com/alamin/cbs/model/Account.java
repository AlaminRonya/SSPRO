package com.alamin.cbs.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    private int account_id;
    private int user_id;
    private String account_number;
    private String account_name;
    private String account_type;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
