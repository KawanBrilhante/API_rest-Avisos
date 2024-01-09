package br.tc.tceac.administracao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvisosNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AvisosNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String avisosNotFoundHandler(AvisosNotFoundException ex) {
        return ex.getMessage();
    }

}
