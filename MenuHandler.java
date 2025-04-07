import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuHandler {
    private final PetService petService = new PetServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final AdoptionService adoptionService = new AdoptionServiceImpl(petService);
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Admin");
            System.out.println("2. Pengguna");
            System.out.println("3. Keluar");
            System.out.print("Pilih peran: ");

            int role;
            try {
                role = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
                continue;
            }

            switch (role) {
                case 1 -> handleAdminMenu();
                case 2 -> handleUserMenu();
                case 3 -> {
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void handleAdminMenu() {
        while (true) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Lihat Hewan yang Tersedia");
            System.out.println("3. Lihat Permintaan Adopsi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Nama Hewan: ");
                    String name = scanner.nextLine();
                    System.out.print("Jenis Hewan: ");
                    String type = scanner.nextLine();
                    System.out.print("Usia Hewan (contoh: 2 tahun / 3 bulan): ");
                    String age = scanner.nextLine();
                    String id = String.valueOf(petService.getNextPetId());
                    petService.addPet(new Pet(Integer.parseInt(id), name, type, age));
                    System.out.println("Hewan berhasil ditambahkan.");
                }
                case 2 -> {
                    List<Pet> pets = petService.getAllPets();
                    if (pets.isEmpty()) {
                        System.out.println("Tidak ada hewan tersedia.");
                    } else {
                        System.out.println("| ID | Nama | Jenis | Usia        | Status   |");
                        System.out.println("---------------------------------------------");
                        for (Pet pet : pets) {
                            System.out.printf("| %-2d | %-4s | %-6s | %-10s | %-8s |\n",
                                    pet.getId(), pet.getName(), pet.getType(), pet.getAge(),
                                    pet.isAdopted() ? "Adopted" : "Tersedia");
                        }
                    }
                }
                case 3 -> {
                    List<AdoptionRequest> requests = adoptionService.getAllRequests();
                    if (requests.isEmpty()) {
                        System.out.println("Belum ada permintaan adopsi.");
                    } else {
                        System.out.println("| ID Permintaan | Nama Pengaju | No HP       | ID Hewan | Status     |");
                        System.out.println("------------------------------------------------------------------------");
                        for (AdoptionRequest req : requests) {
                            System.out.printf("| %-14d | %-12s | %-10s | %-8d | %-10s |\n",
                                    req.getId(),
                                    req.getUser().getName(),
                                    req.getUser().getPhone(),
                                    req.getPet().getId(),
                                    req.getStatus());
                        }
                        System.out.print("\nMasukkan ID Permintaan untuk disetujui (0 untuk batal): ");
                        int requestId = Integer.parseInt(scanner.nextLine());
                        if (requestId != 0) {
                            boolean success = adoptionService.approveRequest(requestId);
                            if (success) {
                                System.out.println("Permintaan disetujui.");
                            } else {
                                System.out.println("Permintaan tidak ditemukan atau sudah diproses.");
                            }
                        }
                    }
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void handleUserMenu() {
        System.out.print("Masukkan nama Anda: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan nomor HP Anda: ");
        String phone = scanner.nextLine();
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, name, phone);

        while (true) {
            System.out.println("\n--- Menu Pengguna ---");
            System.out.println("1. Lihat Hewan Tersedia");
            System.out.println("2. Ajukan Adopsi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    List<Pet> pets = petService.getAllPets();
                    if (pets.isEmpty()) {
                        System.out.println("Tidak ada hewan tersedia.");
                    } else {
                        System.out.println("| ID | Nama | Jenis | Usia        | Status   |");
                        System.out.println("---------------------------------------------");
                        for (Pet pet : pets) {
                            System.out.printf("| %-2d | %-4s | %-6s | %-10s | %-8s |\n",
                                    pet.getId(), pet.getName(), pet.getType(), pet.getAge(),
                                    pet.isAdopted() ? "Adopted" : "Tersedia");
                        }
                    }
                }
                case 2 -> {
                    List<Pet> pets = petService.getAllPets();
                    if (pets.isEmpty()) {
                        System.out.println("Tidak ada hewan tersedia.");
                        break;
                    }
                    System.out.print("Masukkan ID Hewan yang ingin diadopsi: ");
                    int petId = Integer.parseInt(scanner.nextLine());
                    Pet petToAdopt = petService.getPetById(petId);
                    if (petToAdopt == null || petToAdopt.isAdopted()) {
                        System.out.println("Hewan tidak tersedia.");
                    } else {
                        adoptionService.submitRequest(user, petId);
                        System.out.println("Permintaan adopsi telah diajukan.");
                    }
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
