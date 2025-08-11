package br.com.tarefa.api.service;

import br.com.tarefa.api.entity.Project;

public interface ProjectService {
    Project findById(Long id);
}
