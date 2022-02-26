package fr.blacroix.poc.multifront.frontendread.controller;

import fr.blacroix.poc.multifront.frontendread.dto.Stock;
import fr.blacroix.poc.multifront.frontendread.service.BackConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BackConsumer backConsumer;

    @GetMapping("/")
    public String getForm(Model m) {
        List<Stock> list = backConsumer.getStock();
        m.addAttribute("stockList", list);
        return "index";
    }

}
