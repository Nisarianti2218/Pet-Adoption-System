import java.util.ArrayList;
import java.util.List;

public class AdoptionServiceImpl implements AdoptionService {
    private final List<AdoptionRequest> requests = new ArrayList<>();
    private final PetService petService;
    private int nextRequestId = 1;

    public AdoptionServiceImpl(PetService petService) {
        this.petService = petService;
    }

    @Override
    public void submitRequest(User user, int petId) {
        Pet pet = petService.getPetById(petId);
        if (pet != null && !pet.isAdopted()) {
            AdoptionRequest request = new AdoptionRequest(nextRequestId++, user, pet, "Menunggu Persetujuan");
            requests.add(request);
        }
    }

    @Override
    public List<AdoptionRequest> getAllRequests() {
        return requests;
    }

    @Override
    public boolean approveRequest(int requestId) {
        for (AdoptionRequest req : requests) {
            if (req.getId() == requestId && req.getStatus().equals("Menunggu Persetujuan")) {
                req.setStatus("Disetujui");
                Pet pet = req.getPet();
                pet.setAdopted(true); // ⬅️ TANDAI HEWAN SUDAH DIADOPSI
                return true;
            }
        }
        return false;
    }
}
