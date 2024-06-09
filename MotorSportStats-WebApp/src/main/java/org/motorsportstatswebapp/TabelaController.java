package org.motorsportstatswebapp;

import org.motorsportstatscore.entity.Piloto;
import org.motorsportstatscore.repository.PilotoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TabelaController
{
    @GetMapping("/TabelaPilotos")
    public String TabelaPilotos(Model model)
    {
        List<Piloto> Pilotos = PilotoRepository.listar();
        model.addAttribute("Pilotos", Pilotos);
        return "Tabela";
    }
}
