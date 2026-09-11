/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Consulta {
    private Veterinario veterinario;
    private int id;
    private Mascota mascota;
    private ArrayList<Medicamento> listaMedicamentos;

    public Consulta(Veterinario veterinario, int id, Mascota mascota) {
        this.id = id;
        this.mascota = mascota;
        this.listaMedicamentos =  new ArrayList<>();
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void addListaMedicamento(Medicamento m) {
        this.listaMedicamentos.add(m);
    }
    
    public void removeListaMedicamento(Medicamento m){
        this.listaMedicamentos.remove(m);
    }

    @Override
    public String toString() {
        return "Consulta{" + "veterinario=" + veterinario + ", id=" + id + ", mascota=" + mascota + ", listaMedicamentos=" + listaMedicamentos + '}';
    }
    
    
    
    
    
}
