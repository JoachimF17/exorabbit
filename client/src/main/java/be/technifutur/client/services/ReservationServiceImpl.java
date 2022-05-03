package be.technifutur.client.services;

import be.technifutur.client.models.Reservation;

import java.util.List;
import java.util.UUID;

public class ReservationServiceImpl extends ReservationService
{
    @Override
    public void create(Reservation reservation)
    {

    }

    @Override
    public void setToFacture(UUID ref)
    {
        list.stream().filter((r) -> r.getRef() == ref).findFirst(); //TODO: demain
    }

    @Override
    public List<Reservation> getReservFactures()
    {
        return null;
    }
}
