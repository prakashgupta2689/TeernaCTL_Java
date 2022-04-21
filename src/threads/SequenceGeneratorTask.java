package threads;

public class SequenceGeneratorTask implements Runnable{

    private NumbersGenerator numbersGenerator;
    private int result;

    public SequenceGeneratorTask(NumbersGenerator numbersGenerator, int result) {
        this.numbersGenerator = numbersGenerator;
        this.result = result;
    }


    @Override
    public void run() {
        numbersGenerator.printNumbers(result);
    }
}
