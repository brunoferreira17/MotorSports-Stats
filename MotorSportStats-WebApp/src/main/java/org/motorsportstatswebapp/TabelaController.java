/*package org.motorsportstatswebapp;

import org.motorsportstatswebapp.entity.Piloto;
import org.motorsportstatswebapp.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TabelaController
{
    @Autowired
    private PilotoService pilotoRepository;

    @GetMapping("/pilotos")
    public String listarPilotos(Model model) {
        List<Piloto> pilotos = pilotoRepository.findAll();
        model.addAttribute("pilotos", pilotos);
        return "Tabela";
    }

}*/
