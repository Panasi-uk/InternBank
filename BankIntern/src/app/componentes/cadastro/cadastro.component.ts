import { Component } from '@angular/core';
//importação necessarias
import { FormsModule } from '@angular/forms'; //esse recurso necessario com formularios no Angular
import{AuthService} from '../../services/auth.service'; //importando o serviço de autenticação
import { Router, RouterLink, RouterLinkActive } from '@angular/router'; //importando o serviço de roteamento
import { CommonModule } from '@angular/common'; //importando o modulo de funcionalidades comuns
import { Usuario } from '../../models/usuario'; 

@Component({
  selector: 'app-cadastro',
  standalone: true, //standalone é um atributo que indica que o componente é independente
  imports: [FormsModule, RouterLink, RouterLinkActive, CommonModule], //importando os modulos necessarios
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css'
})
export class CadastroComponent {
    
  tituloComp: string ='Cadastro de Usuario'

  //1 - definir uma variavel para armazenar o usuario
  usuario: Usuario = new Usuario('', '','', '', '', '', '', '', '', '',''); //criando um novo usuario

  //2 - inicializar um novo usuario - seguindo alguns passos importantes
  selectedRole: string = 'Usuario'; //definindo o papel do usuario

  errorMessage: string = '' //definindo uma mensagem de erro

  constructor(private authService: AuthService, private router: Router){} //injetando o serviço de autenticação e o serviço de roteamento

  onSubmit(): void{
    //definir uma constante para armazenar o usuario
    const Nome =this.selectedRole
    //chamando o serviço de autenticação para registrar o usuario
    this.authService.register(this.usuario, Nome).subscribe({
      next: (response) => {
        console.log('Usuario registrado com sucesso', response.message)
        this.router.navigate(['/login'])
      },

      error:(error) =>{
        if(error.error && error.error.length > 0 )
          this.errorMessage = error[0].defaultMessage

        else{
          this.errorMessage = 'Erro ao registrar o usuario'
        }

      }
      
    }) //subscribe é um metodo que permite que o observador se inscreva para receber notificações de valores emitidos por um Observable

  }
}