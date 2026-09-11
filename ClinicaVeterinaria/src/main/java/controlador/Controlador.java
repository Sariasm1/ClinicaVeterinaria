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
        // [ CREACIÓN OBJETOS ] //
        
        // ANIMALES
        Mascota gato = new Mascota(1, "Princesa", 10, "Tigrillo");
        Mascota perro = new Mascota(2, "Dante", 5, "Cafe");
        Mascota loro = new Mascota(3, "Ronny", 12, "Verde");
        Mascota conejo = new Mascota(4, "Sparky", 3, "Blanco");
        
        // PERSONAS
        Propietario Santiago = new Propietario("Santiago", 19, "111", "Cartagena");
        Propietario Daniel = new Propietario("Daniel", 23, "222", "Cartagena");
        Veterinario Juan = new Veterinario(10, "Juan", 35, "333", "Cartagena");
        
        // [ ASIGNACIÓN OBJETOS ] //
        
        agregarMascotaAPropietario(gato, Santiago);
        agregarMascotaAPropietario(perro, Santiago);
        
    }
    
    public void cambiarPropietarioMascota(Mascota mascota, Propietario nuevoPropietario) {
    Propietario antiguoPropietario = mascota.getPropietario();

    if (antiguoPropietario == nuevoPropietario) {
        vista.errorMascotaRepetida(nuevoPropietario, mascota);
        return;
    }
    if (antiguoPropietario != null) {
        antiguoPropietario.getListaMascotas().remove(mascota);
    }

    if (!nuevoPropietario.getListaMascotas().contains(mascota)) {
        nuevoPropietario.addListaMascotas(mascota);
    }

    vista.msgMascotaAgregada(nuevoPropietario, mascota);
    mascota.setPropietario(nuevoPropietario);
}
    
    public void agregarMascotaAPropietario(Mascota mascota, Propietario propietario){
        if (mascota.getPropietario() != null && mascota.getPropietario() != propietario) {
        vista.errorMascotaTieneOtroPropietario(propietario, mascota);
        return;
        }
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
    
    public void asociarMascotaAConsulta(Mascota mascota, Consulta consulta) {
    if (consulta.getMascota() != null) {
        if (consulta.getMascota().getId() == mascota.getId()) {
            vista.errorMascotaRepetidaEnConsulta(consulta, mascota);
        } else {
            vista.errorConsultaYaTieneMascota(consulta, consulta.getMascota());
        }
        return;
    }

    consulta.setMascota(mascota);
    vista.msgMascotaAsignadaAConsulta(consulta, mascota);
}

    public void cambiarMascotaDeConsulta(Mascota nuevaMascota, Consulta consulta) {
        Mascota mascotaActual = consulta.getMascota();

        if (mascotaActual != null && mascotaActual.getId() == nuevaMascota.getId()) {
            vista.errorMismaMascotaEnConsulta(consulta, nuevaMascota);
            return;
        }

        consulta.setMascota(nuevaMascota);
        vista.msgMascotaCambiadaEnConsulta(consulta, nuevaMascota);
    }

    public void removerMascotaDeConsulta(Consulta consulta) {

        if (consulta.getMascota() == null) {
            vista.errorConsultaSinMascota(consulta);
            return;
        }

        Mascota mascotaRemovida = consulta.getMascota();


        consulta.setMascota(null);
        vista.msgMascotaRemovidaDeConsulta(consulta, mascotaRemovida);
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
