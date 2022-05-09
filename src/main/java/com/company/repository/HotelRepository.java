package com.company.repository;

import com.company.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer> {

}
