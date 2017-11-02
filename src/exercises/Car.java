package exercises;

import java.awt.*;

public abstract class Car implements Movable{

    /**
     * The number of doors of the car
     */
    int nrDoors; // Number of doors on the car

    /**
     * Current engine power of the car
     * Calculated with an arbitrary number
     */
    double enginePower; // Engine power of the car

    /**
     * Current speed of the car
     * Calculated with an arbitrary number
     */
    double currentSpeed; // The current speed of the car

    /**
     * The car's current color
     */
    Color color; // Color of the car

    /**
     * The car's model name
     */
    String modelName;

    /**
     * The position of the car in the universe
     * <i>position</i> = [X,Y]
     */
    double[] position;

    /**
     * The direction the car is facing, in radians
     * The direction is calculated according to the unit circle
     */
    double direction;  // Radians -> according to unit circle

    /**
     * @return the number of doors of the vehicle
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return car's engine power in arbitrary form
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return current speed in arbitrary form
     */
    double getCurrentSpeed(){
        return currentSpeed;
    }

    double[] getPosition(){
        return position;
    }

    /**
     * @return color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * @param clr the color to set
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed to 0.1
     */
    void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed to 0
     */
    void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Changes the car's direction by one quarter of a revolution to the left
     */
    @Override
    public void turnLeft() {
        direction += Math.PI/2;
        direction = direction % (Math.PI*2);
    }

    /**
     * Changes the car's direction by one quarter of a revolution to the right
     */
    @Override
    public void turnRight() {

        direction -= Math.PI/2;
        direction = (direction + Math.PI*2) % (Math.PI*2);
    }

    /**
     * Changes the car's current position according to it's speed and direction
     * The amount is calculated via simple trigonometry
     */
    @Override
    public void move() {
        position[0] += Math.cos(direction) * currentSpeed;
        position[1] += Math.sin(direction) * currentSpeed;
    }

    abstract void incrementSpeed(double amount);
    abstract void decrementSpeed(double amount);

    /**
     * Calls the incrementSpeed() method from the subclass, depending on model name
     * @param amount is the value you want to increase your speed with
     */
    public void gas(double amount){
        if(amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * Calls the decrementSpeed() method from the subclass, depending on model name
     * @param amount is the value you want to increase your speed with
     */
    public void brake(double amount){
        if(amount > 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
