package com.xworkz.medicineapp.controller;


import com.xworkz.medicineapp.dto.MedicineDTO;
import com.xworkz.medicineapp.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@RequestMapping("/")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/addMedicine")
    public String addMedicine(@Validated MedicineDTO medicineDTO){

        System.out.println(medicineDTO);

        boolean success=medicineService.validateAndSave(medicineDTO);

        if(success) {
            System.out.println("Validated and saved successfully");
            return "MedicineResponse";
        }
        else System.err.println("Failed to save and validate data");
        return "FailurePage";

    }


    @GetMapping("search")
    public String searchMedicine(@RequestParam("medicineName") String medicineName, Model model){
        System.out.println(medicineName);
        Optional<MedicineDTO> medicineDTO=medicineService.getMedicine(medicineName);
        if(medicineDTO.isPresent()) {
            model.addAttribute("medicine", medicineDTO.get());
            System.out.println(medicineDTO);
        }
        else  model.addAttribute("DataNotFound","No Medicine found for given name");

        return "Search";
    }



    @GetMapping("searchById")
    public String searchMedicineById(@RequestParam("id") int id, Model model){
        System.out.println(id);

        Optional<MedicineDTO> medicineDTO=medicineService.getMedicineById(id);

        if(medicineDTO.isPresent()) {
            model.addAttribute("medicineDto", medicineDTO.get());
            System.out.println(medicineDTO);
        }
        else  model.addAttribute("DataNotFound","No Medicine found for given id");

        return "SearchById";
    }
}
