package com.company.service;

import com.company.dto.RoomDTO;
import com.company.entity.RoomEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;

    public RoomDTO create(RoomDTO dto){
        RoomEntity entity = new RoomEntity();
        entity.setFloor(dto.getFloor());
        entity.setHotelId(dto.getHotelId());
        entity.setNumber(dto.getNumber());
        entity.setSize(dto.getSize());
        repository.save(entity);

        return toDTO(entity);
    }

    public PageImpl<RoomDTO> getByHotelId(Integer hotelId,int page,int size){
        Page<RoomEntity> entityPage = repository.findByHotelId(hotelId, PageRequest.of(page, size));

        return  new PageImpl<>(entityPage.stream().map(this::toDTO).toList(),
                PageRequest.of(page, size), entityPage.getTotalElements());
    }

    public List<RoomDTO> getList(){
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public boolean delete(Integer id){
        repository.findById(id).orElseThrow(()->{
            throw new ItemNotFoundException("not found");
        });
        repository.deleteById(id);
        return true;
    }

    public RoomDTO update(Integer id,RoomDTO dto){
        RoomEntity entity = repository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("not found");
        });
        entity.setSize(dto.getSize());
        entity.setNumber(dto.getNumber());
        entity.setFloor(dto.getFloor());
        repository.save(entity);
        return toDTO(entity);
    }


    public RoomDTO toDTO(RoomEntity entity){
        RoomDTO dto = new RoomDTO();
        dto.setNumber(entity.getNumber());
        dto.setFloor(entity.getFloor());
        dto.setHotelId(entity.getHotelId());
        dto.setSize(entity.getSize());
        return dto;
    }
}
