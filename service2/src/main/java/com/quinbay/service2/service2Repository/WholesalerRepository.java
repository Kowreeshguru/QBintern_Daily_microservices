package com.quinbay.service2.service2Repository;


import com.quinbay.service2.model.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler, Integer> {
    Wholesaler findById(int in);
}
