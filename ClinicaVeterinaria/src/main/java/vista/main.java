/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.*;
import modelo.*;

/**
 *
 * @author santi
 */
public class main {
    
     public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria("Patitas", 123, "Cartagena");
        ClinicaVeterinaria vista = new ClinicaVeterinaria();
        Controlador controlador = new Controlador(veterinaria, vista);
        /////
        controlador.iniciarSistema();
    }
}
