package com.xworkz.medicineapp.service;

import com.xworkz.medicineapp.dto.MedicineDTO;
import com.xworkz.medicineapp.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public boolean validateAndSave(MedicineDTO medicineDTO) {

        boolean isValid=false;

        if(medicineDTO.getMedicineName()==null || medicineDTO.getMedicineName().length()<3){
            System.err.println("Entered medicine name is invalid");
            return isValid;
        }
        else if (medicineDTO.getPrice()==null || medicineDTO.getPrice().isEmpty()) {
            System.err.println("Entered medicine price is invalid");
            return isValid;
        }
        else if (medicineDTO.getMg()==null || medicineDTO.getMg().isEmpty()) {
            System.err.println("Entered medicine mg is invalid");
            return isValid;
        }
        else if (medicineDTO.getCombination()==null || medicineDTO.getCombination().length()<3) {
            System.err.println("Entered medicine combination is invalid");
            return isValid;
        }
        else if (medicineDTO.getExpDate()==null || medicineDTO.getExpDate().length()<8) {
            System.err.println("Entered medicine exp date is invalid");
            return isValid;
        }
        else {
            System.out.println("All data is valid");
            isValid=true;

            boolean isSaved=medicineRepository.save(medicineDTO);
            if(isSaved) System.out.println("Data saved successfully");
            else System.err.println("Failed to save data");
        }

        return isValid;
    }

    @Override
    public Optional<MedicineDTO> getMedicine(String medicineName) {
        if(medicineName==null || medicineName.length()<3){
            System.out.println("Invalid medicine name");
            return Optional.empty();
        }
        else{
           Optional<MedicineDTO> dto= medicineRepository.searchByName(medicineName);
           return dto;
        }
    }


    @Override
    public Optional<MedicineDTO> getMedicineById(int id) {
        if(id<0){
            System.out.println("Invalid id entered");
            return Optional.empty();
        }
        else{
            Optional<MedicineDTO> dto= medicineRepository.searchById(id);
            return dto;
        }
    }
}
