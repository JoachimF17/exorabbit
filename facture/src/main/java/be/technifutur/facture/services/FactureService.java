package be.technifutur.facture.services;

import be.technifutur.facture.models.Facture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class FactureService
{
    private List<Facture> factures = new ArrayList<>();

    public abstract void createFacture(int nbrNuit, UUID reserv_ref);

    public abstract List<Facture> getFactures();
}