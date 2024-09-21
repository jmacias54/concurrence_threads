package com.mx.barbershop.hilos;

import com.mx.barbershop.model.Cliente;
import com.mx.barbershop.model.Peluqueria;

import java.util.Random;

public class Barber implements Runnable {

	private final Peluqueria peluqueria;
	private final String name;

	public Barber(Peluqueria peluqueria, String name) {
		this.peluqueria = peluqueria;
		this.name = name;
	}

	@Override
	public void run() {

		Random random = new Random();
		try {
			while (true) {
				Cliente cliente = peluqueria.obtenerCliente();

				System.out.println(name + " comienza a atender a " + cliente.getName());
				int tiempoAtencion = random.nextInt(10) + 1;

				Thread.sleep(tiempoAtencion * 1000);

				System.out.println(name + " ha terminado de atender a " + cliente.getName() +
					" en " + tiempoAtencion + " segundos.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
