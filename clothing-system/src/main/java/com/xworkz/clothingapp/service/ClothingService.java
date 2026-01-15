package com.xworkz.clothingapp.service;

import com.xworkz.clothingapp.dto.ClothDTO;
import com.xworkz.clothingapp.entity.ClothEntity;

import java.util.List;
import java.util.Optional;

public interface ClothingService {

    boolean validateAndSave(ClothDTO clothDTO);

    Optional<ClothDTO> findClothInfoById(int id);

    boolean updatePriceById(int cId, double updatedPrice);

    boolean deleteById(int clothId);

    boolean updateCloth(ClothDTO clothDTO);


    Optional<ClothDTO> findClothInfoByClothName(String clothName);

    List<ClothDTO> findClothInfoBySize(String cSize);

    List<ClothDTO> findClothInfoByColor(String clothColor);

    List<ClothDTO> findClothsByCategory(String cCategory);

    List<ClothDTO> findClothsByBrand(String bName);

    List<ClothDTO> findClothsByAvailabilityStatus(String status);

    List<ClothDTO> findClothsByPrice(double price);

    List<ClothDTO> findClothsByStockQuantity(int stockQuantity);




    List<Object[]> findClothNameAndBrandAndPriceByCategory(String catgryName);

    List<Object[]> fetchClothsListByCategoryAndPriceRange(String catName, double minPrice, double maxPrice);

    List<ClothDTO> getClothsListByCategoryAndSize(String categoryName, String clSize);

    List<ClothDTO> getAllClothesDetails();

    List<String> getAllClothesName();

    List<String> getAllBrandNames();

    List<String> getAllCategories();

    List<ClothDTO> getClothsListByCategoryAndColor(String categoryName1, String color1);

    List<ClothDTO> fetchClothsListByCategoryBrandAndPriceRange(String ctName, String bName1, double minPrice1, double maxPrice1);

}
