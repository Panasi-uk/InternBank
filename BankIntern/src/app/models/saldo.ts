import { Conta } from './conta';

export class Saldo {
  constructor(
    public saldoId: number,
    public visualizacao: number,
    public conta: Conta
  ) {}
}