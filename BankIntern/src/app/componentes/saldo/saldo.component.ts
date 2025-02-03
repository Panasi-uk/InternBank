import { Component } from '@angular/core';
import { SaldoService } from '../../services/saldo.service';

@Component({
  selector: 'app-saldo',
  templateUrl: './saldo.component.html',
  styleUrls: ['./saldo.component.css']
})
export class SaldoComponent {
  saldo: number = 0;

  constructor(private saldoService: SaldoService) {
    this.atualizarSaldo();
  }

  atualizarSaldo() {
    this.saldo = this.saldoService.consultarSaldo();
  }
}
