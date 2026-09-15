/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rs662
 */
public class Pedido {
    private Combo comboSeleccionado;
    private PersonalizacionOpcion papaSeleccionada;
    private PersonalizacionOpcion bebidaSeleccionada;
    private List<PersonalizacionOpcion>listaExtras;
    
    public Pedido() {
        this.listaExtras = new ArrayList<>();
    }
    

    public Combo getComboSeleccionado() {
        return comboSeleccionado;
    }

    public void setComboSeleccionado(Combo comboSeleccionado) {
        this.comboSeleccionado = comboSeleccionado;
    }

    public PersonalizacionOpcion getPapaSeleccionada() {
        return papaSeleccionada;
    }

    public void setPapaSeleccionada(PersonalizacionOpcion papaSeleccionada) {
        this.papaSeleccionada = papaSeleccionada;
    }

    public PersonalizacionOpcion getBebidaSeleccionada() {
        return bebidaSeleccionada;
    }

    public void setBebidaSeleccionada(PersonalizacionOpcion bebidaSeleccionada) {
        this.bebidaSeleccionada = bebidaSeleccionada;
    }

    public List<PersonalizacionOpcion> getListaExtras() {
        return listaExtras;
    }

    public void setListaExtras(List<PersonalizacionOpcion> listaExtras) {
        this.listaExtras = listaExtras;
    }
    public double calcularTotal() {
        double total = 0.0;
        if (comboSeleccionado != null) {
            total += comboSeleccionado.getPrecioBase();
        }
        if (papaSeleccionada != null) {
            total += papaSeleccionada.getPrecio();
        }
        if (bebidaSeleccionada != null) {
            total += bebidaSeleccionada.getPrecio();
        }
        if (listaExtras != null) {
            for (PersonalizacionOpcion extra : listaExtras) {
                total += extra.getPrecio();
            }
        }
        return total;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RESUMEN DEL PEDIDO ===\n");
        sb.append("Combo: ").append(comboSeleccionado != null ? comboSeleccionado.getNombre() : "Ninguno").append("\n");
        sb.append("Papas: ").append(papaSeleccionada != null ? papaSeleccionada.getNombre() : "Ninguno").append("\n");
        sb.append("Bebida: ").append(bebidaSeleccionada != null ? bebidaSeleccionada.getNombre() : "Ninguno").append("\n");
        sb.append("Extras: ");
        if (listaExtras != null && !listaExtras.isEmpty()) {
            for (int i = 0; i < listaExtras.size(); i++) {
                sb.append(listaExtras.get(i).getNombre());
                if (i < listaExtras.size() - 1) sb.append(", ");
            }
        } else {
            sb.append("Ninguno");
        }
        sb.append("\nTOTAL A PAGAR: S/. ").append(calcularTotal());
        return sb.toString();
    }
    
            
    
}
