package lungguh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
/*
 * author enter_rebel
 * maaf code masih berantakan dan belum ada penjelasan
 * karena masih dadakan
 */

public class tgs4_io_file {

   public static void main(String tgs4[]) {
        String state1 = "D:\\PBON\\angka1.txt";
        String  state2= "D:\\PBON\\angka2.txt";
        String  hasil = "D:\\PBON\\hasil.txt";
        Scanner scan = new Scanner(System.in);
        DisplayMenu menu;
        FileStream file = new FileStream();
        int angka1 = file.baca_file(state1);
        int angka2 = file.baca_file(state2);
        menu = new DisplayMenu(angka1, angka2);
        menu.menu(scan, file, hasil);
    }
}
class FileStream {

    File f;
    FileWriter writer;
    FileReader reader;
    BufferedReader br;
    BufferedWriter bw;
    private String to_write;
    private String which_readed;

    public FileStream() {
        to_write = "";
        which_readed = "";
    }

    public void tuilisFile(String Stt, int to_write) {
        try {
            f = new File(Stt);
            writer = new FileWriter(f);
            bw = new BufferedWriter(writer);
            bw.write(to_write);
            bw.close();
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void tuilisFile(String Stt, String to_write,boolean x) {
        try {
            f = new File(Stt);
            writer = new FileWriter(f);
            bw = new BufferedWriter(writer);
            bw.write(to_write);
            bw.close();
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void tuilisFile(String Stt, String to_write) {
        try {
            f = new File(Stt);
            writer = new FileWriter(f);
            bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(to_write);
            bw.close();
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void baca_file(String Stt, int c) {
        try {
            f = new File(Stt);
            reader = new FileReader(f);
            br = new BufferedReader(reader);
            String temp = br.readLine();
            while (temp != null) {
                which_readed = which_readed + temp + "\n";
                temp = br.readLine();
            }
            br.close();
            reader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int baca_file(String Stt) {
        int i = 0;
        try {
            f = new File(Stt);
            reader = new FileReader(f);
            br = new BufferedReader(reader);
            String string = br.readLine();
            int x = Integer.parseInt(string);
            i = x;
            reader.close();
            br.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public String getText_to_write() {
        return to_write;
    }

    public void setText_to_write(String to_write) {
        this.to_write = to_write;
    }

    public String getText_which_readed() {
        return which_readed;
    }
}

class DisplayMenu {

    private int hasil, a, b;

    public DisplayMenu(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void menu(Scanner p, FileStream x, String Stt) {
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
            x.tuilisFile(Stt,String.valueOf(hasil));
    }
}
