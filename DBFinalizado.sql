-- Criação do Banco de Dados
CREATE DATABASE BancoModelo;
GO

USE BancoModelo;
GO

-- Criação da tabela Usuario
CREATE TABLE Usuario (
    Usuario_id INT PRIMARY KEY IDENTITY(1,1),
    Nome VARCHAR(100) NOT NULL,
    CPF CHAR(11) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Telefone VARCHAR(11),
    Endereco VARCHAR(200),
    CEP CHAR(8),
    Bairro VARCHAR(50),
    Cidade VARCHAR(50),
    Numero VARCHAR(10),
	Senha VARCHAR(50) NOT NULL,
	role VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER',
	enabled BIT NOT NULL

);
 
-- Criação da tabela Admin
CREATE TABLE Admin (
    Admin_id INT PRIMARY KEY IDENTITY(1,1),
    Criacao DATETIME NOT NULL,
    Edicao DATETIME,
    Usuario_id INT NOT NULL,
    FOREIGN KEY (Usuario_id) REFERENCES Usuario(Usuario_id)
);

-- Criação da tabela Conta
CREATE TABLE Conta (
    Conta_id INT PRIMARY KEY IDENTITY(1,1),
    Agencia VARCHAR(10) NOT NULL,
    Numero_Conta VARCHAR(20) NOT NULL,
    Senha VARCHAR(50) NOT NULL,
    Usuario_id INT NOT NULL,
    FOREIGN KEY (Usuario_id) REFERENCES Usuario(Usuario_id)
);
 
-- Criação da tabela Saldo
CREATE TABLE Saldo (
    Saldo_id INT PRIMARY KEY IDENTITY(1,1),
    Visualizacao DECIMAL(18,2) NOT NULL,
    Conta_id INT NOT NULL,
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id)
);
 
-- Criação da tabela Transacoes
CREATE TABLE Transacoes (
    Transacoes_id INT PRIMARY KEY IDENTITY(1,1),
    Pix_id INT,
    Pagamento_id INT,
    Deposito_id INT,
    Extrato_id INT,
	Transferencia_id INT,
    Saque_id INT,
    Conta_id INT NOT NULL,
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id)
);
 
-- Criação da tabela Extrato
CREATE TABLE Extrato (
    Extrato_id INT PRIMARY KEY IDENTITY(1,1),
    Data DATETIME NOT NULL,
    Entrada DECIMAL(18,2),
    Saida DECIMAL(18,2),
    Transacoes_id INT,
	FOREIGN KEY (Transacoes_id) REFERENCES Transacoes(Transacoes_id)
);
 
 
-- Criação da tabela Pix
CREATE TABLE Pix (
    Pix_id INT PRIMARY KEY IDENTITY(1,1),
    Entrada DECIMAL(18,2),
    Saida DECIMAL(18,2),
    Saldo_id INT NOT NULL,
    Conta_id INT NOT NULL,
	Usuario_id INT NOT NULL,
    FOREIGN KEY (Saldo_id) REFERENCES Saldo(Saldo_id),
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id),
	FOREIGN KEY (Usuario_id) REFERENCES Usuario(Usuario_id)
);
 
-- Criação da tabela Pagamento
CREATE TABLE Pagamento (
    Pagamento_id INT PRIMARY KEY IDENTITY(1,1),
    Entrada DECIMAL(18,2),
    Saida DECIMAL(18,2),
    Saldo_id INT NOT NULL,
    Conta_id INT NOT NULL,
	Usuario_id INT NOT NULL,
    FOREIGN KEY (Saldo_id) REFERENCES Saldo(Saldo_id),
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id),
	FOREIGN KEY (Usuario_id) REFERENCES Usuario(Usuario_id)
);
 
-- Criação da tabela Deposito
CREATE TABLE Deposito (
    Deposito_id INT PRIMARY KEY IDENTITY(1,1),
    Entrada DECIMAL(18,2),
    Saida DECIMAL(18,2),
    Saldo_id INT NOT NULL,
    Conta_id INT NOT NULL,
	Usuario_id INT NOT NULL,
    FOREIGN KEY (Saldo_id) REFERENCES Saldo(Saldo_id),
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id),
	FOREIGN KEY (Usuario_id) REFERENCES Usuario(Usuario_id)
);

-- Criação da Tabela Transferencia
CREATE TABLE Transferencia (
    Transferencia_id INT PRIMARY KEY IDENTITY(1,1),
    Entrada DECIMAL(18,2),
    Saida DECIMAL(18,2),
    Saldo_id INT NOT NULL,
    Conta_id INT NOT NULL,
	Usuario_id INT NOT NULL,
    FOREIGN KEY (Saldo_id) REFERENCES Saldo(Saldo_id),
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id),
	FOREIGN KEY (Usuario_id) REFERENCES Usuario(Usuario_id)
);
 
-- Criação da tabela Saque
CREATE TABLE Saque (
    Saque_id INT PRIMARY KEY IDENTITY(1,1),
    Entrada DECIMAL(18,2),
    Saida DECIMAL(18,2),
    Saldo_id INT NOT NULL,
    Conta_id INT NOT NULL,
    FOREIGN KEY (Saldo_id) REFERENCES Saldo(Saldo_id),
    FOREIGN KEY (Conta_id) REFERENCES Conta(Conta_id)
);

-- Tabela para Join relacionando Transacoes_Conta
CREATE TABLE Transacoes_Conta
(Transacao_Id INT NOT NULL, -- fk de transacoes
 Contas_Id INT NOT NULL, -- fk de conta
 PRIMARY KEY (Transacao_Id, Contas_Id), -- pk composta 
 FOREIGN KEY (Transacao_Id)
	REFERENCES Transacoes(Transacoes_Id),
 FOREIGN KEY (Contas_Id)
	REFERENCES Conta(Conta_Id),

);



-- Inserção de usuários
INSERT INTO Usuario (Nome, CPF, Email, Telefone, Endereco, CEP, Bairro, Cidade, Numero, Senha, enabled)
VALUES
('João Silva', '12345678901', 'joao@email.com', '11999999999', 'Rua A, 123', '01001000', 'Centro', 'São Paulo', '123', 'senha123', 1),
('Maria Oliveira', '23456789012', 'maria@email.com', '11988888888', 'Rua B, 456', '02002000', 'Bela Vista', 'São Paulo', '456', 'senha234', 1),
('Pedro Santos', '34567890123', 'pedro@email.com', '11977777777', 'Rua C, 789', '03003000', 'Liberdade', 'São Paulo', '789', 'senha345', 1),
('Lorena', '45678901234', 'lorena@email.com', '11966666666', 'Rua D, 101', '04004000', 'Vila Mariana', 'São Paulo', '101', 'senha456', 1),
('Cinthia Souza', '56789012345', 'cinthia@email.com', '11955555555', 'Rua E, 202', '05005000', 'Pinheiros', 'São Paulo', '202', 'senha567', 1), 
('Amanda Pereirra', '67890123456', 'amanda@email.com', '11944444444', 'Rua F, 303', '06006000', 'Moema', 'São Paulo', '303', 'senha678', 1);

-- Inserção de contas
INSERT INTO Conta (Agencia, Numero_Conta, Senha, Usuario_id)
VALUES
('0001', '123456-7', 'senha123', 2),
('0002', '234567-8', 'senha234', 3),
('0003', '345678-9', 'senha345', 4),
('0004', '456789-0', 'senha456', 5),
('0005', '567890-1', 'senha567', 6),
('0006', '678901-2', 'senha678', 7);

SELECT * FROM Conta;

SELECT * FROM Usuario;

-- Relação entre as tabelas Conta e Usuario
SELECT 
    c.Conta_id,
    c.Agencia,
    c.Numero_Conta,
	c.Senha,
    u.Nome,
    u.Email,
    u.Telefone
FROM 
    Conta c
INNER JOIN 
    Usuario u ON c.Usuario_id = u.Usuario_id;
 
 
-- Saldo relacionado a conta
SELECT 
    s.Saldo_id,
    s.Visualizacao AS Saldo,
    c.Conta_id,
    c.Agencia,
    c.Numero_Conta,
    u.Nome AS Titular
FROM 
    Saldo s
INNER JOIN 
    Conta c ON s.Conta_id = c.Conta_id
INNER JOIN 
    Usuario u ON c.Usuario_id = u.Usuario_id;

	

SELECT c.Usuario_id, c.Conta_id,
	p.Pix_id, 
	p.Entrada, 
	p.Saida
FROM Conta c
	LEFT JOIN Transacoes cp
ON c.Conta_id = cp.Conta_id
	LEFT JOIN Pix p
ON cp.Conta_id = c.Conta_id;

 
 

--Relação de pagamentos, conta ID e Usuario ID
SELECT
	p.Pagamento_id,
	c.Conta_id,
	c.Usuario_id
FROM
	Pagamento p
 
INNER JOIN Conta c ON p.Pagamento_id = c.Conta_id;
 

-- transações relacionada a contas
SELECT 
	t.Transacoes_id,
	t.Pix_id,
	t.Pagamento_id,
	t.Deposito_id,
	t.Saque_id,
	t.Extrato_id,
	c.Conta_id,
	c.Agencia,
	c.Numero_Conta
FROM 
	Conta c
INNER JOIN Transacoes_Conta tc
ON c.Conta_id = tc.Contas_id
INNER JOIN Transacoes t 
ON tc.Transacao_Id = t.Transacoes_id


--transações relacionada a extrato
SELECT 
    t.Transacoes_Id,
    e.Extrato_Id
FROM Transacoes t
INNER JOIN Transacoes_Conta tc
    ON tc.Transacao_Id = t.Transacoes_Id 
INNER JOIN Extrato e
    ON e.Transacoes_id = t.Transacoes_Id;  


-- transações relacionada a depósito
SELECT 
    t.Transacoes_Id,
    d.Deposito_id,
    d.Entrada AS Deposito_Entrada,
    d.Saida AS Deposito_Saida
FROM Transacoes t
INNER JOIN Transacoes_Conta tc
    ON tc.Transacao_Id = t.Transacoes_Id  
INNER JOIN Deposito d
    ON d.Deposito_id = t.Deposito_id; 

-- transações relacionada a transferência
SELECT 
    t.Transacoes_Id,
    tf.Transferencia_id,
    tf.Entrada AS Transferencia_Entrada,
    tf.Saida AS Transferencia_Saida
FROM Transacoes t
INNER JOIN Transacoes_Conta tc
    ON tc.Transacao_Id = t.Transacoes_Id  
INNER JOIN Transferencia tf
   ON tf.Transferencia_id = t.Transferencia_id;



--transações relacionada a saque
SELECT 
    t.Transacoes_Id,
    s.Saque_id,
    s.Entrada AS Saque_Entrada,
    s.Saida AS Saque_Saida
FROM Transacoes t
INNER JOIN Transacoes_Conta tc
    ON tc.Transacao_Id = t.Transacoes_Id 
INNER JOIN Saque s
    ON s.Saque_id = t.Saque_id; 

	select * from usuario

