/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoosim;

/**
 * Author: Alan Li
 * Class: ICS4U
 * Program: Advanced Zoo Simulator Assignment
 */
public class ZooSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     * This image class represents an image with a width and a length
     */
    public class Image {
    
    // the width and length of the image
    private double width;
    private double length;
    }

    /**
     * This IObject interface represents objects that can be turn and placed
     */
    public interface IObject {
    
        /**
         * Turns the object by the specific degree
         * @param degrees, the degrees we are turning
         */
        public void turn (double degrees);

        /**
         * Places the object at specific x and y coordinates 
         * @param x, the x coordinate we are putting the object
         * @param y, the y coordinate we are putting the object
         */
        public void place (int x, int y);
    }

    /**
     * This IEntity interface represents objects that can move, make sound, eat, and sleep
     * This IEntity interface extends from IObject which means it has a turn and place method as well
     */
    public interface IEntity extends IObject {
    
        /**
         * Moves the object in the direction based on the degrees of the object
         * @param degrees, the angle the object is facing
         */
        public void move(double degrees);

        /**
         * Makes a sound based on the characteristics of the object
         */
        public void makeSound();

        /**
         * Makes the object eat, resetting the hunger 
         */
        public void eat();

        /**
         * Makes the object sleep, resetting the fatigue
         */
        public void sleep();
    }

    /**
     * This animal class implements the IEntity interface and represents an object that can turn, be placed, move, make sound, eat, and sleep
     */
    public class Animal implements IEntity {
    
    // Attributes of Object Animal
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
         * Constructs the new Animal object
         * The parameters used to initialize the Animal Constructor 
         * @param newId, the id of the animal
         * @param newName, the name of the animal
         * @param newSpecies, the species of the animal
         * @param newSex, the sex of the animal
         * @param newAge, the age of the animal
         * @param newXCord, the x coordinate of the animal's position
         * @param newYCord, the y coordinate of the animal's position
         * @param newSize, the size of the animal
         * @param newSpeed, the speed of the animal
         * @param newDirectionDegrees, the angle the animal is facing
         * @param newHunger, the hunger of the animal
         * @param newFatigue, the fatigue of the animal
         * @param newImage, the image representing the animal
         * @param newSound, the sound the animal makes
         */
        public Animal (int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound) {
    
    // assigns the attributes of the animal object
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
         * Makes the sound of the animal
         */
        @Override
    public void makeSound(){
        // prints the sound of the animal
        System.out.println(sound);
    }
    
        /**
         * Moves the object in the direction based on the degrees of the object
         * @param degrees, the degrees we are turning
         */
        @Override
    public void move(double degrees){ 
       
        // converts the degrees into radians 
        double radians = Math.toRadians(degrees);
        // calculate the change in the x direction
        double diffX = Math.cos(radians) * speed;
        // calculate the change in the y direction
        double diffY = Math.sin(radians) * speed;
        // updating the new xCord by adding the change in x direction
        xCord += diffX;
        // updating the new yCord by adding the change in y direction
        yCord += diffY;
        // calculates the distance moved using the pythagorean theorem
        double distanceMoved = Math.sqrt(Math.pow(xCord, 2) + Math.pow(yCord, 2));
        // prints the distance moved with the speed
        System.out.println("Distance moved: " + distanceMoved + " with a speed of " + speed);
    }
    
        /**
         * checks if the animal is hungry based on the hunger level
         * @return returns true if the animal is hungry, and false otherwise
         */
        public boolean isHungry() {
        return hunger > 10;
    }

        /**
         * feeds the animal, resetting its hunger level
         */
        @Override
    public void eat(){
        // sets hunger back to 0
        hunger = 0;
        // prints the name of the animal and that their hunger is restored
        System.out.println(name + " eats and their hunger is fully restored.");
    }
    
        /**
         * checks if the animal is tired based on the fatigue level
         * @return returns true if the animal is tried, and false otherwise 
         */
        public boolean isTired() {
        return fatigue > 10;
    }

        /**
         * makes the animal sleep, resetting its fatigue level
         */
        @Override
    public void sleep(){
        // sets fatigue back to 0
        fatigue = 0;
        // prints the name of the animal and that their fatigue is restored
        System.out.println(name + " sleeps and their fatigue is fully gone.");
    }

        /**
         * Turns the object by the specific degree
         * @param degrees, the degrees we are turning
         */
        @Override
    public void turn(double degrees){
        // add the degrees we are turning onto the default angle of the animal object
        directionDegrees += degrees;
    }

        /**
         * Places the object at specific x and y coordinates
         * @param x, the x coordinate we are putting the object
         * @param y, the y coordinate we are putting the object
         */
        @Override
    public void place(int x, int y){
        // setting the x and y coordinate of the animal object
        xCord = x;
        yCord = y;
        // printing the position of the animal object
        System.out.println("X-Position: " + xCord + " " + "Y-Position: " + yCord);
    }
    
        /**
         * Gets the speed of the animal
         * @return returns the speed of the animal
         */
        public double getSpeed(){
        return speed;
    }
    
        /**
         * Gets the x coordinate of the animal's position
         * @return returns the x coordinate of the animal's position
         */
        public double getXCord(){
        return xCord;
    }
    
        /**
         * Sets the x coordinate of the animal's position
         * @param newXCord, the new x coordinate of the animal's position
         */
        public void setXCord(double newXCord){
        xCord = newXCord;
    }
    
        /**
         * Gets the y coordinate of the animal's position
         * @return returns the y coordinate of the animal's position
         */
        public double getYCord(){
        return yCord;
    }
    
        /**
         * Sets the y coordinate of the animal's position
         * @param newYCord, the new y coordinate of the animal's position
         */
        public void setYCord(double newYCord){
        yCord = newYCord;
    }
    
        /**
         * Gets the name of the animal
         * @return returns the name of the animal
         */
        public String getName(){
        return name;
    }
        
        /**
         * Gets the species of the animal
         * @return returns the species of the animal
         */
        public String getSpecies(){
            return species;
    }
    
    }

    /**
     * This IFlyable interface represents objects that can fly
     */
    public interface IFlyable{
        
        /**
         * Makes the object fly
         */
        public void fly();

        /**
         * Makes the object land
         */
        public void land();

        /**
         * Checks if the object is flying
         */
        public void isFlying();
    }
    
    /**
     * This ISwimmable interface represents objects that can swim
     */
    public interface ISwimmable{
        
        /**
         * checks if the object can surface
         * @return returns true if the object can surface, and false otherwise
         */
        public boolean canSurface();
    }
    
    /**
     * Represents the subclass of the Animal class
     * Represents the animals that live on land
     */
    public class LandAnim extends Animal {
        
        /**
         * Constructs the new LandAnim object
         * The parameters used to initialize the LandAnim Constructor
         * @param newId, the id of the land animal
         * @param newName, the name of the land animal
         * @param newSpecies, the species of the land animal
         * @param newSex, the sex of the land animal
         * @param newAge, the age of the land animal
         * @param newXCord, the x coordinate of the land animal's position
         * @param newYCord, the y coordinate of the land animal's position
         * @param newSize, the size of the land animal
         * @param newSpeed, the speed of the land animal
         * @param newDirectionDegrees, the angle the land animal is facing
         * @param newHunger, the hunger of the land animal
         * @param newFatigue, the fatigue of the land animal
         * @param newImage, the image representing the land animal
         * @param newSound, the sound the land animal makes
         */
        public LandAnim(int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound) {
            super(newId, newName, newSpecies, newSex, newAge, newXCord, newYCord, newSize, newSpeed, newDirectionDegrees, newHunger, newFatigue, newImage, newSound);
        }
        
    }
    
    /**
     * Represents the subclass of the Animal class and implements from the IFlyable interface
     * Represents the animals that are birds and can fly
     */
    public class BirdAnim extends Animal implements IFlyable{
        
        private boolean canFly;
        
        /**
         * Constructs the new BirdAnim object
         * The parameters used to initialize the BirdAnim Constructor
         * @param newId, the id of the bird animal
         * @param newName, the name of the bird animal
         * @param newSpecies, the species of the bird animal
         * @param newSex, the sex of the bird animal
         * @param newAge, the age of the bird animal
         * @param newXCord, the x coordinate of the bird animal's position
         * @param newYCord, the y coordinate of the bird animal's position
         * @param newSize, the size of the bird animal
         * @param newSpeed, the speed of the bird animal
         * @param newDirectionDegrees, the angle the bird animal is facing
         * @param newHunger, the hunger of the bird animal
         * @param newFatigue, the fatigue of the bird animal
         * @param newImage, the image representing the bird animal
         * @param newSound, the sound the bird animal makes
         * @param newCanFly, sees if the bird can fly or not
         */
        public BirdAnim(int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound, boolean newCanFly) {
            super(newId, newName, newSpecies, newSex, newAge, newXCord, newYCord, newSize, newSpeed, newDirectionDegrees, newHunger, newFatigue, newImage, newSound);
            // assigns the attributes of the bird animal object
            canFly = newCanFly;
        }
        
        /**
         * Makes the bird fly
         */
        @Override
        public void fly(){
            
        }
        
        /**
         * Makes the bird land
         */
        @Override
        public void land(){
            
        }
        
        /**
         * Checks if the bird is flying
         */
        @Override
        public void isFlying(){
            
        }
    }
    
    /**
     * Represents the subclass of the Animal class and implements the ISwimmable interface
     * Represents the animals that live in the water
     */
    public class WaterAnim extends Animal implements ISwimmable {
        
        private boolean canBreathe;
        
        /**
         * Constructs the new WaterAnim object
         * The parameters used to initialize the WaterAnim Constructor
         * @param newId, the id of the water animal
         * @param newName, the name of the water animal
         * @param newSpecies, the species of the water animal
         * @param newSex, the sex of the water animal
         * @param newAge, the age of the water animal
         * @param newXCord, the x coordinate of the water animal's position
         * @param newYCord, the y coordinate of the water animal's position
         * @param newSize, the size of the water animal
         * @param newSpeed, the speed of the water animal
         * @param newDirectionDegrees, the angle the water animal is facing
         * @param newHunger, the hunger of the water animal
         * @param newFatigue, the fatigue of the water animal
         * @param newImage, the image representing the water animal
         * @param newSound, the sound the water animal makes
         * @param newCanBreathe, sees if the water animal can breathe underwater
         */
        public WaterAnim(int newId, String newName, String newSpecies, String newSex, int newAge, double newXCord, double newYCord, double newSize, double newSpeed, double newDirectionDegrees, double newHunger, double newFatigue, Image newImage, String newSound, boolean newCanBreathe) {
            super(newId, newName, newSpecies, newSex, newAge, newXCord, newYCord, newSize, newSpeed, newDirectionDegrees, newHunger, newFatigue, newImage, newSound);
            // assigns the attributes of the water animal object
            canBreathe = newCanBreathe;
        }
        
        /**
         * checks if the water animal needs to surface to breathe
         * @return returns true if the needs to surface to breathe and false otherwise
         */
        @Override
        public boolean canSurface(){
            // if the animal can breathe underwater then return false as the water animal doesn't need to surface
            if (canBreathe == true){
                return false;
            // return true otherwise if the water animal needs to surface to breathe
            }
            else {
                return true;
            }
        }
    }

    /**
     * Represent a type of object called food and implements from the IObject interface
     */
    public class Food implements IObject{
        
        // Attributes
        private double directionDegrees;
        private double xCord;
        private double yCord;
        private double size;
        
        /**
         * Constructs the new Food object
         * The parameters used to initialize the Food Constructor
         * @param newDirectionDegrees, the angle the food is facing
         * @param newXCord, the x coordinate of the food's position
         * @param newYCord, the y coordinate of the food's position
         * @param newSize, the size of the food
         */
        public Food (double newDirectionDegrees, double newXCord, double newYCord, double newSize){
            // assigns the attributes of the food object
            directionDegrees = newDirectionDegrees;
            xCord = newXCord;
            yCord = newYCord;
            size = newSize;
        }
        
        /**
         * Turns the food object by the given angle
         * @param degrees, the angle/degrees to turn the food object
         */
        @Override
        public void turn (double degrees){
            // add the degrees we are turning onto the default angle of the food object
            directionDegrees += degrees;
        }
        
        /**
         * Places the food object at specific x and y coordinates 
         * @param x, the x coordinate we are placing the food object
         * @param y, the y coordinate we are placing the food object
         */
        @Override
        public void place (int x, int y){
            // setting the x and y coordinate of the food object
            xCord = x;
            yCord = y;
        }
    }
    
    /**
     * Represents a type of object called rock and implements from the IObject interface
     */
    public class Rock implements IObject {
        
        // Attributes
        private double directionDegrees;
        private double xCord;
        private double yCord;
        private double size;
        
        /**
         * Constructs the new Rock object
         * The parameters used to initialize the Rock Constructor
         * @param newDirectionDegrees, the angle the rock is facing
         * @param newXCord, the x coordinate of the rock's position
         * @param newYCord, the y coordinate of the rock's position
         * @param newSize, the size of the rock
         */
        public Rock(double newDirectionDegrees, double newXCord, double newYCord, double newSize){
            // assigns the attributes of the rock object
            directionDegrees = newDirectionDegrees;
            xCord = newXCord;
            yCord = newYCord;
            size = newSize;
        }
        
        /**
         * Turns the rock object by the given angle
         * @param degrees, the angle/degrees to turn the rock object
         */
        @Override
        public void turn (double degrees){
            //add the degrees we are turning onto the default angle of the rock object
            directionDegrees += degrees;
        }
        
        /**
         * Places the rock object at specific x and y coordinates
         * @param x, the x coordinate we are placing the rock object
         * @param y, the y coordinate we are placing the rock object
         */
        @Override
        public void place (int x, int y){
            // setting the x and y coordiante of the rock object
            xCord = x;
            yCord = y;
        } 
    }
    
    /**
     * Represents a type of object called tree and implements from the IObject interface
     */
    public class Tree implements IObject {
        
        // Attributes
        private double directionDegrees;
        private double xCord;
        private double yCord;
        private double size;
        
        /**
         * Constructs the new Tree object
         * The parameters used to initialize the Tree Constructor
         * @param newDirectionDegrees, the angle the tree is facing
         * @param newXCord, the  x coordinate of the tree's position
         * @param newYCord, the y coordinate of the tree's position
         * @param newSize, the size of the tree
         */
        public Tree (double newDirectionDegrees, double newXCord, double newYCord, double newSize){
            // assigns the attributes of the tree object
            directionDegrees = newDirectionDegrees;
            xCord = newXCord;
            yCord = newYCord;
            size = newSize;
    }

        /**
         * Turns the tree object by the given angle
         * @param degrees, the angle/degrees to turn the tree object
         */
        @Override
        public void turn (double degrees){
            // add the degrees we are turning onto the default angle of the tree object
            directionDegrees += degrees;
        }
        
        /**
         * Places the tree object at specific x and y coordinates
         * @param x, the x coordinate we are placing the tree object
         * @param y, the y coordinate we are placing the tree object
         */
        @Override
        public void place (int x, int y){
            // setting the x and y coordinate of the tree object
            xCord = x;
            yCord = y;
        } 
    }
    
    /**
     * Represents the zoo that contains all the animals
     */
    public class Zoo {
        
        // Array to store the animals in the zoo
        private Animal [] animals = new Animal [100];
        // Current number of animals in the zoo
        private int animalCount = 0;
        
        /**
         * Adds animals to the zoo
         * @param animal, the animal object that is going to be added
         */
        public void addAnimal(Animal animal){
            //checks if the zoo has capacity to add more animals
            if (animalCount < animals.length){
                //adds the animal into the array
                animals[animalCount] = animal;
                //add to animal count
                animalCount++;
            }
            else {
                System.out.println("Zoo is full");
            }
        }
        
        /**
         * Displays the statistics about the zoo
         */
        public void displayZooStats(){
            System.out.println("Zoo Statistics: ");
            System.out.println("Number of animals in the zoo: " + animalCount);
            System.out.println("Animals in the zoo:");
            // Iterate over each animal and prints its name and its species
            for (int i = 0; i < animalCount; i++){
                Animal animal = animals[i];
                System.out.println("Animal Name: " + animal.getName() + ", Animal Species: " + animal.getSpecies());
            }
        }
        
        /**
         * Feeds all hungry animals in the zoo
         */
        public void feedHungryAnimal() {
            // Iterates over each animal in the zoo and sees if the animal is hungry
            for (int i = 0; i < animalCount; i++){
                // if animal is hungry and then make it eat
                if (animals[i].isHungry()){
                    animals[i].eat();
                }
            }
        }
        
        /**
         * Makes all tired animals in the zoo sleep
         */
        public void makeTiredAnimalSleep() {
            // Iterates over each animal in the zoo and sees if the animal is tired
            for (int i = 0; i < animalCount; i++){
                // if animal is tired then make it sleep
                if (animals[i].isTired()){
                    animals[i].sleep();
                }
            }
        }
        
        /**
         * Moves all animals in the zoo in a specific direction
         * @param degrees, the angle/degrees to move the animal
         */
        public void moveAnimal(double degrees){ 
            
            // Iterates over each animal in the zoo 
            for (int i = 0; i < animalCount; i++){
                // convert degrees into radians
                double radians = Math.toRadians(degrees);
                // calculate the horizontal and vertical displacement based on the animals speed and angle
                double diffX = Math.cos(radians) * animals[i].getSpeed();
                double diffY = Math.sin(radians) * animals[i].getSpeed();
                //update the x and y coordinate of the animal
                animals[i].setXCord(animals[i].getXCord() + diffX);
                animals[i].setYCord(animals[i].getYCord() + diffY);
                // calculate the distance moved by each animal using the pythagorean theorem
                double distanceMoved = Math.sqrt(Math.pow(animals[i].getXCord(), 2) + Math.pow(animals[i].getYCord(), 2));
                // prints the name of the animal, the distance it moved, and the speed of the animal
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
    
