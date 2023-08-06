package com.tollpayment.repository;

import com.tollpayment.models.Role;
import com.tollpayment.models.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
