import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContaComponent } from './componentes/conta/conta.component';
import { SaldoComponent } from './componentes/saldo/saldo.component';
import { ExtratoComponent } from './componentes/extrato/extrato.component';
import { TransferenciaComponent } from './componentes/transferencia/transferencia.component';
import { PagamentoComponent } from './componentes/pagamento/pagamento.component';
import { LoginComponent } from './componentes/login/login.component';
import { CadastroComponent } from './componentes/cadastro/cadastro.component';
import { PixComponent } from './componentes/pix/pix.component';
import { DepositoComponent } from './componentes/deposito/deposito.component';
import { SaqueComponent } from './componentes/saque/saque.component';
import { AdmComponent } from './componentes/adm/adm.component';


export const routes: Routes = [
  { path: 'conta', component: ContaComponent },
  { path: 'saldo', component: SaldoComponent },
  { path: 'extrato', component: ExtratoComponent },
  { path: 'transferencia', component: TransferenciaComponent },
  { path: 'pagamento', component: PagamentoComponent },
  { path: 'login', component: LoginComponent},
  { path: 'cadastro', component: CadastroComponent},
  { path: "pix", component: PixComponent},
  { path: 'saque', component: SaqueComponent},
  {path: 'deposito', component: DepositoComponent},
  {path : 'adm', component: AdmComponent},
  { path: 'cadastro/:id', component: CadastroComponent},
  { path: 'login/:id', component: LoginComponent},
  {path: 'adm/:id', component: AdmComponent},
  {path: 'pix/:id', component: PixComponent},
  {path: 'deposito/:id', component: DepositoComponent},
  {path: 'saque/:id', component: SaqueComponent},
  {path: 'transferencia/:id', component: TransferenciaComponent},
  {path: 'pagamento/:id', component: PagamentoComponent},
  {path: 'extrato/:id', component: ExtratoComponent},
  {path: 'saldo/:id', component: SaldoComponent},
  {path: 'conta/:id', component: ContaComponent},
  { path: '', redirectTo: '/cadastro', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }