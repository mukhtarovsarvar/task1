package com.company.controller;

import com.company.dto.HotelDTO;
import com.company.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;


    @GetMapping("")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(hotelService.get());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody HotelDTO dto){
        return ResponseEntity.ok(hotelService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id,
                                    @RequestBody HotelDTO dto){
        return ResponseEntity.ok(hotelService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id){
        return ResponseEntity.ok(hotelService.delete(id));
    }

}
