import { Component } from '@angular/core';
import { ContaService } from '../../services/conta.service';
@Component({
  selector: 'app-transferencia',
  imports: [],
  templateUrl: './transferencia.component.html',
  styleUrl: './transferencia.component.css'
})
export class TransferenciaComponent {
  constructor(private contaService: ContaService) {}

  transferir(valor: number, contaDestino: string) {
    if (valor <= this.contaService.consultarSaldo()) {
      this.contaService.atualizarSaldo(-valor);
      return `Transferência de R$ ${valor} para ${contaDestino} realizada com sucesso.`;
    } else {
      return 'Saldo insuficiente';
    }
  }
}
