package be.technifutur.client.models.dtos;

import be.technifutur.client.models.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ReservationDTO implements Serializable
{
    private UUID ref;
    private LocalDate arrive;
    private LocalDate depart;
    private FactureDTO facture;

    public static ReservationDTO of(Reservation reservation, double prix)
    {
        return new ReservationDTO(
                reservation.getRef(),
                reservation.getArrive(),
                reservation.getDepart(),
                new FactureDTO(prix)
                );
    }

    @Data
    @AllArgsConstructor
    public static class FactureDTO
    {
        private double prix;
    }
}
