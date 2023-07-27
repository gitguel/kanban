package br.com.credisfera.kanban.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.credisfera.kanban.model.Task;

public interface TaskRespository extends JpaRepository<Task, UUID> {

}
