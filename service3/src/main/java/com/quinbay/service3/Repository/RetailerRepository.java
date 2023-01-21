package com.quinbay.service3.Repository;


import com.quinbay.service3.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Integer> {
    Retailer findById(int in);
}
