import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  obterUsuarios() {
    return [
      { nome: 'João Silva', cpf: '12345678901', email: 'joao@email.com', telefone: '11999999999', endereco: 'Rua A, 123', cep: '01001000', bairro: 'Centro', cidade: 'São Paulo', numero: '123', senha: 'senha123' },
      { nome: 'Maria Oliveira', cpf: '23456789012', email: 'maria@email.com', telefone: '11988888888', endereco: 'Rua B, 456', cep: '02002000', bairro: 'Bela Vista', cidade: 'São Paulo', numero: '456', senha: 'senha234' },
      { nome: 'Pedro Santos', cpf: '34567890123', email: 'pedro@email.com', telefone: '11977777777', endereco: 'Rua C, 789', cep: '03003000', bairro: 'Liberdade', cidade: 'São Paulo', numero: '789', senha: 'senha345' },
      { nome: 'Lorena', cpf: '45678901234', email: 'lorena@email.com', telefone: '11966666666', endereco: 'Rua D, 101', cep: '04004000', bairro: 'Vila Mariana', cidade: 'São Paulo', numero: '101', senha: 'senha456' },
      { nome: 'Cinthia Souza', cpf: '56789012345', email: 'cinthia@email.com', telefone: '11955555555', endereco: 'Rua E, 202', cep: '05005000', bairro: 'Pinheiros', cidade: 'São Paulo', numero: '202', senha: 'senha567' },
      { nome: 'Amanda Peres', cpf: '67890123456', email: 'amanda@email.com', telefone: '11944444444', endereco: 'Rua F, 303', cep: '06006000', bairro: 'Moema', cidade: 'São Paulo', numero: '303', senha: 'senha678' }
    ];
  }
}

