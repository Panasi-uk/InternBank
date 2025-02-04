import { Component } from '@angular/core';

import { FormsModule } from '@angular/forms'; //esse recurso necessario com formularios no Angular
import{AuthService} from '../../services/auth.service'; //importando o serviço de autenticação
import { Router, RouterLink } from '@angular/router'; //importando o serviço de roteamento
import { CommonModule } from '@angular/common'; //importando o modulo de funcionalidades comuns
//import { User } from '../../models/user'; // importando o modelo de usuario

@Component({
  selector: 'app-login',
  standalone: true, //standalone é um atributo que indica que o componente é independente
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  tituloComp: string ='Login de Usuario'

  //1 - definir uma propriedade para recebrum valor credenciais de acesso para o login do usuario
  credentials: any = {
    email: '',
    password: ''
  }
  //2- definir o construtor para injetar o serviço de autenticação e o serviço de roteamento
  constructor(private authService: AuthService, private router: Router){}

  //3- definir o metodo onsSubmit para submeter as credenciais de acesso para o serviço de autenticação
  onSubmit(): void{
    this.authService.login(this.credentials).subscribe({
      next: (response) => {
        console.log('Login bem sucedido!', response.message);
        this.router.navigate(['/conta']) // se tudo ocorrer bem redireciona para a conta
      },
      error:(error) =>{
        console.error('Erro ao fazer login!', error.error.error);
      }
    })
  }
}
