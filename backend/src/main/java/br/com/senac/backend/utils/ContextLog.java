package br.com.senac.backend.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContextLog {

    private String classe;
    private String metodo;
}
