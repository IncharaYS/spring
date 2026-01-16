package com.xworkz.clothingapp.controller;

import com.xworkz.clothingapp.dto.ClothDTO;
import com.xworkz.clothingapp.entity.ClothEntity;
import com.xworkz.clothingapp.exception.DuplicateClothNameException;
import com.xworkz.clothingapp.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ClothingController {

    @Autowired
    private ClothingService clothingService;


    @GetMapping("addClothPage")
    public String addClothPage(){
        return "AddCloth";
    }

    @PostMapping("addCloth")
    public String addCloth(@Valid @ModelAttribute ClothDTO clothDTO, BindingResult bindingResult, Model model ){

        if(bindingResult.hasErrors()){
//            bindingResult.getAllErrors().forEach(System.out::println);

            bindingResult.getAllErrors().forEach(e-> System.out.println(e.getDefaultMessage()));

            model.addAttribute("failureMsg", "Please enter valid details");
            return "AddCloth";
        }
        try {
            boolean success = clothingService.validateAndSave(clothDTO);

            if (success) {
                model.addAttribute("successMsg", "Cloth added successfully!");
                model.addAttribute("clothDto", clothDTO);
                return "ClothInfo";
            } else {
                model.addAttribute("clothDto", clothDTO);
                model.addAttribute("failureMsg", "Failed to add cloth");
                return "AddCloth";
            }
        }
        catch (DuplicateClothNameException dcne){
            dcne.printStackTrace();
            model.addAttribute("clothDto", clothDTO);
            model.addAttribute("failureMsg", "Given cloth name already exists");
            return "AddCloth";

        }

    }


    @GetMapping("searchPage")
    public String searchPage(){
        return "SearchCloth";
    }




    @GetMapping("/searchCloth")
    public String searchCloth(@RequestParam String searchBy, @RequestParam String searchValue, Model model) {

        if (searchBy==null || searchValue==null) {
            return "SearchCloth";
        }

        switch (searchBy) {

            case "clothName":
                Optional<ClothDTO> cloth = clothingService.findClothInfoByClothName(searchValue);

                if (cloth.isPresent()) {
                    model.addAttribute("cloth", cloth.get());
                } else {
                    model.addAttribute("errorMsg", "No cloth found");
                }
                break;

            case "size":
                List<ClothDTO> sizeList = clothingService.findClothInfoBySize(searchValue);

                if (!sizeList.isEmpty()) {
                    model.addAttribute("clothList", sizeList);
                } else {
                    model.addAttribute("errorMsg", "No cloth found");
                }
                break;

            case "color":
                List<ClothDTO> colorList = clothingService.findClothInfoByColor(searchValue);

                if (!colorList.isEmpty()) {
                    model.addAttribute("clothList", colorList);
                } else {
                    model.addAttribute("errorMsg", "No cloth found");
                }
                break;

            case "category":
                List<ClothDTO> categoryList = clothingService.findClothsByCategory(searchValue);

                if (!categoryList.isEmpty()) {
                    model.addAttribute("clothList", categoryList);
                } else {
                    model.addAttribute("errorMsg", "No cloth found");
                }
                break;

            case "brand":
                List<ClothDTO> brandList = clothingService.findClothsByBrand(searchValue);

                if (!brandList.isEmpty()) {
                    model.addAttribute("clothList", brandList);
                } else {
                    model.addAttribute("errorMsg", "No cloth found");
                }
                break;

            case "availability":
                List<ClothDTO> availabilityList = clothingService.findClothsByAvailabilityStatus(searchValue);

                if (!availabilityList.isEmpty()) {
                    model.addAttribute("clothList", availabilityList);
                } else {
                    model.addAttribute("errorMsg", "No cloth found");
                }
                break;

            case "price":

                try {
                    double price = Double.parseDouble(searchValue);
                    List<ClothDTO> priceList = clothingService.findClothsByPrice(price);

                    if (!priceList.isEmpty()) {
                        model.addAttribute("clothList", priceList);
                    } else {
                        model.addAttribute("errorMsg", "No cloth found");
                    }


                }
                catch (NumberFormatException e) {
                    model.addAttribute("errorMsg", "Invalid price value");
                }
                break;

            case "stock":

                try {

                    int stock = Integer.parseInt(searchValue);
                    List<ClothDTO> stockList =
                            clothingService.findClothsByStockQuantity(stock);

                    if (!stockList.isEmpty()) {
                        model.addAttribute("clothList", stockList);
                    } else {
                        model.addAttribute("errorMsg", "No cloth found");
                    }
                }
                catch (NumberFormatException e) {
                    model.addAttribute("errorMsg", "Invalid stock quantity");
                }
                break;
        }

        return "SearchCloth";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id,Model model) {
        boolean deleted = clothingService.deleteById(id);
        if(deleted){
            model.addAttribute("successfulDelete","Deleted Successfully");
        }
        return "SearchCloth";
    }



    @GetMapping("/updateClothPage")
    public String updateClothPage(@RequestParam int id, Model model) {

        Optional<ClothDTO> optionalCloth = clothingService.findClothInfoById(id);

        if (optionalCloth.isPresent()) {
            model.addAttribute("clothDto", optionalCloth.get());
        } else {
            model.addAttribute("errorMsg", "Cloth not found with ID : " + id);
        }

        return "UpdateCloth";
    }



    @PostMapping("/updateCloth")
    public String updateCloth(ClothDTO dto, Model model) {
        boolean updated = clothingService.updateCloth(dto);

        if (!updated) {
            model.addAttribute("errorMsg", "Update failed");
            model.addAttribute("clothDto", dto);
            return "UpdateCloth";
        }
        model.addAttribute("successMsg", "Cloth updated successfully");
        model.addAttribute("clothDto", dto);
        return "SearchCloth";
    }



}
