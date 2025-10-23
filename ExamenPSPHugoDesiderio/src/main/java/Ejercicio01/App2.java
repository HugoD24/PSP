package Ejercicio01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class App2 {

    static void main(String[] args) {

        String nombrefichero = args[0];

        try {
            ArrayList<String> usuariosAcce = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(nombrefichero));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] usuarios = linea.split("accedió al sistema el día");

                if (usuarios.length == 2) {
                    usuariosAcce.add(usuarios[0].trim());
                }
            }

            ArrayList<String> ultimos3 = new ArrayList<>();
            ultimos3.add(usuariosAcce.get(usuariosAcce.size()-2));
            ultimos3.add(usuariosAcce.get(usuariosAcce.size()-3));
            ultimos3.add(usuariosAcce.get(usuariosAcce.size()-4));


            Collections.sort(ultimos3);

            System.out.println("Número total de accesos: " + usuariosAcce.size());
            System.out.println("Ultimos 3 usuarios que han accedico: " + ultimos3.toString());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
