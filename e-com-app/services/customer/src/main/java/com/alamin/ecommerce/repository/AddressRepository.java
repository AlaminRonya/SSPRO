package com.alamin.ecommerce.repository;

import com.alamin.ecommerce.model.PresentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AddressRepository extends JpaRepository<PresentAddress, UUID> {
}
