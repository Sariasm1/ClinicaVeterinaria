/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
import vista.*;


/**
 *
 * @author santi
 */
public class Controlador {
    
    ClinicaVeterinaria vista = new ClinicaVeterinaria();
    
    public void iniciarSistema(){
        
    }
    
    public void agregarMascotaAPropietario(Mascota mascota, Propietario propietario){
        if(propietario.getListaMascotas().contains(mascota))
        {
            return ;
        }
        propietario.addListaMascotas(mascota);
        mascota.setPropietario(propietario);
    }
    
    
}
