package exercises;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;


    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        position = new double[]{0,0};
        direction = Math.PI/2;
        stopEngine();
    }

//    public int getNrDoors(){
//        return nrDoors;
//    }
//    public double getEnginePower(){
//        return enginePower;
//    }
//
//    public double getCurrentSpeed(){
//        return currentSpeed;
//    }
//
//    public Color getColor(){
//        return color;
//    }
//
//    public void setColor(Color clr){
//        color = clr;
//    }
//
//    public void startEngine(){
//        currentSpeed = 0.1;
//    }
//
//    public void stopEngine(){
//        currentSpeed = 0;
//    }

    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    @Override
    void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}