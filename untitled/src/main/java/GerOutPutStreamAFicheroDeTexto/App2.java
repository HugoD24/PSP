package GerOutPutStreamAFicheroDeTexto;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int suma = 0;

            while (sc.hasNextInt()) {
                suma += sc.nextInt();
            }

        System.out.println(suma);
    }
}
