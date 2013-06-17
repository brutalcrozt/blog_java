/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wenny;

import java.util.Scanner;

/**
 *
 * @author enter
 */
public class Sepakbola {
String nama;
String club;
String posisi;
int umur;
Scanner wait = new Scanner(System.in);	
public void biodata(String nama, String club, String posisi, int umur){		
	System.out.println("Name\t\t\t: "+nama);
	System.out.println("Klub\t\t\t: "+club);
	System.out.println("Position\t\t: "+posisi);
	System.out.println("Age\t\t\t: "+umur);
        this.nama = nama;
        this.club=club;
        this.posisi=posisi;
        this.umur=umur;
	}

public void beli (String nama, String club, String posisi, int umr){
	System.out.println ("Kita berhasil membeli " +nama +", yang berhasil dari klub " +club +" posisi " +posisi +" dan berumur " +umr);
}
public void tunggu () {
    char tunggu;
    System.out.println("Masukkan satu karakter sembarang untuk melanjutkan");
    tunggu = wait.next().charAt(0);
}
}
