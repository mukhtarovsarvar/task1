package com.company.controller;

import com.company.dto.RoomDTO;
import com.company.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;


    @GetMapping("")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(roomService.getList());
    }


    @GetMapping("/{hId}")
    public ResponseEntity<?> get(@PathVariable("hId") Integer hotelId,
                                 @RequestParam(value = "page",defaultValue = "0") int page,
                                 @RequestParam(value = "size",defaultValue = "5") int size){
        return ResponseEntity.ok(roomService.getByHotelId(hotelId,page,size));
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody RoomDTO dto){
        return ResponseEntity.ok(roomService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id,
                                    @RequestBody RoomDTO dto){
        return ResponseEntity.ok(roomService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id){
        return ResponseEntity.ok(roomService.delete(id));
    }
}
