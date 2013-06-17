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
public class Wenny {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        short control, submenu;
        control = 10;
        while (control != 0) {
            System.out.println("Selamat datang di area transfer pemain!");
            System.out.println("Daftar Pemain");
            System.out.println("1. Robin Van Persie");
            System.out.println("2. Frank Lempard");
            System.out.println("3. Lionel Messi");
            System.out.println("4. Christiano Ronaldo");
            System.out.println("Kamu memilih pemain yang mana?");
            control = scan.nextShort();
            System.out.println("1. List Biodata");
            System.out.println("2. Beli Pemain");
            System.out.println("0. Untuk exit");
            System.out.println("Pilihan: ");
            submenu = scan.nextShort();
            switch (submenu) {
                case 1:
                    switch (control) {
                        case 1:
                            Sepakbola RVP = new Sepakbola();
                            RVP.biodata("Robin Van Persie", "Manchaser United", "FW", 27);
                            RVP.tunggu();
                            break;
                        case 2:
                            Sepakbola FL = new Sepakbola();
                            FL.biodata("Frank Lempard", "Chealse", "MF", 28);
                            FL.tunggu();
                            break;
                        case 3:
                            Sepakbola LM = new Sepakbola();
                            LM.biodata("Lionel Messi", "Barcelona", "FW", 26);
                            LM.tunggu();
                            break;
                        case 4:
                            Sepakbola CR = new Sepakbola();
                            CR.biodata("Cristiano Ronaldo", "Real Madrid", "MF", 25);
                            CR.tunggu();
                            break;
                        default:
                            System.out.println("Pemain tersebut tidak tersedia");
                    }
                    break;
                case 2:
                    switch (control) {
                        case 1:
                            Sepakbola RVP = new Sepakbola();
                            RVP.beli("Robin Van Persie", "Manchaser United", "FW", 27);
                            RVP.tunggu();
                            break;
                        case 2:
                            Sepakbola FL = new Sepakbola();
                            FL.beli("Frank Lempard", "Chealse", "MF", 28);
                            FL.tunggu();
                            break;
                        case 3:
                            Sepakbola LM = new Sepakbola();
                            LM.beli("Lionel Messi", "Barcelona", "FW", 26);
                            LM.tunggu();
                            break;
                        case 4:
                            Sepakbola CR = new Sepakbola();
                            CR.beli("Cristiano Ronaldo", "Real Madrid", "MF", 25);
                            CR.tunggu();
                            break;
                        default:
                            System.out.println("Pemain tersebut tidak tersedia");
                    }
                    break;
                case 0:
                    System.exit(submenu);
                    break;
                default:
                    System.out.println("Pemain tersebut tidak tersedia");
            }
        }
    }
}
