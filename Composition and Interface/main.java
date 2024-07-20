public class main {

    static void addNumber(int a, int b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {

        addNumber(6,7);
        Computer hp250 = new Computer(new Ram(), new Processor(), new Storage());

        System.out.println(hp250);
    }
}