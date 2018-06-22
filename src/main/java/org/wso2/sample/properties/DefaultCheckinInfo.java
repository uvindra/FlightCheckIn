package org.wso2.sample.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.wso2.sample.model.CheckinInfo;
import org.wso2.sample.model.CheckinInfoDTO;

@Configuration
@PropertySource("classpath:config.properties")
public class DefaultCheckinInfo {

    //@Value("${bookingReference}")
    private String bookingReference;

    //@Value("${flightNumber}")
    private String flightNumber;

    //@Value("${seatNumber}")
    private String seatNumber;

    //@Value("${passengerName}")
    private String passengerName;

    //@Value("${customerId}")
    private String customerId;

    //@Value("${from}")
    private String from;

    //@Value("${to}")
    private String to;

    //@Value("${flightDistance}")
    private long flightDistance;


    @Bean
    public CheckinInfoDTO CheckInfoTemplate() {
        CheckinInfo checkinInfo = new CheckinInfo();
        checkinInfo.setCustomerId(customerId);
        checkinInfo.setFlightDistance(flightDistance);
        checkinInfo.setFlightNumber(flightNumber);
        checkinInfo.setFrom(from);
        checkinInfo.setTo(to);
        checkinInfo.setPassengerName(passengerName);
        checkinInfo.setSeatNumber(seatNumber);

        CheckinInfoDTO checkinInfoDTO = new CheckinInfoDTO();
        checkinInfoDTO.bookingReference = bookingReference;
        checkinInfoDTO.checkInDetails = checkinInfo;

        return checkinInfoDTO;
    }


    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFlightDistance(long flightDistance) {
        this.flightDistance = flightDistance;
    }
}
