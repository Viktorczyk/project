package project.Komis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Komis.Model.Dto.ModelDto;
import project.Komis.Model.PrepareCar.*;
import project.Komis.Repository.CarRepository.CarRepository;
import project.Komis.Repository.CarRepository.FuelRepository;
import project.Komis.Repository.CarRepository.ManufacturerRepository;

import java.util.List;

@Service
public interface CarDataService {

   /* samochody */
    Car getCarById(Integer carId);

    List<Car> getAllCarsService();

    List<Car> findNotSoldCarService();

    Car addCar(Car carToSave);



    /* szczegóły samochodów*/

    // Marka
    List<Manufacturer> getAllManufacturereService();

    Manufacturer getManuByIdService(Integer manuId);

    Manufacturer getManuByNameService(String name);

    Manufacturer addManuService(Manufacturer newManu);


    //Model
    Model getModelByNameService(String modelName, Integer manuId);

    Model addModel(Model modelToSave);

    List<Model> getAllModelService();

    //Napęd - paliwo - Fuel

    Fuel getFuelByIdService(Integer fuelId);

    List<Fuel> getAllFuelService();

    Fuel getFuelByNameService(String typeFuel);

    Fuel addFuel(Fuel newFuel);

    Fuel updateFuel(Fuel fuel);

    void deleteFuel (Integer fuelId);

    //Skrzynia - GearBox
    GearBox getGearBoxByIdService(Integer gearBoxId);

    List<GearBox> getAllGearBoxService();

    GearBox getGearBoxByName(String typeGearBox);

    GearBox addGearService(GearBox newGearBox);

    GearBox updateGearBox(GearBox gearBox);

    void deleteGearbox (Integer gearBoxId);

    //Body
    BodyType getBodyTypeByIdService(Integer bodyTypeId);

    List<BodyType> getAllBodyTypeService();

    BodyType getBodyTypeByBody(String bodyTypeName);

    BodyType addBodyTypeService(BodyType newBodyType);



}
