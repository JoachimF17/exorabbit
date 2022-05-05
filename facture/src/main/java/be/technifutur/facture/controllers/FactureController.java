package be.technifutur.facture.controllers;

import be.technifutur.facture.models.Facture;
import be.technifutur.facture.services.FactureServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/facture")
public class FactureController
{
    private final FactureServiceImpl fsi = FactureServiceImpl.getInstance();

    @GetMapping
    public List<Facture> getFactures()
    {
        return fsi.getFactures();
    }

    @GetMapping("/{ref}")
    public double getFactureByRef(@PathVariable UUID ref)
    {
        return fsi.getPrixParReference(ref);
    }
}
