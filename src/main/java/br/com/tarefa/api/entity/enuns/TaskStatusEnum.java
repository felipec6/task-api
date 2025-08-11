package br.com.tarefa.api.entity.enuns;

import br.com.tarefa.api.exceptions.BusinessException;
import lombok.Getter;

@Getter
public enum TaskStatusEnum {
    OPEN("Open"),
    COMPLETED("Completed"),
    IN_PROGRESS("In Progress"),
    CANCELED("Canceled");

    private final String label;

    TaskStatusEnum(String label) {
        this.label = label;
    }

    public static TaskStatusEnum fromName(String name) {
        for (TaskStatusEnum status : TaskStatusEnum.values()) {
            if (status.name().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new BusinessException("No enum constant with name " + name);
    }
}
