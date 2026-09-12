/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class Veterinaria {
    private String nombreVeterinaria;
    private int nit;
    private String direccion;
    private ArrayList<Propietario> listaPropietarios;
    private ArrayList<Veterinario> listaVeterinarios;
    private ArrayList<Consulta> listaConsultas;   

    public Veterinaria(String nombreVeterinaria, int nit, String direccion) {
        this.nombreVeterinaria = nombreVeterinaria;
        this.nit = nit;
        this.direccion = direccion;
        listaPropietarios = new ArrayList<>();
        listaVeterinarios = new ArrayList<>();
        listaConsultas = new ArrayList<>();
    }

    public String getNombreVeterinaria() {
        return nombreVeterinaria;
    }

    public int getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public ArrayList<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setNombreVeterinaria(String nombreVeterinaria) {
        this.nombreVeterinaria = nombreVeterinaria;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void addListaPropietarios(Propietario p){
        listaPropietarios.add(p);
    }
    
    public void addListaVeterinarios(Veterinario v){
        listaVeterinarios.add(v);
    }
    
    public void addListaConsultas(Consulta c){
        listaConsultas.add(c);
    }
    
    public void removeListaPropietarios(Propietario p){
        listaPropietarios.remove(p);
    }
    
    public void removeListaVeterinarios(Veterinario v){
        listaVeterinarios.remove(v);
    }
    
    public void removeListaConsultas(Consulta c){
        listaConsultas.remove(c);
    }
    
}
