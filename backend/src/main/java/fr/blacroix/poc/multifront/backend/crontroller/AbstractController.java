package fr.blacroix.poc.multifront.backend.crontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public abstract class AbstractController {

    @ExceptionHandler
    protected ResponseEntity<String> handleException(Exception t) {
        log.error("Exception handled:", t);
        return new ResponseEntity<>(t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}