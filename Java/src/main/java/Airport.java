// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

import planeModels.ClassificationLevel;
import planeModels.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlaneList() {
        List<PassengerPlane> passengerPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlaneList.add((PassengerPlane) plane);
            }
        }
        return passengerPlaneList;
    }

    public List<MilitaryPlane> getMilitaryPlaneList() {
        List<MilitaryPlane> militaryPlaneList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlaneList.add((MilitaryPlane) plane);
            }
        }
        return militaryPlaneList;
    }

    public List<MilitaryPlane> getTransportMilitaryPlaneList() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane : getMilitaryPlaneList()) {
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlaneList() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        for (MilitaryPlane militaryPlane : getMilitaryPlaneList()) {
            if (militaryPlane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlaneList() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlaneList = getPassengerPlaneList();
        return Collections.max(passengerPlaneList,
                Comparator.comparing(PassengerPlane::getPassengersCapacity));
    }

    public Airport sortPlaneListByMaxFlightDistance() {
        planes.sort(Comparator.comparing(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortPlaneListByMaxSpeed() {
        planes.sort(Comparator.comparing(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortPlaneListByMaxLoadCapacity() {
        planes.sort(Comparator.comparing(Plane::getMaxLoadCapacity));
        return this;
    }

    public boolean checkIfPlainsFromListAreOfCertainClassificationLevel(List<ExperimentalPlane> list, ClassificationLevel classificationLevel) {
        boolean listContainsPlainsOfCertainClassificationLevel = false;
        for (ExperimentalPlane experimentalPlane : list) {
            if (experimentalPlane.getClassificationLevel().equals(classificationLevel)) {
                listContainsPlainsOfCertainClassificationLevel = true;
                break;
            }
        }
        return listContainsPlainsOfCertainClassificationLevel;
    }

    public boolean checkIfPlainsFromListAreOfCertainMilitaryType(List<MilitaryPlane> list,
                                                                 MilitaryType militaryType) {
        boolean listContainsPlainsOfCertainMilitaryType = false;
        for (MilitaryPlane militaryPlane : list) {
            if (militaryPlane.getType().equals(militaryType)) {
                listContainsPlainsOfCertainMilitaryType = true;
                break;
            }
        }
        return listContainsPlainsOfCertainMilitaryType;
    }

    public boolean checkThatListWasSortedCorrectlyByMaxLoadCapacity(List<? extends Plane> list) {
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < list.size() - 1; i++) {
            Plane currentPlane = list.get(i);
            Plane nextPlane = list.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
    }

    @Override
    public String toString() {
        return "Airport{" + "Planes=" + planes.toString() + "}";
    }
}
