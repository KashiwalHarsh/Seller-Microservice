package com.infy.sellerMs.repository;
import com.infy.sellerMs.entity.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, Long> {}

