package pbopraktek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author enter
 */
public class Tgs4 {

    public static void main(String adi[]) {
        String dir1 = "D:\\PBON\\angka1.txt";
        String dir2 = "D:\\PBON\\angka2.txt";
        String result = "D:\\PBON\\hasil.txt";
        Scanner main_scanner = new Scanner(System.in);
        Menu_and_operate telat_tiga_bulan;
        IOFile latihan = new IOFile();
        int intsatu = latihan.baca_file(dir1);
        int intdua = latihan.baca_file(dir2);
        telat_tiga_bulan = new Menu_and_operate(intsatu, intdua);
        telat_tiga_bulan.menu(main_scanner, latihan, result);
    }
}

class IOFile {

    File f;
    FileWriter writer;
    FileReader reader;
    BufferedReader br;
    BufferedWriter bw;
    private String text_to_write;
    private String text_which_readed;

    public IOFile() {
        text_to_write = "";
        text_which_readed = "";
    }

    public void write_file(String dir, int to_write) {
        try {
            f = new File(dir);
            writer = new FileWriter(f);
            bw = new BufferedWriter(writer);
            bw.write(to_write);
            bw.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // overloading method write_file 
    // method pertama menulis int
    // method kedua menulis String

    public void write_file(String dir, String to_write) {
        try {
            f = new File(dir);
            writer = new FileWriter(f);
            bw = new BufferedWriter(writer);
            bw.write(to_write);
            bw.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write_file(String dir, String to_write, boolean bol) {
        try {
            f = new File(dir);
            writer = new FileWriter(f, bol);
            bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(to_write);
            bw.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void baca_file(String dir, int c) {
        try {
            f = new File(dir);
            reader = new FileReader(f);
            br = new BufferedReader(reader);
            String temp = br.readLine();
            while (temp != null) {
                text_which_readed = text_which_readed + temp + "\n";
                temp = br.readLine();
            }
            br.close();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int baca_file(String dir) {
        int i = 0;
        try {
            f = new File(dir);
            reader = new FileReader(f);
            br = new BufferedReader(reader);
            String string = br.readLine();
            int x = Integer.parseInt(string);
            i = x;
            reader.close();
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return i;
    }

    public String getText_to_write() {
        return text_to_write;
    }

    public void setText_to_write(String text_to_write) {
        this.text_to_write = text_to_write;
    }

    public String getText_which_readed() {
        return text_which_readed;
    }
}

class Menu_and_operate {

    private int hasil, a, b;

    public Menu_and_operate(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void menu(Scanner p, IOFile x, String dir) {
        System.out.printf("Pilih operasi\n");
        System.out.printf("1. Tambah\n");
        System.out.printf("2. Kurang\n");
        System.out.printf("3. Kali\n");
        System.out.printf("4. Bagi\n");
        System.out.printf("Pilihan anda : ");
        int pil = p.nextInt();
        switch (pil) {
            case 1: {
                hasil = a + b;
                break;
            }
            case 2: {
                hasil = a - b;
                break;
            }
            case 3: {
                hasil = a * b;
                break;
            }
            case 4: {
                hasil = a / b;
                break;
            }
            default: {
                System.out.println("Maaf, pilihan tidak tersedia!");
            }
        }
        if (pil == 1 || pil == 2 || pil == 3 || pil == 4) {
            x.write_file(dir,String.valueOf(hasil), true);
        } else {
            System.out.println("Program tidak menyimpan hasil!");
        }
    }
}
