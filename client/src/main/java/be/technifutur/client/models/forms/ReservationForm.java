package be.technifutur.client.models.forms;

import be.technifutur.client.models.Reservation;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationForm
{
    private LocalDate arrive;
    private LocalDate depart;

    public Reservation toReservation()
    {
        return new Reservation(arrive, depart);
    }
}
