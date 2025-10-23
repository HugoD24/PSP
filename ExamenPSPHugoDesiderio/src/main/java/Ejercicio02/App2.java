package Ejercicio02;

import java.io.*;
import java.util.ArrayList;

public class App2 {
    static void main() {

        String RUTA_APP1 = "C:\\Users\\alumno\\Desktop\\ExamenPSPHugoDesiderio\\src\\main\\java\\Ejercicio02\\App1.java";
        String nombreFichero = "20251023-Hugo.md";

        File fichero = new File(nombreFichero);
        boolean append = fichero.exists();

        try {
            ProcessBuilder pb = new ProcessBuilder("java", RUTA_APP1, nombreFichero);
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;

            FileWriter fw = new FileWriter(nombreFichero, append);



            while ((linea = br.readLine()) != null) {
                String[] usuarios = linea.split(" ");

                if (usuarios.length == 3) {
                    char[] contra = usuarios[3].toCharArray();

                    for (int i = 0; i < contra.length; i++) {
                        boolean contieneDIGI = false;
                        boolean contieneLETR = false;
                        if (Character.isDigit(contra[i])) {
                           contieneDIGI = true;
                        }
                        if (Character.isLetter(contra[i])) {
                            contieneLETR = true;
                        }

                        if (contieneLETR && contieneDIGI){
                            fw.write
                        }
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
