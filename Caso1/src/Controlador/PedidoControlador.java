/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Combo;
import Modelo.PersonalizacionOpcion;
import Modelo.SingletonPedido;
import Modelo.Pedido;
import Vista.BembosPedidos;

import java.util.ArrayList;
import java.util.List;

public class PedidoControlador {

    private BembosPedidos vista;

    
    public PedidoControlador(BembosPedidos vista) {
        this.vista = vista;
    }

 
    private Pedido getPedidoActual() {
        return SingletonPedido.getInstancia().getPedidoActual();
    }

   
    public void seleccionarCombo(String nombre, String descripcion, double precio) {
        Combo combo = new Combo(nombre, descripcion, precio);
        getPedidoActual().setComboSeleccionado(combo);
    }

    
    public void registrarPapas() {
        PersonalizacionOpcion papa = null;

        if (vista.RbRegulares.isSelected()) {
            papa = new PersonalizacionOpcion("Papas Fritas Regulares", 0.0);
        } else if (vista.RbMedianas.isSelected()) {
            papa = new PersonalizacionOpcion("Papas Fritas Medianas", 2.00);
        } else if (vista.RbGrandes.isSelected()) {
            papa = new PersonalizacionOpcion("Papas Fritas Grandes", 4.00);
        } else if (vista.RbFamiliares.isSelected()) {
            papa = new PersonalizacionOpcion("Papas Fritas Familiares", 6.00);
        }

        getPedidoActual().setPapaSeleccionada(papa);
    }

    
    public void registrarBebida() {
        String bebidaNombre = (String) vista.CmbBebidas.getSelectedItem();
        PersonalizacionOpcion bebida = new PersonalizacionOpcion(bebidaNombre, 0.0);
        getPedidoActual().setBebidaSeleccionada(bebida);
    }


    public void registrarExtras() {
        List<PersonalizacionOpcion> extras = new ArrayList<>();

        if (vista.ChkSundae.isSelected()) {
            extras.add(new PersonalizacionOpcion("Sundae Chocolúcuma Vainilla", 7.00));
        }
        if (vista.ChkSalchipapa.isSelected()) {
            extras.add(new PersonalizacionOpcion("Salchipapa", 10.00));
        }
        if (vista.ChkNuggets.isSelected()) {
            extras.add(new PersonalizacionOpcion("6 Nuggets", 12.00));
        }
        if (vista.ChkCheeseFingers.isSelected()) {
            extras.add(new PersonalizacionOpcion("4 Cheese Fingers", 13.00));
        }
        if (vista.ChkNuggetspapa.isSelected()) {
            extras.add(new PersonalizacionOpcion("Nuggetspapa", 15.00));
        }

        getPedidoActual().setListaExtras(extras);
    }


    public void mostrarResumenPedido() {
        String resumenTexto = getPedidoActual().toString();
        vista.TxtAreResumen.setText(resumenTexto);
    }


    public double obtenerTotal() {
        return getPedidoActual().calcularTotal();
    }
}
