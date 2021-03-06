package be.technifutur.client.models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class Reservation implements Serializable
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

    public Reservation(LocalDate arrive, LocalDate depart)
    {
        this.ref = UUID.randomUUID();
        this.arrive = arrive;
        this.depart = depart;
        this.status = Status.DEMANDE;
    }

    public Reservation(UUID ref, LocalDate arrive, LocalDate depart)
    {
        this.ref = ref;
        this.arrive = arrive;
        this.depart = depart;
        this.status = Status.DEMANDE;
    }
}
