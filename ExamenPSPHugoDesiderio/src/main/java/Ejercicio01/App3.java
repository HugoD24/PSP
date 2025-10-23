package Ejercicio01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App3 {

    static void main() {

        String[] usuarios = {"Hugo","Guillermo","Paco","Borja"};


        String RUTA_APP1 = "C:\\Users\\alumno\\Desktop\\ExamenPSPHugoDesiderio\\src\\main\\java\\Ejercicio01\\App1.java";
        String nombreFichero = "RegistroDeAccesos";

        String RUTA_APP2 = "C:\\Users\\alumno\\Desktop\\ExamenPSPHugoDesiderio\\src\\main\\java\\Ejercicio01\\App2.java";

        int numeroLlamadas = rand(3,6);

        String ultimoUser = "";

        for (int i = 0; i < numeroLlamadas; i++) {

            String userElegido = usuarios[rand(0,4)];

            if(userElegido.equals(ultimoUser)){
                userElegido = usuarios[rand(0,4)];
            }else {
                ultimoUser = userElegido;
            }

            ProcessBuilder pb = new ProcessBuilder("java", RUTA_APP1, nombreFichero , userElegido);
            try {
                Process p = pb.start();

                p.waitFor();
                Thread.sleep(1000);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            ProcessBuilder pb2 = new ProcessBuilder("java", RUTA_APP2, nombreFichero);
            Process p2 = pb2.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String line = null;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
            }



    }

    private static int rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
