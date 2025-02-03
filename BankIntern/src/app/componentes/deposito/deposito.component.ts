import { Component } from '@angular/core';
import { ContaService } from '../../services/conta.service';
@Component({
  selector: 'app-deposito',
  imports: [],
  templateUrl: './deposito.component.html',
  styleUrl: './deposito.component.css'
})
export class DepositoComponent {
  constructor(private contaService: ContaService) {}

  depositar(valor: number) {
    this.contaService.atualizarSaldo(valor);
    return `Depósito de R$ ${valor} realizado com sucesso.`;
  }
}

