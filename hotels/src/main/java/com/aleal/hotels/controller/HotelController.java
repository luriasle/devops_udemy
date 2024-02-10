package com.aleal.hotels.controller;

import com.aleal.hotels.config.HotelsServiceConfiguration;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.PropertiesHotels;
import com.aleal.hotels.services.IHotelService;
import com.aleal.hotels.services.dto.HotelRoom;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private IHotelService service;

    @Autowired
    private HotelsServiceConfiguration config;


    @GetMapping
    public List<Hotel> search() {
        logger.info("Init Method search()");
        
        return this.service.search();
    }

    @GetMapping("/list-properties")
    public String getPropertiesHotels() throws JsonProcessingException {
        logger.info("Init Method getPropertiesHotels()");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        PropertiesHotels propertiesHotels = new PropertiesHotels(
                config.getMsg(),
                config.getBuildVersion(),
                config.getMailDetails()
        );

        return ow.writeValueAsString(propertiesHotels);
    }

    @GetMapping("/{id}/rooms")
//    @CircuitBreaker(name = "searchRoomByHotelIdCB", fallbackMethod = "searchRoomByHotelIdAlternative")
    @Retry(name = "searchRoomByHotelIdRetry", fallbackMethod = "searchRoomByHotelIdAlternative")
    public HotelRoom searchRoomByHotelId(@PathVariable Long id) {
        logger.info("Init Method searchRoomByHotelId()");

        return this.service.searchRoomByHotelId(id);
    }

    public HotelRoom searchRoomByHotelIdAlternative(@PathVariable Long id, Throwable thr) {
        logger.info("Init Method searchRoomByHotelIdAlternative()");

        return this.service.searchRoomByHotelIdWithoutRooms(id);
    }
}
