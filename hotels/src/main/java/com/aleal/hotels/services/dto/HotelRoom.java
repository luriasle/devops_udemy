package com.aleal.hotels.services.dto;

import com.aleal.hotels.services.room.dto.RoomDto;
import lombok.Data;

import java.util.List;

@Data
public class HotelRoom {

    private long hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<RoomDto> rooms;
}
