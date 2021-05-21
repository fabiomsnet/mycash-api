package org.bootcamp.spring.mycashapi.web.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiError {

    private HttpStatus status;
    private LocalDateTime dataHora;
    private String mensagem;
    private List<String> subErros;

    public ApiError(HttpStatus status) {
        this.status = status;
        this.dataHora = LocalDateTime.now();
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        this.subErros = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
    }
}
