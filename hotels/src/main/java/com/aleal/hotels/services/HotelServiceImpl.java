package com.aleal.hotels.services;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.client.room.RoomFeignClient;
import com.aleal.hotels.services.dto.HotelRoom;
import com.aleal.hotels.services.room.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelDao hotelDao;

    @Autowired
    private RoomFeignClient roomFeignClient;

    public HotelServiceImpl(IHotelDao hotelDao, RoomFeignClient roomFeignClient) {
        this.hotelDao = hotelDao;
        this.roomFeignClient = roomFeignClient;
    }

    @Override
    public List<Hotel> search() {
        return (List<Hotel>) hotelDao.findAll();
    }

    public HotelRoom searchRoomByHotelId(Long id) {
        HotelRoom hotelRoom = new HotelRoom();
        Optional<Hotel> hotel = hotelDao.findById(id);

        List<RoomDto> roomDtos = roomFeignClient.searchByHotelId(id);

        hotelRoom.setHotelId(hotel.get().getHotelId());
        hotelRoom.setHotelName(hotel.get().getHotelName());
        hotelRoom.setHotelAddress(hotel.get().getHotelAddress());
        hotelRoom.setRooms(roomDtos);

        return hotelRoom;
    }

    public HotelRoom searchRoomByHotelIdWithoutRooms(Long id) {
        HotelRoom hotelRoom = new HotelRoom();
        Optional<Hotel> hotel = hotelDao.findById(id);

        hotelRoom.setHotelId(hotel.get().getHotelId());
        hotelRoom.setHotelName(hotel.get().getHotelName());
        hotelRoom.setHotelAddress(hotel.get().getHotelAddress());

        return hotelRoom;
    }
}
