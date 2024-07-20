public class Processor {
    String type = "core i5";

    int numberOfCores = 2;

    @Override
    public String toString() {
        return "Processor{" +
                "type='" + type + '\'' +
                ", numberOfCores=" + numberOfCores +
                '}';
    }
}
