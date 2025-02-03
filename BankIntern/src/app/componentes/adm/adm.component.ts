import { Component } from '@angular/core';
import{ UsuarioComponent } from '../usuario/usuario.component';


@Component({
  selector: 'app-adm',
  imports: [],
  templateUrl: './adm.component.html',
  styleUrl: './adm.component.css'
})

export class AdmComponent {
  usuarios: any[];
  
  constructor(private usuarioComponent: UsuarioComponent) {
    this.usuarios = this.usuarioComponent.listarUsuarios();
  }

  listarUsuarios() {
    return this.usuarios;
  }
}