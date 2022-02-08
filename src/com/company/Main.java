package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        int airplanesLanded;
        int airplanesTakenOff;
        int airplanesRejected;

        ArrayList<Integer> numberOffAirPlanesTakenOff = new ArrayList<>();
        ArrayList<Integer> numberOffAirPlanesLanded = new ArrayList<>();

        // Køer for flyplassen
        Queue<Integer> takeOffQ = new LinkedList<Integer>();
        Queue<Integer> landingQ = new LinkedList<Integer>();

        landingQ.add(1);
        landingQ.add(2);
        landingQ.add(3);

        System.out.println(landingQ.size());

        // Landing queue
        for (int i = landingQ.size(); i < 20; i++){



        }


        // Take off queue
        for (int i = landingQ.size(); i < 20; i++){



        }


    }
}

/*
## RULES ##
- Inside each time event an airplane can take off OR land
- At random points an airplane will take of OR land. These have to be put into the end of the queue
- Since airplanes run on gas and can run empty. It's important to get them landing as soon as possible.
    Because of this an airplane will only take off IF the landing queue is empty (fully empty)
- There is a limit to how many can be in the queue at the same time. This number is 10
- At the start of simulation the runway is supposed to be empty

*/

/*
  Les data/parameterverdier for simuleringen fra bruker

    Initier begge køene til å være tomme

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