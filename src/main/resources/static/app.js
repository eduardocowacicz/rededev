const API_URL = 'http://localhost:8081/api';

let vagaSelecionada = null;

async function carregarVagas() {
    try {
        const response = await fetch(`${API_URL}/vagas`);
        const vagas = await response.json();
        exibirVagas(vagas);
    } catch (error) {
        console.error('Erro ao carregar vagas:', error);
    }
}

function exibirVagas(vagas) {
    const container = document.getElementById('vagas-container');
    if (!container) return;

    container.innerHTML = '';

    vagas.forEach(vaga => {
        const card = document.createElement('div');
        card.className = 'col-md-6 col-lg-4';
        card.innerHTML = `
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">${vaga.titulo}</h5>
                    <p class="text-muted mb-2">${vaga.contratante.empresa}</p>
                    <span class="badge badge-salario mb-2">R$ ${vaga.salario.toLocaleString('pt-BR')}</span>
                    <span class="badge badge-localizacao mb-2">${vaga.localizacao}</span>
                    <p class="card-text mt-3">${vaga.descricao.substring(0, 100)}...</p>
                </div>
                <div class="card-footer bg-white border-0">
                    <button class="btn btn-outline-primary btn-sm me-2" onclick="abrirDetalhes(${vaga.id})">Ver detalhes</button>
                    <button class="btn btn-primary btn-sm" onclick="abrirCandidatura(${vaga.id})">Candidatar-se</button>
                </div>
            </div>
        `;
        container.appendChild(card);
    });
}

async function abrirDetalhes(vagaId) {
    try {
        const response = await fetch(`${API_URL}/vagas/${vagaId}`);
        const vaga = await response.json();

        document.getElementById('modal-titulo').textContent = vaga.titulo;
        document.getElementById('modal-empresa').textContent = vaga.contratante.empresa;
        document.getElementById('modal-localizacao').textContent = vaga.localizacao;
        document.getElementById('modal-salario').textContent = `R$ ${vaga.salario.toLocaleString('pt-BR')}`;
        document.getElementById('modal-descricao').textContent = vaga.descricao;
        document.getElementById('modal-requisitos').textContent = vaga.requisitos;

        vagaSelecionada = vagaId;

        const modal = new bootstrap.Modal(document.getElementById('vagaModal'));
        modal.show();
    } catch (error) {
        console.error('Erro ao carregar detalhes:', error);
    }
}

async function abrirCandidatura(vagaId) {
    vagaSelecionada = vagaId;
    await carregarProgramadores();
    const modal = new bootstrap.Modal(document.getElementById('candidatarModal'));
    modal.show();
}

async function carregarProgramadores() {
    try {
        const response = await fetch(`${API_URL}/programadores`);
        const programadores = await response.json();

        const select = document.getElementById('select-programador');
        select.innerHTML = '<option value="">Selecione...</option>';

        programadores.forEach(prog => {
            const option = document.createElement('option');
            option.value = prog.id;
            option.textContent = `${prog.nome} - ${prog.nivel}`;
            select.appendChild(option);
        });
    } catch (error) {
        console.error('Erro ao carregar programadores:', error);
    }
}

async function confirmarCandidatura() {
    const programadorId = document.getElementById('select-programador').value;

    if (!programadorId) {
        alert('Selecione um programador!');
        return;
    }

    try {
        const response = await fetch(`${API_URL}/candidaturas?programadorId=${programadorId}&vagaId=${vagaSelecionada}`, {
            method: 'POST'
        });

        if (response.ok) {
            alert('Candidatura realizada com sucesso!');
            bootstrap.Modal.getInstance(document.getElementById('candidatarModal')).hide();
        } else {
            alert('Erro ao realizar candidatura.');
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao realizar candidatura.');
    }
}

async function cadastrarProgramador(event) {
    event.preventDefault();

    const programador = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        telefone: document.getElementById('telefone').value,
        competencias: document.getElementById('competencias').value,
        nivel: document.getElementById('nivel').value,
        resumo: document.getElementById('resumo').value
    };

    try {
        const response = await fetch(`${API_URL}/programadores`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(programador)
        });

        if (response.ok) {
            alert('Cadastro realizado com sucesso!');
            window.location.href = 'index.html';
        } else {
            alert('Erro ao cadastrar.');
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao cadastrar.');
    }
}

async function cadastrarContratante(event) {
    event.preventDefault();

    const contratante = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        empresa: document.getElementById('empresa').value,
        cnpj: document.getElementById('cnpj').value
    };

    try {
        const response = await fetch(`${API_URL}/contratantes`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(contratante)
        });

        if (response.ok) {
            const data = await response.json();
            alert(`Cadastro realizado! Seu ID é: ${data.id}`);
            window.location.href = 'criar-vaga.html';
        } else {
            alert('Erro ao cadastrar.');
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao cadastrar.');
    }
}

async function criarVaga(event) {
    event.preventDefault();

    const contratanteId = document.getElementById('contratanteId').value;

    const vaga = {
        titulo: document.getElementById('titulo').value,
        descricao: document.getElementById('descricao').value,
        requisitos: document.getElementById('requisitos').value,
        salario: parseFloat(document.getElementById('salario').value),
        localizacao: document.getElementById('localizacao').value
    };

    try {
        const response = await fetch(`${API_URL}/vagas?contratanteId=${contratanteId}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(vaga)
        });

        if (response.ok) {
            alert('Vaga criada com sucesso!');
            window.location.href = 'index.html';
        } else {
            alert('Erro ao criar vaga. Verifique o ID do contratante.');
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao criar vaga.');
    }
}

async function carregarCandidatos() {
    const params = new URLSearchParams(window.location.search);
    const vagaId = params.get('vagaId');

    if (!vagaId) {
        document.getElementById('candidatos-container').innerHTML = '<p class="text-center">ID da vaga não informado.</p>';
        return;
    }

    try {
        const vagaResponse = await fetch(`${API_URL}/vagas/${vagaId}`);
        const vaga = await vagaResponse.json();
        document.getElementById('vaga-titulo').textContent = vaga.titulo;

        const response = await fetch(`${API_URL}/vagas/${vagaId}/candidatos`);
        const candidatos = await response.json();

        exibirCandidatos(candidatos);
    } catch (error) {
        console.error('Erro:', error);
    }
}

function exibirCandidatos(candidatos) {
    const container = document.getElementById('candidatos-container');

    if (candidatos.length === 0) {
        container.innerHTML = '<p class="text-center text-muted">Nenhum candidato ainda.</p>';
        return;
    }

    container.innerHTML = '';

    candidatos.forEach(cand => {
        const statusClass = cand.status === 'ACEITA' ? 'badge-aceita' : cand.status === 'RECUSADA' ? 'badge-recusada' : 'badge-pendente';

        const card = document.createElement('div');
        card.className = 'candidato-card';
        card.innerHTML = `
            <div class="d-flex justify-content-between align-items-start">
                <div>
                    <h5 class="mb-1">${cand.programador.nome}</h5>
                    <p class="text-muted mb-1">${cand.programador.email}</p>
                    <p class="mb-1"><strong>Nível:</strong> ${cand.programador.nivel}</p>
                    <p class="mb-1"><strong>Competências:</strong> ${cand.programador.competencias}</p>
                    <p class="mb-0"><strong>Resumo:</strong> ${cand.programador.resumo || 'Não informado'}</p>
                </div>
                <div class="text-end">
                    <span class="badge ${statusClass} mb-2">${cand.status}</span>
                    <div class="mt-2" id="acoes-${cand.id}">
                        ${cand.status === 'PENDENTE' ? `
                            <button class="btn btn-success btn-sm me-1" onclick="atualizarStatus(${cand.id}, 'ACEITA')">Aceitar</button>
                            <button class="btn btn-danger btn-sm" onclick="atualizarStatus(${cand.id}, 'RECUSADA')">Recusar</button>
                        ` : ''}
                    </div>
                </div>
            </div>
        `;
        container.appendChild(card);
    });
}

async function atualizarStatus(candidaturaId, status) {
    try {
        const response = await fetch(`${API_URL}/candidaturas/${candidaturaId}?status=${status}`, {
            method: 'PUT'
        });

        if (response.ok) {
            carregarCandidatos();
        } else {
            alert('Erro ao atualizar status.');
        }
    } catch (error) {
        console.error('Erro:', error);
    }
}

document.addEventListener('DOMContentLoaded', function() {
    if (document.getElementById('vagas-container')) {
        carregarVagas();
    }

    if (document.getElementById('candidatos-container')) {
        carregarCandidatos();
    }

    const btnConfirmar = document.getElementById('btn-confirmar-candidatura');
    if (btnConfirmar) {
        btnConfirmar.addEventListener('click', confirmarCandidatura);
    }

    const btnCandidatarModal = document.getElementById('btn-candidatar-modal');
    if (btnCandidatarModal) {
        btnCandidatarModal.addEventListener('click', function() {
            bootstrap.Modal.getInstance(document.getElementById('vagaModal')).hide();
            abrirCandidatura(vagaSelecionada);
        });
    }

    const formProgramador = document.getElementById('form-programador');
    if (formProgramador) {
        formProgramador.addEventListener('submit', cadastrarProgramador);
    }

    const formContratante = document.getElementById('form-contratante');
    if (formContratante) {
        formContratante.addEventListener('submit', cadastrarContratante);
    }

    const formVaga = document.getElementById('form-vaga');
    if (formVaga) {
        formVaga.addEventListener('submit', criarVaga);
    }
});
