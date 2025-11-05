import java.util.Scanner;

// 1. INTERFACE STRATEGY
interface BiayaTambahanStrategy {
    double hitungBiaya(double nilaiDasar, int durasiFaktor);
}

// 2. CONCRETE STRATEGY 1 (Denda Keterlambatan)
class DendaKeterlambatanStrategy implements BiayaTambahanStrategy {

    @Override
    public double hitungBiaya(double hargaSewaHarian, int hariTerlambat) {
        if (hariTerlambat <= 0) {
            return 0.0;
        }
        double faktorDenda = 1.5;
        double totalDenda = hargaSewaHarian * hariTerlambat * faktorDenda;
        System.out.println("[Strategi Keterlambatan] Denda: " + hariTerlambat + " hari x " + hargaSewaHarian + " x " + faktorDenda);
        return totalDenda;
    }
}

// 3. CONCRETE STRATEGY 2 (Tanggungan Kerusakan)
class TanggunganKerusakanStrategy implements BiayaTambahanStrategy {

    @Override
    public double hitungBiaya(double hargaAlatBaru, int persentaseKerusakan) {
        if (persentaseKerusakan <= 0) {
            return 0.0;
        }
        double denda = hargaAlatBaru * (persentaseKerusakan / 100.0);
        System.out.println("[Strategi Kerusakan] Tanggungan: " + persentaseKerusakan + "% dari Harga Alat Baru (" + hargaAlatBaru + ")");
        return denda;
    }
}

// 4. CONTEXT CLASS (SewaAlatContext)
class SewaAlatContext {
    private BiayaTambahanStrategy strategy;
    private double nilaiDasar;
    private int faktorMasalah;

    public SewaAlatContext(double nilaiDasar, int faktorMasalah) {
        this.nilaiDasar = nilaiDasar;
        this.faktorMasalah = faktorMasalah;
    }

    public void setStrategy(BiayaTambahanStrategy strategy) {
        this.strategy = strategy;
    }

    public double hitungBiayaTambahan() {
        if (strategy == null) {
            throw new IllegalStateException("Strategi biaya belum ditentukan.");
        }
        System.out.print("Menerapkan metode perhitungan: " + strategy.getClass().getSimpleName() + " -> ");
        return strategy.hitungBiaya(nilaiDasar, faktorMasalah);
    }
}

// MAIN CLASS (KuyCampStrategyDemo)
public class KuyCampStrategyDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- PENENTUAN DENDA ALAT KUYCAMP (Strategy Pattern Demo) ---");
        
        // Data Dasar
        double hargaSewaHarianTenda = 50000.0;
        double hargaAlatBaruTenda = 500000.0;

        System.out.println("\nPilih Jenis Masalah:");
        System.out.println("1. Keterlambatan Pengembalian");
        System.out.println("2. Kerusakan Alat (Sobek/Patah)");
        System.out.print("Pilihan (1/2): ");
        
        // Menggunakan nextInt() untuk pilihan dan factor masalah
        int pilihan = scanner.nextInt(); 
        
        SewaAlatContext context;
        double totalBiayaTambahan = 0.0;
        
        if (pilihan == 1) {
            System.out.print("Masukkan jumlah hari terlambat: ");
            int hariTerlambat = scanner.nextInt(); 
            
            context = new SewaAlatContext(hargaSewaHarianTenda, hariTerlambat);
            context.setStrategy(new DendaKeterlambatanStrategy());
            
            totalBiayaTambahan = context.hitungBiayaTambahan();

        } else if (pilihan == 2) {
            System.out.print("Masukkan estimasi persentase kerusakan (1-100%): ");
            int persentaseKerusakan = scanner.nextInt();
            
            context = new SewaAlatContext(hargaAlatBaruTenda, persentaseKerusakan);
            context.setStrategy(new TanggunganKerusakanStrategy());
            
            totalBiayaTambahan = context.hitungBiayaTambahan();

        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.println("\n=============================================");
        System.out.printf("Total Biaya Tambahan Dikenakan: Rp %,.2f%n", totalBiayaTambahan);
        System.out.println("=============================================");
        
        scanner.close();
    }
}