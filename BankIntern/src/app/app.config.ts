import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

/* 
ApplicationConfig; é uma interface que define a configuração da aplicação.
provideZoneChangeDetection; é uma função que fornece a detecção de mudanças de zona.
provideRouter; é uma função que fornece o roteador.
*/

import { routes } from './app.routes';
// Importa o arquivo app.routes.ts

import { provideClientHydration, withEventReplay } from '@angular/platform-browser';
// Importa as funções provideClientHydration e withEventReplay do pacote @angular/platform-browser.

import { provideHttpClient } from '@angular/common/http';
// Importa a função provideHttpClient do pacote @angular/common/http.

// Define a constante appConfig que é um objeto com a propriedade providers que é um array de funções.
export const appConfig: ApplicationConfig = {
  
  // A propriedade providers é um array de funções.
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }), 
    provideRouter(routes), 
    provideClientHydration(withEventReplay()),
    // Fornece a detecção de mudanças de zona, o roteador, a hidratação do cliente e o replay de eventos.
    provideHttpClient()
  ]
  
};