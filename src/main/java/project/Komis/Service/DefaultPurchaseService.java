package project.Komis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Komis.Model.Client;
import project.Komis.Model.Person;
import project.Komis.Model.PrepareCar.Car;
import project.Komis.Model.Purchase;
import project.Komis.Repository.CarRepository.CarRepository;
import project.Komis.Repository.ClientRepository;
import project.Komis.Repository.PurchaseRepository;

import java.util.Date;
import java.util.List;

@Service
public class DefaultPurchaseService implements SellingService{

    private CarRepository carRepository;
    private ClientRepository clientRepository;
    private PurchaseRepository purchaseRepository;

    @Autowired
    public DefaultPurchaseService(CarRepository carRepository, ClientRepository clientRepository, PurchaseRepository purchaseRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase sellCar(Integer sellCarId, Person person, Integer price) {

        Car soldCar = carRepository.findOne(sellCarId) ;
        soldCar.setSell(true);
        carRepository.save(soldCar);

        Client persistedClient = clientRepository.findByPesel(person.getPesel()).orElseGet(() -> clientRepository.save(person));

        Purchase purchase = new Purchase();
        purchase.setCar(soldCar);
        purchase.setClientWhoBuy(persistedClient);
        purchase.setDate(new Date());
        purchase.setPrice(price);
        return purchaseRepository.save(purchase);
         }

    @Override
    public List<Purchase> getAllSales() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase getByIdService(Integer purchaseId) {
        return purchaseRepository.findOne(purchaseId);
    }
}
