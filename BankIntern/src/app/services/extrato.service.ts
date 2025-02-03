import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExtratoService {

  constructor() { }

  obterExtrato() {
    // Exemplo de dados simulados. Substitua com dados reais, por exemplo, de uma API.
    return [
      { descricao: 'Depósito', valor: 500, saldo: 500, data: '01/01/2025' },
      { descricao: 'Transferência', valor: -200, saldo: 300, data: '02/01/2025' },
      { descricao: 'Pagamento', valor: -100, saldo: 200, data: '03/01/2025' },
      // Mais dados...
    ];
  }
}
