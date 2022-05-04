package be.technifutur.client.services;

import be.technifutur.client.models.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class ReservationService
{
    protected List<Reservation> list = new ArrayList<>();

    public abstract void create(Reservation reservation);

    public abstract void setToFacture(UUID ref);

    public abstract List<Reservation> getReservFactures();
}
