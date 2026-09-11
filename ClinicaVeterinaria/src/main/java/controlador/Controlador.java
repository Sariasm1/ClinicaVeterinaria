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
       for (Mascota m : propietario.getListaMascotas()) {
        if (m.getId() == mascota.getId()) {
            vista.errorMascotaRepetida(propietario, mascota);
            return;
        }
    }
        /*
        No realizo validaciones para getPropietario() de Mascota y validar si ya es el mismo dueño suponiendo 
        que el sistema es automatico. 
        */
        
        propietario.addListaMascotas(mascota);
        mascota.setPropietario(propietario);
    }
    
    public void asociarVeterinarioAConsulta(Veterinario veterinario, Consulta consulta){
        for (Consulta c : veterinario.getListaConsultas()) {
        if (c.getId() == consulta.getId()) {
            vista.errorAsociarVeterinarioEnConsulta(veterinario, consulta);
            return;
        }
    }
        /*
        No realizo validaciones para getVeterinario() de Consulta y validar si ya es el mismo veterinario suponiendo 
        que el sistema es automatico. 
        */
        veterinario.addListaConsultas(consulta);
        consulta.setVeterinario(veterinario);
    }
    
    public void recetarMedicamento(Medicamento medicamento, Consulta consulta){
        for (Medicamento m : consulta.getListaMedicamentos()) {
        if (m.getNombre().equalsIgnoreCase(medicamento.getNombre())) {
            vista.errorRecetarMedicamento(medicamento, consulta);
            return;
        }
    }
        consulta.addListaMedicamento(medicamento);
        medicamento.setConsulta(consulta);
    }
    
    
 }
