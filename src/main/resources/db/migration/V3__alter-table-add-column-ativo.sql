alter table `MEDICO_TB` add column ativo tinyint;
update `MEDICO_TB` set ativo = 1;
