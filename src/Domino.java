public class Domino {
    private int firstNum, secondNum;

    public Domino(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;

    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    @Override
    public String toString() {
        return "[" + firstNum + "|" + secondNum + "]";
    }

    public void rotate() {
        int temp = secondNum;
        secondNum = firstNum;
        firstNum = temp;
    }
}
