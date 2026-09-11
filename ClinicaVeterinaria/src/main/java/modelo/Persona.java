/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santi
 */
public abstract class Persona {
    private String nombre;
    private int edad;
    private String cedula;
    private String direccion;

    public Persona(String nombre, int edad, String cedula, String direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public Persona() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", cedula=" + cedula + ", direccion=" + direccion + '}';
    }
    
    
    
}
