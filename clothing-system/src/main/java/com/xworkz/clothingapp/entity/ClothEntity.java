package com.xworkz.clothingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cloths")

@NamedQueries({
        @NamedQuery(name = "findClothInfoByCategory",query = "select cloth from ClothEntity cloth where cloth.categoryName=:categoryName and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothInfoByClothName",query = "select cloth from ClothEntity cloth where cloth.clothName=:cName and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothInfoByBrandName",query = "select cloth from ClothEntity cloth where cloth.brandName=:brand and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothInfoBySize",query = "select cloth from ClothEntity cloth where cloth.size=:size and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothInfoByColor",query = "select cloth from ClothEntity cloth where cloth.color=:color and cloth.isDeleted=0"),
        @NamedQuery(name = "filterClothsByCategory",query = "select cloth from ClothEntity cloth where cloth.categoryName=:cCategory and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothsByBrand",query = "select cloth from ClothEntity cloth where cloth.brandName=:bName and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothNameAndBrandAndPriceByCategory",query = "select cloth.clothName,cloth.size,cloth.brandName,cloth.price from ClothEntity cloth where cloth.categoryName=:cName and cloth.isDeleted=0"),
        @NamedQuery(name = "fetchClothsListByCategoryAndPriceRange",query = "select cloth.clothName,cloth.size,cloth.brandName,cloth.price from ClothEntity cloth where cloth.categoryName=:cName and cloth.price between :min and :max and cloth.isDeleted=0"),
        @NamedQuery(name = "getClothsListByCategoryAndSize",query = "select cloth from ClothEntity cloth where cloth.categoryName=:categoryName and cloth.size=:cSize and cloth.isDeleted=0"),
        @NamedQuery(name = "getAllClothesDetails",query = "select cloth from ClothEntity cloth where cloth.isDeleted=0"),
        @NamedQuery(name = "getAllClothesName",query = "select distinct cloth.clothName from ClothEntity cloth where cloth.isDeleted=0"),
        @NamedQuery(name = "getAllBrandNames",query = "select distinct cloth.brandName from ClothEntity cloth where cloth.isDeleted=0"),
        @NamedQuery(name = "getAllCategories",query = "select distinct cloth.categoryName from ClothEntity cloth where cloth.isDeleted=0"),
        @NamedQuery(name = "getClothsListByCategoryAndColor",query = "select cloth from ClothEntity cloth where cloth.categoryName=:categoryName and cloth.color=:color and cloth.isDeleted=0"),
        @NamedQuery(name = "fetchClothsListByCategoryBrandAndPriceRange",query = "select cloth from ClothEntity cloth where cloth.categoryName=:cName and cloth.brandName=:brand and cloth.price between :min and :max and cloth.isDeleted=0"),
        @NamedQuery(name = "findClothsByAvailabilityStatus", query = "from ClothEntity c where c.availabilityStatus=:status and c.isDeleted=0"),
        @NamedQuery(name = "findClothsByPrice", query = "from ClothEntity c where c.price = :price and c.isDeleted=0"),
        @NamedQuery(name = "findClothsByStockQuantity", query = "from ClothEntity c where c.stockQuantity = :stockQty and c.isDeleted=0"),
        @NamedQuery(name = "deleteById",query = "update ClothEntity c set c.isDeleted=1 where c.clothId=:eId and c.isDeleted=0")
})

public class ClothEntity {

    @Id
    @Column(name = "cloth_id")
    private int clothId;
    @Column(name = "cloth_name")
    private String clothName;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "size")
    private String size;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private double price;
    @Column(name = "stock_qty")
    private int stockQuantity;
    @Column(name = "availability_status")
    private String availabilityStatus;
    @Column(name = "is_deleted")
    private int isDeleted;

}
