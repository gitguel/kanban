package br.com.credisfera.kanban.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_task")
public class Task {

	@Id
	@Getter
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	@Getter
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Getter
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Getter
	@Column(name = "concluded_at")
	private LocalDateTime concludedAt;

	@Getter
	@Setter
	@Column(name = "title")
	private String title;

	@Getter
	@Setter
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Getter
	@Setter
	@Column(name = "version")
	private String version;
	
	@Getter
	@Setter
	@Column(name = "task_order")
	private Integer order;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TaskStatus status;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "prioridade")
	private TaskPriority priority;

	@PrePersist
	@PreUpdate
	private void prePersist() {
		if (TaskStatus.DONE.equals(status)) {
			concludedAt = LocalDateTime.now();
		}
	}
}
