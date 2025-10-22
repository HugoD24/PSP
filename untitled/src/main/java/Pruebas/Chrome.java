package Pruebas;

import java.io.File;
import java.io.IOException;

public class Chrome {
    public static void main(String[] args) {
        // Obtengo el sistema operativo
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();
        String comando;
        ProcessBuilder pb;

        if (sistemaOperativo.contains("windows")) {
        // Una de las rutas donde puede estar instalado Google Chrome
            comando = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        File fichero = new File (comando);

        //Si no existe en esa ruta pruebo es muy probable que esté en esta otra opción.
        if (!fichero.exists()) {
        comando = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        }
            pb = new ProcessBuilder(comando.split("\\s"));
        } else {
            pb = new ProcessBuilder( "open", "-a", "Google Chrome");
        }
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Ejemplo rapido
        File archivo = new File("C:\\Users\\Usuario\\Documents\\ejemplo.txt");

        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("¿Existe?: " + archivo.exists());
        System.out.println("¿Es archivo?: " + archivo.isFile());
        System.out.println("¿Es carpeta?: " + archivo.isDirectory());
        System.out.println("Directorio por defecto -> "+ System.getProperty("user.dir"));

    }
}
