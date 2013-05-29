/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getin;

/**
 *
 * @author enter
 * no literal FOR! looping gak cuma FOR!
 */
public class Getin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ax,ctrl,temp,space;
        ax = 1;
        ctrl=1;
        do {
            temp=ax;
            space=11-ax-temp;
            while(temp>0) {
                System.out.print("*");
                temp--;
            }
            temp=ax;
            if (ax>=6) {
                ctrl=-1;
                temp--;
            }
            while (space>0) {
                System.out.print(" ");
                space--;
            }
            while(temp>0) {
                System.out.print("*");
                temp--;
            }
            System.out.println();
            ax=ax+ctrl;
        } while (ax!=0);
    }
}
