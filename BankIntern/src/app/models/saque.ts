import { Conta } from './conta';
import { Saldo } from './saldo';

export class Saque {
  constructor(
    public saqueId: number,
    public saldo: Saldo,
    public conta: Conta,
    public entrada?: number,
    public saida?: number
  ) {}
}
