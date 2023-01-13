import java.util.Scanner;

class PetShop {
    // Scanner variable
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Pets array with 2 random pet
        Pet[] pets = {new Dog("Fido", 3), new Cat("Fluffy", 5)};
        //Foods array with 2 random pet
        Food[] foods = {new Kibble(), new CannedFood()};
        //Toys array with 2 random pet
        Toy[] toys = {new Ball(), new Frisbee()};
        //Utils object for using playWithPet method
        Utils utils = new Utils();

        //Main console menu
        System.out.println("Welcome to the online pet shop!");
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1. List pets");
            System.out.println("2. List foods");
            System.out.println("3. List toys");
            System.out.println("4. Add pet");
            System.out.println("5. Remove pet");
            System.out.println("6. Search for pet");
            System.out.println("7. Play with pet");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 8) {
                break;
            }

            switch (choice) {
                case 1:
                    listPets(pets);
                    break;
                case 2:
                    listFoods(foods);
                    break;
                case 3:
                    listToys(toys);
                    break;
                case 4:
                    pets = addPet(pets);
                    break;
                case 5:
                    pets = removePet(pets);
                    break;
                case 6:
                    searchForPet(pets);
                    break;
                case 7:
                    Pet petToPlayWith = searchForPet(pets);
                    if (petToPlayWith != null){
                        utils.playWithPet(petToPlayWith);
                    }
                    break;
            }
        }
    }
    //Print pets to console
    private static void listPets(Pet[] pets) {
        System.out.println("Number of pets: "+ Pet.numberOfPets);
        for (Pet pet : pets) {
            System.out.println(pet.getName() + " (" + pet.getAge() + " years old)");
        }
    }
    //Print foods to console
    private static void listFoods(Food[] foods) {
        for (Food food : foods) {
            food.serve();
        }
    }
    //Print toys to console
    private static void listToys(Toy[] toys) {
        for (Toy toy : toys) {
            toy.play();
        }
    }
    //Add new pet to given pet array and return it
    private static Pet[] addPet(Pet[] pets) {

        //Get pet properties
        System.out.print("Enter pet type (dog or cat): ");
        String type = sc.nextLine();
        System.out.print("Enter pet name: ");
        String name = sc.nextLine();
        System.out.print("Enter pet age: ");
        int age = sc.nextInt();
        sc.nextLine();

        //Create pet with using factory
        Pet newPet = PetFactory.createPet(type, name, age);

        //Add pet to array
        Pet[] newPets = new Pet[pets.length + 1];
        System.arraycopy(pets, 0, newPets, 0, pets.length);
        newPets[pets.length] = newPet;
        System.out.println("Pet added successfully!");

        //Return new array
        return newPets;
    }
    //Remove pet from given array
    private static final Pet[] removePet(Pet[] pets) {
        //Get pet name to be removed
        System.out.print("Enter pet name: ");
        String name = sc.nextLine();

        //Search pet
        int index = -1;
        for (int i = 0; i < pets.length; i++) {
            if (pets[i].getName().equals(name)) {
                index = i;
                break;
            }
        }
        //If pet is not found, return array
        if (index == -1) {
            System.out.println("Pet not found!");
            return pets;
        }

        //Remove pet from array
        Pet[] newPets = new Pet[pets.length - 1];
        System.arraycopy(pets, 0, newPets, 0, index);
        System.arraycopy(pets, index + 1, newPets, index, pets.length - index - 1);
        System.out.println("Pet removed successfully!");
        Pet.numberOfPets--;

        //Return new array
        return newPets;
    }

    //Search for a pet and print it's properties if found
    private static final Pet searchForPet(Pet[] pets) {
        //Get name of pet from user
        System.out.print("Enter pet name: ");
        String name = sc.nextLine();

        //Search for pet
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                //If pet found
                System.out.println("Pet found: " + pet.getName() + " (" + pet.getAge() + " years old)");
                return pet;
            }
        }
        //If pet not found
        System.out.println("Pet not found!");
        return null;
    }
}