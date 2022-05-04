package be.technifutur.facture.services;

import be.technifutur.facture.models.Facture;
import be.technifutur.facture.rabbit.FactureSender;

import java.util.List;
import java.util.UUID;

public class FactureServiceImpl extends FactureService
{
    @Override
    public void createFacture(int nbNuit, UUID reservRef)
    {
        factures.add(new Facture(50*nbNuit, reservRef));
        FactureSender.sendFactureToClient(reservRef);
    }

    @Override
    public List<Facture> getFactures()
    {
        return factures;
    }
}
