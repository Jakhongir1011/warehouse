package com.example.appwarehouse.repository;

import com.example.appwarehouse.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByCode(String code);

}
