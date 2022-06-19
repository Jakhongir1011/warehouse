package com.example.appwarehouse.Entity;

import com.example.appwarehouse.Entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends AbsEntity {

    @ManyToOne
    private Category parentCategory; //null, 1,1,1

}
