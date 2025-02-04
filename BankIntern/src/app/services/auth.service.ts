// recurso que da a possibilidade de usar o decorator @injectable
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; // classe que vai auxiliar na construção das requisições http
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
  private apiUrl = 'http://localhost:8080/api/usuario'

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
  register(usuario: Usuario): Observable<{message: string}> {
    return this.http.post<{message: string}>(`${this.apiUrl}/usuario/cadastro`, usuario);
  }


    login(credentials: {email: string, password: string}): Observable<{message: string}>{
      const authHeader = `Basic ${btoa(`${credentials.email}: ${credentials.password}`)}`
      console.log('Enviando para o backend:', credentials)


      return this.http.post<{message:string}>(`${this.apiUrl}/usuario/login`, credentials, {headers: new HttpHeaders({'Content-Type':'application/json'})}).pipe(
        tap((response)=>{
          console.log('Login bem sucedido!')
          localStorage.setItem('authHeader', authHeader) //atualiza o state/estado da aplicação
        })
      )
      
    }

    isLoggedIn(): boolean{
      return !!localStorage.getItem('authHeader')
    }
    
    getAuthHeader(): string{
      return localStorage.getItem('authHeader') || ''
    }
    
    
    getCurrentUserEmail(): Observable<{email: string}>{
      return this.http.get<{email: string}>(`${this.apiUrl}/usuario/current-user`, 
        {withCredentials: true})
        //metodo assincrona que recupera o usuario logado no sistema
        //requisição: get para rota, que habilita o uso de cookies a partir do  {withCredentials: true}
    }

    //6- definir o metodo logout
    logout(): Observable<void>{
      return this.http.post<void>(`${this.apiUrl}/usuario/logout`, {}, {
        headers: new HttpHeaders({Authorization: this.getAuthHeader()})
      }).pipe(
        tap(()=> {
          localStorage.removeItem('isLoggedIn') 
          console.log('Usuario deslogado')
        })
      )
      //pipe(): auxilia na execução de tarefas assincronas e estabelece um "canal" de comunicação direta entre recursos assincronos do componente.

    }

 
   
}



