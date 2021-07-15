import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int sumValues(int[] value) {
        int sum = 0;
        for (Integer i : value) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int START = 0;
        int arraySize = 231231318;
        int[] array = generateArray(arraySize);

        long startTime = System.currentTimeMillis();

        System.out.println("Сумма всех чисел массива: " + sumValues(array));

        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения: " + (endTime - startTime));

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        long startTime1 = System.currentTimeMillis();

        ArraysSumm arraysSumm = new ArraysSumm(array, START, arraySize);

        System.out.println("Сумма всех чисел массива: " + forkJoinPool.invoke(arraysSumm));

        long endTime1 = System.currentTimeMillis();

        System.out.println("Время выполнения: " + (endTime1 - startTime1));
    }
}
