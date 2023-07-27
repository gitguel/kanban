package br.com.credisfera.kanban.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskPriority {
	HIGH("Alta"),
	MEDIUM("Média"),
	LOW("Baixa");
	
	@Getter
	private String priority;
}
