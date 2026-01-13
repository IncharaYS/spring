package com.xworkz.clothingapp.service;

import com.xworkz.clothingapp.dto.ClothDTO;
import com.xworkz.clothingapp.entity.ClothEntity;
import com.xworkz.clothingapp.exception.DuplicateClothNameException;
import com.xworkz.clothingapp.repository.ClothingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingServiceImpl implements ClothingService{

    @Autowired
    private ClothingRepository clothingRepository;



    @Override
    public boolean validateAndSave(ClothDTO clothDTO) {

        boolean isValidated = validateClothInfo(clothDTO);
        boolean isSaved = false;

        if (!isValidated) {
            System.err.println("Data not validated");
            return false;
        }

        ClothEntity clothEntity = new ClothEntity();
        BeanUtils.copyProperties(clothDTO, clothEntity);


        Optional<ClothEntity> existing = clothingRepository.findClothInfoByClothName(clothEntity.getClothName());

        if (existing.isPresent()) {
            System.err.println("Cloth already exists: " + clothDTO.getClothName());
            throw new DuplicateClothNameException("Cloth already exists");
        }
        else {
            try {
                clothEntity.setIsDeleted(0);
                isSaved = clothingRepository.save(clothEntity);

                if (isSaved) {
                    System.out.println("Data Saved Successfully");
                } else {
                    System.err.println("Failed to save data");
                }
            } catch (Exception e) {
                System.err.println("Exception while saving cloth: " + e.getMessage());
                isSaved = false;
            }
        }
        return isSaved;
    }


    @Override
    public Optional<ClothDTO> findClothInfoById(int id) {
        if (id>0){
            ClothDTO clothDTO = new ClothDTO();

            Optional<ClothEntity> clothEntity = clothingRepository.findClothInfoById(id);
            BeanUtils.copyProperties(clothEntity.get(),clothDTO);
            return Optional.of(clothDTO);
        }else System.err.println("Invalid Id");
        return Optional.empty();
    }

    @Override
    public boolean updatePriceById(int cId, double updatedPrice) {
        boolean isValidated=false;
        if(cId<=0){
            System.err.println("Invalid Id");
        } else if (updatedPrice<=0.0) {
            System.err.println("Invalid Price");
        }else {
            isValidated = true;
            boolean isUpdated = clothingRepository.updatePriceById(cId,updatedPrice);
            if (isUpdated) System.out.println("Cloth Price updated successfully!!");
            else System.err.println("Failed to update Price by Id");
        }


        return isValidated;
    }

    @Override
    public boolean deleteById(int clothId) {
        boolean isDeleted=false;
        if (clothId>0){
            isDeleted = clothingRepository.deleteById(clothId);
            if (isDeleted) System.out.println("Cloth Data deleted successfully!!!");
            else System.err.println("Failed to delete data");
        }
        return isDeleted;
    }




    @Override
    public Optional<ClothDTO> findClothInfoByClothName(String clothName) {

        if (clothName == null || clothName.isEmpty()) {
            System.err.println("Invalid cloth name");
            return Optional.empty();
        }

        Optional<ClothEntity> cloth = clothingRepository.findClothInfoByClothName(clothName);

        if (cloth.isPresent()) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth.get(), dto);
            return Optional.of(dto);
        }

        return Optional.empty();
    }



    @Override
    public List<ClothDTO> findClothInfoBySize(String cSize) {

        if (cSize==null || cSize.isEmpty()) {
            System.err.println("Invalid size");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> clothList = clothingRepository.findClothInfoBySize(cSize);

        for (ClothEntity cloth : clothList) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<ClothDTO> findClothInfoByColor(String clothColor) {

        if (clothColor==null || clothColor.isEmpty()) {
            System.err.println("Invalid color");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> clothList =clothingRepository.findClothInfoByColor(clothColor);

        for (ClothEntity cloth : clothList) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<ClothDTO> findClothsByCategory(String cCategory) {

        if (cCategory==null || cCategory.isEmpty()) {
            System.err.println("Invalid category");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> cloths = clothingRepository.findClothsByCategory(cCategory);

        for (ClothEntity cloth : cloths) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<ClothDTO> findClothsByBrand(String bName) {

        if (bName==null || bName.isEmpty()) {
            System.err.println("Invalid brand name");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> cloths = clothingRepository.findClothsByBrand(bName);

        for (ClothEntity cloth : cloths) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<ClothDTO> findClothsByAvailabilityStatus(String status) {

        if (status==null || status.isEmpty()) {
            System.err.println("Invalid availability status");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> cloths = clothingRepository.findClothsByAvailabilityStatus(status);

        for (ClothEntity cloth : cloths) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<ClothDTO> findClothsByPrice(double price) {

        if (price<=0) {
            System.err.println("Invalid price");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> cloths = clothingRepository.findClothsByPrice(price);

        for (ClothEntity cloth : cloths) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public List<ClothDTO> findClothsByStockQuantity(int stockQuantity) {

        if (stockQuantity<0) {
            System.err.println("Invalid stock quantity");
            return Collections.emptyList();
        }

        List<ClothDTO> dtoList = new ArrayList<>();
        List<ClothEntity> cloths = clothingRepository.findClothsByStockQuantity(stockQuantity);

        for (ClothEntity cloth : cloths) {
            ClothDTO dto = new ClothDTO();
            BeanUtils.copyProperties(cloth, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }






    @Override
    public List<Object[]> findClothNameAndBrandAndPriceByCategory(String catgryName) {
        if (catgryName!=null||!catgryName.isEmpty()){
            List<Object[]> clothDetailsList = clothingRepository.findClothNameAndBrandAndPriceByCategory(catgryName);
            if (clothDetailsList!=null){
                return clothDetailsList;
            }else System.err.println("Data not Available!!!");
        }
        return Collections.emptyList();
    }

    @Override
    public List<Object[]> fetchClothsListByCategoryAndPriceRange(String catName, double minPrice, double maxPrice) {
        if (catName==null||catName.isEmpty()) {
            System.err.println("Invalid category");
        } else if (minPrice<=0.0) {
            System.err.println("Invalid minimum price");
        } else if (maxPrice<minPrice||maxPrice<=0.0) {
            System.err.println("Invalid maximum price");
        } else{
            List<Object[]> clothDetailsList = clothingRepository.fetchClothsListByCategoryAndPriceRange(catName,minPrice,maxPrice);
            if (clothDetailsList!=null){
                return clothDetailsList;
            }else System.err.println("Data not Available!!!");
        }
        return Collections.emptyList();
    }

    @Override
    public List<ClothDTO> getClothsListByCategoryAndSize(String categoryName, String clSize) {
        if (categoryName==null||categoryName.isEmpty()){
            System.err.println("Invalid category");
        } else if (clSize==null||clSize.isEmpty()) {
            System.err.println("Invalid size");
        }else {
            List<ClothDTO> clothDTOList = new ArrayList<>();
            List<ClothEntity> clothEntities = clothingRepository.getClothsListByCategoryAndSize(categoryName,clSize);
            if (clothEntities!=null){
                clothEntities.stream().forEach(clothEntity -> {
                    ClothDTO clothDTO = new ClothDTO();
                    BeanUtils.copyProperties(clothEntity,clothDTO);
                    clothDTOList.add(clothDTO);
                });
            }else System.err.println("Data Not Available");
            return clothDTOList;
        }
        return Collections.emptyList();
    }

    @Override
    public List<ClothDTO> getAllClothesDetails() {
        List<ClothDTO> clothDTOS = new ArrayList<>();
        List<ClothEntity> clothEntities = clothingRepository.getAllClothesDetails();
        if (clothEntities!=null){
            clothEntities.stream().forEach(clothEntity -> {
                ClothDTO clothDTO = new ClothDTO();
                BeanUtils.copyProperties(clothEntity,clothDTO);
                clothDTOS.add(clothDTO);
            });
            return clothDTOS;
        }else System.err.println("Data Not Available!!!");

        return Collections.emptyList();
    }

    @Override
    public List<String> getAllClothesName() {
        List<String> clothNamesList = clothingRepository.getAllClothesName();
        if (clothNamesList !=null){
            return clothNamesList;
        }else System.err.println("Data Not Available!!!");

        return Collections.emptyList();
    }

    @Override
    public List<String> getAllBrandNames() {
        List<String> brandNamesList = clothingRepository.getAllBrandNames();
        if (brandNamesList !=null){
            return brandNamesList;
        }else System.err.println("Data Not Available!!!");
        return Collections.emptyList();
    }

    @Override
    public List<String> getAllCategories() {
        List<String> categoriesList = clothingRepository.getAllCategories();
        if (categoriesList !=null){
            return categoriesList;
        }else System.err.println("Data Not Available!!!");
        return Collections.emptyList();
    }

    @Override
    public List<ClothDTO> getClothsListByCategoryAndColor(String categoryName1, String color1) {
        if (categoryName1==null||categoryName1.isEmpty()){
            System.err.println("Invalid category");
        } else if (color1==null||color1.isEmpty()) {
            System.err.println("Invalid color");
        }else {
            List<ClothDTO> clothDTOList = new ArrayList<>();
            List<ClothEntity> clothEntities = clothingRepository.getClothsListByCategoryAndColor(categoryName1,color1);
            if (clothEntities!=null){
                clothEntities.stream().forEach(clothEntity -> {
                    ClothDTO clothDTO = new ClothDTO();
                    BeanUtils.copyProperties(clothEntity,clothDTO);
                    clothDTOList.add(clothDTO);
                });
            }else System.err.println("Data Not Available");
            return clothDTOList;
        }
        return Collections.emptyList();
    }

    @Override
    public List<ClothDTO> fetchClothsListByCategoryBrandAndPriceRange(String ctName, String bName1, double minPrice1, double maxPrice1) {
        if (ctName==null||ctName.isEmpty()) {
            System.err.println("Invalid category");
        } else if (bName1==null||bName1.isEmpty()) {
            System.err.println("Invalid brand name");
        } else if (minPrice1<=0.0) {
            System.err.println("Invalid minimum price");
        } else if (maxPrice1<minPrice1||maxPrice1<=0.0) {
            System.err.println("Invalid maximum price");
        }else {
            List<ClothDTO> clothDTOS = new ArrayList<>();
            List<ClothEntity> clothEntities = clothingRepository.fetchClothsListByCategoryBrandAndPriceRange(ctName,bName1,minPrice1,maxPrice1);
            if (clothEntities!=null){
                clothEntities.stream().forEach(clothEntity1 -> {
                    ClothDTO clothDTO = new ClothDTO();
                    BeanUtils.copyProperties(clothEntity1,clothDTO);
                    clothDTOS.add(clothDTO);
                });
                return clothDTOS;
            }else System.err.println("Data Not Available");
        }
        return Collections.emptyList();
    }

    private boolean validateClothInfo(ClothDTO clothDTO) {

        if (clothDTO.getClothName() == null || clothDTO.getClothName().trim().isEmpty()) {
            System.err.println("Invalid cloth name");
            return false;
        }

        if (clothDTO.getCategoryName() == null || clothDTO.getCategoryName().trim().isEmpty()) {
            System.err.println("Invalid category name");
            return false;
        }

        if (clothDTO.getSize() == null || clothDTO.getSize().trim().isEmpty()) {
            System.err.println("Invalid size");
            return false;
        }

        if (clothDTO.getColor() == null || clothDTO.getColor().trim().isEmpty()) {
            System.err.println("Invalid color");
            return false;
        }

        if (clothDTO.getPrice() <= 0) {
            System.err.println("Invalid price");
            return false;
        }

        if (clothDTO.getStockQuantity() < 0) {
            System.err.println("Invalid stock quantity");
            return false;
        }

        if (clothDTO.getAvailabilityStatus() == null
                || clothDTO.getAvailabilityStatus().trim().isEmpty()) {
            System.err.println("Invalid availability status");
            return false;
        }

        return true;
    }
}
