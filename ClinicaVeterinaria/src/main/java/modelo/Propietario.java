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
public class Propietario extends Persona {
    private ArrayList<Mascota> listaMascotas;

    public Propietario(String nombre, int edad, String cedula, String direccion) {
        listaMascotas = new ArrayList<>();
        super(nombre, edad, cedula, direccion);
    }

    public void addListaMascotas(Mascota m){
        this.listaMascotas.add(m);
    }
    
     public void removeListaMascotas(Mascota m){
        this.listaMascotas.remove(m);
    }
     
    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    
    
}
