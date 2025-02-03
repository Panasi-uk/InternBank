import { Injectable } from '@angular/core';
import { Pagamento } from '../models/pagamento';
import { Extrato } from '../models/extrato';

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {
  private saldo: number = 1000;
  private extrato: Extrato[] = [];

  consultarSaldo(): number {
    return this.saldo;
  }

  realizarPagamento(pagamento: Pagamento): string {
    if (pagamento.valor !== undefined && this.saldo >= pagamento.valor) {
      this.saldo -= pagamento.valor;
      this.extrato.push({ tipo: 'Pagamento', valor: pagamento.valor, data: new Date() });
      return `Pagamento de R$ ${pagamento.valor} para boleto ${pagamento.codigoBarras} realizado com sucesso.`;
    }
    return 'Saldo insuficiente!';
  }

  consultarExtrato(): Extrato[] {
    return this.extrato;
  }
}