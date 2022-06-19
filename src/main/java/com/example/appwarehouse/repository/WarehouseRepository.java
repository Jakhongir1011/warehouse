package com.example.appwarehouse.repository;

import com.example.appwarehouse.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
    boolean existsByName(String name);
}
