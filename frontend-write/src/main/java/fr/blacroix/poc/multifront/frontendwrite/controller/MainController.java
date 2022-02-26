package fr.blacroix.poc.multifront.frontendwrite.controller;

import fr.blacroix.poc.multifront.frontendwrite.dto.Stock;
import fr.blacroix.poc.multifront.frontendwrite.service.BackConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final BackConsumer backConsumer;

    @GetMapping(value = "/")
    public String getForm(Model m, @RequestParam(required = false) String result) {
        m.addAttribute("stock", new Stock());
        if ("delete-success".equals(result)) {
            m.addAttribute("result", "Deletion Success");
        } else if ("delete-error".equals(result)) {
            m.addAttribute("result", "<b>Deletion Error</b>");
        } else if ("add-success".equals(result)) {
            m.addAttribute("result", "Adding Success");
        } else if ("add-error".equals(result)) {
            m.addAttribute("result", "<b>Adding Error</b>");
        } else {
            m.addAttribute("result", "");
        }
        return "index";
    }

    @PostMapping("/add")
    public String addForm(final Stock stock) {
        log.info("Call for adding item: {}", stock);
        String result = backConsumer.addStock(stock);
        return "redirect:/?result=add-" + result;
    }

    @PostMapping("/delete")
    public String deleteForm(final Stock stock) {
        log.info("Call for deleting item with id: {}", stock.getId());
        String result = backConsumer.deleteStock(stock.getId());
        return "redirect:/?result=delete-" + result;
    }

}
