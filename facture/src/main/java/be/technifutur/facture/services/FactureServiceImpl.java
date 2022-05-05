package be.technifutur.facture.services;

import be.technifutur.facture.models.Facture;
import be.technifutur.facture.rabbit.FactureSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class FactureServiceImpl extends FactureService
{
    private final Logger logger = LoggerFactory.getLogger(FactureServiceImpl.class);
    private static FactureServiceImpl _INSTANCE;

    public static FactureServiceImpl getInstance()
    {
        if(_INSTANCE == null)
            _INSTANCE = new FactureServiceImpl();

        return _INSTANCE;
    }

    @Override
    public void createFacture(int nbNuits, UUID reservRef) throws JsonProcessingException
    {
        Facture f = new Facture(50*nbNuits, reservRef);
        factures.add(f);
        FactureSender.sendFactureToClient(f);
        logger.info("FACTURE : "+f);
    }

    @Override
    public List<Facture> getFactures()
    {
        return factures;
    }
}
