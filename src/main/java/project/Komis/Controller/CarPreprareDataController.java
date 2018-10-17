package project.Komis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.Komis.Model.Dto.ModelDto;
import project.Komis.Model.PrepareCar.BodyType;
import project.Komis.Model.PrepareCar.Fuel;
import project.Komis.Model.PrepareCar.Manufacturer;
import project.Komis.Service.DefaultCarService;

import java.util.List;

@Controller
@RequestMapping("/komis")
public class CarPreprareDataController {


    private final DefaultCarService defaultCarService;

    public CarPreprareDataController(DefaultCarService defaultCarService) {
        this.defaultCarService = defaultCarService;
    }

    @GetMapping("/manu")
    public String addMamu(Model model){
        model.addAttribute("addManu",new Manufacturer());
        List<Manufacturer> manuList = defaultCarService.getAllManufacturereService();
        model.addAttribute("allManu", manuList);
        return "pages/manu";
    }

    @PostMapping("/manu")
    public String saveManu(
            @ModelAttribute("addManu")
            Manufacturer nameToSave){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(nameToSave.getName());
        defaultCarService.addManuService(nameToSave);
        return "redirect:/komis/manu";
    }


    @GetMapping("/fuel")
    public String addFuel(Model model){
        model.addAttribute("addFuel",new Fuel());
        List<Fuel> fuelList = defaultCarService.getAllFuelService();
        model.addAttribute("allFuel", fuelList);
        return "pages/fuel";
    }

    @PostMapping("/fuel")
    public String saveFuel(
            @ModelAttribute("addFuel")
                    Fuel fuelToSave){
        Fuel fuel = new Fuel();
        fuel.setTypeFuel(fuelToSave.getTypeFuel());
        defaultCarService.addFuel(fuelToSave);
        return "redirect:/komis/fuel";
    }

    @GetMapping("/fuel/delete/{id}")
    public String deleteFuel (Model model, @PathVariable("id") Integer fuelId){
        Fuel fuel = new Fuel();
        setFuelDel(fuel);
        model.addAttribute("fuelID", fuelId);
        if(fuel.getId()==null){
            return "redirect:/komis/fuel";
        }else{
            return "pages/deleteFuel";
        }

    }

    private void setFuelDel(@PathVariable("id") Fuel fuel) {
        defaultCarService.getFuelByIdService(fuel.getId());


    }

    @DeleteMapping("fuel/delete/{id}")
    public String deleteFuelType(@PathVariable("id") Integer fuelId,
                                 Model model,
                                 RedirectAttributes ra){
        defaultCarService.deleteFuel(fuelId);
        return "redirect:/komis/fuel";
    }


    @GetMapping("/body")
    public String addBody(Model model){
        model.addAttribute("addBody",new BodyType());
        List<BodyType> bodyTypeListList = defaultCarService.getAllBodyTypeService();
        model.addAttribute("allBody", bodyTypeListList);
        return "pages/body";
    }

    @PostMapping("/body")
    public String saveBody(
            @ModelAttribute("addBody")
                    BodyType bodyTypeToSave){
       BodyType bodyType = new BodyType();
        bodyType.setBody(bodyTypeToSave.getBody());
        defaultCarService.addBodyTypeService(bodyTypeToSave);
        return "redirect:/komis/body";
    }

    @GetMapping("/model")
    public String addModel(Model model){
        model.addAttribute("addModel", new ModelDto());
        List<Manufacturer> allManu = defaultCarService.getAllManufacturereService();
        model.addAttribute("allManu", allManu);
        List<project.Komis.Model.PrepareCar.Model> modelList = defaultCarService.getAllModelService();
        model.addAttribute("modelList",modelList);
        return "pages/addModel";
    }

    @PostMapping("/model")
    public String saveModel(@ModelAttribute("addModel")
                            ModelDto modelToSave
                            ){
        project.Komis.Model.PrepareCar.Model carModel = new project.Komis.Model.PrepareCar.Model();
            carModel.setManufacturer(defaultCarService.getManuByIdService(modelToSave.getManufacturer()));
            carModel.setName(modelToSave.getModel());
        defaultCarService.addModel(carModel);
        return "redirect:/komis/model";

    }

}
