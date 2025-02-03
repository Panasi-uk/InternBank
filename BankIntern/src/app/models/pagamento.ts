import { Conta } from './conta';
import { Usuario } from './usuario';
import { Saldo } from './saldo';

export class Pagamento {
  valor: number | undefined;
  codigoBarras: any;
  constructor(
    public pagamentoId: number,
    public saldo: Saldo,
    public conta: Conta,
    public usuario: Usuario,
    public entrada?: number,
    public saida?: number
  ) {}
}
