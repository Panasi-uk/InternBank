export class Usuario {
  
    constructor(
      public usuarioId: string,
      public nome: string,
      public cpf: string,
      public email: string,
      public telefone: string,
      public endereco: string,
      public cep: string,
      public bairro: string,
      public cidade: string,
      public numero: string,
      public password: string
    ) {}
  }
