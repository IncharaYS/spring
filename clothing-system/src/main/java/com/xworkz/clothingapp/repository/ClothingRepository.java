package com.xworkz.clothingapp.repository;

import com.xworkz.clothingapp.dto.ClothDTO;
import com.xworkz.clothingapp.entity.ClothEntity;

import java.util.List;
import java.util.Optional;

public interface ClothingRepository {

    boolean save(ClothEntity clothEntity);

    Optional<ClothEntity> findClothInfoById(int id);

    boolean updatePriceById(int cId, double updatedPrice);

    boolean deleteById(int clothId);

    boolean updateCloth(ClothEntity clothEntity);




    Optional<ClothEntity> findClothInfoByClothName(String clothName);

    List<ClothEntity> findClothInfoBySize(String cSize);

    List<ClothEntity> findClothInfoByColor(String clothColor);

    List<ClothEntity> findClothsByCategory(String cCategory);

    List<ClothEntity> findClothsByBrand(String bName);

    List<ClothEntity> findClothsByAvailabilityStatus(String status);

    List<ClothEntity> findClothsByPrice(double price);

    List<ClothEntity> findClothsByStockQuantity(int stockQuantity);






    List<Object[]> findClothNameAndBrandAndPriceByCategory(String catgryName);

    List<Object[]> fetchClothsListByCategoryAndPriceRange(String catName, double minPrice, double maxPrice);

    List<ClothEntity> getClothsListByCategoryAndSize(String categoryName, String clSize);

    List<ClothEntity> getAllClothesDetails();



    List<String> getAllClothesName();

    List<String> getAllBrandNames();

    List<String> getAllCategories();



    List<ClothEntity> getClothsListByCategoryAndColor(String categoryName1, String color1);

    List<ClothEntity> fetchClothsListByCategoryBrandAndPriceRange(String ctName, String bName1, double minPrice1, double maxPrice1);

}
