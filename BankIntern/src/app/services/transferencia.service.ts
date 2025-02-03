import { Injectable } from '@angular/core';
import { ContaService } from './conta.service';

@Injectable({ providedIn: 'root' })

export class TransferenciaService {
  constructor(private contaService: ContaService) {}
  transferir(valor: number, contaDestino: string) {
    if (valor <= this.contaService.consultarSaldo()) {
      this.contaService.atualizarSaldo(-valor);
      console.log(`Transferência de R$${valor} para conta ${contaDestino} realizada com sucesso.`);
      return `Transferência realizada com sucesso.`;
    } else {
      return 'Saldo insuficiente';
    }
  }
}
