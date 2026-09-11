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
        No realicé validaciones para getPropietario() de Mascota y validar si ya es el mismo dueño suponiendo 
        que el sistema es automatico. 
        */
        
        vista.msgMascotaAgregada(propietario, mascota);
        propietario.addListaMascotas(mascota);
        mascota.setPropietario(propietario);
    }
    
    public void removerMascotaPropietario(Mascota mascota, Propietario propietario) {
    Mascota mascotaEncontrada = null;

    for (Mascota m : propietario.getListaMascotas()) {
        if (m.getId() == mascota.getId()) {
            mascotaEncontrada = m;
            break;
        }
    }

    if (mascotaEncontrada == null) {
        vista.errorMascotaNoEncontrada(propietario, mascota);
        return;
    }
    
    vista.msgMascotaRemovida(propietario, mascota);
    propietario.getListaMascotas().remove(mascotaEncontrada);
    mascota.setPropietario(null);
}
    
    public void asociarVeterinarioAConsulta(Veterinario veterinario, Consulta consulta){
        for (Consulta c : veterinario.getListaConsultas()) {
        if (c.getId() == consulta.getId()) {
            vista.errorAsociarVeterinarioEnConsulta(veterinario, consulta);
            return;
        }
    }
        /*
        No realicé validaciones para getVeterinario() de Consulta y validar si ya es el mismo veterinario suponiendo 
        que el sistema es automatico. 
        */
        vista.msgVeterinarioAgregado(veterinario, consulta);
        veterinario.addListaConsultas(consulta);
        consulta.setVeterinario(veterinario);
    }
    
    public void removerVeterinarioDeConsulta(Veterinario veterinario, Consulta consulta) {
    Consulta consultaEncontrada = null;

    for (Consulta c : veterinario.getListaConsultas()) {
        if (c.getId() == consulta.getId()) {
            consultaEncontrada = c;
            break;
        }
    }

    if (consultaEncontrada == null) {
        vista.errorConsultaNoAsignada(veterinario, consulta);
        return;
    }
    
    vista.msgVeterinarioRemovido(veterinario, consulta);
    veterinario.getListaConsultas().remove(consultaEncontrada);
    consulta.setVeterinario(null);
}
    
    
    public void recetarMedicamento(Medicamento medicamento, Consulta consulta){
        for (Medicamento m : consulta.getListaMedicamentos()) {
        if (m.getNombre().equalsIgnoreCase(medicamento.getNombre())) {
            vista.errorRecetarMedicamento(medicamento, consulta);
            return;
        }
    }
        vista.msgMedicamentoRecetado(medicamento, consulta);
        consulta.addListaMedicamento(medicamento);
        medicamento.setConsulta(consulta);
    }
    
    public void removerMedicamento(Medicamento medicamento, Consulta consulta) {
    Medicamento medEncontrado = null;

    for (Medicamento m : consulta.getListaMedicamentos()) {
        if (m.getNombre().equalsIgnoreCase(medicamento.getNombre())) {
            medEncontrado = m;
            break;
        }
    }

    if (medEncontrado == null) {
        vista.errorMedicamentoNoEncontrado(medicamento, consulta);
        return;
    }

    vista.msgMedicamentoRemovido(medicamento, consulta);
    consulta.getListaMedicamentos().remove(medEncontrado);
    medicamento.setConsulta(null);
}

   public void cambiarDosisMedicamentos(Consulta consulta, String nombreMedicamento, int nuevaDosis) {
    if (nuevaDosis <= 0) {
        vista.errorDosisInvalida();
        return;
    }

    for (Medicamento m : consulta.getListaMedicamentos()) {
        if (m.getNombre().equalsIgnoreCase(nombreMedicamento)) {
             vista.msgMedicamentoDosisCambiada(m, consulta);
            m.setUnidades(nuevaDosis);
            return;
        }
    }

    vista.errorMedicamentoNoEncontradoPorString(nombreMedicamento, consulta);
}
    
    
 }
