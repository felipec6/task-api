package br.com.tarefa.api.entity.enuns;

import br.com.tarefa.api.exceptions.BusinessException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum TaskStatusEnum {
    OPEN("Aberto"),
    COMPLETED("Completo"),
    IN_PROGRESS("Em progresso"),
    CANCELED("Cancelado");

    private final String label;

    TaskStatusEnum(String label) {
        this.label = label;
    }

    public static TaskStatusEnum fromLabel(String label) {
        for (TaskStatusEnum status : TaskStatusEnum.values()) {
            if (status.getLabel().equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new BusinessException("No enum constant with label " + label);
    }

    public static List<String> getLabels() {
        return Arrays.stream(TaskStatusEnum.values())
                .map(TaskStatusEnum::getLabel)
                .toList();
    }
}
