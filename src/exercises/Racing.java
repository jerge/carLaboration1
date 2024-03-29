package exercises;

import exercises.models.Saab95;
import exercises.models.Volvo240;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;


public class Racing {
    private Scanner sc = new Scanner(System.in);

    private Car actual = null;
    private List<Car> carList = new ArrayList<>();
    public static void main(String[] args){
        new Racing().program();
    }

    private void program(){
        help();
        int cmd = 0;
        while (cmd != 11){
            cmd = sc.nextInt();
            exeCmd(cmd);
            moveCars();
            out.println("Next command:");
        }
    }

    private void exeCmd(int cmd){
        if (actual == null && !(cmd == 1 || cmd == 2)) {
            out.println("Please create a new car");
        } else {
            switch (cmd){
                case 1:
                    createVolvo();
                    break;
                case 2:
                    createSaab();
                    break;
                case 3:
                    changeCars();
                    break;
                case 4:
                    showCars();
                    break;
                case 5:
                    actual.startEngine();
                    break;
                case 6:
                    actual.stopEngine();
                    break;
                case 7:
                    doGas();
                    break;
                case 8:
                    doBreak();
                    break;
                case 9:
                    actual.turnRight();
                    break;
                case 10:
                    actual.turnLeft();
                    break;
                case 0:
                    help();
                    break;
                default:
                    break;
            }

        }

    }

    private void changeCars() {
        showCars();
        out.println("Choose car: ");
        actual = carList.get(sc.nextInt()-1);
    }

    private void showCars(){
        for (int i = 0; i < carList.size()  ; i++) {
            out.print((i+1) + ": " + carList.get(i).getModelName());
            printPosition(carList.get(i));
            if (carList.get(i).equals(actual)){
                out.print(" <-- Actual");
            }
            out.println();
        }
    }

    private void printPosition(Car c){
        out.print(" @");
        out.printf("%.2f", c.getPosition()[0]);
        out.print(" , ");
        out.printf("%.2f", c.getPosition()[1]);
    }

    private void doGas(){
        out.println("How much do you want to gas? (0-1)");
        actual.gas(sc.nextDouble());
    }

    private void doBreak(){
        out.println("How much do you want to gas? (0-1)");
        actual.gas(sc.nextDouble());
    }

    private void help(){
        out.println("Available commands:");
        out.println("1:New Volvo" + "\n" +
                "2:New Saab");
        out.println("3:Change Car");
        out.println("4:Show Cars");
        out.println("5:Start Engine" + "\n" +
                "6:Stop Engine");
        out.println("7:Gas" + "\n" +
                "8:Break");
        out.println("9:Turn Right" + "\n" +
                "10:Turn Left");
        out.println("11:Exit");
        out.println("0:Help");
    }

    private void moveCars(){
        for (Car c : carList) {
            c.move();
        }
    }

    private void createVolvo(){
        Volvo240 v = new Volvo240();
        carList.add(v);
        actual = v;
    }

    private void createSaab() {
        Saab95 s = new Saab95();
        carList.add(s);
        actual = s;
    }
}

