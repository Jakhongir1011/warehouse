package com.example.appwarehouse.controller;

import com.example.appwarehouse.Entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public Result addWarehouse(@RequestBody Warehouse warehouse){
        Result result = warehouseService.addWarehouseService(warehouse);
        return result;
    }

    @GetMapping
    public List<Warehouse> getWarehouse(){
        List<Warehouse> getWarehouseService = warehouseService.getWarehouseService();
        return getWarehouseService;
    }

    @GetMapping("/{id}")
    public Warehouse getByIdWarehouse(@PathVariable Integer id){
        Warehouse byIdWarehouseService = warehouseService.getByIdWarehouseService(id);
        return byIdWarehouseService;
    }

    @DeleteMapping("/{id}")
    public Result deleteByIdWarehouse(@PathVariable Integer id){
        Result result = warehouseService.deleteByIdWarehouseService(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateWarehouse(@RequestBody Warehouse warehouse, @PathVariable Integer id){
        Result result = warehouseService.updateWarehouseService(warehouse,id);
        return result;
    }


}
