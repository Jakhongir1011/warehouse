package com.example.warehouseuz.Entity;

import com.example.warehouseuz.Entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurement extends AbsEntity { // kg, dona shunga oxshagan o'lchov birligi



}
