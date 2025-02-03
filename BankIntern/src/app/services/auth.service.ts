// recurso que da a possibilidade de usar o decorator @injectable
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // classe que vai auxiliar na construção das requisições http
import { Observable,tap } from 'rxjs'; // bibliotecas usadas para operar com a assinconicidade necessaria para o funcionamento das requisições e respostas http.
// Observable; representa o fluxo de dados assincrona do projeto - na camada logica
//TAP; é um operador que permite executar ações secundarias sem modificar o fluxo principal
import { Usuario } from '../models/usuario' //importação do model user


@Injectable({
  providedIn: 'root' 
})
export class AuthService {
// 1 - passo: definir a url-base para a integração do fron-end com o backend
// aqui é importante indicar em qual "endereço" o backend esta "rodando"
  
  //querendo inserir um registro no banco de daod. como pode ser feito?
  // no backend o endpoint é '/users/register'
  //http://localhost:8080/api/users/register
  private apiUrl = 'http://localhost:8080/api'

  //2 - definir no construtor a injeção de depencia da classe HttpVliente. Por que?
  // Porque a partir do uso desta injeção de dependencia é que serão realizadas a requisições http para as APIs do backend
  // o servece dependen deste recurso para fazer as requisições http
  constructor(private http: HttpClient) { } // a var http é a injeção de dependencia gerada da classe HttpCleint;
  // essa var sera conhecida como um objeto referencial

  /*
  ===========================================================================
  AQUI VAMOS DEFINIR AS REQUISIÇÕES AOS ENDPOINST DAS APIs
  ===========================================================================
  */

  //3 - definir a requisição e seus elementos logicos necessarios para o endpoint de cadastro 
  //definir um metodo register(){}: porque a partir dele, a requisição ao backend será feita
  // ao usar essa expressão definimos um metodo que passa a ser uma tarefa assincrona
  register(usuario: Usuario, roleName: string): Observable<{message: string}>{
    return this.http.post<{message: string}>(`${this.apiUrl}/usuarios/register?roleName=${roleName}`,usuario)
  } 

  /*
    user: parametro/objeto vai conter os dados que queremos enviar para a base
    roleName: nome do "papel do usuario dentro do sistema" (admin ou user)
    requisição ao backend: estamos fazendo uma requisição POST - para enviar dados para o backend - atraves da rota/endpoint ${apiUrl}/user/register; alem disso, tambem estamos passando, por essa rota o papel do usuario como um parametro da consulta
    (roleName)
    retorno: um elemento que emite um objeto com uma mensagem de sucesso ou erro.
  
  */

  //4 - Definir o metodo de login
  //temos que transforma-lo numa requisição assincrona parametrizando o metodo par
  //receber os dados com os quais eçe vai lidar
    login(credentials: {email: string, password: string}): Observable<{message: string}>{
      return this.http.post<{message:string}>(`${this.apiUrl}/usuarios/login`,credentials,{withCredentials: true}).pipe(
        tap((response)=>{
          console.log('Login bem sucedido!', response.message)
          localStorage.setItem('isLoggedIn', 'true') //atualiza o state/estado da aplicação
        })
      )
    }
    //5- definir um metodo para obter o usuario atual - que, no momento, esta logado no sistema
    getCurrentUserEmail(): Observable<{email: string}>{
      return this.http.get<{email: string}>(`${this.apiUrl}/usuarios/current-user`, 
        {withCredentials: true})
        //metodo assincrona que recupera o usuario logado no sistema
        //requisição: get para rota, que habilita o uso de cookies a partir do  {withCredentials: true}
    }

    //6- definir o metodo logout
    logout(): Observable<void>{
      return this.http.post<void>(`${this.apiUrl}/usuarios/logout`, {}, {withCredentials: true}).pipe(
        tap(()=> {
          localStorage.removeItem('isLoggedIn') //remove o state/estado da autenticação, ou seja, encerrando a sessão de usuario.
        })
      )
      //pipe(): auxilia na execução de tarefas assincronas e estabelece um "canal" de comunicação direta entre recursos assincronos do componente.

    }

    //7 - passo definir um novo metodo; esse metodo possui um unico objetivo simples;
    //verificar se o usuario esta logado no sistema
    isLoggedIn(): boolean{
      return localStorage.getItem('isLoggedIn') === 'true'
    }
}



