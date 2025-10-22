package Pruebas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsoAppend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Quieres añadir al archivo (append)? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();

        // Si el usuario escribe "s", activamos el modo append (true)
        boolean append = respuesta.equals("s");

        System.out.print("Escribe el texto que quieres guardar: ");
        String texto = sc.nextLine();

        try (FileWriter fw = new FileWriter("mensaje.txt", append)) {
            fw.write(texto + "\n");
            System.out.println("Texto guardado correctamente en el archivo 'mensaje.txt'.");
            if (append) {
                System.out.println("Se ha añadido al final del archivo (modo append).");
            } else {
                System.out.println("Se ha sobrescrito el contenido anterior.");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
