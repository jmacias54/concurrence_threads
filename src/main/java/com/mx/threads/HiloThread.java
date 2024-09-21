package com.mx.threads;

public class HiloThread extends Thread {

	public void run() {

		for(int i = 0; i <= 5; i++) {
			System.out.println(" ::: hilo :" + Thread.currentThread().getName() + " Hilo :" + i + "");
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("El Hilo se ha interrumpido!!!");
			}
		}
	}

	public static void main(String[] args) {
		HiloThread hiloThread1 = new HiloThread();
		HiloThread hiloThread2 = new HiloThread();

		hiloThread1.start();
		hiloThread2.start();

	}


}
