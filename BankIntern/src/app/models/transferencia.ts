import { Conta } from './conta';
import { Usuario } from './usuario';
import { Saldo } from './saldo';

export class Transferencia {
  valor: number [] = [];
  constructor(
    public transferenciaId: number,
    public saldo: Saldo,
    public conta: Conta,
    public usuario: Usuario,
    public entrada?: number,
    public saida?: number
  ) {}
}
