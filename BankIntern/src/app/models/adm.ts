import { Usuario } from './usuario';

export class Admin {
  constructor(
    public adminId: number, //usando o PUBLIC Reduz a verbosidade,
    public criacao: Date,
    public usuario: Usuario,
    public edicao?: Date
  ) {}
}
