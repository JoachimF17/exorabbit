package be.technifutur.client.services;

import be.technifutur.client.models.Reservation;
import be.technifutur.client.rabbit.ClientSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class ReservationServiceImpl extends ReservationService
{
    private final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
    private static ReservationServiceImpl _INSTANCE;
    @Override
    public void create(Reservation reservation) throws JsonProcessingException
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
            .filter((r) -> r.getRef().equals(ref))
            .findFirst()
            .ifPresent((r) ->
            {
                r.setStatus(Reservation.Status.FACTURE);
                logger.info("RESERVATION UUID : <"+r.getRef()+"> FACTUREE AVEC SUCCES");
            });
    }

    @Override
    public List<Reservation> getReservFactures()
    {
        return list.stream().filter((r) -> r.getStatus() == Reservation.Status.FACTURE).toList();
    }
}
