package bagli_sirala;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BagliListeEleman {
    int deger;
    int adres;
    BagliListeEleman sonraki;

    public BagliListeEleman(int deger, int adres) {
        this.deger = deger;
        this.adres = adres;
        this.sonraki = null;
    }
}

class BagliListe {
    BagliListeEleman baslangic;

    public BagliListe() {
        this.baslangic = null;
    }

    public void elemeanEkle(int deger, int adres) {
        BagliListeEleman yeniEleman = new BagliListeEleman(deger, adres);

        if (baslangic == null) {
            baslangic = yeniEleman;
        } else {
            BagliListeEleman temp = baslangic;
            while (temp.sonraki != null) {
                temp = temp.sonraki;
            }
            temp.sonraki = yeniEleman;
        }
    }

    public void sirala() {
        BagliListeEleman mevcut = baslangic;
        BagliListeEleman index = null;
        int temp;

        if (baslangic == null) {
            return;
        } else {
            while (mevcut != null) {
                index = mevcut.sonraki;

                while (index != null) {
                    if (mevcut.adres > index.adres) {
                        temp = mevcut.deger;
                        mevcut.deger = index.deger;
                        index.deger = temp;

                        temp = mevcut.adres;
                        mevcut.adres = index.adres;
                        index.adres = temp;
                    }
                    index = index.sonraki;
                }
                mevcut = mevcut.sonraki;
            }
        }
    }

    public void yazdir() {
        BagliListeEleman temp = baslangic;
        while (temp != null) {
            System.out.println(temp.deger +" "+ temp.adres);
            temp = temp.sonraki;
        }
    }
}

public class Bagli_Sirala {

    public static void main(String[] args) {
        BagliListe liste = new BagliListe();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adını giriniz: ");
        String dosyaAdi = scanner.nextLine();

        try {
            File dosya = new File(dosyaAdi);
            Scanner scan = new Scanner(dosya);

            while (scan.hasNextLine()) {
                int sayi = Integer.parseInt(scan.nextLine());
                int adres = Integer.parseInt(new StringBuilder(String.valueOf(sayi)).reverse().toString());
                liste.elemeanEkle(sayi, adres);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Böyle bir dosya bulunamadı!");
  
        }
        liste.sirala();
        liste.yazdir();
    }

}
