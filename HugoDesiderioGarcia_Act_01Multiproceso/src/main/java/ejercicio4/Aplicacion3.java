package ejercicio4;

import java.io.File;
import java.io.IOException;

public class Aplicacion3 {
    public static void main(String[] args) {

        String tempMin = "10";
        String tempMax = "30";
        String ficheroNom = "temperaturas.txt";
        String RUTA_APP1 = "D:\\HUGO\\Proyectos_2DAM\\2_DAM\\PSP\\HugoDesiderio_Act_01Multiproceso\\HugoDesiderioGarcia_Act_01Multiproceso\\src\\main\\java\\ejercicio4\\Aplicacion1.java";

        File fichero = new File(ficheroNom);
        fichero.delete();

        for (int i = 1; i <= 4; i++) {
            try {
                Process p1 = new ProcessBuilder("java",RUTA_APP1,tempMin, tempMax, ficheroNom ).inheritIO().start();

                p1.waitFor();
                Thread.sleep(1000);


                Process p2 = new ProcessBuilder("java", ficheroNom).inheritIO().start();
                p2.waitFor();

            } catch (IOException | InterruptedException e) {
                System.out.println("Error ejecutando aplicaciones: " + e.getMessage());
            }
        }
    }
}
