package br.com.credisfera.kanban.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.credisfera.kanban.model.Task;
import br.com.credisfera.kanban.repository.TaskRespository;

@Service
public class TaskService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private TaskRespository taskRepository;

	public List<Task> findAllFilter() {
		Session session = entityManager.unwrap(Session.class);
		List<Task> tasks = taskRepository.findAll(Sort.by(Sort.Direction.ASC, "order"));

		return tasks;
	}

	public List<Task> findAll() {
		return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "order"));
	}

	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	@Transactional
	public void saveAll(List<Task> tasks) {
		for (int i = 0; i < tasks.size(); i++) {
			tasks.get(i).setOrder(i+1);
			save(tasks.get(i));
		}
	}

	public Optional<Task> findById(UUID id) {
		return taskRepository.findById(id);
	}

	public void delete(UUID id) {
		taskRepository.deleteById(id);
	}
}
