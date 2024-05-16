package org.motorsportstatswebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testeController {

    @GetMapping("/minhaPagina")
    public String minhaPagina(Model model) {
        // Adicione quaisquer dados que você deseja passar para a página
        model.addAttribute("dynamicValue", "Este valor é dinâmico!");
        return "index"; // O nome do arquivo HTML sem a extensão


    }
}
