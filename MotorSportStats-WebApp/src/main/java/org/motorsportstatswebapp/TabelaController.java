package org.motorsportstatswebapp;

import org.motorsportstats.services.Implementations.PilotoRepositoryImp;
import org.motorsportstatscore.entity.Piloto;
import org.motorsportstatscore.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TabelaController
{
    @Autowired
    private PilotoRepositoryImp pilotoRepository;


    @GetMapping("/TabelaPilotos")
    public String TabelaPilotos(Model model)
    {
        List<Piloto> Pilotos = pilotoRepository.listar();
        model.addAttribute("Pilotos", Pilotos);
        return "Tabela";
    }
}
