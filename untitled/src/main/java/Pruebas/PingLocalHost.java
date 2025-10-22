package Pruebas;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PingLocalHost {
    public static void main(String[] args) {
        try {
            // Creamos el ProcessBuilder para ejecutar "ping localhost"
            ProcessBuilder pb = new ProcessBuilder("ping", "localhost");
            Process procesoPing = pb.start();

            System.out.println("Ping iniciado...");

            // Esperamos hasta 15 segundos a que termine el ping
            boolean terminoSolo = procesoPing.waitFor(15, TimeUnit.SECONDS);

            if (terminoSolo) {
                // El ping terminó por sí solo antes de los 15 segundos
                System.out.println("El proceso de ping terminó antes de los 15 segundos.");
            } else {
                // No terminó solo: nuestro programa lo cierra
                procesoPing.destroy(); // mata el proceso de ping
                System.out.println("Tiempo límite alcanzado: el programa ha cerrado el ping.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
