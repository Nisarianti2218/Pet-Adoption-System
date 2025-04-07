import java.util.List;

public interface AdoptionService {
    void submitRequest(User user, int petId);

    List<AdoptionRequest> getAllRequests();

    boolean approveRequest(int requestId);
}
