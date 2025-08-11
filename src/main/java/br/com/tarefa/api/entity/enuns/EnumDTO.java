package br.com.tarefa.api.entity.enuns;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnumDTO {
    private String code;
    private String label;
}
