/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rs662
 */
public class SingletonPedido {
    private static SingletonPedido instanciaUnica;
    private Pedido pedidoActual;

    // Constructor privado para evitar que creen objetos con 'new GestorPedido()'
    private SingletonPedido() {
        this.pedidoActual = new Pedido();
    }

    // Método estático para obtener la única instancia
    public static SingletonPedido getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new SingletonPedido();
        }
        return instanciaUnica;
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    public void setPedidoActual(Pedido pedidoActual) {
        this.pedidoActual = pedidoActual;
    }

    // Reinicia el pedido si el usuario quiere hacer uno nuevo
    public void reiniciarPedido() {
        this.pedidoActual = new Pedido();
    }
}
    

