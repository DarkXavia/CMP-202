public class Admin extends User {
    String staffNo;

    void uploadResults(String course, float score) {
        System.out.println(course + " " + score);
    }

    public static void main(String[] args) {
        Admin adminName = new Admin();
        adminName.name = "Ark";
        adminName.password = "246810";
        System.out.println(adminName.register());
    }
}
public class Animal {
    String name;

    String move() {
        return "Moves by walking";
    }

    boolean isALive() {
        return true;
    }
}

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
public class Computer implements Electronic{

    Ram ram;

    Processor cpu;

    Storage storage;

    public Computer(Ram ram, Processor cpu, Storage storage) {
        this.ram = ram;
        this.cpu = cpu;
        this.storage = storage;
    }

    @Override
    public boolean on(){
        return true;

    }
    @Override
    public boolean off(){
        return false;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", cpu=" + cpu +
                ", storage=" + storage +
                '}';
    }
}
public interface Electronic {

    boolean onOrOff = false;

    boolean on();

    boolean off();

    default void electronic(){
        if (onOrOff){
            System.out.println("Default");
        }
    }
}

public class gameOutput {
    public static void main(String[] args) {
        XandO xando = new XandO();
        xando.drawUI();
    }
}

public class
LandAnimal extends Animal {
    @Override
    String move() {
        return "swings on trees";
    }

    public static void main(String[] args) {
        LandAnimal lion = new LandAnimal();
        LandAnimal monkey = new LandAnimal();
        lion.name = "brad";
        monkey.move();
        System.out.println(lion.name);
        System.out.println(monkey.move());
    }

}
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

public class Ram {
    String name = "DDR4";
        int readSpeed = 3;

    float writeSpeed = 1.5f;

    @Override
    public String toString() {
        return "Ram{" +
                "name='" + name + '\'' +
                ", readSpeed=" + readSpeed +
                ", writeSpeed=" + writeSpeed +
                '}';
    }
}

public class Storage {
    String type = "SSD";
    String manufacturer = "Samsung";

        int capacity = 512;

    @Override
    public String toString() {
        return "Storage{" +
                "type='" + type + '\'' +
                ",manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

public class Student extends User {
    String matric_no = "bhu/22/04/05/0017";
    String admission_no = "youarecorrect";

    String registerCourse() {
        if (matric_no.equals("") || admission_no.equals("")) {
            return "You cannot register your courses at this moment";
        } else {
            return "You have registered all courses";
        }
    }

    String checkResults() {
        if (matric_no.equals("") || admission_no.equals("")) {
            return "Cannot check your result.";
        } else {
            return "You got 8As, 2Bs and 1D";
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Ark Young";
        student.password = "MrCoder";
        System.out.println(student.register());
        System.out.println(student.registerCourse());
        System.out.println(student.checkResults());
    }
}
public class User {
    String name;
    String password;

    String login() {
        return "Logged in";
    }

    String logout() {
        return "Logged out";
    }

    String register() {
        if (name.equals("") || password.equals("")) {
            return "Can't be empty";
        } else {
            return "Successfull";
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XandO {

    JFrame tictac = new JFrame("X and O");

    JButton[] buttons = new JButton[9];

    boolean isXTurn = true;

    public XandO() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(new ButtonClickListener());
            tictac.add(buttons[i]);
        }
    }

    void drawUI(){
        tictac.setLayout(new GridLayout(3, 3));
        tictac.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tictac.setSize(400, 400);
        tictac.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if (!clickedButton.getText().isEmpty()) {
                return;
            }

            clickedButton.setText(isXTurn ? "X" : "O");
            isXTurn = !isXTurn;

            checkForWinner();
        }
    }

    private void checkForWinner() {
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combination : winCombinations) {
            String b1 = buttons[combination[0]].getText();
            String b2 = buttons[combination[1]].getText();
            String b3 = buttons[combination[2]].getText();

            if (!b1.isEmpty() && b1.equals(b2) && b2.equals(b3)) {
                JOptionPane.showMessageDialog(tictac, "Player " + b1 + " wins!");
                resetBoard();
                return;
            }
        }

        boolean allButtonsClicked = true;
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                allButtonsClicked = false;
                break;
            }
        }

        if (allButtonsClicked) {
            JOptionPane.showMessageDialog(tictac, "It's a tie!");
            resetBoard();
        }
    }

    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
        }
        isXTurn = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            XandO game = new XandO();
            game.drawUI();
        });
    }
}
