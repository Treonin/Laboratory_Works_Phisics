import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.out;

public class L1 {
    public static void main(String[] args) throws IOException{
        double xAxis[] = new double[101]; // масив переменных смещения по координате х
        double yAxis[] = new double[101]; // масив переменных смещения по координате y
        double zAxis[] = new double[101]; // масив переменных смещения по координате z
        double dsrX = 0;
        double dsrY = 0;
        double dsrZ = 0;
        for (int num = 1; num < 101; ++num) { //запуск процесса моделирования через масив потоков
            final int flowNum = num;
            new Thread(() -> write(flowNum)).start();
            double x = Math.random() * 0.05 + 0.001; // выборка для координаты перемещения х
            double y = Math.random() * 0.05 + 0.001; // выборка для координаты перемещения y
            double z = Math.random() * 0.05 + 0.001; // выборка для координаты перемещения z
            xAxis[num] = x; // присваиваем каждому элементу для координаты x массива случайное значение с дипазона
            yAxis[num] = y; // присваиваем каждому элементу для координаты y массива случайное значение с дипазона
            zAxis[num] = z; // присваиваем каждому элементу для координаты z массива случайное значение с дипазона
            dsrX += xAxis[num]*0.01; //дисперсия по координате x для мат. ожидания 0,01
            dsrY += yAxis[num]*0.01; //дисперсия по координате y для мат. ожидания 0,01
            dsrZ += zAxis[num]*0.01; //дисперсия по координате z для мат. ожидания 0,01
        }
        PrintStream listOut = new PrintStream("L1.txt");//запускаем запись в файл наших даных
            listOut.println("Вывод среднего значения смещения частички между 1-м и 25-м циклом: ");
            listOut.printf("d (x2 - x1) = %,.4f\n", (xAxis[25] - xAxis[1]) / 25);
            listOut.print("\t");
            listOut.printf("d (y2 - y1) = %,.4f\n", (yAxis[25] - yAxis[1]) / 25);
            listOut.print("\t");
            listOut.printf("d (z2 - z1) = %,.4f\n", (zAxis[25] - zAxis[1]) / 25);
            listOut.println();
            listOut.println();
            listOut.println("Вывод среднего значения смещения частички между 25-м и 50-м циклом: ");
            listOut.printf("d (x3 - x2) = %,.4f\n", (xAxis[50] - xAxis[25]) / 25);
            listOut.print("\t");
            listOut.printf("d (y3 - y2) = %,.4f\n", (yAxis[50] - yAxis[25]) / 25);
            listOut.print("\t");
            listOut.printf("d (z3 - z2) = %,.4f\n", (zAxis[50] - zAxis[25]) / 25);
            listOut.println();
            listOut.println();
            listOut.println("Вывод среднего значения смещения частички между 50-м и 75-м циклом: ");
            listOut.printf("d (x4 - x3) = %,.4f\n", (xAxis[75] - xAxis[50]) / 25);
            listOut.print("\t");
            listOut.printf("d (y4 - y3) = %,.4f\n", (yAxis[75] - yAxis[50]) / 25);
            listOut.print("\t");
            listOut.printf("d (z4 - z3) = %,.4f\n", (zAxis[75] - zAxis[50]) / 25);
            listOut.println();
            listOut.println();
            listOut.println("Вывод дисперсии значений координат частички за цикл моделированния: ");
            listOut.printf("dsrX = %,.4f\n", dsrX);
            listOut.print("\t");
            listOut.printf("dsrY = %,.4f\n", dsrY);
            listOut.print("\t");
            listOut.printf("dsrZ = %,.4f\n", dsrZ);
            listOut.println();
            listOut.println();
            listOut.println("Вывод массива координат смещения частички: ");
        for (int i = 1; i < 101; i++) {
            listOut.print(i);
            listOut.printf("x = %,.4f\n", xAxis[i]);
            listOut.print("\t");
            listOut.print(i);
            listOut.printf("y = %,.4f\n", yAxis[i]);
            listOut.print("\t");
            listOut.print(i);
            listOut.printf("z = %,.4f\n", xAxis[i]);
            listOut.println();
        }

    }
    public static void write(int num) {
        out.println("Поток номер " + num + " отработал");
    }
}




