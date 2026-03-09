CREATE OR ALTER TABLE estudante (
    id INT PRIMARY KEY,
    nome VARCHAR(90),
    idade INT,
);
ALTER TABLE estudante
ADD COLUMN sexo CHAR(1);
ALTER TABLE estudante
ADD CONSTRAINT sexo CHECK(sexo in ('M', 'F'));
ALTER TABLE estudante 
ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY;


select * from estudante;