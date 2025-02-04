import { Component, NgModule } from '@angular/core';
import { ContaService } from '../../services/conta.service';


@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styleUrl: './conta.component.css',
  providers: [ContaService]
})

export class ContaComponent {
showSaldo: any;
toggleSaldo() {
throw new Error('Method not implemented.');
}
  saldo: number;
  Nome: string;
  
  constructor(private contaService: ContaService) {
    this.Nome = this.contaService.getNomeUsuario();
    this.saldo = this.contaService.consultarSaldo();
  }

  consultarSaldo() {
    this.saldo = this.contaService.consultarSaldo();
  }
  
}

