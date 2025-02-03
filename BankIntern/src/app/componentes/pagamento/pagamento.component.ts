import { Component } from '@angular/core';
import { ContaService } from '../../services/conta.service';

@Component({
  selector: 'app-pagamento',
  imports: [],
  templateUrl: './pagamento.component.html',
  styleUrl: './pagamento.component.css'
})
export class PagamentoComponent {
  constructor(private contaService: ContaService) {}

  pagar(valor: number, codigoBarras: string) {
    if (valor <= this.contaService.consultarSaldo()) {
      this.contaService.atualizarSaldo(-valor);
      return `Pagamento de R$ ${valor} para boleto ${codigoBarras} realizado com sucesso.`;
    } else {
      return 'Saldo insuficiente';
    }
  }
}