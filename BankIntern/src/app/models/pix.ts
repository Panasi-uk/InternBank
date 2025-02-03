import { Conta } from './conta';
import { Usuario } from './usuario';
import { Saldo } from './saldo';

export class Pix {
  valor: number | undefined;
  chave: any;
  constructor(
    public pixId: number,
    public saldo: Saldo,
    public conta: Conta,
    public usuario: Usuario,
    public entrada?: number,
    public saida?: number
  ) {}
}