public class BlackBox {

    private static final int DEFAULT_VALUE = 0;

    private int innerValue;


    private BlackBox(int innerValue) {
        this.innerValue = innerValue;
    }

    private BlackBox() {
        this.innerValue = DEFAULT_VALUE;
    }

    private void add(int addValue){
        this.innerValue += addValue;
    }

    private void subtract(int subtractValue){
        this.innerValue -= subtractValue;
    }

    private void multiply(int multiplyValue){
        this.innerValue *= multiplyValue;
    }

    private void divide(int divideValue){
        this.innerValue /= divideValue;
    }

    private void leftShift(int shifter){
        this.innerValue <<= shifter;
    }

    private void rightShift(int shifter){
        this.innerValue >>= shifter;
    }
}
