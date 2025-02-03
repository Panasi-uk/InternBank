import { Injectable } from '@angular/core';
@Injectable({ providedIn: 'root' })

export class DepositoService {
  private saldo: number = 0;
  atualizarSaldo(valor: number) {
    this.saldo += valor;
    console.log(`Novo saldo: R$${this.saldo}`);
  }
  obterSaldo() {
    return this.saldo;
  }
}