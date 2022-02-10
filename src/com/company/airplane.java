package com.company;

public class airplane {

    // Nødvendige variabler for flyene
    int airplaneNumber;
    int timeOffDeparture;
    int timeOffLanding;

    // Constructor
    public airplane(int airplaneNumber, int timeOffLanding) {
        this.airplaneNumber = airplaneNumber;
        this.timeOffLanding = timeOffLanding;
    }

    public int getAirplaneNumber() {
        return airplaneNumber;
    }

    public void setAirplaneNumber(int airplaneNumber) {
        this.airplaneNumber = airplaneNumber;
    }

    public int getTimeOffDeparture() {
        return timeOffDeparture;
    }

    public void setTimeOffDeparture(int timeOffDeparture) {
        this.timeOffDeparture = timeOffDeparture;
    }

    public int getTimeOffLanding() {
        return timeOffLanding;
    }

    public void setTimeOffLanding(int timeOffLanding) {
        this.timeOffLanding = timeOffLanding;
    }
}
