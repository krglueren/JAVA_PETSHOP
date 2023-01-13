//Abstract Pet class which has constructor and getters
abstract class Pet {
    private String name;
    private int age;
    public static int numberOfPets;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfPets++;
    }

    public final String getName() {
        return name;
    }

    public final int getAge() {
        return age;
    }

    //Abstract method to sound for diffrent type of pets
    public abstract void makeSound();
}