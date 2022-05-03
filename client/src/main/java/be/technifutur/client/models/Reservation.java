package be.technifutur.client.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Reservation
{
    private UUID ref;
    private LocalDate arrive;
    private LocalDate depart;
    private Status status;

    public static enum Status
    {
        DEMANDE,
        FACTURE
    }
}
