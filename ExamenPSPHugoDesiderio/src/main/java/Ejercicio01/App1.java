package Ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App1 {
    static void main(String[] args) {

        if(args.length!=2){
            System.out.println("Argumentos incorrectos");
            return;
        }

        String nombreFichero = args[0];
        String nomUser = args[1];

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formato);


        File fichero = new File(nombreFichero);
        boolean append = fichero.exists();

        try {
            FileWriter fw = new FileWriter(nombreFichero, append);
            fw.write(nomUser + " accedió al sistema el día" + fechaHora + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
