package mk.ukim.finki.wpaud.web.controller;

import mk.ukim.finki.wpaud.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getManufacturersPage(Model model) {
        model.addAttribute("bodyContent", "manufacturers");
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "manufacturers";
    }

}
