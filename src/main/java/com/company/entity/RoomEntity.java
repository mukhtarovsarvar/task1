package com.company.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer number;
    @Column
    private Integer floor;
    @Column
    private Double size;

    @Column(name = "hotel_id",nullable = false)
    private Integer hotelId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="hotel_id",insertable = false,updatable = false)
    private HotelEntity hotel;

}
