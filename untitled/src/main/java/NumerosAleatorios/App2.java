package NumerosAleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class App2 {
    public static void main(String[] args) {
        String RUTA = "D:\\HUGO\\RepasoPSP\\PSP\\untitled\\src\\main\\java\\NumerosAleatorios\\App1.java";

        ProcessBuilder pb = new ProcessBuilder("java",RUTA);
        pb.redirectErrorStream(true);

        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            ArrayList<Integer> numeros = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }

            br.close();

            Collections.sort(numeros);

            System.out.println("Numeros recibidos y ordenados: ");
            for (int i = 0; i < numeros.size(); i++) {
                System.out.println(numeros.get(i));
            }

            p.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
