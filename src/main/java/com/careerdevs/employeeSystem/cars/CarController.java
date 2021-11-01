package com.careerdevs.employeeSystem.cars;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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


    public CarController(){
        Long id = idCounter.incrementAndGet();
        carList.put(id, new Car(id, "Ford", "Focus", 60));
    }

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

    @GetMapping("/create/{make}/{model}/{price}")
    public Car createCar(@PathVariable String make, @PathVariable String model, @PathVariable Integer price){
        Car createdCar = new Car(idCounter.incrementAndGet(), make, model, price);
        carList.put(createdCar.getId(), createdCar);
        return createdCar;
    }

    @GetMapping("/update/{id}")
    public Car updateCar(@PathVariable Long id, @RequestParam(value = "make", defaultValue = "Make") String make, @RequestParam( value = "model", defaultValue = "Model") String model, @RequestParam(value = "price", defaultValue = "0") Integer price){
        Car updatedCar = carList.get(id);
        if(!make.equals("Make"))
            updatedCar.setMake(make);
        if(!model.equals("Model"))
            updatedCar.setModel(model);
        if(price != 0)
            updatedCar.setPrice(price);
        return updatedCar;
    }


    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        Car deletedCar = carList.get(id);
        carList.remove(deletedCar.getId());
        return deletedCar.getMake() + " " + deletedCar.getModel() + " Deleted!";
    }



}
