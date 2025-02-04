import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { ContaComponent } from './componentes/conta/conta.component';
import { SaldoComponent } from './componentes/saldo/saldo.component';
import { ExtratoComponent } from './componentes/extrato/extrato.component';
import { TransferenciaComponent } from './componentes/transferencia/transferencia.component';
import { PagamentoComponent } from './componentes/pagamento/pagamento.component';
import { PixComponent } from './componentes/pix/pix.component';
import { DepositoComponent } from './componentes/deposito/deposito.component';
import { SaqueComponent } from './componentes/saque/saque.component';
import { AdmComponent } from './componentes/adm/adm.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppComponent,
    ContaComponent,
    SaldoComponent,
    ExtratoComponent,
    TransferenciaComponent,
    PagamentoComponent,
    PixComponent,
    DepositoComponent,
    SaqueComponent,
  ],
  providers: [],
})
export class AppModule { }