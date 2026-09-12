/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;
import modelo.*;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class ClinicaVeterinaria {

    public ClinicaVeterinaria() {
    }

    
    
    public void mostrarPropietariosConMascota(ArrayList<Propietario> propietarios) {
    System.out.println("=== LISTADO DE PROPIETARIOS ===");
    for (Propietario p : propietarios) {
        System.out.println("Propietario: " + p.getNombre());
        for (Mascota m : p.getListaMascotas()) {
            System.out.println("  - " + m.getNombre() + " (ID: " + m.getId() + ")");
        }
    }
    
}
    
    public void mostrarConsultas(ArrayList<Consulta> consultas) {
    System.out.println("=== LISTADO DE CONSULTAS ===");
    for (Consulta c : consultas) {
        System.out.println("Consulta ID: " + c.getId());
        System.out.println("  - Mascota: " + c.getMascota().getNombre());
        System.out.println("  - Veterinario: " + c.getVeterinario().getNombre());
    }
}
    public void mostrarConsultasDesdeStrings(ArrayList<String> resumenConsultas) {
    System.out.println("=== LISTADO DE CONSULTAS ===");
    for (String linea : resumenConsultas) {
        System.out.println(linea);
    }
}
    
    public void mostrarMedicamentosDeConsulta(int idConsulta, String nombreMascota, ArrayList<Medicamento> listaMedicamentos) {
    System.out.println("=== MEDICAMENTOS RECETADOS ===");
    System.out.println("Consulta ID: " + idConsulta + " - Paciente: " + nombreMascota);
    for (Medicamento m : listaMedicamentos) {
        System.out.println("  * " + m.getNombre() + " - Dosis/Unidades: " + m.getUnidades());
    }
}
    
    
    public void errorMascotaRepetida(Propietario propietario, Mascota mascota)
    {
        System.out.println("El propietario "+ propietario.getNombre() + " ya es dueño de la mascota "+ mascota.getNombre()+ " con id: "+ mascota.getId());
    }
    
    public void errorMascotaTieneOtroPropietario(Propietario propietario, Mascota mascota){
        System.out.println("No se puede asignar de dueño a "+propietario.getNombre()+" para la mascota "+mascota.getNombre()+" con id "+mascota.getId()+" porque ya "+mascota.getPropietario().getNombre()+" es su dueño!");
    }
    
    public void errorMascotaNoEncontrada(Propietario propietario, Mascota mascota)
    {
        System.out.println("El propietario "+ propietario.getNombre() + " no es dueño de la mascota "+ mascota.getNombre()+ " con id: "+ mascota.getId());
    }
    
    public void msgMascotaAgregada(Propietario propietario, Mascota mascota)
    {
       System.out.println("El propietario "+ propietario.getNombre() + " ahora es dueño de la mascota "+ mascota.getNombre()+ " con id: "+ mascota.getId());
    }
    
    public void msgMascotaRemovida(Propietario propietario, Mascota mascota)
    {
       System.out.println("El propietario "+ propietario.getNombre() + " ya no es dueño de la mascota "+ mascota.getNombre()+ " con id: "+ mascota.getId());
    }
    
    public void errorAsociarVeterinarioEnConsulta(Veterinario veterinario, Consulta consulta)
    {
        System.out.println("El veterinario "+ veterinario.getNombre() + " ya esta atendiendo la consulta con id "+ consulta.getId());
    }
    
    public void msgVeterinarioRemovido(Veterinario veterinario, Consulta consulta)
    {
       System.out.println("El veterinario "+ veterinario.getNombre() + " ya no esta atendiendo la consulta con id "+ consulta.getId());
    }
    
    public void msgVeterinarioAgregado(Veterinario veterinario, Consulta consulta)
    {
       System.out.println("El veterinario "+ veterinario.getNombre() + " ahora esta atendiendo la consulta con id "+ consulta.getId());
    }
    
    public void errorConsultaNoAsignada(Veterinario veterinario, Consulta consulta)
    {
        System.out.println("El veterinario "+ veterinario.getNombre() + " no esta atendiendo la consulta con id "+ consulta.getId());
    }
    
    public void errorMascotaRepetidaEnConsulta(Consulta consulta, Mascota mascota)
    {
        System.out.println("La consulta con id: " + consulta.getId() + " ya tiene asignada a la mascota " + mascota.getNombre() + " con id: " + mascota.getId());
    }

    public void errorConsultaYaTieneMascota(Consulta consulta, Mascota mascota)
    {
        System.out.println("La consulta con id: " + consulta.getId() + " ya tiene una mascota asignada (" + mascota.getNombre() + " con id: " + mascota.getId() + ")");
    }

    public void errorMismaMascotaEnConsulta(Consulta consulta, Mascota mascota)
    {
        System.out.println("La consulta con id: " + consulta.getId() + " ya tiene registrada actualmente a la mascota " + mascota.getNombre() + " con id: " + mascota.getId());
    }

    public void errorConsultaSinMascota(Consulta consulta)
    {
        System.out.println("La consulta con id: " + consulta.getId() + " no tiene ninguna mascota asociada para remover");
    }

    public void msgMascotaAsignadaAConsulta(Consulta consulta, Mascota mascota)
    {
        System.out.println("La mascota " + mascota.getNombre() + " con id: " + mascota.getId() + " ahora esta asignada a la consulta con id: " + consulta.getId());
    }

    public void msgMascotaCambiadaEnConsulta(Consulta consulta, Mascota mascota)
    {
        System.out.println("Se cambio la mascota de la consulta con id: " + consulta.getId() + " por la mascota " + mascota.getNombre() + " con id: " + mascota.getId());
    }

    public void msgMascotaRemovidaDeConsulta(Consulta consulta, Mascota mascota)
    {
        System.out.println("La mascota " + mascota.getNombre() + " con id: " + mascota.getId() + " ya no esta asignada a la consulta con id: " + consulta.getId());
    }
    
    public void errorRecetarMedicamento(Medicamento medicamento, Consulta consulta)
    {
        System.out.println("La consulta con id "+ consulta.getId() + " ya tiene el medicamento "+ medicamento.getNombre() + " recetado.");
        System.out.println("Si deseas cambiar la dosis, usa su respectiva funcion.");
    }
    
    public void msgMedicamentoRecetado(Medicamento medicamento, Consulta consulta)
    {
       System.out.println("El medicamento "+ medicamento.getNombre() + " con dosis de "+ medicamento.getUnidades()+" fue recetado a la consulta con id: "+ consulta.getId());
    }
    
    public void errorMedicamentoNoEncontrado(Medicamento medicamento, Consulta consulta)
    {
        System.out.println("La consulta con id "+ consulta.getId() + " no tiene el medicamento "+ medicamento.getNombre() + " recetado.");
    }
    
    public void errorMedicamentoNoEncontradoPorString(String medicamento, Consulta consulta)
    {
        System.out.println("La consulta con id "+ consulta.getId() + " no tiene el medicamento "+ medicamento + " recetado.");
    }
    
    public void msgMedicamentoRemovido(Medicamento medicamento, Consulta consulta)
    {
       System.out.println("El medicamento "+ medicamento.getNombre() + " con dosis de "+ medicamento.getUnidades()+" fue removido de la consulta con id: "+ consulta.getId());
    }
    
    
    public void errorDosisInvalida()
    {
        System.out.println("El nuevo valor de dosis debe ser extrictamente un número entero positivo!");
    }
    
    public void msgMedicamentoDosisCambiada(Medicamento medicamento, Consulta consulta)
    {
       System.out.println("La dosis del medicamento "+ medicamento.getNombre() + " fue cambiada a "+ medicamento.getUnidades());
    }
}