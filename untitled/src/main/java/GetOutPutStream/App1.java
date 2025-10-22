package GetOutPutStream;

import java.io.*;
import java.util.ArrayList;

/*Vamos a crear dos pequeñas aplicaciones. La aplicación que va a
funcionar como hijo en este caso va a ser sumador, va a estar
recibiendo enteros y cuando deje de recibirlos va a sumarlos y
devolver el resultado.
 La aplicación que va a funcionar como padre va a generar 5
números aleatorios entre el 1 y el 30, se los va a enviar y luego va a
recibir la respuesta.
*/


public class App1 {
    public static void main(String[] args) {

        String RUTA = "D:\\HUGO\\RepasoPSP\\PSP\\untitled\\src\\main\\java\\GetOutPutStream\\App2.java";
        ProcessBuilder pb = new ProcessBuilder("java",RUTA);
        ArrayList<Integer> numeros = new ArrayList<>();

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

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String respuesta = br.readLine();

            System.out.println("El resultado de sumar: ");
            for (int i = 0; i < numeros.size()-1; i++) {
                System.out.print(numeros.get(i) + " + ");
            }
            System.out.println(numeros.get(numeros.size()-1) + " es: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
