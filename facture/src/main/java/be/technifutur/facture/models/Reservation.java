package be.technifutur.facture.models;

import be.technifutur.facture.rabbit.FactureListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Reservation implements Serializable
{
    private UUID ref;
    private LocalDate arrive;
    private LocalDate depart;
    private Status status;
    private double prix;

    public static enum Status
    {
        DEMANDE,
        FACTURE
    }
}