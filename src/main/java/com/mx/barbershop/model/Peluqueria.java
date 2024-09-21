package com.mx.barbershop.model;

import com.mx.barbershop.hilos.Barber;

import java.util.LinkedList;
import java.util.Queue;

public class Peluqueria {

	private static final int TOTAL_BARBEROS = 3;
	private static final int TOTAL_CLIENTES = 10;
	private Queue<Cliente> colaClientes = new LinkedList<>();
	Object lock = new Object();
	private Thread[] barberos;

	public Peluqueria() {
		/* aqui al arreglo de hilos se le van agregando los runnable de cada barbero de TOTAL_BARBEROS */
		barberos = new Thread[TOTAL_BARBEROS]; // se define un arreglo de hilos con un tamaño
		for(int i = 0; i < barberos.length; i++) {
			// se agrega a cada hilo el runnable de cada barbero
			barberos[i] = new Thread(new Barber(this, "Barber-" + (i + 1)));

		}
	}

	public void iniciar() {
		/* aqui se inician o crean los barberos */
		for(Thread barber : barberos) {
			barber.start();
		}

		/* se van agregado los clientes a Queue Clientes */
		for(int i = 1; i <= TOTAL_CLIENTES; i++) {
			Cliente cliente = new Cliente("CLIENT" + i);
			addCliente(cliente);
		}
	}

	public void addCliente(Cliente cliente) {
		synchronized(lock) {
			colaClientes.offer(cliente);
			lock.notify();
		}
	}

	public Cliente obtenerCliente() throws InterruptedException {
		synchronized(lock) {
			while(colaClientes.isEmpty()) {
				lock.wait();
			}
			return colaClientes.poll();
		}
	}
}
