import { Injectable } from '@angular/core';
import { Pix } from '../models/pix';
import { Extrato } from '../models/extrato';
import { Transferencia } from '../models/transferencia';
import { Pagamento } from '../models/pagamento';

@Injectable({
  providedIn: 'root'
})
export class ContaService {
  atualizarSaldo(arg0: number) {
    throw new Error('Method not implemented.');
  }
  saldo: number = 1000;
  nomeUsuario: string = 'Usuário Teste';
  extrato: Extrato[] = [];

  getNomeUsuario(): string {
    return this.nomeUsuario;
  }

  consultarSaldo(): number {
    return this.saldo;
  }

  realizarPix(pix: Pix): string {
    if (pix.valor !== undefined && this.saldo >= pix.valor) {
      this.saldo -= pix.valor;
      this.extrato.push({ tipo: 'Pix', valor: pix.valor, data: new Date() });
      return 'Pix realizado com sucesso!';
    }
    return 'Saldo insuficiente!';
  }

  realizarTransferencia(transferencia: Transferencia): string {
    if (typeof transferencia.valor === 'number' && this.saldo >= transferencia.valor) {
      this.saldo -= transferencia.valor;
      this.extrato.push({ tipo: 'Transferência', valor: transferencia.valor, data: new Date() });
      return 'Transferência realizada com sucesso!';
    }
    return 'Saldo insuficiente!';
  }

  realizarPagamento(pagamento: Pagamento): string {
    if (pagamento.valor !== undefined && this.saldo >= pagamento.valor) {
      this.saldo -= pagamento.valor;
      this.extrato.push({ tipo: 'Pagamento', valor: pagamento.valor, data: new Date() });
      return 'Pagamento realizado com sucesso!';
    }
    return 'Saldo insuficiente!';
  }

  consultarExtrato(): Extrato[] {
    return this.extrato;
  }
}
