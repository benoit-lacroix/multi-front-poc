package fr.blacroix.poc.multifront.frontendread.controller;

import fr.blacroix.poc.multifront.frontendread.dto.Stock;
import fr.blacroix.poc.multifront.frontendread.service.BackConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final BackConsumer backConsumer;

    @RequestMapping("/")
    public String root() {
        return "redirect:/read";
    }

    @GetMapping("/read")
    public String getForm(Model m, Authentication authentication) {
        log.info("Authentication: {}", authentication.getName());
        List<Stock> list = backConsumer.getStock();
        m.addAttribute("stockList", list);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/read";
    }

}
