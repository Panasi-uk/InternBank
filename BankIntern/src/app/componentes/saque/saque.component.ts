import { Component } from '@angular/core';
import { ContaService } from '../../services/conta.service';
@Component({
  selector: 'app-saque',
  imports: [],
  templateUrl: './saque.component.html',
  styleUrl: './saque.component.css'
})
export class SaqueComponent {
  constructor(private contaService: ContaService) {}

  sacar(valor: number) {
    if (valor <= this.contaService.consultarSaldo()) {
      this.contaService.atualizarSaldo(-valor);
      return `Saque de R$ ${valor} realizado com sucesso.`;
    } else {
      return 'Saldo insuficiente';
    }
  }
}
