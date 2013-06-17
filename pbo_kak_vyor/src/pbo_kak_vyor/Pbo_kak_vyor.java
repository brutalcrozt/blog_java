/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo_kak_vyor;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author enter
 */
public class Pbo_kak_vyor {

    public static void main(String[] args) {
        int banyak_array = 10;
        int pilih = 0;
        boolean exit = false;
        Scanner reader = new Scanner(System.in);
        System.out.print("Masukkan jumlah array yang ingin dibuat : ");
        try {
            banyak_array = reader.nextInt();
            reader.skip("\n"); // 
        } catch (Exception ex) {
            if (ex.getMessage() != null) { // jika ada pesan error maka tampilkan
                System.err.println("Penyebab exception : " + ex.getMessage());
            } else {
                System.err.println("Terjadi kesalahan saat input karena "+ex);
                Logger.getLogger(Pbo_kak_vyor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        belajar_array adi = new belajar_array(banyak_array); // ?
        adi.generate();
        do {
            System.out.println("1. Urutkan array");
            System.out.println("2. Jumlah total semua elemen array");
            System.out.println("3. Rata-rata semua elemen array");
            System.out.println("4. Tampilkan elemen ganjil");
            System.out.println("5. Tampilkan elemen genap");
            System.out.println("6. Tampilkan elemen terbesar dan terkecil");
            System.out.println("7. Rata-rata element ganjil dan genap");
            System.out.println("8. Balik urutan array(reverse)");
            System.out.println("9. Ganti nilai elemen array yang duplikat");
            System.out.println("10. Keluar");
            System.out.print("Masukkan pilihan anda : ");
            try {
                pilih = reader.nextInt();
                reader.skip("\n");
            } catch (Exception exception) {
                if (exception.getMessage() != null) { // jika ada pesan error maka tampilkan
                    System.err.println("Penyebab exception : " + exception.getMessage());
                } else {
                    System.err.println("Maaf pilihan tidak tersedia");
                    break;// keluar program
                }
            }
            switch (pilih) {
                case 1: {
                    boolean sort = true;//?
                    try {
                        adi.print();
                        System.out.println("Urutkan secara :");
                        System.out.println("a. Ascending");
                        System.out.println("d. Descending");
                        System.out.println("Masukkan pilihan anda (a/d) : ");
                        // (char)System.in.read();
                        switch ((char) System.in.read()) {
                            case 'a': {
                                //tidak ada break jadi masuk case tepat dibawah case ini
                            }
                            case 'A': {
                                sort = true;
                                break;
                            }
                            case 'd': {
                                //tidak ada break jadi masuk case tepat dibawah case ini
                            }
                            case 'D': {
                                sort = false;
                                break;
                            }
                            default: {
                                System.out.println("Maaf pilihan tidak tersedia");
                                break;
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Pbo_kak_vyor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("sebelum sorting. ");
                    adi.print();
                    adi.sorting(sort);
                    System.out.print("sesudah sorting. ");
                    adi.print();
                    adi.tunggu();
                    break;
                }
                case 2: {
                    adi.print();
                    float total = adi.get_tot_value();
                    System.out.println("total semua array bila dijumlahkan adalah " + total);
                    adi.tunggu();
                    break;
                }
                case 3: {
                    adi.print();
                    float tot = adi.get_tot_value();
                    //float rata = (tot / banyak_array);
                    System.out.print("Rata-rata dari semua elemen array adalah ");
                    // 4 angka dibelakang koma
                    System.out.printf("%.4f \n", (tot / (float) banyak_array));
                    adi.tunggu();
                    break;
                }
                case 4: {
                    // local variable untuk dicek apakah ganjil
                    int dicek;
                    int total_ganjil = 0;
                    adi.print();
                    System.out.println("elemen array yang bernilai ganjil adalah");
                    for (int i = 0; i < banyak_array; i++) {
                        dicek = adi.get_array_at_index(i);
                        if ((dicek % 2) == 1) {
                            System.out.print(dicek + " ");
                            total_ganjil += dicek;
                        }
                    }
                    System.out.println("\ntotal nilai elemen array yang ganjil adalah " + total_ganjil);
                    adi.tunggu();
                    break;
                }
                case 5: {
                    // local variable untuk dicek apakah ganjil
                    int dicek;
                    int total_genap = 0;
                    adi.print();
                    System.out.println("elemen array yang bernilai genap adalah");
                    for (int i = 0; i < banyak_array; i++) {
                        dicek = adi.get_array_at_index(i);
                        if ((dicek % 2) == 0) {
                            System.out.print(dicek + " ");
                            total_genap += dicek;
                        }
                    }
                    System.out.println("\ntotal nilai elemen array yang genap adalah " + total_genap);
                    adi.tunggu();
                    break;
                }
                case 6: {
                    adi.print();
                    int max, min, temp;
                    max = adi.get_array_at_index(0);
                    min = max;
                    for (int i = 0; i < banyak_array; i++) {
                        temp = adi.get_array_at_index(i);
                        if (temp > max) {
                            max = temp;
                        } else if (temp < min) {
                            min = temp;
                        }
                    }
                    System.out.println("Nilai terbesar adalah " + max + " dan nilai terkecil adalah " + min);
                    adi.tunggu();
                    break;
                }
                case 7: {
                    adi.print();
                    int checking;
                    float tot_gan = 0, tot_gen = 0,
                            counter_genap = 0, counter_ganjil = 0;
                    for (int i = 0; i < banyak_array; i++) {
                        checking = adi.get_array_at_index(i);
                        if ((checking % 2) == 1) {
                            tot_gan += checking;
                            counter_ganjil++;
                        } else {
                            tot_gen += checking;
                            counter_genap++;
                        }
                    }
                    System.out.print("Rata-rata nilai ganjil adalah ");
                    // 4 angka dibelakang koma
                    System.out.printf("%.4f", (double) (tot_gan / counter_ganjil));
                    System.out.print("\nRata-rata nilai genap adalah ");
                    // 4 angka dibelakang koma
                    System.out.printf("%.4f \n", (double) (tot_gen / counter_genap));
                    adi.tunggu();
                    break;
                }
                case 8: {
                    adi.print();
                    adi.reverse();
                    System.out.println("Urutan array telah dibalik");
                    adi.print();
                    adi.tunggu();
                    break;
                }
                case 9: {
                    adi.print();
                    System.out.println("Setelah nilai yang duplicate diganti");
                    adi.regenerate_no_duplicate();
                    adi.print();
                    adi.tunggu();
                    break;
                }
                case 10: {
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Maaf pilihan tidak tersedia");
                    break;
                }
            }
        } while (!exit);
        //adi.setBanyak(banyak_array);
        //adi.coba();
        //adi.generate();
        //adi.print();

    }
}

class belajar_array {
    // variable untuk menyimpan banyak array yang akan dibuat
    // default value untuk variable banyak adalah 10

    private int banyak;
    // declarasi array dengan jumlah element yang belum ditentukan
    private int[] acak;
    // variable untuk mengecek apakah ada nilai element yang duplikat dari 
    // array yang sudah dibuat
    private boolean unik;
    // variable untuk menunggu user mengetikan data saat user melihat submenu app
    char c;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    // construktor dengan parameter int sebagai jumlah element array yang akan dibuat

    public belajar_array() {
    }

    public belajar_array(int n) {
        this.banyak = n;
        acak = new int[banyak];
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
        System.out.println("sekarang banyak di dlm kelas adalah " + this.banyak);
    }
    //method untuk mengecek apakah ada nilai yang duplikat

    public boolean check(int x) {
        boolean hasil = true;
        for (int i = x - 1; i >= 0; i--) {
//            if (i==-1) {
//                // jika x yang masuk adalah 0 maka i = -1
//                // jadi lanjut tidak usah melakukan ceking
//                continue;
//            }
            if (acak[x] == acak[i]) {
                hasil = hasil && false;
            } else {
                hasil = hasil && true;
            }
        }
        return hasil;
    }

    public void coba() { //testing
        for (int i = 0; i < 10; i++) {
            acak[i] = rand.nextInt(banyak);
        }
        System.out.println("sebelum");
        for (int i = 0; i < 10; i++) {
            System.out.print(acak[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            unik = check(i);
            //System.out.print("\n unik ke "+i+" = "+unik);
            while (!unik) {
                //System.out.print(" tidak unik ");
                acak[i] = rand.nextInt(banyak);
                //System.out.print("angka baru = "+acak[i]);
                unik = check(i);
                //System.out.print(" sekarang unik = "+unik+" ");
            }
        }

        System.out.println("sesudah");
        for (int i = 0; i < 10; i++) {
            System.out.print(acak[i] + " ");
        }
    }
    // method untuk generate angka random
    // parameter true = random no duplicate
    // parameter false = just random

    public void generate() {
        for (int i = 0; i < banyak; i++) {
            // batas atas nilai random yang akan dihasilkan adalah 
            // banyak array dikali banyak array
            acak[i] = rand.nextInt(banyak * banyak);
        }
    }

    public void regenerate_no_duplicate() { //tested @ 10 array
        for (int i = 0; i < banyak; i++) {
            unik = this.check(i);
            while (!unik) {
                acak[i] = rand.nextInt(banyak);
                unik = this.check(i);
            }
        }
    }
    //method untuk menyalin array ke sebuah array baru

    public void salin(int[] acak2) {
        System.arraycopy(acak, 0, acak2, 0, banyak);
    }

    public void print() {
        System.out.println("Isi array pada saat ini adalah ");
        for (int i = 0; i < banyak; i++) {
            System.out.print(acak[i] + " ");
        }
        System.out.println("");
    }

    public void tunggu() {
        // menunggu user menginputkan sebuah tombol
        System.out.print("inputkan sebuah karakter sembarang ");
        c = scan.next().charAt(0);
    }

    public void sorting(boolean bol) {
        int temp;
        for (int i = banyak - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                temp = acak[i];
                if (bol) { //ascending
                    if (acak[j] > acak[i]) {
                        acak[i] = acak[j];
                        acak[j] = temp;
                    }
                } else {  // descending
                    if (acak[j] < acak[i]) {
                        acak[i] = acak[j];
                        acak[j] = temp;
                    }
                }
            }
        }
    }

    public int get_array_at_index(int index) {
        return acak[index];
    }

    public float get_tot_value() {
        float total;
        total = 0;
        for (int i = 0; i < banyak; i++) {
            total += this.get_array_at_index(i);
        }
        return total;
    }

    public void reverse() {
        int[] balik = new int[banyak];
        int counter = 0;
        // perulangan untuk membalik array dengan menyimpannya ke array baru
        for (int i = banyak - 1; i > -1; i--) {
            balik[i] = acak[counter];
            counter++;
        }
        // merubah array yang lama dengan array yang sudah dibalik
        System.arraycopy(balik, 0, acak, 0, banyak);
    }
}
