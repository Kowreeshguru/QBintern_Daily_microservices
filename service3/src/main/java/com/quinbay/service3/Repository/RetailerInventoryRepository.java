package com.quinbay.service3.Repository;

import com.quinbay.service3.model.RetailerInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerInventoryRepository extends JpaRepository<RetailerInventory, Integer> {
    RetailerInventory findById(int in);
}
