package be.technifutur.client.services;

import be.technifutur.client.models.Facture;
import be.technifutur.client.models.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class ReservationService
{
    protected List<Reservation> list = new ArrayList<>();

    public abstract void create(Reservation reservation) throws JsonProcessingException;

    public abstract void setToFacture(Facture facture);

    public abstract List<Reservation> getReservFactures();
}
