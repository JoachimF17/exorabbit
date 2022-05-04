package be.technifutur.client.services;

import be.technifutur.client.models.Reservation;
import be.technifutur.client.rabbit.ClientSender;

import java.util.List;
import java.util.UUID;

public class ReservationServiceImpl extends ReservationService
{
    private static ReservationServiceImpl _INSTANCE;
    @Override
    public void create(Reservation reservation)
    {
        list.add(reservation);
        ClientSender.sendReservToFacture(reservation);
    }

    public static ReservationServiceImpl getInstance()
    {
        if(_INSTANCE == null)
            _INSTANCE = new ReservationServiceImpl();

        return _INSTANCE;
    }

    @Override
    public void setToFacture(UUID ref)
    {
        list.stream()
            .filter((r) -> r.getRef() == ref)
            .findFirst()
            .ifPresent((r) -> r.setStatus(Reservation.Status.FACTURE));
    }

    @Override
    public List<Reservation> getReservFactures()
    {
        return list.stream().filter((r) -> r.getStatus() == Reservation.Status.FACTURE).toList();
    }
}
