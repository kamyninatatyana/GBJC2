package lesson05;

public class Calculation implements Runnable{

    float[] array;
    private int finalSize;
    private int indexInFormula;


    public Calculation(float[] array, int finalSize, int indexInFormula) {
        this.array = array;
        this.finalSize = finalSize;
        this.indexInFormula = indexInFormula;
    }

    @Override
    public void run() {

        for (int i = 0; i < finalSize; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + indexInFormula / 5) * Math.cos(0.2f + indexInFormula / 5)
                    * Math.cos(0.4f + indexInFormula / 2));
            indexInFormula++;
        }

    }
}
