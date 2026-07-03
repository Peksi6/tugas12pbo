// Konsep: Package
// package com.tugas.project; 

import java.util.ArrayList;

// Konsep: Interface
interface OperasiData {
    void tampilkanInfo();
}

// Konsep: Abstract Class
abstract class Produk implements OperasiData {
    // Konsep: Encapsulation (Private fields)
    private String id;
    
    public Produk(String id) { this.id = id; }
    public String getId() { return id; }
}

// Konsep: Inheritance
class Elektronik extends Produk {
    private String nama;

    public Elektronik(String id, String nama) {
        super(id);
        this.nama = nama;
    }

    // Konsep: Polimorfisme (Overriding)
    @Override
    public void tampilkanInfo() {
        System.out.println("Produk Elektronik [" + getId() + "]: " + nama);
    }
}

// Konsep: Generic & Collection
class Gudang<T> {
    private ArrayList<T> listData = new ArrayList<>();

    public void tambah(T item) { listData.add(item); }
    public void lihatSemua() {
        for (T item : listData) {
            ((OperasiData) item).tampilkanInfo();
        }
    }
}

// Main Class (Class & Object)
public class AplikasiProject {
    public static void main(String[] args) {
        Gudang<Elektronik> gudangKita = new Gudang<>();
        
        Elektronik laptop = new Elektronik("E01", "Laptop ASUS");
        Elektronik hp = new Elektronik("E02", "Smartphone Samsung");

        gudangKita.tambah(laptop);
        gudangKita.tambah(hp);

        System.out.println("--- Daftar Barang di Gudang ---");
        gudangKita.lihatSemua();
    }
}