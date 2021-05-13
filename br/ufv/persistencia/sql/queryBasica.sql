INSERT INTO funcionario(idFuncionario, matricula, nome, cpf, telefone, dtNasc, senha,
salario, dtContratado, situacao, cargo, sexo, foto) VALUES (0,1,'admin','1','1','2000-1-1','admin', 2000, '2000-1-1',
'TRABALHANDO','GERENTE', 'M', 'C:\\Users\\Lázaro\\Desktop\\Lázaro\\UFV\\PER-2\\POO\\Projetos\\ProjetoFinalPOO\\src\\imagens\\unknown.png');

DESCRIBE Funcionario;
select * from funcionario;

select  *, date_format(dtNasc, "%d/%m/%Y") AS 'dtNasc' from funcionario;
DELETE from funcionario WHERE idFuncionario = 20;

SELECT idCliente, nome, cpf, date_format(dtNasc, '%d/%m/%Y') AS 'dtNasc', telefone FROM cliente;
select * from venda;

SELECT MAX(idVenda)+1 AS 'idVenda' from venda;

SELECT * FROM produto_has_venda NATURAL JOIN produto NATURAL JOIN venda;
DESCRIBE produto;
select * from produto_has_venda;
delete from venda where idVenda = 1;

select * from produto;
select * from acessosistema;
delete from funcionario where idFuncionario = -1;
delete from acessosistema where idAcessoSistema = 2;

select idAcessoSistema, dtAcesso, hrAcesso, hrSaida, nome from acessosistema NATURAL JOIN funcionario;
UPDATE acessosistema SET hrSaida = '13:31:09' WHERE idAcessoSistema =(Select MAX(idAcessoSistema) from acessosistema);

INSERT INTO acessosistema(dtAcesso, hrAcesso, hrSaida, idFuncionario) VALUES('2021-02-15','10:30:08','10:30:08',1);

DROP DATABASE projetofinalpoo;