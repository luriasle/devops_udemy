package com.aleal.hotels.services.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RoomDto {

    private Long roomId;
    private Long hotelId;
    private String roomName;
    private String roomAvailable;

}
