package com.alamin.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity(name = "tbl_customers")
public class Customer extends BaseEntity {
    private String firstname;
    private String lastname;
    private String email;
    @OneToOne
    private PresentAddress address;
}
