package com.alamin.ecommerce.model;

import com.alamin.ecommerce.utils.RequestInfoContextHolder;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
@SuperBuilder(toBuilder = true)
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(insertable = true, updatable = false)
    private LocalDate createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(insertable = false, updatable = true)
    private LocalDate updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(insertable = false, updatable = true)
    private LocalDate deletedAt;

    private String browser = RequestInfoContextHolder.getBrowser();
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private String ip = RequestInfoContextHolder.getIp();
    private boolean status;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        setCreatedBy();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
        setUpdatedBy();
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = LocalDate.now();
        setDeletedBy();
    }

    private void setCreatedBy() {
        // Set createdBy
    }

    private void setUpdatedBy() {
        // Set updatedBy
    }

    private void setDeletedBy() {
        // Set deletedBy
    }
}
