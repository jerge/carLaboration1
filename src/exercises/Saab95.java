package exercises;
import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        position = new double[]{0,0};
        direction = Math.PI/2;
        stopEngine();
    }

//
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

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    @Override
    void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    @Override
    void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (Math.abs(currentSpeed) > enginePower) {
            currentSpeed = -enginePower;
        }
    }
}