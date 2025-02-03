import { Component, OnInit } from '@angular/core';
import { ExtratoService } from '../../services/extrato.service';  // Importando o serviço

@Component({
  selector: 'app-extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.css']  // Se o CSS estiver em um arquivo separado, certifique-se de que o caminho está correto.
})
export class ExtratoComponent implements OnInit {
  extrato: { descricao: string; valor: number; saldo: number; data: string }[] = [];

  // Injetando o serviço no construtor
  constructor(private extratoService: ExtratoService) {}

  ngOnInit(): void {
    // No método ngOnInit, chamamos o serviço para obter o extrato
    this.extrato = this.extratoService.obterExtrato();
  }
}
