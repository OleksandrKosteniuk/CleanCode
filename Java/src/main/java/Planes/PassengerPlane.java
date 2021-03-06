package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

    //=================FIELDS=================
    private final int passengersCapacity;

    //=================CONSTRUCTORS=================
    public PassengerPlane(String model, int maximumSpeed, int maximumFlightDistance, int maximumLoadCapacity, int passengersCapacity) {
        super(model, maximumSpeed, maximumFlightDistance, maximumLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    //=================METHODS=================
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
