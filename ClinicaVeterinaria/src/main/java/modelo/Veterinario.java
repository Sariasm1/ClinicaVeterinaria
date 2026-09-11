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
    private ArrayList<Consulta> listaConsultas;
    private int tarjetaProfesional;

    public Veterinario(int tarjetaProfesional, String nombre, int edad, String cedula, String direccion) {
        super(nombre, edad, cedula, direccion);
        this.tarjetaProfesional = tarjetaProfesional; 
        listaConsultas = new ArrayList<>();
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }
    
    public void addListaConsultas(Consulta c){
        listaConsultas.add(c);
    }
    
    public void removeListaConsultas(Consulta c){
        listaConsultas.remove(c);
    }

    public int getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(int tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "listaConsultas=" + listaConsultas + ", tarjetaProfesional=" + tarjetaProfesional + '}';
    }


   
    
}
