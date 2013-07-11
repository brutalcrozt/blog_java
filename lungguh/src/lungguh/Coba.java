package lungguh;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coba{
	int hasil;
		String angka1;
		String angka2;
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
		File fileSaya = new File("d:\\PBOL\\angka1.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileSaya));
		BufferedReader br2 = new BufferedReader(new FileReader("d:/PBOL/angka2.txt"));
			angka1 = br.readLine();
			angka2 = br2.readLine();
			} catch (IOException ex) {
		Logger.getLogger(Coba.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void cetak() {
	try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d:/PBOL/hasil.txt"))); bw.write(""+hasil);
		} catch (IOException ex) {
		Logger.getLogger(Coba.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Coba r = new Coba();
		r.read();
			System.out.println("MENU");
			System.out.println("1. Tambah");
			System.out.println("2. Kurang");
			System.out.println("3. Kali");
			System.out.println("4. Bagi");
			System.out.println("Masukan pilihan ");
		r.pilihan = scan.nextInt();
	switch (r.pilihan) {
		case 1:
			r.hasil = r.tambah(Integer.parseInt(r.angka1), Integer.parseInt(r.angka2));
		break;
		case 2:
			r.hasil = r.kurang(Integer.parseInt(r.angka1), Integer.parseInt(r.angka2));
		break;
		case 3:
			r.hasil = r.kali(Integer.parseInt(r.angka1), Integer.parseInt(r.angka2));
		break;
		case 4:
			r.hasil = r.bagi(Integer.parseInt(r.angka1), Integer.parseInt(r.angka2));
		break;
		default:
		break;
		}
		r.cetak();
	}
}