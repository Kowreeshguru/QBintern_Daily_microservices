package com.quinbay.service2.service2Repository;


import com.quinbay.service2.model.WholesalerInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WholesalerInventoryRepository extends JpaRepository<WholesalerInventory, Integer> {
    WholesalerInventory findById(int in);
}
