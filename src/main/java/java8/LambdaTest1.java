package java8;

public class LambdaTest1 {
    public static void main(String[] args){
        LambdaTest1 tester = new LambdaTest1();

        // ----------- 匿名类 -----------
        MathOperation op1 = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a+b;
            }
        };

        // ----------- 普通方式 -----------
        class MathOperationImpl implements MathOperation {
            public int operation(int a, int b) {
                return a+b;
            }
        }
        MathOperation op2 = new MathOperationImpl();
        System.out.println("10 + 5 = " + tester.operate(10, 5, op2));

        // ----------- Lambda表达式 -----------
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

    }

    // MathOperation 是函数式接口
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}


interface MathOperation {
    int operation(int a, int b);
}




