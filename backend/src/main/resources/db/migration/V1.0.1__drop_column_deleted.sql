--
-- SCRIPT DE ALTEREAÇÃO DA TABELA TB_TASK
--
alter table tb_task
	drop column deleted,
	drop column deleted_at;