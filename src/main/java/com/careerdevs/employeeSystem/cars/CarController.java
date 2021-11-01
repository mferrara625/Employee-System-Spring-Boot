package com.careerdevs.employeeSystem.cars;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cars")
public class CarController {

    private Map<Long, Car> carList = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();


    @GetMapping
    public List<Car> allCars(){
        return new ArrayList<>(carList.values());
    }

    @PostMapping
    public Car car(@RequestBody Car newCar){
        Long id = idCounter.incrementAndGet();
        newCar.setId(id);
        carList.put(id, newCar);
        return newCar;
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id){
        return carList.get(id);
    }


}
