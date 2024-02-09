package com.aleal.hotels.services;

import java.util.List;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.dto.HotelRoom;

public interface IHotelService {
	
	List<Hotel> search();
	HotelRoom searchRoomByHotelId(Long id);
	HotelRoom searchRoomByHotelIdWithoutRooms(Long id);

}
