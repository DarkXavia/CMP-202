public class Aquatic extends Animal {
    @Override
    String move() {
        return "moves by swimming";
    }

    public static void main(String[] args) {
        Aquatic fish = new Aquatic();
        fish.name = "Catfish";
        System.out.println("\n" + fish.name + " " + fish.move());
    }
}