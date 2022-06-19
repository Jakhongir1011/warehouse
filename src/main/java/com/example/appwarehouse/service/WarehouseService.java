package com.example.appwarehouse.service;

import com.example.appwarehouse.Entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouseService(Warehouse warehouse){
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName){
            return new Result("There is such a warehouse", false, warehouse.getId());
        }
        warehouseRepository.save(warehouse);
        return new Result("stored the warehouse",true,warehouse.getId());
    }


    public List<Warehouse> getWarehouseService(){
        List<Warehouse> all = warehouseRepository.findAll();
        return all;
    }


    public Warehouse getByIdWarehouseService(Integer id){
        Optional<Warehouse> warehouseRepositoryById = warehouseRepository.findById(id);
        if (warehouseRepositoryById.isPresent()){
            return warehouseRepositoryById.get();
        }
        return  new Warehouse();
    }


    public Result deleteByIdWarehouseService(Integer id){
        boolean b = warehouseRepository.existsById(id);
        if (!b){
            return new Result("These isn't such warehouse",false, id);
        }
        warehouseRepository.deleteById(id);
        return new Result("There is such warehouse", true, id);
    }


    public Result updateWarehouseService(Warehouse warehouse, Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()){
            Warehouse warehouseById = optionalWarehouse.get();
            warehouseById.setName(warehouse.getName());
            Warehouse save = warehouseRepository.save(warehouseById);
            return new Result("warehouse saved",true,id);
        }
        return  new Result("wearehouse not found", false, id);
    }

}
