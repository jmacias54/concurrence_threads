package com.mx.threads;

public class HiloRunnable implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.println(" ::: Runnable hilo :" + Thread.currentThread().getName() + " Hilo :" + i + "");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("El Hilo Runnable se ha interrumpido!!!");
			}
		}
	}

	public static void main(String[] args) {
		HiloRunnable hiloRunnable1 = new HiloRunnable();
		HiloRunnable hiloRunnable2 = new HiloRunnable();

		Thread thread1 = new Thread(hiloRunnable1);
		Thread thread2 = new Thread(hiloRunnable2);

		thread1.start();
		thread2.start();

	}
}
