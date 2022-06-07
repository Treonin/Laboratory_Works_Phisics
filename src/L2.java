import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.out;
public class L2 {
    public static void main(String[] args) throws IOException {
        final int N = 101;
        double xAndy[][] = new double[N][N];
        double yAndz[][] = new double[N][N];
        double xAndz[][] = new double[N][N];
        double dsrX = 0;
        double dsrY = 0;
        double dsrZ = 0;
        for (int num = 1; num < 101; num++) {
            for (int num1 = 1; num1 < 101; num1++) { //запуск процесса моделирования через масив потоков

                double x = Math.random() * 0.05 + 0.001; // выборка для координаты перемещения х
                double y = Math.random() * 0.05 + 0.001; // выборка для координаты перемещения y
                double z = Math.random() * 0.05 + 0.001; // выборка для координаты перемещения z


                xAndy[num][num1] = x; // присваиваем каждому элементу для координаты x массива случайное значение с дипазона
                yAndz[num][num1] = y; // присваиваем каждому элементу для координаты y массива случайное значение с дипазона
                xAndz[num][num1] = z; // присваиваем каждому элементу для координаты z массива случайное значение с дипазона
            }
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i == j) xAndy[i][j] = xAndy[i][j];
                else xAndy[i][j] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                out.printf("%,.4f\n", xAndy[i][j]);
            out.print("%,.4f\n");
        }
        PrintStream listOut = new PrintStream("L2.txt");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                listOut.print(i);
                listOut.printf("x = %,.4f\n", xAndy[i][j]);
                listOut.print("\t");
            }

    }
}
