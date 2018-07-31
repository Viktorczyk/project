package project.Komis.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.Komis.Model.Dto.CarDto;
import project.Komis.Model.Dto.PurchaseDto;
import project.Komis.Model.PrepareCar.*;
import project.Komis.Service.DefaultCarService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/komis")
public class CarDataController {


    private final DefaultCarService defaultCarService;


    public CarDataController(DefaultCarService defaultCarService) {
        this.defaultCarService = defaultCarService;
    }

    /* Strona ze wszystkimi autami */
    @RequestMapping(value="/allcars", method= RequestMethod.GET)
    public String getAllCarsService(Model model){
        List<Car> carList = defaultCarService.getAllCarsService();
        model.addAttribute("allCars", carList);
        return "pages/allCars";
    }


    /* Strona z autami dostępny do sprzedaży */
    @RequestMapping(value="/cars", method= RequestMethod.GET)
    public String printAvalaibleCars(Model model){
        List<Car> carList = defaultCarService.findNotSoldCarService();
        model.addAttribute("carForSold", carList);
        return "pages/avalaibleCars";
    }


    /* Strona ze szczegółami aut */
    @RequestMapping(value="/car/{id}")
    public String getCar(@PathVariable("id")Integer carId,
    Model model){
        Car car = defaultCarService.getCarById(carId);
        if(car != null ){
            model.addAttribute("car", car);
        }
        return "pages/carDetailsPage";
    }


    /*Sprzedaż auta*/
    @GetMapping(value ="/{carId}/sell")
    public String sellCarForm(
            @PathVariable("carId") Integer carId,
            Model model
    ){
      Car carSell = defaultCarService.getCarById(carId);
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setCar(carSell);
        purchaseDto.setCarId(carId);
        model.addAttribute("purchaseDto", purchaseDto);

        return "pages/sellcar";
    }


    /* Strona dodania auta*/
    @GetMapping("/addcar")
    public String addCarForm(Model model){
        model.addAttribute("addCar", new CarDto());
        List<Manufacturer> allManu = defaultCarService.getAllManufacturereService();
        model.addAttribute("allManu", allManu);
        List<Fuel> allFuel = defaultCarService.getAllFuelService();
        model.addAttribute("allFuel", allFuel);
        List<GearBox> allGearBox = defaultCarService.getAllGearBoxService();
        model.addAttribute("allGearBox", allGearBox);
        List<BodyType> allBody = defaultCarService.getAllBodyTypeService();
        model.addAttribute("allBody",allBody);

        return "pages/addCarPages";

    }

    /* Zapis auta*/
    @PostMapping("/addcar")
    public String saveCar(@Valid @ModelAttribute("addCar")
                          CarDto carToSave,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
        return "pages/addCarPages";
        }

        Car car = new Car();
        car.setManufacturer(defaultCarService.getManuByIdService(carToSave.getManufacturer()));
        car.setModel(defaultCarService.getModelByNameService(carToSave.getModel(), carToSave.getManufacturer()));
        car.setGearBox(defaultCarService.getGearBoxByIdService(carToSave.getGearBox()));
        car.setFuel(defaultCarService.getFuelByIdService(carToSave.getFuel()));
        car.setBodyType(defaultCarService.getBodyTypeByIdService(carToSave.getBodyType()));
        car.setTypeCar(TypeCar.checkTypeCar(carToSave.getTypeCar()));                           //odnosimy sie bezposredno do klasy enum
        car.setEngine(carToSave.getEngine());
        car.setPower(carToSave.getPower());
        car.setMileage(carToSave.getMileage());
        car.setVIN(carToSave.getVIN());
        car.setNumberPlate(carToSave.getNumberPlate());
        car.setNumberInsurance(carToSave.getNumberInsurance());
        car.setNumberTestDrive(carToSave.getNumberTestDrive());
        car.setPrice(carToSave.getPrice());
        car.setText(carToSave.getText());
        car.setYearProduction(carToSave.getYearProduction());
        car.setSell(false);
        defaultCarService.addCar(car);
        return "redirect:/komis/cars";
    }



}
