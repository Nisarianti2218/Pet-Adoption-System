import java.util.ArrayList;
import java.util.List;

public class PetServiceImpl implements PetService {
    private List<Pet> pets = new ArrayList<>();
    private int petIdCounter = 1;

    @Override
    public void addPet(Pet pet) {
        pets.add(pet);
        petIdCounter++;
    }

    @Override
    public List<Pet> getAllPets() {
        return pets;
    }

    @Override
    public Pet getPetById(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public int getNextPetId() {
        return petIdCounter;
    }
}
