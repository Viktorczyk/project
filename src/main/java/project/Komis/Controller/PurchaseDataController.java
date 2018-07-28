package project.Komis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.Komis.Model.Dto.PurchaseDto;
import project.Komis.Model.Person;
import project.Komis.Service.CarDataService;
import project.Komis.Service.SellingService;

@Controller
@RequestMapping("/komis/purchase")
public class PurchaseDataController {

    private SellingService sellingService;
    private CarDataService carDataService;

    public PurchaseDataController(SellingService sellingService, CarDataService carDataService) {
        this.sellingService = sellingService;
        this.carDataService = carDataService;
    }

    @PostMapping
    private String sell(
            @ModelAttribute("purchaseDto")PurchaseDto purchaseDto
            ){
        purchaseDto.setCar(carDataService.getCarById(purchaseDto.getCarId()));
        Person person = new Person();
        person.setFirstname(purchaseDto.getFirstname());
        person.setLastname(purchaseDto.getLastname());
        person.setAddress(purchaseDto.getAddress());
        person.setPesel(purchaseDto.getPesel());

        sellingService.sellCar(purchaseDto.getCarId(), person, purchaseDto.getPrice());

        return  "redirect:/komis/cars";
    }
}
