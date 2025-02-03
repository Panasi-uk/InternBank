import { Injectable } from '@angular/core';
import { Pix } from '../models/pix';
import { Extrato } from '../models/extrato';

@Injectable({
  providedIn: 'root'
})
export class PixService {
  getDefaultUsuario(): import("../models/usuario").Usuario {
    throw new Error('Method not implemented.');
  }
  getDefaultConta(): import("../models/conta").Conta {
    throw new Error('Method not implemented.');
  }
  getDefaultSaldo(): import("../models/saldo").Saldo {
    throw new Error('Method not implemented.');
  }
  saldo: number = 1000;
  extrato: Extrato[] = [];
  valor: number [] = [];

  consultarSaldo(): number {
    return this.saldo;
  }

  realizarPix(pix: Pix): string {
    if (pix.valor !== undefined && this.saldo >= pix.valor) {
      this.saldo -= pix.valor;
      this.extrato.push({ tipo: 'Pix', valor: pix.valor, data: new Date() });
      return `Pix de R$ ${pix.valor} enviado para ${pix.chave} com sucesso.`;
    }
    return 'Saldo insuficiente!';
  }

  consultarExtrato(): Extrato[] {
    return this.extrato;
  }
}
