import java.util.List;

public interface PetService {
    void addPet(Pet pet);

    List<Pet> getAllPets();

    Pet getPetById(int id);

    int getNextPetId();
}
