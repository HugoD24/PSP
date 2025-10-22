package NumerosAleatorios;

public class App1 {
    public static void main(String[] args) {

        for (int i = 1; i <= 30; i++) {
            System.out.println(rand(0,100));
        }
    }

    private static int rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
