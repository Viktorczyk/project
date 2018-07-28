package project.Komis.Service;


import org.springframework.stereotype.Service;
import project.Komis.Model.Dto.ModelDto;
import project.Komis.Model.PrepareCar.*;
import project.Komis.Repository.CarRepository.*;

import java.util.List;

@Service
public class DefaultCarService implements CarDataService {

    private final CarRepository carRepository;
    private final FuelRepository fuelRepository;
    private final GearBoxRepository gearBoxRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ModelRepository modelRepository;
    private final BodyTypeRepository bodyTypeRepository;


    public DefaultCarService(CarRepository carRepository, FuelRepository fuelRepository, GearBoxRepository gearBoxRepository, ManufacturerRepository manufacturerRepository, ModelRepository modelRepository, BodyTypeRepository bodyTypeRepository) {
        this.carRepository = carRepository;
        this.fuelRepository = fuelRepository;
        this.gearBoxRepository = gearBoxRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.modelRepository = modelRepository;
        this.bodyTypeRepository = bodyTypeRepository;
    }


    @Override
    public Car getCarById(Integer carId) {
        return carRepository.findOne(carId);
    }

    @Override
    public List<Car> getAllCarsService() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public List<Car> findNotSoldCarService() {
        return carRepository.findNotSoldCar();
    }

    @Override
    public Car addCar(Car carToSave) {
        return carRepository.save(carToSave);
    }

    @Override
    public List<Manufacturer> getAllManufacturereService() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getManuByIdService(Integer manuId) {
        return manufacturerRepository.findOne(manuId);
    }

    @Override
    public Manufacturer getManuByNameService(String name) {
      Manufacturer manufacturerByName = manufacturerRepository.getManufacturerByName(name);
      if(manufacturerByName != null){           //sprawdzamy czy nie istnieje w bazie
          return manufacturerByName;             //jezeli istnieje to wyświetlamy
      }
      Manufacturer newManufacturer = new Manufacturer();        //jeżeli nie istnieje tworzymy nowy obiekt z nową nazwą
      newManufacturer.setName(name);                            //przypisujemy nazwę do obiektu
        return newManufacturer;                                    //zwracamy nowa nazwę
    }

    @Override
    public Manufacturer addManuService(Manufacturer newManu) {
        return manufacturerRepository.save(newManu);
    }

    @Override
    public Model getModelByNameService(String modelName, Integer manuId) {
        Model modelByName = modelRepository.getModelByName(modelName);
        if(modelByName != null){
            modelByName.setManufacturer(manufacturerRepository.getManufacturerById(manuId));            //przypisujemy do modelu IDMarki
            return modelByName;
        }
        Model newModel = new Model();
        newModel.setName(modelName);
        newModel.setManufacturer(manufacturerRepository.getManufacturerById(manuId));
        return newModel;
    }

    @Override
    public Model addModel(Model modelToSave) {


        return modelRepository.save(modelToSave);
    }

    @Override
    public List<Model> getAllModelService() {
        return modelRepository.findAll();
    }

    @Override
    public Fuel getFuelByIdService(Integer fuelId) {
        return fuelRepository.findOne(fuelId);
    }

    @Override
    public List<Fuel> getAllFuelService() {
        return fuelRepository.findAll();
    }

    @Override
    public Fuel getFuelByNameService(String typeFuel) {
        Fuel fuelByName = fuelRepository.getFuelByTypeFuel(typeFuel);
        if(fuelByName != null){
            return fuelByName;
        }

        Fuel newFuel = new Fuel();
        newFuel.setTypeFuel(typeFuel);
        return newFuel;
    }

    @Override
    public Fuel addFuel(Fuel newFuel) {
        return fuelRepository.save(newFuel);
    }

    @Override
    public GearBox getGearBoxByIdService(Integer gearBoxId) {
        return gearBoxRepository.findOne(gearBoxId);
    }

    @Override
    public List<GearBox> getAllGearBoxService() {
        return gearBoxRepository.findAll();
    }

    @Override
    public GearBox getGearBoxByName(String typeGearBox) {
        GearBox gearBoxByName = gearBoxRepository.getGearBoxByTypeGearBox(typeGearBox);
        if(gearBoxByName != null){
            return gearBoxByName;
        }

        GearBox newTypeGearBox = new GearBox();
        newTypeGearBox.setTypeGearBox(typeGearBox);
        return newTypeGearBox;
    }

    @Override
    public GearBox addGearService(GearBox newGearBox) {
        return gearBoxRepository.save(newGearBox);
    }

    @Override
    public BodyType getBodyTypeByIdService(Integer bodyTypeId) {
        return bodyTypeRepository.findOne(bodyTypeId);
    }

    @Override
    public List<BodyType> getAllBodyTypeService() {
        return bodyTypeRepository.findAll();
    }

    @Override
    public BodyType getBodyTypeByBody(String bodyTypeName) {
        BodyType bodyTypeByBody = bodyTypeRepository.getBodyTypeByBody(bodyTypeName);
        if(bodyTypeByBody != null){
            return bodyTypeByBody;
        }

        BodyType newBodyType = new BodyType();
        newBodyType.setBody(bodyTypeName);

        return newBodyType;
    }

    @Override
    public BodyType addBodyTypeService(BodyType newBodyType) {
        return bodyTypeRepository.save(newBodyType);
    }
}
