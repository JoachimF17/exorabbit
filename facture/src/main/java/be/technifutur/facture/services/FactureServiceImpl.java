package be.technifutur.facture.services;

import be.technifutur.facture.models.Facture;
import be.technifutur.facture.rabbit.FactureSender;

import java.util.List;
import java.util.UUID;

public class FactureServiceImpl extends FactureService
{
    private static FactureServiceImpl _INSTANCE;

    public static FactureServiceImpl getInstance()
    {
        if(_INSTANCE == null)
            _INSTANCE = new FactureServiceImpl();

        return _INSTANCE;
    }

    @Override
    public void createFacture(int nbNuits, UUID reservRef)
    {
        factures.add(new Facture(50*nbNuits, reservRef));
        FactureSender.sendFactureToClient(reservRef);
    }

    @Override
    public List<Facture> getFactures()
    {
        return factures;
    }
}
