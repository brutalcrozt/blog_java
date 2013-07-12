/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 *
 * @author enter_rebel
 */
public class Niconnetion {

    public static void main(String[] args) {
        String string = " **   ** ";
        String string1 = "****I****";
        String string2 = "*L*O*V*E*";
        String string3 = " *F*T*I* ";
        String string4 = "  *****  ";
        String string5 = "    *    ";
        int delay = 250;
        int nanos = 99;
        Write once = new Write(string, delay,nanos);
        once.mulai();
        once.setTo_write(string1);
        once.lining();
        once.mulai();
        once.setTo_write(string2);
        once.lining();
        once.mulai();
        once.setTo_write(string3);
        once.lining();
        once.mulai();
        once.setTo_write(string4);
        once.lining();
        once.mulai();
        once.setTo_write(string5);
        once.lining();
        once.mulai();
    }
}

class Write extends Thread {

    private String to_write;
    private int delay;
    private int nano;
    public Write(String string, int aka_delay,int aka_nano) {
        this.delay = aka_delay;
        this.to_write = string;
        nano = aka_nano;
    }

    public void lining() {
        System.out.println("");
    }

    public void mulai() {
        for (int i = 0; i < to_write.length(); i++) {
            int delayed = 10 - i;
            try {
                System.out.printf("%s", to_write.charAt(i));
                sleep(delay * delayed + 1,nano);
            } catch (InterruptedException x) {
                System.out.println("Interupted");
            }
        }
    }

    /**
     * @param to_write the to_write to set
     */
    public void setTo_write(String to_write) {
        this.to_write = to_write;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * @param nano the nano to set
     */
    public void setNano(int nano) {
        this.nano = nano;
    }
}