public class Calculator {
    private final MathService mathService;
    public Calculator(MathService mathService) {
        this.mathService = mathService;
    }
    public int add(int a, int b) {
        return mathService.add(a, b);
    }
    public int subtract(int a, int b) {
        return mathService.subtract(a, b);
    }
}
public class MathService {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
}
