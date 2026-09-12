/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
import vista.*;
import java.util.ArrayList;


/**
 *
 * @author santi
 */
public class Controlador {
    
    private Veterinaria veterinaria;
    private ClinicaVeterinaria vista;

    public Controlador(Veterinaria veterinaria, ClinicaVeterinaria vista) {
        this.veterinaria = veterinaria;
        this.vista = vista;
    }
    
    
    
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
        Propietario Jose = new Propietario("Jose", 15, "333", "Cartagena");
        Veterinario Juan = registrarVeterinario(10, "Juan", 35, "333", "Cartagena");
        
        // CONSULTA
        Consulta consulta1 = registrarConsulta(50);
        Consulta consulta2 = registrarConsulta(60);
        
        // MEDICAMENTOS
        
        
        Medicamento amoxicilina = new Medicamento("Amoxicilina", 5);
        Medicamento meloxicam = new Medicamento("Meloxicam", 2);
        Medicamento omeprazol = new Medicamento("Omeprazol", 10);
        
        
        // ------- [ ASIGNACIÓN OBJETOS ] ------- //
        
        //* MASCOTAS
        
        agregarMascotaAPropietario(gato, Santiago);
        agregarMascotaAPropietario(perro, Santiago);
        agregarMascotaAPropietario(gato, Daniel);
        agregarMascotaAPropietario(loro, Daniel);
        
        //* VETERINARIO
        
        asociarVeterinarioAConsulta(Juan, consulta1);
        asociarVeterinarioAConsulta(Juan, consulta2);
        
        
        // ------- [ PROBAR CAMBIOS ] ------- //
        
        //* Remover veterinario de consulta
        removerVeterinarioDeConsulta(Juan, consulta1);
        removerVeterinarioDeConsulta(Juan, consulta2);
        
        //* Remover veterinario de falsa consulta
        removerVeterinarioDeConsulta(Juan, consulta1);
        
        //* Cambiar a mismo dueño
        cambiarPropietarioMascota(gato, Santiago);
        cambiarPropietarioMascota(loro, Daniel);
        
        //* Cambiar a nuevos dueños
        cambiarPropietarioMascota(loro, Santiago);
        cambiarPropietarioMascota(gato, Daniel);
        
        //* Remover mascota de falso dueño
        removerMascotaPropietario(gato, Santiago);
        removerMascotaPropietario(loro, Daniel);
        
        //* Remover mascota de dueño real
        removerMascotaPropietario(gato, Daniel);
        removerMascotaPropietario(loro, Santiago);
        
        //* Agregar mascotas 
        agregarMascotaAPropietario(gato, Santiago);
        agregarMascotaAPropietario(perro, Santiago); // Nunca dejó de ser dueño.
        agregarMascotaAPropietario(conejo, Jose);
        agregarMascotaAPropietario(loro, Daniel);
        
        // ------- [ ASIGNACIÓN OBJETOS ] ------- //
        
        //* VETERINARIO
        
        //* Agregar veterinario a consulta
        asociarVeterinarioAConsulta(Juan, consulta1);
        asociarVeterinarioAConsulta(Juan, consulta2);
        
        //* MASCOTAS
        
        //* Asociar mascota a consulta
        asociarMascotaAConsulta(gato, consulta1);
        asociarMascotaAConsulta(perro, consulta2);
        
         // ------- [ PROBAR CAMBIOS ] ------- //
        
        // * Remover mascota de consulta
        removerMascotaDeConsulta(consulta1);
        removerMascotaDeConsulta(consulta2);
        
        // * Remover mascota de falsa consulta
        removerMascotaDeConsulta(consulta1);
        
        // * Cambiar mascota de consulta
        cambiarMascotaDeConsulta(gato, consulta1);
        cambiarMascotaDeConsulta(perro, consulta1);
        
        // ------- [ ASIGNACIÓN OBJETOS ] ------- //
        
       // * MEDICAMENTOS

        //* Recetar medicamentos normalmente
        recetarMedicamento(amoxicilina, consulta1);
        recetarMedicamento(meloxicam, consulta1);
        recetarMedicamento(omeprazol, consulta2);

        //* Recetar medicamento duplicado
        recetarMedicamento(amoxicilina, consulta1);


         // ------- [ PROBAR CAMBIOS ] ------- //
         
        //* Cambiar dosis exitoso
        cambiarDosisMedicamentos(consulta1, "Amoxicilina", 8);

        //* Cambiar dosis con cantidad inválida (<= 0)
        cambiarDosisMedicamentos(consulta1, "Amoxicilina", 0);
        cambiarDosisMedicamentos(consulta1, "Amoxicilina", -3);

        //* Cambiar dosis de medicamento inexistente en la consulta 
        cambiarDosisMedicamentos(consulta1, "Ibuprofeno", 4);

        //* Remover medicamento de consulta incorrecta
        removerMedicamento(omeprazol, consulta1); // omeprazol está en consulta2, no en consulta1

        //* Remover medicamento exitoso
        removerMedicamento(meloxicam, consulta1);

        //* Remover medicamento que ya fue eliminado
        removerMedicamento(meloxicam, consulta1);
        
        // Mostrar metodos generales.
        
        mostrarPropietariosConMascota();
        mostrarConsultas();
        mostrarMedicamentosRecetados();
       
    }
    
   public void mostrarPropietariosConMascota() {
    ArrayList<Propietario> unicosConMascota = new ArrayList<>();

    for (Propietario p : veterinaria.getListaPropietarios()) {
        if (p.getListaMascotas() != null && !p.getListaMascotas().isEmpty() && !unicosConMascota.contains(p)) {
            unicosConMascota.add(p);
        }
    }
    vista.mostrarPropietariosConMascota(unicosConMascota);
}
   
    public void mostrarConsultas() {
    ArrayList<Consulta> consultas = veterinaria.getListaConsultas();

    if (consultas == null || consultas.isEmpty()) {
        return;
    }

    ArrayList<String> lineasConsultas = new ArrayList<>();

    for (Consulta c : consultas) {
        String nombreMascota = (c.getMascota() != null) ? c.getMascota().getNombre() : "Sin asignar";
        String nombreVet = (c.getVeterinario() != null) ? c.getVeterinario().getNombre() : "Sin asignar";

        lineasConsultas.add("Consulta ID: " + c.getId() + "\n  - Mascota: " + nombreMascota + "\n  - Veterinario: " + nombreVet);
    }

    vista.mostrarConsultasDesdeStrings(lineasConsultas);
}

    public void mostrarMedicamentosRecetados() {
        ArrayList<Consulta> consultas = veterinaria.getListaConsultas();

    if (consultas == null || consultas.isEmpty()) {
        return;
    }

    ArrayList<Consulta> conMed = new ArrayList<>();
    for (Consulta c : consultas) {
        if (c.getListaMedicamentos() != null && !c.getListaMedicamentos().isEmpty()) {
            conMed.add(c);
        }
    }

    if (conMed.isEmpty()) {
        return;
    }

    for (Consulta c : conMed) {
        String nombreMascota = (c.getMascota() != null) ? c.getMascota().getNombre() : "Sin asignar";

        vista.mostrarMedicamentosDeConsulta(c.getId(), nombreMascota, c.getListaMedicamentos());
    }
}
    
    public Veterinario registrarVeterinario(int tarjetaProfesional, String nombre, int edad, String cedula, String direccion){
        Veterinario veterinario = new Veterinario(tarjetaProfesional, nombre, edad, cedula, direccion);
        veterinario.setVeterinaria(veterinaria);
        veterinaria.addListaVeterinarios(veterinario);
        return veterinario;
    }
    
    public Consulta registrarConsulta(int id){
        Consulta consulta = new Consulta(id);
        veterinaria.addListaConsultas(consulta);
        return consulta;
    }
    
    
    public void cambiarPropietarioMascota(Mascota mascota, Propietario nuevoPropietario) {
    Propietario antiguoPropietario = mascota.getPropietario();

    if (antiguoPropietario == nuevoPropietario) {
        vista.errorMascotaRepetida(nuevoPropietario, mascota);
        return;
    }
    if (antiguoPropietario != null) {
        antiguoPropietario.getListaMascotas().remove(mascota);
        veterinaria.removeListaPropietarios(antiguoPropietario);
    }

    if (!nuevoPropietario.getListaMascotas().contains(mascota)) {
        nuevoPropietario.addListaMascotas(mascota);
    }

    vista.msgMascotaAgregada(nuevoPropietario, mascota);
    mascota.setPropietario(nuevoPropietario);
    veterinaria.addListaPropietarios(nuevoPropietario);
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
        veterinaria.addListaPropietarios(propietario);
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
             m.setUnidades(nuevaDosis);
             vista.msgMedicamentoDosisCambiada(m, consulta);
            return;
        }
    }

    vista.errorMedicamentoNoEncontradoPorString(nombreMedicamento, consulta);
}
    
    
 }
