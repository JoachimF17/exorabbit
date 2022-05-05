package be.technifutur.facture.controllers;

import be.technifutur.facture.models.Facture;
import be.technifutur.facture.services.FactureServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
