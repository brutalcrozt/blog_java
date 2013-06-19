/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.io.IOException;
import java.util.Scanner;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enter
 */
public class AI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner baca = new Scanner(System.in);
        double entropy;
        int tot_parameter;
        System.out.print("Masukkan jumlah parameter untuk dihitung : ");
        tot_parameter = baca.nextInt();
        System.out.print("Masukkan jumlah data yang tersedia : ");
        int jml_data = baca.nextInt();
        System.out.print("Masukkan jumlah attribut terbanyak : ");
        int max_attribut = baca.nextInt();
        baca.skip("\n");
        Entropy adi_allen = new Entropy(tot_parameter, jml_data, max_attribut);
        adi_allen.set_attribut();
        entropy = adi_allen.calc_entropy();
        for (int i = 0; i < tot_parameter; i++) {
            adi_allen.gain(i);
        }
        adi_allen.print_data();
    }
}

class Entropy {

    private int tot_parameter, jml_data, max_attribut;
    final double log2 = Math.log10(2); //rumus
    private String[] parameter;
    String[][] jenis_attribut;
    private int[] jml_attribut;
    private double entropy;
    Scanner pembaca = new Scanner(System.in);
    private double[] gain; // data in
    private double[] sub_entropy; // klo ga salah untuk menyimpan gain

    public Entropy(int tot_parameter, int jml_data, int max_attribut) {
        this.tot_parameter = tot_parameter;
        this.jml_data = jml_data;
        this.max_attribut = max_attribut;
        jenis_attribut = new String[tot_parameter][max_attribut];
        parameter = new String[tot_parameter];
        jml_attribut = new int[tot_parameter];
        gain = new double[tot_parameter];
    }

    public int get_tot_parameter() {
        return this.tot_parameter;
    }

    public void set_attribut() {
        for (int i = 0; i < tot_parameter; i++) {
            System.out.print("Masukkan nama parameter ke-" + (i + 1) + " : ");
            parameter[i] = pembaca.nextLine();
            System.out.print("Masukkan jumlah attribut untuk parameter " + parameter[i] + " : ");
            jml_attribut[i] = pembaca.nextInt();
            pembaca.skip("\n");
            for (int j = 0; j < jml_attribut[i]; j++) {
                System.out.print("Masukkan jenis attribut ke-" + (j + 1) + " untuk parameter " + parameter[i] + " : ");
                jenis_attribut[i][j] = pembaca.nextLine();
            }
        }
    }

    public double calc_entropy() {
        double ya, tidak, pec_y, pec_t, log_pec_y, log_pec_t, ha;
        System.out.println("Perhitungan entropy(S)");
        System.out.print("Masukkan jumlah data S = ya untuk total data =" + jml_data + " : ");
        ya = pembaca.nextDouble();
        System.out.print("Masukkan jumlah data S = tidak untuk total data =" + jml_data + " : ");
        tidak = pembaca.nextDouble();
        System.out.printf("entropy(S) = -(%d/%d)log2(%d/%d) + (-(%d/%d)log2(%d/%d) \n",
                (int) ya, (int) jml_data, (int) ya, (int) jml_data, (int) tidak, (int) jml_data, (int) tidak, (int) jml_data);
        pec_y = ya / jml_data;
        pec_t = tidak / jml_data;
        System.out.printf("entropy(S) = -(%.5f)((log(%d/%d))/log2) + (-(%.5f)((log(%d/%d))/log2)) \n",
                pec_y, (int) ya, (int) jml_data, pec_t, (int) tidak, (int) jml_data);
        log_pec_y = Math.log10(pec_y);
        log_pec_t = Math.log10(pec_t);
        System.out.printf("entropy(S) = -(%.5f)(%.5f/%.5f) + (-(%.5f)(%.5f/%.5f)) \n",
                pec_y, log_pec_y, log2, pec_t, log_pec_t, log2);
        // ya dan tidak digunakan untuk menyimpan perhitungan log2(a/b) masing-masing
        ya = log_pec_y / log2;
        tidak = log_pec_t / log2;
        System.out.printf("entropy(S) = -(%.5f)(%.5f) + (-(%.5f)(%.5f)) \n",
                pec_y, ya, pec_t, tidak);
        // pec ya dan tidak di kali -1
        pec_y = -1 * pec_y;
        pec_t = -1 * pec_t;
        // ya digunakan untuk menyimpan gain ya 
        // tidak digunakan untuk menyimpan gain tidak
        ya = pec_y * ya;
        tidak = pec_t * tidak;
        System.out.printf("entropy(S) = %.5f + %.5f \n", ya, tidak);
        // ha adalah hasilakhir yang akan dikembalikan nilainya
        ha = ya + tidak;
        System.out.printf("entropy(S) = %.5f \n", ha);
        this.entropy = ha;
        this.tunggu();
        return ha;
    }
    // parameter x adalah total data jika menghitung entropy S 
    // adalah total fuck!

    public void tunggu() {
        try {
            System.in.read();// wait user type any key please!! damn fuck
        } catch (IOException ex) {
            Logger.getLogger(Entropy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// desain to calculate gain for 1 parameter

    public double gain(int index_parameter) {
        System.out.println("perhitungan gain untuk " + parameter[index_parameter]);
        double end_result[], pec_end_result[], log_pec_end_result[], ha, sub_total[], pec_tot[];
        end_result = new double[2]; // ya dan tidak
        pec_end_result = new double[2];
        log_pec_end_result = new double[2];
        sub_total = new double[jml_attribut[index_parameter]];
        sub_entropy = new double[jml_attribut[index_parameter]];
        pec_tot = new double[jml_attribut[index_parameter]];
        int counter;
        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
            System.out.print("Masukkan jumlah data S = ya untuk " + jenis_attribut[index_parameter][i] + " ");
            counter = 0;
            end_result[counter] = pembaca.nextDouble();
            counter++;
            System.out.print("Masukkan jumlah data S = tidak untuk " + jenis_attribut[index_parameter][i] + " ");
            end_result[counter] = pembaca.nextDouble();
            sub_total[i] = end_result[counter] + end_result[counter - 1];// jadi pembagi dan pembilang
// calc sub enthropy
            if (((int) end_result[0] == 0) || ((int) end_result[1] == 0)) {
                System.out.println("ada salah satu end result bernilai nol maka\n"
                        + "sub entropy " + jenis_attribut[index_parameter][i] + " = 0");
                sub_entropy[i] = 0;
            } else if ((int) end_result[0] == (int) end_result[1]) {
                System.out.println("karena nilai end_result ya dan end_result tidak bernilai sama\n"
                        + "yaitu " + end_result[0] + " dan " + end_result[1] + " maka sub entropy " + jenis_attribut[index_parameter][i] + " = 1");
                sub_entropy[i] = 1;
            } else {
                System.out.printf("sub entropy(S" + jenis_attribut[index_parameter][i] + ") = -((%d/%d)log2(%d/%d)) + "
                        + "((%d/%d)log2(%d/%d)) \n",
                        (int) end_result[0], (int) sub_total[i], (int) end_result[0], (int) sub_total[i],
                        (int) end_result[1], (int) sub_total[i], (int) end_result[1], (int) sub_total[i]);
                pec_end_result[0] = end_result[0] / sub_total[i];
                pec_end_result[1] = end_result[1] / sub_total[i];
                System.out.printf("sub entropy(S" + jenis_attribut[index_parameter][i] + ") = -(%.5f)((log(%d/%d))/log2) + "
                        + "(-(%.5f)((log(%d/%d))/log2)) \n",
                        pec_end_result[0], (int) end_result[0], (int) sub_total[i],
                        pec_end_result[0], (int) end_result[1], (int) sub_total[i]);
                log_pec_end_result[0] = Math.log10(pec_end_result[0]);
                log_pec_end_result[1] = Math.log10(pec_end_result[1]);
                System.out.printf("sub entropy(S" + jenis_attribut[index_parameter][i] + ") = -(%.5f)(%.5f/%.5f) + "
                        + "(-(%.5f)(%.5f/%.5f)) \n",
                        pec_end_result[0], log_pec_end_result[0], log2,
                        pec_end_result[1], log_pec_end_result[1], log2);
                // end_result[] 0 dan 1 digunakan untuk menyimpan perhitungan log2(a/b) masing-masing
                end_result[0] = log_pec_end_result[0] / log2;
                end_result[1] = log_pec_end_result[1] / log2;
                System.out.printf("sub entropy(S" + jenis_attribut[index_parameter][i] + ") = -(%.5f)(%.5f) +"
                        + " (-(%.5f)(%.5f)) \n",
                        pec_end_result[0], end_result[0],
                        pec_end_result[1], end_result[1]);
                // pec_end_result[] 0 dan 1 di kali -1
                pec_end_result[0] = pec_end_result[0] * -1;//-1
                pec_end_result[1] = pec_end_result[1] * -1;//-1
                // ya digunakan untuk menyimpan gain ya // old 
                // tidak digunakan untuk menyimpan gain tidak //old
                end_result[0] = pec_end_result[0] * end_result[0];
                end_result[1] = pec_end_result[1] * end_result[1];
                System.out.printf("sub entropy(S" + jenis_attribut[index_parameter][i] + ") = %.5f + %.5f \n", end_result[0], end_result[1]);
                // ha adalah hasilakhir yang akan dikembalikan nilainya
                sub_entropy[i] = end_result[0] + end_result[1];
                System.out.printf("sub entropy(S" + jenis_attribut[index_parameter][i] + ") = %.5f \n", sub_entropy[i]);
            }
        }
        // tambahan sebuah pecahan di depan rumus
        ha = 0;
        System.out.printf("Gain (S %s) = %.5f ",parameter[index_parameter],entropy);
        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
            System.out.printf("-(%d/%d)*",(int)sub_total[i],this.jml_data,sub_entropy[i]);
        }
        System.out.println("");
        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
            pec_tot[i] = sub_total[i] / (double) this.jml_data;
        }
        System.out.printf("Gain (S %s) = %.5f ",parameter[index_parameter], entropy);
        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
            System.out.printf("-(%.5f)*(%.5f)",pec_tot[i],sub_entropy[i]);
        }
        System.out.println("");
        ha = entropy;
        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
            ha = ha - (sub_entropy[i]*pec_tot[i]);
        }
        System.out.printf("Gain (S %s) = %.5f \n",parameter[index_parameter], ha);
        this.gain[index_parameter] = ha;
        this.tunggu();
        return ha;
    }

    public void print_data() {
        for (int i = 0; i < parameter.length; i++) {
            System.out.println("parameter ke " + (i + 1) + " : " + parameter[i]);
            for (int j = 0; j < this.jenis_attribut[i].length; j++) {
                if (jenis_attribut[i][j] == null) {
                    continue;
                } else {
                    System.out.println("attribut ke " + (j + 1) + " adalah " + jenis_attribut[i][j]);
                }
            }
            System.out.println("gain " + parameter[i] + " adalah " + gain[i]);
        }
    }
}
//public double gain(int index_parameter) {
//        System.out.println("perhitungan gain untuk " + parameter[index_parameter]);
//        double end_result[], pec_end_result[], log_pec_end_result[], ha, sub_total[], pec_tot;
//        end_result = new double[2]; // ya dan tidak
//        pec_end_result = new double[2];
//        log_pec_end_result = new double[2];
//        sub_total = new double[jml_attribut[index_parameter]];
//        sub_entropy = new double[jml_attribut[index_parameter]];
//        int counter;
//        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
//            System.out.print("Masukkan jumlah data S = ya untuk " + jenis_attribut[index_parameter][i]+" ");
//            counter = 0;
//            end_result[counter] = pembaca.nextDouble();
//            counter++;
//            System.out.print("Masukkan jumlah data S = tidak untuk " + jenis_attribut[index_parameter][i]+" ");
//            end_result[counter] = pembaca.nextDouble();
//            sub_total[i] = end_result[counter] + end_result[counter - 1];// jadi pembagi dan pembilang
//// calc sub enthropy
//            if (((int) end_result[0] == 0) || ((int) end_result[1] == 0)) {
//                System.out.println("ada salah satu end result bernilai nol maka\n"
//                        + "sub_entropy " + parameter[i] + " = 0");
//                sub_entropy[i] = 0;
//            } else if ((int) end_result[0] == (int) end_result[1]) {
//                System.out.println("karena nilai end_result ya dan end_result tidak bernilai sama\n"
//                        + "yaitu " + end_result[0] + " dan " + end_result[1] + " maka sub_entropy " + parameter[i] + " = 1");
//                sub_entropy[i] = 1;
//            } else {
//                pec_tot = sub_total[i] / (double) this.jml_data;
//                // tambahan sebuah pecahan di depan rumus
//                System.out.printf("entropy(S" + parameter[index_parameter] + ") = -(%d/%d)((%d/%d)log2(%d/%d)) + "
//                        + "(%d/%d)((%d/%d)log2(%d/%d)) \n",
//                        (int) sub_total[i], this.jml_data, (int) end_result[0], (int) sub_total[i], (int) end_result[0], (int) sub_total[i],
//                        (int) sub_total[i], this.jml_data, (int) end_result[1], (int) sub_total[i], (int) end_result[1], (int) sub_total[i]);
//                pec_end_result[0] = end_result[0] / sub_total[i];
//                pec_end_result[1] = end_result[1] / sub_total[i];
//                System.out.printf("entropy(S" + parameter[index_parameter] + ") = -(%.5f)((%.5f)((log(%d/%d))/log2)) + "
//                        + "(-(%.5f)((%.5f)((log(%d/%d))/log2))) \n",
//                        pec_tot, pec_end_result[0], (int) end_result[0], (int) sub_total[i], pec_tot, pec_end_result[0], (int) end_result[1], (int) sub_total[i]);
//                log_pec_end_result[0] = Math.log10(pec_end_result[0]);
//                log_pec_end_result[1] = Math.log10(pec_end_result[1]);
//                System.out.printf("entropy(S" + parameter[index_parameter] + ") = -(%.5f)((%.5f)(%.5f/%.5f)) + (-(%.5f)((%.5f)(%.5f/%.5f))) \n",
//                        pec_tot, pec_end_result[0], log_pec_end_result[0], log2, pec_tot, pec_end_result[1], log_pec_end_result[1], log2);
//                // end_result[] 0 dan 1 digunakan untuk menyimpan perhitungan log2(a/b) masing-masing
//                end_result[0] = log_pec_end_result[0] / log2;
//                end_result[1] = log_pec_end_result[1] / log2;
//                System.out.printf("entropy(S" + parameter[index_parameter] + ") = -(%.5f)((%.5f)(%.5f)) + (-(%.5f)((%.5f)(%.5f))) \n",
//                        pec_tot, pec_end_result[0], end_result[0], pec_tot, pec_end_result[1], end_result[1]);
//                // pec_end_result[] 0 dan 1 di kali -1
//                pec_end_result[0] = -1 * end_result[0] * pec_tot;
//                pec_end_result[1] = -1 * end_result[1] * pec_tot;
//                // ya digunakan untuk menyimpan gain ya // old 
//                // tidak digunakan untuk menyimpan gain tidak //old
//                end_result[0] = pec_end_result[0] * end_result[0];
//                end_result[1] = pec_end_result[1] * end_result[1];
//                System.out.printf("entropy(S" + parameter[index_parameter] + ") = %.5f + %.5f \n", end_result[0], end_result[1]);
//                // ha adalah hasilakhir yang akan dikembalikan nilainya
//                sub_entropy[i] = end_result[0] + end_result[1];
//                System.out.printf("entropy(S" + parameter[index_parameter] + ") = %.5f \n", sub_entropy[i]);
//            }
//        }
//        ha = 0;
//        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
//            ha = entropy - sub_entropy[i];
//        }
//        System.out.print("Gain (S" + parameter[index_parameter] + ") = " + entropy + " ");
//        for (int i = 0; i < jml_attribut[index_parameter]; i++) {
//            System.out.println(sub_entropy + " ");
//        }
//        System.out.println("");
//        this.gain[index_parameter] = ha;
//        this.tunggu();
//        return ha;
//    }