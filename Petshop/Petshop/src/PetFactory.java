//Factory class to use factory pattern while using
class PetFactory {
    //Create pet method which takes properties and pet type, and returns new pet object
    public static Pet createPet(String type, String name, int age) {
        switch (type) {
            case "dog":
                return new Dog(name, age);
            case "cat":
                return new Cat(name, age);
            default:
                throw new IllegalArgumentException("Invalid pet type: " + type);
        }
    }
}


