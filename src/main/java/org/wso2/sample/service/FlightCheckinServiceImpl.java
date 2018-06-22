package org.wso2.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.sample.model.CheckinInfo;
import org.wso2.sample.model.CheckinInfoDTO;
import org.wso2.sample.properties.DefaultCheckinInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service("flightCheckinService")
public class FlightCheckinServiceImpl implements FlightCheckinService {

    //@Autowired
    //private DefaultCheckinInfo defaultCheckinInfo;

    private Map<String, CheckinInfo> checkinInfoLookup = new HashMap<>();

    public FlightCheckinServiceImpl() {
        //CheckinInfoDTO checkinInfoDTO = defaultCheckinInfo.CheckInfoTemplate();

        //checkinInfoLookup.put(checkinInfoDTO.bookingReference, checkinInfoDTO.checkInDetails);
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("config.properties");
        try {
            prop.load(stream);

            CheckinInfo checkinInfo = new CheckinInfo();
            checkinInfo.setCustomerId(prop.getProperty("customerId"));
            checkinInfo.setFlightDistance(Long.parseLong(prop.getProperty("flightDistance")));
            checkinInfo.setFlightNumber(prop.getProperty("flightNumber"));
            checkinInfo.setFrom(prop.getProperty("from"));
            checkinInfo.setTo(prop.getProperty("to"));
            checkinInfo.setPassengerName(prop.getProperty("passengerName"));
            checkinInfo.setSeatNumber(prop.getProperty("seatNumber"));

            checkinInfoLookup.put(prop.getProperty("bookingReference"), checkinInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CheckinInfo getCheckIn(String bookingReference) {
        return checkinInfoLookup.get(bookingReference);
    }

    @Override
    public boolean isCheckInExists(String bookingReference) {
        return checkinInfoLookup.containsKey(bookingReference);
    }

    @Override
    public void addCheckIn(String bookingReference, CheckinInfo checkInDetails) {
        checkinInfoLookup.put(bookingReference, checkInDetails);
    }

    @Override
    public void deleteCheckIn(String bookingReference) {
        checkinInfoLookup.remove(bookingReference);
    }
}
