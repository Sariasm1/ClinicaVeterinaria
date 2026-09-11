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
public class Veterinario extends Persona {
    private ArrayList<Mascota> listaMascotas;
    private ArrayList<Consulta> listaConsultas;
    private int tarjetaProfesional;

    public Veterinario(int tarjetaProfesional, String nombre, int edad, String cedula, String direccion) {
        super(nombre, edad, cedula, direccion);
        this.tarjetaProfesional = tarjetaProfesional; 
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public int getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(int tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public void addListaMascotas(Mascota m){
        listaMascotas.add(m);
    }
    
    public void removeListaMascotas(Mascota m){
        listaMascotas.remove(m);
    }

    @Override
    public String toString() {
        return "Veterinario{" + "listaMascotas=" + listaMascotas + ", listaConsultas=" + listaConsultas + ", tarjetaProfesional=" + tarjetaProfesional + '}';
    }
    
    
    
}
