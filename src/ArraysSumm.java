import java.util.concurrent.RecursiveTask;

public class ArraysSumm extends RecursiveTask<Integer> {
    final int[] array;
    final int start;
    final int end;

    public ArraysSumm(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int forkTaskAndGetResult() {
        final int middle = (end - start) / 2 + start;
        ArraysSumm arraysSumm = new ArraysSumm(array, start, middle);
        ArraysSumm arraysSumm1 = new ArraysSumm(array, middle, end);
        invokeAll(arraysSumm, arraysSumm1);
        return arraysSumm.join() + arraysSumm1.join();
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;
        switch(diff){
            case 0:
                return 0;
            case 1:
                return array[start];
            case 2:
                return array[start] + array[start + 1];
            default:
                return this.forkTaskAndGetResult();
        }
    }
}
