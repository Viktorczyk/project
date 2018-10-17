package project.Komis.Controller.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import project.Komis.Model.PrepareCar.Car;

import project.Komis.Service.CarDataService;
import project.Komis.Service.CarDataServiceJpa;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestApiController {

    @Autowired
    public final CarDataService carDataService;



    public RestApiController(CarDataService carDataService) {
        this.carDataService = carDataService;

    }

    @GetMapping(value = "/all-cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCars() {
        return carDataService.getAllCarsService();
    }

    @GetMapping(value = "/cars/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car get(@PathVariable ("carId") Integer carId){
        return carDataService.getCarById(carId);
    }

    @PostMapping(value="/car")
    public Car newCarApi (@RequestBody Car newCar){

        newCar.setId(0);

        carDataService.addCar(newCar);

        return newCar;
    }


    @PutMapping("/carput")
    public Car updateCar(@RequestBody Car updateCar){
        carDataService.addCar(updateCar);
        return updateCar;
    }

    @DeleteMapping("/cardel/{fuelId}")
    public String deleteFuel(@PathVariable ("fuelId") Integer fuelId){

        carDataService.deleteFuel(fuelId);

        return "Delete fuel id - " + fuelId ;
    }

}
