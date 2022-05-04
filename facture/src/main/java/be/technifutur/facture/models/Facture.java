package be.technifutur.facture.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture
{
    private double prix;
    private UUID reservRef;
}
