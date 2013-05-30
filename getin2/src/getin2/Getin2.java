/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getin2;

/**
 *
 * @author enter
 *
 * no literal FOR! looping gak cuma FOR!
 */
 public class Getin2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ctrl,key,asterisk,x,space;
        key = -2;
        x = 1;
        ctrl = 0;
        do {
            System.out.print("*");
            if (key>2) {
              x = -1;  
            }
            key = key + x;
            asterisk = 0;
            space = key ;
            while  (space>0) {
                System.out.print(" ");
                asterisk++;
                space--;
            }
            space = key;
            asterisk = 7 - (asterisk * 2);
            while (asterisk>0) {
                System.out.print("*");
                asterisk--;
            }
            while  (space>0) {
                System.out.print(" ");
                space--;
            }
            System.out.println("*");
            ctrl++;
        } while (ctrl<9);
        
    }
}
