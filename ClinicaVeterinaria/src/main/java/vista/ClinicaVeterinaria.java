/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;
import modelo.*;

/**
 *
 * @author Estudiante
 */
public class ClinicaVeterinaria {

    public ClinicaVeterinaria() {
    }
    
    
    
    public void errorMascotaRepetida(Propietario propietario, Mascota mascota)
    {
        System.out.println("El propietario "+ propietario.getNombre() + " ya es dueño de una mascota con id: "+ mascota.getId());
    }
    
    public void errorAsociarVeterinarioEnConsulta(Veterinario veterinario, Consulta consulta)
    {
        System.out.println("El veterinario "+ veterinario.getNombre() + " ya esta atendiendo la consulta con id "+ consulta.getId());
    }
}
