/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoosim;

/**
 *
 * @author michael.roy-diclemen
 */
public class ZooSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     *
     */
    public class Image {
    
    private double width;
    private double length;
    }

    /**
     *
     */
    public interface IObject {
    
        /**
         *
         * @param degrees
         */
        public void turn (double degrees);

        /**
         *
         * @param x
         * @param y
         */
        public void place (int x, int y);
    }

    /**
     *
     */
    public interface IEntity extends IObject {
    
        /**
         *
         * @param degrees
         */
        public void move(double degrees);

        /**
         *
         */
        public void makeSound();

        /**
         *
         */
        public void eat();

        /**
         *
         */
        public void sleep();
    }

    /**
     *
     */
    public class Animal implements IEntity {
    
    private int id;
    private String name;
    private String species;
    private String sex;
    private int age;
    private double xCord;
    private double yCord;
    private double size;
    private double speed;
    private double directionDegrees;
    private double hunger;
    private double fatigue;
    private Image image;
    private String sound;
    
        /**
         *
         * @param newId
         * @param newName
         * @param newSpecies
         * @param newSex
         * @param newAge
         * @param newXCord
         * @param newYCord
         * @param newSize
         * @param newSpeed
         * @param newDirectionDegrees
         * @param newHunger
         * @param newFatigue
         * @param newImage
         * @param newSound
         */
        public Animal (int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound) {
        
    id = newId;
    name = newName;
    species = newSpecies;
    sex = newSex;
    age = newAge; 
    xCord = newXCord;
    yCord = newYCord;
    size = newSize;
    speed = newSpeed;
    directionDegrees = newDirectionDegrees;
    hunger = newHunger;
    fatigue = newFatigue;
    image = newImage;
    sound = newSound;
    }

        /**
         *
         */
        @Override
    public void makeSound(){
        System.out.println(sound);
    }
    
        /**
         *
         * @param degrees
         */
        @Override
    public void move(double degrees){ 
       
        double radians = Math.toRadians(degrees);
        double diffX = Math.cos(radians) * speed;
        double diffY = Math.sin(radians) * speed;
        xCord += diffX;
        yCord += diffY;
        double distanceMoved = Math.sqrt(Math.pow(xCord, 2) + Math.pow(yCord, 2));
        System.out.println("Distance moved: " + distanceMoved + " with a speed of " + speed);
    }
    
        /**
         *
         * @return
         */
        public boolean isHungry() {
        return hunger > 10;
    }

        /**
         *
         */
        @Override
    public void eat(){
        hunger = 0;
        System.out.println(name + " eats and their hunger is fully restored.");
    }
    
        /**
         *
         * @return
         */
        public boolean isTired() {
        return fatigue > 10;
    }

        /**
         *
         */
        @Override
    public void sleep(){
        fatigue = 0;
        System.out.println(name + " sleeps and their fatigue is fully gone.");
    }

        /**
         *
         * @param degrees
         */
        @Override
    public void turn(double degrees){
        directionDegrees += degrees;
    }

        /**
         *
         * @param x
         * @param y
         */
        @Override
    public void place(int x, int y){
        xCord = x;
        yCord = y;
        System.out.println("X-Position: " + xCord + " " + "Y-Position: " + yCord);
    }
    
        /**
         *
         * @return
         */
        public double getSpeed(){
        return speed;
    }
    
        /**
         *
         * @return
         */
        public double getXCord(){
        return xCord;
    }
    
        /**
         *
         * @param newXCord
         */
        public void setXCord(double newXCord){
        xCord = newXCord;
    }
    
        /**
         *
         * @return
         */
        public double getYCord(){
        return yCord;
    }
    
        /**
         *
         * @param newYCord
         */
        public void setYCord(double newYCord){
        yCord = newYCord;
    }
    
        /**
         *
         * @return
         */
        public String getName(){
        return name;
    }
    
    }

    /**
     *
     */
    public interface IFlyable{
        
        /**
         *
         */
        public void fly();

        /**
         *
         */
        public void land();

        /**
         *
         */
        public void isFlying();
    }
    
    /**
     *
     */
    public interface ISwimmable{
        
        /**
         *
         * @return
         */
        public boolean canSurface();
    }
    
    /**
     *
     */
    public class LandAnim extends Animal {
        
        /**
         *
         * @param newId
         * @param newName
         * @param newSpecies
         * @param newSex
         * @param newAge
         * @param newXCord
         * @param newYCord
         * @param newSize
         * @param newSpeed
         * @param newDirectionDegrees
         * @param newHunger
         * @param newFatigue
         * @param newImage
         * @param newSound
         */
        public LandAnim(int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound) {
            super(newId, newName, newSpecies, newSex, newAge, newXCord, newYCord, newSize, newSpeed, newDirectionDegrees, newHunger, newFatigue, newImage, newSound);
        }
        
    }
    
    /**
     *
     */
    public class BirdAnim extends Animal implements IFlyable{
        
        private boolean canFly;
        
        /**
         *
         * @param newId
         * @param newName
         * @param newSpecies
         * @param newSex
         * @param newAge
         * @param newXCord
         * @param newYCord
         * @param newSize
         * @param newSpeed
         * @param newDirectionDegrees
         * @param newHunger
         * @param newFatigue
         * @param newImage
         * @param newSound
         * @param newCanFly
         */
        public BirdAnim(int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound, boolean newCanFly) {
            super(newId, newName, newSpecies, newSex, newAge, newXCord, newYCord, newSize, newSpeed, newDirectionDegrees, newHunger, newFatigue, newImage, newSound);
            canFly = newCanFly;
        }
        
        /**
         *
         */
        @Override
        public void fly(){
            
        }
        
        /**
         *
         */
        @Override
        public void land(){
            
        }
        
        /**
         *
         */
        @Override
        public void isFlying(){
            
        }
    }
    
    /**
     *
     */
    public class WaterAnim extends Animal implements ISwimmable {
        
        private boolean canBreathe;
        
        /**
         *
         * @param newId
         * @param newName
         * @param newSpecies
         * @param newSex
         * @param newAge
         * @param newXCord
         * @param newYCord
         * @param newSize
         * @param newSpeed
         * @param newDirectionDegrees
         * @param newHunger
         * @param newFatigue
         * @param newImage
         * @param newSound
         * @param newCanBreathe
         */
        public WaterAnim(int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound, boolean newCanBreathe) {
            super(newId, newName, newSpecies, newSex, newAge, newXCord, newYCord, newSize, newSpeed, newDirectionDegrees, newHunger, newFatigue, newImage, newSound);
            canBreathe = newCanBreathe;
        }
        
        /**
         *
         * @return
         */
        @Override
        public boolean canSurface(){
            if (canBreathe == true){
                return false;
            }
            else {
                return true;
            }
        }
    }

    /**
     *
     */
    public class Food implements IObject{
        
        private double directionDegrees;
        private double xCord;
        private double yCord;
        private double size;
        
        /**
         *
         * @param newDirectionDegrees
         * @param newXCord
         * @param newYCord
         * @param newSize
         */
        public Food (double newDirectionDegrees, double newXCord, double newYCord, double newSize){
            directionDegrees = newDirectionDegrees;
            xCord = newXCord;
            yCord = newYCord;
            size = newSize;
        }
        
        /**
         *
         * @param degrees
         */
        @Override
        public void turn (double degrees){
            directionDegrees += degrees;
        }
        
        /**
         *
         * @param x
         * @param y
         */
        @Override
        public void place (int x, int y){
            xCord = x;
            yCord = y;
        }
    }
    
    /**
     *
     */
    public class Rock implements IObject {
        
        private double directionDegrees;
        private double xCord;
        private double yCord;
        private double size;
        
        /**
         *
         * @param newDirectionDegrees
         * @param newXCord
         * @param newYCord
         * @param newSize
         */
        public Rock(double newDirectionDegrees, double newXCord, double newYCord, double newSize){
            directionDegrees = newDirectionDegrees;
            xCord = newXCord;
            yCord = newYCord;
            size = newSize;
        }
        
        /**
         *
         * @param degrees
         */
        @Override
        public void turn (double degrees){
            directionDegrees += degrees;
        }
        
        /**
         *
         * @param x
         * @param y
         */
        @Override
        public void place (int x, int y){
            xCord = x;
            yCord = y;
        } 
    }
    
    /**
     *
     */
    public class Tree implements IObject {
        
        private double directionDegrees;
        private double xCord;
        private double yCord;
        private double size;
        
        /**
         *
         * @param newDirectionDegrees
         * @param newXCord
         * @param newYCord
         * @param newSize
         */
        public Tree (double newDirectionDegrees, double newXCord, double newYCord, double newSize){
            directionDegrees = newDirectionDegrees;
            xCord = newXCord;
            yCord = newYCord;
            size = newSize;
    }

        /**
         *
         * @param degrees
         */
        @Override
        public void turn (double degrees){
            directionDegrees += degrees;
        }
        
        /**
         *
         * @param x
         * @param y
         */
        @Override
        public void place (int x, int y){
            xCord = x;
            yCord = y;
        } 
    }
    
    /**
     *
     */
    public class Zoo {
        
        private Animal [] animals = new Animal [100];
        private int animalCount = 0;
        
        /**
         *
         * @param animal
         */
        public void addAnimal(Animal animal){
            if (animalCount < animals.length){
                animals[animalCount] = animal;
                animalCount++;
            }
            else {
                System.out.println("Zoo is full");
            }
        }
        
        /**
         *
         */
        public void displayZooStats(){
            System.out.println("Zoo Statistics: ");
            System.out.println("Number of animals in the zoo: " + animalCount);
        }
        
        /**
         *
         */
        public void feedHungryAnimal() {
            for (int i = 0; i < animalCount; i++){
                if (animals[i].isHungry()){
                    animals[i].eat();
                }
            }
        }
        
        /**
         *
         */
        public void makeTiredAnimalSleep() {
            for (int i = 0; i < animalCount; i++){
                if (animals[i].isTired()){
                    animals[i].sleep();
                }
            }
        }
        
        /**
         *
         * @param degrees
         */
        public void moveAnimal(double degrees){ 
            
            for (int i = 0; i < animalCount; i++){
                double radians = Math.toRadians(degrees);
                double diffX = Math.cos(radians) * animals[i].getSpeed();
                double diffY = Math.sin(radians) * animals[i].getSpeed();
                animals[i].setXCord(animals[i].getXCord() + diffX);
                animals[i].setYCord(animals[i].getYCord() + diffY);
                double distanceMoved = Math.sqrt(Math.pow(animals[i].getXCord(), 2) + Math.pow(animals[i].getYCord(), 2));
                System.out.println(animals[i].getName() + " moved " + distanceMoved + " with of speed of " + animals[i].getSpeed());
            }
    }
    }
    
    /* Thinking Question
    
    How would you modify this structure to allow for predator/prey interactions and
    Carnivores/Omnivores/Herbivores?
    
    First to introduce carnivores/omnivores/herbivores interactions, I would create a subclass that extends from 
    the Animal Class like a carnivores/omnivores/herbivores subclasses and each would have different behaviours
    and attributes. For predator/prey interactions, I would create a predator and prey interface which would have
    methods like hunt for predators and flee from preys and this would be implemented in the animal and animal 
    subclasses. For which animals hunts or flees for another animal, I would create an animal hierarchy system
    that would give a level for each specific animal and that would determine which animals it can hunt and
    which it should flee from.
    
    */
}
    
