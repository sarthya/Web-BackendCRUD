package com.gj.example.backendCrud.repository;

import com.gj.example.backendCrud.entity.FamilyNodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository extends JpaRepository<FamilyNodeEntity, Long> {
}
