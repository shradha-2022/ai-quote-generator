package com.ai.quotegenerator.api.demo;

import com.ai.quotegenerator.api.demo.service.GroqService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class AiController {

    private final GroqService groqService;

    public AiController(GroqService groqService) {
        this.groqService = groqService;
    }

    @GetMapping("/quote")
    public String generateQuote(@RequestParam(defaultValue = "motivational") String theme) {
        String prompt = "Generate one short, inspiring " + theme + " quote with author attribution. " +
                "Format: Quote text - Author Name. Return only the quote and author, nothing else.";
        return groqService.generateQuote(prompt);
    }
}