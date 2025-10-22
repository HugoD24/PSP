package Pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pruebas {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("calc");
        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        pb.inheritIO(); //hace que el hijo muestre la misma consola que el padre, hereda entrada System.in, salida  System.out y errores System.err

        pb.redirectOutput(new File("salida.txt")); //Redirige todo lo que el proceso imprima por pantalla (su salida estándar, stdout) a un archivo llamado salida.txt

        pb.redirectError(new File("errores.txt")); //Redirige los mensajes de error

        pb.redirectInput(new File("entrada.txt")); //Hace que el proceso lea desde un archivo (como si fuera System.in)

        //pb.waitFor(); //Espera a que termine el proceso

        //pb.exitValue(); //Devuelve el código de salida (0 = OK)

       // pb.getInputStream(); //Lee la salida del proces (si no usas inheritIO())


      /*  try (BufferedReader br = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("→ " + linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


//        int exitValue(); Código de finalización devuelto por el proceso hijo.
//          Boolean isAlive() → Comprueba si el proceso todavía está en ejecución
//        Boolean isAlive() → Comprueba si el proceso todavía está en ejecución


    }
}
