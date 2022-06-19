package com.example.appwarehouse.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private Timestamp date ;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Currency currency;

    private String factureNumber;

    @Column(unique = true, nullable = false)
    private String code;
}
