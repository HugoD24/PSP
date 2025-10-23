package ejercicio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Aplicacion2 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Aplicacion2 <nombreArchivo>");
            return;
        }
        String nombreArchivo = args[0];
        String fechaMax= "";
        Double tempMax = Double.NEGATIVE_INFINITY;

        try {

            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine())!= null){
                String[] datos = linea.split("-");

                if (datos.length == 2){
                    String fecha = datos[0].trim();
                    double temp = Double.parseDouble(datos[1].trim());

                    if (temp > tempMax){
                        tempMax = temp;
                        fechaMax = fecha;
                    }
                }
            }
            if (!fechaMax.isEmpty()) {
                System.out.println("La mayor temperatura fue de " + tempMax + "°C el día " + fechaMax);
            } else {
                System.out.println("No se encontraron datos válidos en el fichero.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en el formato del archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
