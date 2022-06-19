package com.example.appwarehouse.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String password;

    /**
     * Userni registratsiya qilganimizda aktiv bo'lib qo'lishi uchun:
     */
    private boolean active = true;

    /**
     * Bitta user bir nechta omborda ishlashi mumkin, bitta omborda esa ko'p user ishlashi mumkin. <br>
     * Set qo'yilganiga sabab bitta userga bitta ombor biriktirilgandan so'ng <br>
     * O'sha user yana o'sha id i lik omborga qo'shilmasligi.
     */
    @ManyToMany
    private Set<Warehouse> warehouses;
}
