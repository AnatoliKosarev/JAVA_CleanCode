import planeModels.ClassificationLevel;
import planeModels.ExperimentalType;
import planeModels.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("ExpMod1", 2000, 25000, 300000, ExperimentalType.LIFTING_BODY, ClassificationLevel.TOP_SECRET),
            new ExperimentalPlane("ExpMod2", 1230, 100, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.UNCLASSIFIED),
            new ExperimentalPlane("ExpMod3", 975, 9000, 70250, ExperimentalType.VTOL, ClassificationLevel.CONFIDENTIAL)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlaneList());
        Airport passengerAirport = new Airport(airport.getPassengerPlaneList());
        Airport experimentalAirport = new Airport(airport.getExperimentalPlaneList());
        System.out.println("Military airport sorted by max distance: " + militaryAirport.sortPlaneListByMaxFlightDistance().toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport.sortPlaneListByMaxSpeed().toString());
        System.out.println("Experimental airport sorted by max load capacity: " + experimentalAirport.sortPlaneListByMaxLoadCapacity().toString());
        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
