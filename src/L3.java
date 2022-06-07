import static java.lang.System.out;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class L3 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] temp = new int[101];
        int dsrTemp1 = 0;
        int dsrTemp2 = 0;
        int dsrTemp3 = 0;
        int tempSum1 = 0;
        int tempSum2 = 0;
        int tempSum3 = 0;
        for (int num = 1; num < 51; num++) { //запуск процесса моделировани€ через масив потоков - греем пластину от
            // центра до кра€, радиус пластины 50
            final int flowNum = num;
            new Thread(() -> write(flowNum)).start();
            int t = (int)(Math.random()*(76)+25); // выборка дл€ случайного значени€ температуры

            temp[num] = t; // присваиваем каждому элементу дл€ массива температур случайное значение с дипазона
            tempSum1 += temp[num]/25;
            tempSum2 += temp[num]/50;
            tempSum3 += temp[num]/75;
            dsrTemp1 += temp[num]*0.5/25; //дисперси€ разброса температуры дл€ мат. ожидани€ 0,5
            dsrTemp2 += temp[num]*0.5/50; //дисперси€ разброса температуры дл€ мат. ожидани€ 0,5
            dsrTemp3 += temp[num]*0.5/75; //дисперси€ разброса температуры дл€ мат. ожидани€ 0,5

        }
        PrintStream listOut = new PrintStream("L3.txt");//запускаем запись в файл наших даных
        listOut.println("¬ывод среднего значени€ температуры дл€ 3-х точек сьема: ");
        listOut.print("t (t2 - t1) = " + tempSum1 / 25);
        listOut.print("\t ");
        listOut.print("t (t3 - t2) = " + tempSum2 / 25);
        listOut.print("\t ");
        listOut.print("t (t4 - t3) = " + tempSum3 / 25);
        listOut.println();
        listOut.println();
        listOut.println("¬ывод дисперсии пол€ температуры дл€ 3-х точек сьема: ");
        listOut.print("dsrTemp1 = " + dsrTemp1);
        listOut.print("\t ");
        listOut.print("dsrTemp2 = " + dsrTemp2);
        listOut.print("\t ");
        listOut.print("dsrTemp3 = " + dsrTemp3);
        listOut.print("\t ");
        listOut.println();
        listOut.println();
        listOut.println("¬ывод масива температур: ");
        for (int i = 1; i < 51; i++) {
            listOut.print("t" + i);
            listOut.print(" " + temp[i]);
            listOut.println("\n ");
        }

    }
    public static void write(int num) {
        out.println("ѕоток номер " + num + " отработал");
    }
}


