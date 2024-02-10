package com.aleal.hotels.hotels;

import com.aleal.hotels.controller.HotelController;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;
import com.aleal.hotels.services.dto.HotelRoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HotelsApplicationTests {

    @Mock
    private IHotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Hotel> expectedHotels = Arrays.asList(
                new Hotel(1L, "Hotel A", "City A"),
                new Hotel(2L, "Hotel B", "City B")
                // Add more hotels if needed for testing variations
        );
        Mockito.when(hotelService.search()).thenReturn(expectedHotels);

        // Act
        List<Hotel> actualHotels = hotelController.search();

        // Assert
        Assertions.assertEquals(expectedHotels.size(), actualHotels.size());
        // Add more assertions if needed to compare individual hotel details
        // For example:
        // assertEquals(expectedHotels.get(0).getName(), actualHotels.get(0).getName());
        // assertEquals(expectedHotels.get(1).getCity(), actualHotels.get(1).getCity());
    }

    @Test
    public void testSearchRoomByHotelId() {
        // Arrange
        long hotelId = 123L;
        HotelRoom expectedRoom = new HotelRoom();
        expectedRoom.setHotelId(hotelId);
        expectedRoom.setHotelName("Example Hotel");
        expectedRoom.setHotelAddress("Example Address");
        // You may set more properties or rooms as needed for testing

        Mockito.when(hotelService.searchRoomByHotelId(ArgumentMatchers.anyLong())).thenReturn(expectedRoom);

        // Act
        HotelRoom actualRoom = hotelController.searchRoomByHotelId(hotelId);

        // Assert
        Assertions.assertEquals(expectedRoom.getHotelId(), actualRoom.getHotelId());
        Assertions.assertEquals(expectedRoom.getHotelName(), actualRoom.getHotelName());
        Assertions.assertEquals(expectedRoom.getHotelAddress(), actualRoom.getHotelAddress());
        // You may add more assertions for room properties or rooms list as needed
    }
}
