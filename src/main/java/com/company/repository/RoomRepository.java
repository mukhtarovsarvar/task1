package com.company.repository;

import com.company.entity.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity,Integer> {

    Page<RoomEntity> findByHotelId(Integer id, Pageable pageable);
}
