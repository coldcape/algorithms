package com.company;

import java.util.*;

import static com.company.GetPoissonRandom.getPoissonRandom;


public class Main {


    public static void main(String[] args) {


        int airplaneNumber = 1;
        int airplanesRejected = 0;

        int numberOffAirPlanesTakenOff = 0;
        int numberOffAirPlanesLanded = 0;
        ArrayList<Integer> waitingTimes = new ArrayList<>();
        int numberOffAirPlanesProcessed = 0;
        int timeAirportUnused = 0;


        // Køer for flyplassen
        Queue<airplane> takeOffQ = new LinkedList<>();
        Queue<airplane> landingQ = new LinkedList<>();




        // User inputs
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.println("Hvor mange tidsenheter skal simuleringen gå?");
        int InputTimeUnits = scanner.nextInt();

        System.out.println("Forventet antall ankomster pr. tidsenhet?");
        float InputArrivals = scanner.nextFloat();

        System.out.println("Forventet antall avganger pr. tidsenhet?");
        float InputTakeOffs = scanner.nextFloat();
        scanner.close();

        for (int timeUnit = 0; timeUnit < InputTimeUnits; timeUnit++) {

            // Landing queue

            int new_landings = getPoissonRandom(InputArrivals);

            for(int i = 0; i < new_landings; i++){
                airplane nextPlane = new airplane(airplaneNumber, timeUnit);
                airplaneNumber++;
                if(landingQ.size() <= 10){
                    landingQ.add(nextPlane);
                    System.out.println("Fly " + nextPlane.airplaneNumber + " klar for landing.");

                }else {
                    airplanesRejected++;
                }
            }

            // Takeoff queue

            int new_takeOffs = getPoissonRandom(InputTakeOffs);

            for(int j = 0; j < new_takeOffs; j++){
                airplane nextPlane = new airplane(airplaneNumber, timeUnit);
                airplaneNumber++;
                if(takeOffQ.size() <= 10){
                    takeOffQ.add(nextPlane);
                    System.out.println("Fly " + nextPlane.airplaneNumber + " klar for avgang");
                }else{
                    airplanesRejected++;
                }
            }

            if(landingQ.size() > 0){
               airplane nextPlane = landingQ.poll();
                nextPlane.setTimeOffDeparture(timeUnit);
                int waitingTime = nextPlane.getTimeOffDeparture() - nextPlane.timeOffLanding;
                waitingTimes.add(waitingTime);
                numberOffAirPlanesLanded++;
                numberOffAirPlanesProcessed++;
                System.out.println("Fly " + nextPlane.airplaneNumber + " har landet, ventetid: " + waitingTime);

            } else if(takeOffQ.size() > 0){
                airplane nextPlane = takeOffQ.poll();
                nextPlane.setTimeOffDeparture(timeUnit);
                int waitingTime = nextPlane.getTimeOffDeparture() - nextPlane.getTimeOffLanding();
                waitingTimes.add(waitingTime);
                numberOffAirPlanesProcessed++;
                numberOffAirPlanesTakenOff++;
                System.out.println("Fly " + nextPlane.airplaneNumber + " tatt av, ventetid: " + waitingTime);

            }else {
                timeAirportUnused++;
            }







        }


        System.out.println("Simuleringen ferdig etter " + InputTimeUnits + " tidsenheter");
        System.out.println("Totalt antall fly behandlet " + numberOffAirPlanesProcessed );
        System.out.println("Antall fly landet " + numberOffAirPlanesLanded);
        System.out.println("Antall fly tatt av " + numberOffAirPlanesTakenOff);
        System.out.println("Antall fly avvist " + airplanesRejected);
        System.out.println("Antall fly klare for landing " + landingQ.size());
        System.out.println("Antalle fly klare til å ta av " + takeOffQ.size());
        float freetimePercent = (((float) timeAirportUnused / InputTimeUnits) * 100);
        System.out.println("Prosent ledig tid " + freetimePercent + "%");
        int sumWaitingTimeLanding = 0;
        for (int i = 0; i < waitingTimes.size(); i++){
           sumWaitingTimeLanding += waitingTimes[i];
        }
        float averageWaitLanding = sumWaitingTimeLanding / waitingTimes.size();



    }
}

/*
  Les data/parameterverdier for simuleringen fra bruker $

    Initier begge køene til å være tomme $

    For hver tidssteg i simuleringen

        Trekk et tilfeldig antall nye fly som kommer for å lande

        For hvert nytt fly som kommer for å lande
            Hvis landingskøen er full
                Avvis det nye flyet (henvis til annen flyplass)
            ellers
                Sett det nye flyet sist i landingskøen

        Trekk et tilfeldig antall nye fly som kommer for å ta av

        For hvert nytt fly som kommer for å ta av
            Hvis avgangskøen er full
                Avvis det nye flyet (avgang må prøves senere)
            ellers
                Sett det nye flyet sist i avgangskøen

        Hvis landingskøen ikke er tom
            Ta ut første fly i landingskøen og la det få lande
        ellers hvis avgangskøen ikke er tom
            Ta ut første fly i avgangskøen og la det få ta av
        ellers
            Flyplassen er tom for fly

    Skriv til slutt ut resultater som gj.snittlig ventetid etc.
 */