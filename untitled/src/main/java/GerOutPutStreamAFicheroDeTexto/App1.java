package GerOutPutStreamAFicheroDeTexto;

import java.io.*;
import java.util.ArrayList;

public class App1 {
    public static void main(String[] args) {

        String RUTA = "D:\\HUGO\\RepasoPSP\\PSP\\untitled\\src\\main\\java\\GetOutPutStream\\App2.java";
        ProcessBuilder pb = new ProcessBuilder("java",RUTA);
        ArrayList<Integer> numeros = new ArrayList<>();

        String rutaFichero = "resultado.txt";
        File ficheroSalida = new File(rutaFichero);
        pb.redirectOutput(ficheroSalida);

        try {
            Process p = pb.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

            //Enviar numeros
            for (int i = 0; i < 5 ; i++) {
                int numero = rand(0,5);
                bw.write(numero + "\n");
                numeros.add(numero);
            }
            bw.flush();
            bw.close();

            //Importante esperar a que el proceso hijo termine de leer el dato del fichero
            p.waitFor();

            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String respuesta = br.readLine();

            System.out.println("El resultado de sumar: ");
            for (int i = 0; i < numeros.size()-1; i++) {
                System.out.print(numeros.get(i) + " + ");
            }
            System.out.println(numeros.get(numeros.size()-1) + " es: " + respuesta);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
