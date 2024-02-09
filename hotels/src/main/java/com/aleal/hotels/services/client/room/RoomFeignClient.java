package com.aleal.hotels.services.client.room;

import com.aleal.hotels.services.room.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("rooms")
public interface RoomFeignClient {

    @GetMapping(value = "/rooms/hotel/{id}")
    List<RoomDto> searchByHotelId(@PathVariable Long id);
}
