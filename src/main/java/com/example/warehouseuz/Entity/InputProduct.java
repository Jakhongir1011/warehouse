package com.example.warehouseuz.Entity;

import javax.persistence.*;
import java.util.Date;

public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne // koplap krimga bitta mahsulot togri kelishi mumkin
    private Product product;

    @Column(nullable = false)
    private Double amount;

    public Double price;

    private Date expireDate;

    @ManyToOne // koplab mahsulotlar bitta kirimda bo'lishi mumkin
    private Input input;
}
