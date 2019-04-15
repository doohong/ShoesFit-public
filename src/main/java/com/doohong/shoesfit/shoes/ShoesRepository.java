package com.doohong.shoesfit.shoes;

import com.doohong.shoesfit.shoes.domain.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes,Long> {
    Shoes findByBrandAndNameAndSize(String brand,String name,int size);
}
