package Package;

import java.util.*;
import java.io.*;

class Translate {

    Scanner scan = new Scanner(System.in);
    Map kamus = new HashMap();
    private String kal2;
    File f = new File("D:\\Kamus_indonesia.txt");
    File g = new File("D:\\Kamus_inggris.txt");

    public void tambahdata() {
        try {
            System.out.print("Masukan kata Indonesia\t: ");
            String kal = scan.next();
            System.out.print("Masukan kata Inggris\t: ");
            String kal2 = scan.next();
            BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
            kamus.put(kal, null);
            BufferedWriter br2 = new BufferedWriter(new FileWriter(g, true));
            kamus.put(kal2, null);
            br.write("," + kal);
            br2.write("," + kal2);
            br.close();
            br2.close();
        } catch (Exception e) {
            System.out.println("belum ada data");
        }
    }

    public String getbacaData(String x) {
        return kal2;
    }

    public int get_index_ind(String base, String kata) {
        int index = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String all_data = br.readLine();
            while (br.readLine() != null) {
                // baca semua data sampai habis
                all_data += br.readLine();
            }
            StringTokenizer tokenizer = new StringTokenizer(all_data, ",");
            // cari indexnya
            while (!tokenizer.nextToken().equals(kata)) {
                index++;
            }
        } catch (FileNotFoundException fnf) {
            System.out.printf("file tidak ditemukan");
        } catch (Exception e) {
        }
        return index;
    }

    public final void setbacaData(File f, File g) {

        try {
            if (!f.exists() && !g.exists()) {
                f.createNewFile();
                g.createNewFile();
            }
            BufferedReader bw = new BufferedReader(new FileReader(f));
            BufferedReader bw2 = new BufferedReader(new FileReader(g));
            String dataBase;
            String kal;
            //String kal2;
            int car = 0;
            while ((car = bw.read()) != -1) {
                dataBase = (char) car + bw.readLine();
                StringTokenizer token = new StringTokenizer(dataBase, ",");
                kal = token.nextToken();
                kal2 = token.nextToken();
                kamus.put(kal, kal2);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BacaString() {
        String[] defaultkal = {null};
        String[] defaultkal2 = {null};
        for (int i = 0; i < defaultkal.length; i++) {
            String string = defaultkal2[i];
        }
        setbacaData(f, g);
//        bacaData(g);
    }

    public static void main(String[] args) {
        Translate tgs = new Translate();
        int c = 0;
        do {
            System.out.println("Menu");
            System.out.println("1.Input");
            System.out.println("2.Translate");
            System.out.println("3.Exit");
            System.out.print("Masukan pilihanmu : ");
            int pil = tgs.scan.nextInt();
            if (pil == 1) {
                tgs.tambahdata();
            } else if (pil == 2) {
                System.out.println("1.Indonesia-Inggris");
                System.out.println("2.Inggris-Indonesia");
                System.out.print("pilih :");

                int plh = tgs.scan.nextInt();
                switch (plh) {
                    case 1:
                        System.out.print("Masukan kata indonesia : ");
                        String kata = tgs.scan.next();
                        File g = new File("D:\\Kamus_inggris.txt");
                        try (FileReader reader = new FileReader(g);
                                BufferedReader buff = new BufferedReader(reader)) {
                            String x = buff.readLine();
                            while (buff.readLine() != null) {
                                x += buff.readLine();
                            }
                            int index = 0;
                            index = tgs.get_index_ind(x, kata);
                            StringTokenizer tk = new StringTokenizer(x, ",");
                            System.out.print("Inggris'nya : ");
                            for (int i = 0; i < index; i++) {
                                tk.nextToken();
                            }
                            //System.out.printf("%s \t di index %d \n", tk.nextToken(),index);
                            // kalau bingung pake yang atas!
                            System.out.printf("%s \n", tk.nextToken());
                        } catch (Exception e) {
                            System.out.printf("%s", e.getMessage());
                        }
//                        System.out.print("Masukan kata indonesia : ");
//                        String kata = tgs.scan.next();
//                        File g = new File("D:\\Kamus_inggris.txt");
//                        try (FileReader reader = new FileReader(g); 
//                            BufferedReader buff = new BufferedReader(reader)) {
//                            String x = buff.readLine();
//                            StringTokenizer tk = new StringTokenizer("," + x);
//                            System.out.println("Inggris'nya : ");
//                            while (tk.hasMoreTokens()) {
//                                tk.nextToken();
//                            }
//                        } catch (Exception e) {
//                        }

//                            (FileReader reader = new FileReader(f);
//                        
//                        BufferedReader buff = new BufferedReader(reader)){
//                            String x = buff.readLine();

                        //+tgs.getbacaData(kata));
                        break;

//                        StringTokenizer tokenizer = new StringTokenizer(tgs.kal2,",",true);
//                        tgs.BacaString();
////                        System.out.print(tgs.y);
////                        StringTokenizer tokenizer = new StringTokenizer(tgs.y, ",",true);
                    case 2:
                        break;
//                        System.out.print("Masukan kata Inggris : ");
//                        String ing = tgs.scan.nextLine();
//                        System.out.println("Indonesia'nya : ");
//                        tgs.BacaString("D:\\Translate Indonesia.txt");
                }
            } else if (pil == 3) {
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak ada");
            }
        } while (c != 4);
    }
}