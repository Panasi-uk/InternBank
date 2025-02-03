import { Usuario } from './usuario';

export class Conta {
  constructor(
    public contaId: number,
    public agencia: string,
    public numeroConta: string,
    public senha: string,
    public usuario: Usuario
  ) {}
  
}
