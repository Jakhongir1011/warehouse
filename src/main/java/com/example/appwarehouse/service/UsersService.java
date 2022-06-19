package com.example.appwarehouse.service;

import com.example.appwarehouse.Entity.User;
import com.example.appwarehouse.Entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.payload.UsersDto;
import com.example.appwarehouse.repository.UsersRepository;
import com.example.appwarehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result saveUsersService(UsersDto usersDto){
        boolean b = usersRepository.existsByPhoneNumber(usersDto.getPhoneNumber());
        if (b){
            return new Result("This phoneNumber already exists",false);
        }

        boolean b1 = usersRepository.existsByCode(usersDto.getCode());
        if (b1){
            return new Result("This Code already exists",false);
        }

        Optional<Warehouse> byId = warehouseRepository.findById(usersDto.getWarehouseId());
        if (!byId.isPresent()){
            return new Result("Warehouse not found",false);
        }

        Set<Warehouse> warehousesSet = new LinkedHashSet<>();
        warehousesSet.add(byId.get());

        User user = new User();
        user.setLastName(usersDto.getLastName());
        user.setFirstName(usersDto.getFirstName());
        user.setCode(usersDto.getCode());
        user.setPassword(usersDto.getPassword());
        user.setPhoneNumber(usersDto.getPhoneNumber());
        user.setWarehouses(warehousesSet);
        usersRepository.save(user);
        return new Result("Success User", true);

    }


    public List<User> getUserService(){
        List<User> all = usersRepository.findAll();
        return all;
    }

    public User getByIdUserService(Integer id){
        Optional<User> optionalUser = usersRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    public Result deleteByIdUserService(Integer id){
        boolean b = usersRepository.existsById(id);
        if (b){
            usersRepository.deleteById(id);
            return new Result("User deleted",true);
        }
        return  new Result("User not found",false);
    }

    public Result updateUserByIdService(Integer id, UsersDto usersDto){
        Optional<User> byId = usersRepository.findById(id);
        if (!byId.isPresent()){
            return new Result("Users not found", false);
        }
        User user = byId.get();

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent()){
            return new Result("Warehouse not found",false);
        }

        boolean code = usersDto.getCode().equals(user.getCode());

        if (!code){
            return  new Result("This code already exists!",false);
        }

        boolean phoneNumber = usersDto.getPhoneNumber().equals(user.getPhoneNumber());
        if (!phoneNumber){
            return  new Result("This phone number already exists!",false);
        }

        Warehouse warehouse = optionalWarehouse.get();
        Set<Warehouse>  warehouseSet = new LinkedHashSet<>();
        warehouseSet.add(warehouse);

        user.setLastName(usersDto.getLastName());
        user.setFirstName(usersDto.getFirstName());
        user.setCode(usersDto.getCode());
        user.setPassword(usersDto.getPassword());
        user.setPhoneNumber(usersDto.getPhoneNumber());
        user.setActive(usersDto.isActive());
        user.setWarehouses(warehouseSet);

        return null;
    }

}
