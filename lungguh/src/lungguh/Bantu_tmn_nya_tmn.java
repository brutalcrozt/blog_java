/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lungguh;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author enter_rebel
 */
public class Bantu_tmn_nya_tmn {

    int hasil;
    String angka1;
    String angka2;
    int numb1;
    int numb2;
    int pilihan;

    public int tambah(int angka1, int angka2) {
        return angka1 + angka2;
    }

    public int kali(int a, int b) {
        return a * b;
    }

    public int bagi(int a, int b) {
        return a / b;
    }

    public int kurang(int a, int b) {
        return a - b;
    }

    public void read() {
        try {
            File fileSaya = new File("D:\\PBOL\\angka1.txt"); // change
            BufferedReader br = new BufferedReader(new FileReader(fileSaya));
            BufferedReader br2 = new BufferedReader(new FileReader("D:\\PBOL\\angka2.txt")); //change
            angka1 = br.readLine();
            angka2 = br2.readLine();
            // salah di sini
            numb1 = Integer.parseInt(angka1);
            numb2 = Integer.parseInt(angka2);
            // end of edit
        } catch (FileNotFoundException ex) { // penambahan case oleh editor :p
            ex.getMessage();
            System.out.println("File tidak ditemukan");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void cetak() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:\\PBOL\\hasil.txt"))); // change
            bw.write("" + hasil);
            // kalo buffernya gak di close , ga bakal kesimpen hasilnya
            // tolong dicermati
            bw.close();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception ex) { // penambahan exception oleh editor :p
            ex.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bantu_tmn_nya_tmn r = new Bantu_tmn_nya_tmn();
        r.read();
        System.out.println("MENU");
        System.out.println("1. Tambah");
        System.out.println("2. Kurang");
        System.out.println("3. Kali");
        System.out.println("4. Bagi");
        System.out.println("Masukan pilihan ");
        r.pilihan = scan.nextInt();
        // dalam case dirubah semua
        switch (r.pilihan) {
            case 1:
                r.hasil = r.tambah(r.numb1,r.numb2);
                break;
            case 2:
                r.hasil = r.kurang(r.numb1,r.numb2);
                break;
            case 3:
                r.hasil = r.kali(r.numb1,r.numb2);
                break;
            case 4:
                r.hasil = r.bagi(r.numb1,r.numb2);
                break;
            default:
                break;
        }
        r.cetak();
    }
}
