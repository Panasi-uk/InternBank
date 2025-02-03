import { Conta } from './conta';

export class Transacoes {
  constructor(
    public transacoesId: number,
    public conta: Conta,
    public pixId?: number,
    public pagamentoId?: number,
    public depositoId?: number,
    public extratoId?: number,
    public transferenciaId?: number,
    public saqueId?: number
  ) {}
}