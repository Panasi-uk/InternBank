import { Injectable } from '@angular/core';
import { Pagamento } from '../models/pagamento';
import { Extrato } from '../models/extrato';
import { Conta } from '../models/conta';

@Injectable({
  providedIn: 'root'
})
export class SaldoService {
  private saldo: number = 1000;

  consultarSaldo(): number {
    return this.saldo;
  }
}