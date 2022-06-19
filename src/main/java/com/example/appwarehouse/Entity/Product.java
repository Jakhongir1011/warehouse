package com.example.appwarehouse.Entity;

import com.example.appwarehouse.Entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product extends AbsEntity {
    @ManyToOne
    private Category category;

    @OneToOne
    private Attachment photo;

    private String code;

    @ManyToOne
    private Measurement measurement;
}
