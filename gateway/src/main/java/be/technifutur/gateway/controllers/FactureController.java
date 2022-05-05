package be.technifutur.gateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/facture")
public class FactureController
{
    private final RestTemplate template;

    public FactureController(RestTemplate template)
    {
        this.template = template;
    }

    @GetMapping
    public Object getFactures()
    {
        return template.getForObject("http://localhost:8082/facture", Object.class);
    }
}
