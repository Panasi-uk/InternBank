import { Conta } from './conta';
import { Usuario } from './usuario';
import { Saldo } from './saldo';

export class Deposito {
  constructor(
    public depositoId: number,
    public saldo: Saldo,
    public conta: Conta,
    public usuario: Usuario,
    public entrada?: number,
    public saida?: number
  ) {}
}