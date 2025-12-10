INSERT INTO programadores (nome, email, telefone, competencias, nivel, resumo, senha) VALUES
('João Silva', 'joao@email.com', '11999990001', 'Java, Spring Boot, MySQL, Docker', 'SENIOR', 'Desenvolvedor com 8 anos de experiência em sistemas corporativos', '123456'),
('Maria Costa', 'maria@email.com', '11999990002', 'JavaScript, React, Node.js, MongoDB', 'PLENO', 'Desenvolvedora fullstack focada em aplicações web modernas', '123456'),
('Pedro Santos', 'pedro@email.com', '11999990003', 'Python, Django, PostgreSQL', 'JUNIOR', 'Recém formado com projetos acadêmicos em Python', '123456');

INSERT INTO contratantes (nome, email, empresa, cnpj, senha) VALUES
('Carlos Oliveira', 'carlos@email.com', 'Tech Corp', '12.345.678/0001-90', '123456'),
('Ana Rodrigues', 'ana@email.com', 'Digital Solutions', '98.765.432/0001-10', '123456');

INSERT INTO vagas (titulo, descricao, requisitos, salario, localizacao, modalidade, nivel_exigido, contratante_id) VALUES
('Desenvolvedor Java Senior', 'Buscamos desenvolvedor Java para atuar em projetos de grande porte utilizando Spring Boot e microsserviços.', 'Java 11+, Spring Boot, JPA, REST APIs, Docker', 12000.00, 'São Paulo - SP', 'Presencial', 'SENIOR', 1),
('Desenvolvedor Frontend React', 'Vaga para desenvolvedor frontend com foco em React e aplicações SPA.', 'React, TypeScript, CSS, Git', 7000.00, 'Remoto', 'Remoto', 'PLENO', 2),
('Fullstack Developer', 'Desenvolvedor fullstack para startup em crescimento.', 'Node.js, React, MongoDB, AWS', 9000.00, 'Rio de Janeiro - RJ', 'Hibrido', 'PLENO', 1),
('Desenvolvedor Python Junior', 'Oportunidade para desenvolvedor iniciante com vontade de aprender.', 'Python, SQL básico, Lógica de programação', 4000.00, 'Curitiba - PR', 'Remoto', 'JUNIOR', 2);

INSERT INTO competencias (nome, nivel, programador_id) VALUES
('Java', 'AVANCADO', 1),
('Spring Boot', 'AVANCADO', 1),
('MySQL', 'INTERMEDIARIO', 1),
('Docker', 'INTERMEDIARIO', 1),
('JavaScript', 'AVANCADO', 2),
('React', 'AVANCADO', 2),
('Node.js', 'INTERMEDIARIO', 2),
('MongoDB', 'BASICO', 2),
('Python', 'INTERMEDIARIO', 3),
('Django', 'BASICO', 3),
('PostgreSQL', 'BASICO', 3);

INSERT INTO experiencias (empresa, cargo, periodo, descricao, programador_id) VALUES
('Tech Solutions', 'Desenvolvedor Java Senior', '2020 - Atual', 'Desenvolvimento de sistemas corporativos com Spring Boot', 1),
('Startup XYZ', 'Desenvolvedor Java Pleno', '2017 - 2020', 'Criação de APIs REST e integração com sistemas legados', 1),
('Web Agency', 'Desenvolvedora Frontend', '2021 - Atual', 'Desenvolvimento de SPAs com React e TypeScript', 2),
('Freelancer', 'Desenvolvedora Web', '2019 - 2021', 'Projetos diversos com JavaScript e Node.js', 2),
('Universidade', 'Estagiário', '2023 - 2024', 'Projeto de iniciação científica em Python', 3);
