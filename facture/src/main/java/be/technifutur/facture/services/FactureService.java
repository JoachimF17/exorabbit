package be.technifutur.facture.services;

import be.technifutur.facture.models.Facture;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class FactureService
{
    protected List<Facture> factures = new ArrayList<>();

    public abstract void createFacture(int nbNuits, UUID reservRef) throws JsonProcessingException;

    public abstract List<Facture> getFactures();
}