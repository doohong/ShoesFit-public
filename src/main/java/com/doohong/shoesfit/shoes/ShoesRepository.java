package com.doohong.shoesfit.shoes;

import com.doohong.shoesfit.shoes.domain.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoesRepository extends JpaRepository<Shoes,Integer> {
    Shoes findByBrandAndNameAndSize(String brand,String name,int size);
    List<Shoes> findByBrandAndName(String brand, String name);

    @Query(value ="SELECT ISNULL(MAX(shoes_no),1) FROM tbl_shoes", nativeQuery = true)
    int findMaxId();

}
