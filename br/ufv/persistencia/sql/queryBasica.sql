INSERT INTO funcionario(idFuncionario, matricula, nome, cpf, telefone, dtNasc, senha,
salario, dtContratado, situacao, cargo, sexo, foto) VALUES (-1,1,'admin','1','1','2000-1-1','admin', 2000, '2000-1-1',
'TRABALHANDO','GERENTE', 'M', 'C:\\Users\\Lázaro\\Desktop\\Lázaro\\UFV\\PER-2\\POO\\Projetos\\ProjetoFinalPOO\\src\\imagens\\unknown.png');

DESCRIBE Funcionario;

select  *, date_format(dtNasc, "%d/%m/%Y") AS 'dtNasc' from funcionario;
DELETE from funcionario WHERE idFuncionario = 20;

SELECT idCliente, nome, cpf, date_format(dtNasc, '%d/%m/%Y') AS 'dtNasc', telefone FROM cliente;

select * from produto;

DROP DATABASE projetofinalpoo;