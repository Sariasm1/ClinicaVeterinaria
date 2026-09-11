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
    
    public void errorMascotaNoEncontrada(Propietario propietario, Mascota mascota)
    {
        System.out.println("El propietario "+ propietario.getNombre() + " no es dueño de la mascota con id: "+ mascota.getId());
    }
    
    public void errorAsociarVeterinarioEnConsulta(Veterinario veterinario, Consulta consulta)
    {
        System.out.println("El veterinario "+ veterinario.getNombre() + " ya esta atendiendo la consulta con id "+ consulta.getId());
    }
    
        public void errorConsultaNoAsignada(Veterinario veterinario, Consulta consulta)
    {
        System.out.println("El veterinario "+ veterinario.getNombre() + " no esta atendiendo la consulta con id "+ consulta.getId());
    }
    
    public void errorRecetarMedicamento(Medicamento medicamento, Consulta consulta)
    {
        System.out.println("La consulta con id "+ consulta.getId() + " ya tiene el medicamento "+ medicamento.getNombre() + " recetado.");
        System.out.println("Si deseas cambiar la dosis, usa su respectiva funcion.");
    }
    
    public void errorMedicamentoNoEncontrado(Medicamento medicamento, Consulta consulta)
    {
        System.out.println("La consulta con id "+ consulta.getId() + " no tiene el medicamento "+ medicamento.getNombre() + " recetado.");
    }
    
    public void errorMedicamentoNoEncontradoPorString(String medicamento, Consulta consulta)
    {
        System.out.println("La consulta con id "+ consulta.getId() + " no tiene el medicamento "+ medicamento + " recetado.");
    }
    
    
    public void errorDosisInvalida()
    {
        System.out.println("El nuevo valor de dosis debe ser extrictamente un número entero positivo!");
    }
}
