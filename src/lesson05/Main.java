package lesson05;

public class Main {

    public static final int SIZE = 10000000;
    public static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        Method1();
        Method2();
    }

    public static void Method1() {

        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        Thread t1 = new Thread(new Calculation(arr, Main.SIZE, 0));

        t1.run();

        System.out.println("Метод 1: Элемент 0: " + arr[0] + " ; Элемент 5000000: " + arr[HALF]);
        System.out.println("Время исполнения задачи в одном потоке:" + (System.currentTimeMillis() - a));

    }

    public static void Method2() {

        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, Main.HALF);
        System.arraycopy(arr, Main.HALF, a2, 0, Main.HALF);


        Thread t2 = new Thread(new Calculation(a1, Main.HALF, 0));
        Thread t3 = new Thread(new Calculation(a2, Main.HALF, Main.HALF));

            t2.start();
            t3.start();

            try {
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.arraycopy(a1, 0, arr, 0, Main.HALF);
            System.arraycopy(a2, 0, arr, Main.HALF, Main.HALF);


            System.out.println("Метод 2. Элемент 0: " + arr[0] + " ; Элемент 5000000: " + arr[HALF]);
            System.out.println("Время исполнения в двух потоках:" + +(System.currentTimeMillis() - a));
        }

    }






