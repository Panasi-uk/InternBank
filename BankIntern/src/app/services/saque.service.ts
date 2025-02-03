import { Injectable } from '@angular/core';
import { ContaService } from './conta.service';

@Injectable({ providedIn: 'root' })

export class SaqueService {
  
  constructor(private contaService: ContaService) {}
  sacar(valor: number) {
    if (valor <= this.contaService.consultarSaldo()) {
      this.contaService.atualizarSaldo(-valor);
      console.log(`Saque de R$${valor} realizado com sucesso.`);
      return `Saque realizado com sucesso.`;
    } else {
      return 'Saldo insuficiente';
    }
  }
}
