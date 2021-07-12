import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import Planes.experimentalPlane;
import models.MilitaryType;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private final List<? extends Plane> listOfPlanes;

    public List<PassengerPlane> getListOfPassengerPlanes() {
        List<? extends Plane> listOfExtendedPlanes = this.listOfPlanes;
        List<PassengerPlane> listOfPassengerPlanes = new ArrayList<>();
        for (Plane plane : listOfExtendedPlanes) {
            if (plane instanceof PassengerPlane) {
                listOfPassengerPlanes.add((PassengerPlane) plane);
            }
        }
        return listOfPassengerPlanes;
    }

    public List<MilitaryPlane> getListOfMilitaryPlanes() {
        List<MilitaryPlane> listOfMilitaryPlanes = new ArrayList<>();
        for (Plane plane : listOfPlanes) {
            if (plane instanceof MilitaryPlane) {
                listOfMilitaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return listOfMilitaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaximumPassengersCapacity() {
        List<PassengerPlane> listOfPassengerPlanes = getListOfPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = listOfPassengerPlanes.get(0);
        for (PassengerPlane passengerPlane : listOfPassengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getListOfTransportMilitaryPlanes() {
        List<MilitaryPlane> listOfTransportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> listOfMilitaryPlanes = getListOfMilitaryPlanes();
        for (MilitaryPlane plane : listOfMilitaryPlanes) {
            if (plane.getType() == MilitaryType.TRANSPORT) {
                listOfTransportMilitaryPlanes.add(plane);
            }
        }
        return listOfTransportMilitaryPlanes;
    }

    public List<MilitaryPlane> getListOfBomberMilitaryPlanes() {
        List<MilitaryPlane> listOfbomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> listOfMilitaryPlanes = getListOfMilitaryPlanes();
        for (MilitaryPlane plane : listOfMilitaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                listOfbomberMilitaryPlanes.add(plane);
            }
        }
        return listOfbomberMilitaryPlanes;

    }

    public List<experimentalPlane> getListOfExperimentalPlanes() {
        List<experimentalPlane> listOfExperimentalPlanes = new ArrayList<>();
        for (Plane plane : listOfPlanes) {
            if (plane instanceof experimentalPlane) {
                listOfExperimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return listOfExperimentalPlanes;
    }

    public Airport sortPlanesByMaxDistance() {
        Collections.sort(listOfPlanes, (Comparator<Plane>) (currentPlane, nextPlane) -> currentPlane.getMaximumFlightDistance() - nextPlane.getMaximumFlightDistance());
        return this;
    }


    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaximumSpeed() {
        Collections.sort(listOfPlanes, (Comparator<Plane>) (currentPlane, nextPlane) -> currentPlane.getMaximumSpeed() - nextPlane.getMaximumSpeed());
        return this;
    }

    public Airport sortBymaximumLoadCapacity() {
        listOfPlanes.sort((Comparator<Plane>) (currentPlane, nextPlane) -> currentPlane.getMaximumLoadCapacity() - nextPlane.getMaximumLoadCapacity());
        return this;
    }

    public List<? extends Plane> getListOfPlanes() {
        return listOfPlanes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + listOfPlanes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.listOfPlanes = planes;
    }

}
