package ch.avendia.petcare.entities;

/**
 * Created by Markus on 01.04.2015.
 */
public class Reservation extends BaseTenant{

    private Client client;
    private Pet[] pets;
    private ServiceReservation[] serviceReservations;
    private ReservationStatus reservationStatus;
}
