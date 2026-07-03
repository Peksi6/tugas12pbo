import mysql.connector
import os

# Konfigurasi Koneksi Database
def get_db_connection():
    return mysql.connector.connect(
        host="localhost",
        user="root",       # Sesuaikan dengan user MySQL Anda
        password="",       # Sesuaikan dengan password MySQL Anda
        database="toko_retail"
    )

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def tampil_menu():
    print("=======================")
    print("   MENU TOKO RETAIL   ")
    print("=======================")
    print("1. Tampil Semua Data")
    print("2. Tambah Data")
    print("3. Cari Data")
    print("4. Ubah Data")
    print("5. Hapus Data")
    print("0. Keluar")
    print("=======================")

# 1. Tampil Semua Data
def tampil_semua_data():
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT kode, nama_barang, harga, stok FROM barang")
    rows = cursor.fetchall()
    
    print("\n" + "="*65)
    print(f"{'DAFTAR BARANG TOKO RETAIL':^65}")
    print("="*65)
    print(f"{'#':<4} | {'Kode':<8} | {'Nama Barang':<25} | {'Harga':<10} | {'Stok':<6}")
    print("-"*65)
    
    for idx, row in enumerate(rows, start=1):
        print(f"{idx:<4} | {row[0]:<8} | {row[1]:<25} | {row[2]:<10} | {row[3]:<6}")
        
    print("-"*65)
    print(f"Total: {len(rows)} barang")
    print("="*65 + "\n")
    
    cursor.close()
    conn.close()

# 2. Tambah Data
def tambah_data():
    print("\n--- TAMBAH DATA BARANG ---")
    kode = input("Masukkan Kode Barang (contoh B004): ")
    nama = input("Masukkan Nama Barang: ")
    harga = int(input("Masukkan Harga Barang: "))
    stok = int(input("Masukkan Stok Barang: "))
    
    conn = get_db_connection()
    cursor = conn.cursor()
    query = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (%s, %s, %s, %s)"
    try:
        cursor.execute(query, (kode, nama, harga, stok))
        conn.commit()
        print("Data berhasil ditambahkan!")
    except mysql.connector.Error as err:
        print(f"Gagal menambahkan data: {err}")
    finally:
        cursor.close()
        conn.close()

# 3. Cari Data
def cari_data():
    print("\n--- CARI DATA BARANG ---")
    keyword = input("Masukkan Kode atau Nama Barang yang dicari: ")
    
    conn = get_db_connection()
    cursor = conn.cursor()
    query = "SELECT kode, nama_barang, harga, stok FROM barang WHERE kode LIKE %s OR nama_barang LIKE %s"
    cursor.execute(query, (f"%{keyword}%", f"%{keyword}%"))
    rows = cursor.fetchall()
    
    if rows:
        print("\nHasil Pencarian:")
        for row in rows:
            print(f"Kode: {row[0]} | Nama: {row[1]} | Harga: {row[2]} | Stok: {row[3]}")
    else:
        print("Data tidak ditemukan.")
        
    cursor.close()
    conn.close()

# 4. Ubah Data
def ubah_data():
    print("\n--- UBAH DATA BARANG ---")
    kode = input("Masukkan Kode Barang yang ingin diubah: ")
    
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM barang WHERE kode = %s", (kode,))
    if cursor.fetchone():
        print("Masukkan data baru (kosongkan jika tidak ingin diubah):")
        nama = input("Nama Barang baru: ")
        harga_input = input("Harga Baru: ")
        stok_input = input("Stok Baru: ")
        
        # Logika update parsial
        if nama:
            cursor.execute("UPDATE barang SET nama_barang = %s WHERE kode = %s", (nama, kode))
        if harga_input:
            cursor.execute("UPDATE barang SET harga = %s WHERE kode = %s", (int(harga_input), kode))
        if stok_input:
            cursor.execute("UPDATE barang SET stok = %s WHERE kode = %s", (int(stok_input), kode))
            
        conn.commit()
        print("Data berhasil diperbarui!")
    else:
        print("Kode barang tidak ditemukan.")
        
    cursor.close()
    conn.close()

# 5. Hapus Data
def hapus_data():
    print("\n--- HAPUS DATA BARANG ---")
    kode = input("Masukkan Kode Barang yang ingin dihapus: ")
    
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM barang WHERE kode = %s", (kode,))
    if cursor.fetchone():
        cursor.execute("DELETE FROM barang WHERE kode = %s", (kode,))
        conn.commit()
        print("Data berhasil dihapus!")
    else:
        print("Kode barang tidak ditemukan.")
        
    cursor.close()
    conn.close()

# Main Loop Aplikasi
def main():
    while True:
        tampil_menu()
        pilihan = input("Pilihan : ")
        
        if pilihan == '1':
            tampil_semua_data()
        elif pilihan == '2':
            tambah_data()
            input("\nTekan Enter untuk kembali ke menu...")
            clear_screen()
        elif pilihan == '3':
            cari_data()
            input("\nTekan Enter untuk kembali ke menu...")
            clear_screen()
        elif pilihan == '4':
            ubah_data()
            input("\nTekan Enter untuk kembali ke menu...")
            clear_screen()
        elif pilihan == '5':
            hapus_data()
            input("\nTekan Enter untuk kembali ke menu...")
            clear_screen()
        elif pilihan == '0':
            print("Keluar dari program. Terima kasih!")
            break
        else:
            print("Pilihan tidak valid! Silakan coba lagi.")
            input("\nTekan Enter...")
            clear_screen()

if __name__ == "__main__":
    clear_screen()
    main()