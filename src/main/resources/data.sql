INSERT INTO programadores (nome, email, telefone, competencias, nivel, resumo) VALUES
('João Silva', 'joao.silva@email.com', '11999990001', 'Java, Spring Boot, MySQL, Docker', 'SENIOR', 'Desenvolvedor com 8 anos de experiência em sistemas corporativos'),
('Maria Costa', 'maria.costa@email.com', '11999990002', 'JavaScript, React, Node.js, MongoDB', 'PLENO', 'Desenvolvedora fullstack focada em aplicações web modernas'),
('Pedro Santos', 'pedro.santos@email.com', '11999990003', 'Python, Django, PostgreSQL', 'JUNIOR', 'Recém formado com projetos acadêmicos em Python');

INSERT INTO contratantes (nome, email, empresa, cnpj) VALUES
('Carlos Oliveira', 'carlos@techcorp.com', 'Tech Corp', '12.345.678/0001-90'),
('Ana Rodrigues', 'ana@digitalsolutions.com', 'Digital Solutions', '98.765.432/0001-10');

INSERT INTO vagas (titulo, descricao, requisitos, salario, localizacao, contratante_id) VALUES
('Desenvolvedor Java Senior', 'Buscamos desenvolvedor Java para atuar em projetos de grande porte utilizando Spring Boot e microsserviços.', 'Java 11+, Spring Boot, JPA, REST APIs, Docker', 12000.00, 'São Paulo - SP', 1),
('Desenvolvedor Frontend React', 'Vaga para desenvolvedor frontend com foco em React e aplicações SPA.', 'React, TypeScript, CSS, Git', 7000.00, 'Remoto', 2),
('Fullstack Developer', 'Desenvolvedor fullstack para startup em crescimento.', 'Node.js, React, MongoDB, AWS', 9000.00, 'Rio de Janeiro - RJ', 1),
('Desenvolvedor Python Junior', 'Oportunidade para desenvolvedor iniciante com vontade de aprender.', 'Python, SQL básico, Lógica de programação', 4000.00, 'Curitiba - PR', 2);
