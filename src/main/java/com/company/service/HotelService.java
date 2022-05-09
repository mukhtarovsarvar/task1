package com.company.service;


import com.company.dto.HotelDTO;
import com.company.entity.HotelEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelDTO create(HotelDTO dto){
        HotelEntity entity = new HotelEntity();
        entity.setName(dto.getName());
        hotelRepository.save(entity);
        return toDTO(entity);
    }

    public Boolean delete(Integer id){
        hotelRepository.findById(id).orElseThrow(()->{
            throw new ItemNotFoundException("not found");
        });

        hotelRepository.deleteById(id);
        return true;
    }

    public List<HotelDTO> get(){
        return hotelRepository.findAll().stream().map(this::toDTO).toList();
    }

    public HotelDTO update(Integer id,HotelDTO dto){
        HotelEntity entity = hotelRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("not found");
        });
        entity.setName(dto.getName());
        hotelRepository.save(entity);
        return toDTO(entity);
    }
    public HotelDTO toDTO(HotelEntity entity){
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
}
