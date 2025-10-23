package Ejercicio02;

import java.util.Scanner;

public class App1 {
    static void main() {

        Scanner sc = new Scanner(System.in);

        int numUser;

        System.out.println("Cuantos usuarios quieres dar de alta? ");
        numUser = sc.nextInt();


        for (int i = 1; i <= numUser; i++) {
            System.out.println("Introduce el nickname del user " + i);
            String nickname = sc.next();
            System.out.println("Introduce la fecha de nacimiento del user " + i);
            String fechaNac = sc.next();
            System.out.println("Introduce la contraseña del user " + i);
            String contra = sc.next();
            System.out.println(nickname + " " + fechaNac + " " + contra);
        }

    }
}
