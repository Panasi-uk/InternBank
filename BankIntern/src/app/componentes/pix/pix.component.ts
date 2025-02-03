import { Component } from '@angular/core';
import { PixService } from '../../services/pix.service';
import { Pix } from '../../models/pix';

@Component({
  selector: 'app-pix',
  templateUrl: './pix.component.html',
  styleUrls: ['./pix.component.css']
})
export class PixComponent {
  saldo: number = 0;
  extrato: any[] = [];
  valor: number | undefined;
  chavePix: string | undefined;

  constructor(private pixService: PixService) {
    this.atualizarSaldo();
  }

  atualizarSaldo() {
    this.saldo = this.pixService.consultarSaldo();
  }

  realizarPix(valor: number, chavePix: string) {
    const pix: Pix = {
      valor, chave: chavePix,
      pixId: 0,
      saldo: this.pixService.getDefaultSaldo(),
      conta: this.pixService.getDefaultConta(),
      usuario: this.pixService.getDefaultUsuario()
    };
    alert(this.pixService.realizarPix(pix));
    this.atualizarSaldo();
  }

  visualizarExtrato() {
    this.extrato = this.pixService.consultarExtrato();
  }
}