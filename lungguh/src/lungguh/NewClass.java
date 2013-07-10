/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lungguh;

import java.util.Scanner;

/**
 *
 * @author enter
 */
public class NewClass {

    public static void main(String[] args) {
        //Tgs_string_672012109 tgs = new Tgs_string_672012109();
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan kalimat : ");
        String kal = scan.nextLine();
        System.out.println("\nUpper case : " + kal.toUpperCase());
        System.out.println("\nLower case : " + kal.toLowerCase());
        Modifier modifier = new Modifier();
        String kull = modifier.modify(kal, true, false, false, false);
        System.out.println("\nSentence case : " + kull);
        kull = modifier.modify(kal, false, true, false, false);
        System.out.println("\nTitle case : " + kull); //capitalizeFully(..)
        String kill = modifier.modify(kull, false, false, true, false);
        System.out.println("\nToggle case : " + kill);
        kull = modifier.modify(kal, false, false, false, true);
        System.out.println("\nWave case : " + kull);
        System.out.print("\n\nKarakter yang akan diganti : ");
        String oc = scan.next();
        System.out.print("Karakter akan diganti dengan : ");
        String nc = scan.next();
        System.out.println("\nHasil Akhir : " + kal.replace(oc, nc).toLowerCase());
    }
}

class Modifier {
    // keterangan buat wavenya ndak jelas, dia besar kecil besar (seperti prisip toggle)
    // menghiraukan spasi atau tidak?

    public String modify(String string, boolean sentence, boolean title, boolean toggle, boolean wave) {
        //kul = string;
        String kul = new String();
        String f_c = new String();
        boolean next = false;
        for (int i = 0; i < string.length(); i++) {
            if ((i == 0) /*&& (sentence || title || wave)*/) {
                f_c = String.valueOf(Character.toUpperCase(string.charAt(i)));
            } else if ((string.charAt(i) == ' ') && (title)) {
                f_c = " ";
                next = true;
            } else if (next) {
                f_c = String.valueOf(string.toUpperCase().charAt(i));
                next = false;
            } else if (wave) {
                if (i%2==1) {
                    f_c = String.valueOf(Character.toLowerCase(string.charAt(i)));
                } else {
                    f_c = String.valueOf(Character.toUpperCase(string.charAt(i)));
                }
            } else {
                f_c = String.valueOf(string.charAt(i));
            }
            kul = kul + f_c;
        }
        if (toggle) {
            String kul1 = kul;
            kul = "";
            for (int i = 0; i < kul1.length(); i++) {
                if (Character.isUpperCase(kul1.charAt(i))) {
                    f_c = String.valueOf(Character.toLowerCase(kul1.charAt(i)));
                } else {
                    f_c = String.valueOf(Character.toUpperCase(kul1.charAt(i)));
                }
                kul = kul + f_c;
            }
        }
        return kul;
    }
}
