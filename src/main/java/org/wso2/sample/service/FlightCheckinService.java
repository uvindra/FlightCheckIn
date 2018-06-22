package org.wso2.sample.service;

import org.wso2.sample.model.CheckinInfo;


public interface FlightCheckinService {
    CheckinInfo getCheckIn(String bookingReference);
    boolean isCheckInExists(String bookingReference);
    void addCheckIn(String bookingReference, CheckinInfo checkInDetails);
    void deleteCheckIn(String bookingReference);
}
