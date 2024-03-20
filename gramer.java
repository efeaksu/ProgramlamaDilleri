package gramer;

import java.util.Scanner;

public class gramer {

    private static final String[] ozne = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
    private static final String[] nesne = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
    private static final String[] yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in); // klavyeden girilen ifadeyi alıyoruz
        System.out.print("ifade girisi : ");
        String ifade = s1.nextLine();
        
        if (kontrol(ifade)) {//ifade kontrolü ve çıktı
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
    }

    private static boolean kontrol(String ifade) {//ifadenin gramer uygunluğunu kontrol eden fonksiyon
        String[] kelimeler = ifade.trim().split("\\s+");//ifadeyi boşluklardan ayır
        if (kelimeler.length != 3) {//gramere uygun olması için ifadede 3 kelime olması gerekir
            return false;
        }
        if(!ozneUygun_Mu(kelimeler[0]) || !nesneUygun_Mu(kelimeler[1]) || !yuklemUygun_Mu(kelimeler[2])) {  //özne-nesne-yüklem sırasının doğruluğunu kontrol ediliyor
            return false;
        }
        
        return true;
    }

    private static boolean ozneUygun_Mu(String kelime) {//klavyeden girilen kelimenin "ozne" dizisinde olup olmadığını kontrol ediyor
        for (String ozne : ozne) {
            if (ozne.equals(kelime)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean nesneUygun_Mu(String kelime) {//klavyeden girilen kelimenin "nesne" dizisinde olup olmadığını kontrol ediyor
        for (String nesne : nesne) {
            if (nesne.equals(kelime)) {
                return true;
            }
        }
        return false;
    }

    private static boolean yuklemUygun_Mu(String kelime) {//klavyeden girilen kelimenin "yuklem" dizisinde olup olmadığını kontrol ediyor
        for (String yuklem : yuklem) {
            if (yuklem.equals(kelime)) {
                return true;
            }
        }
        return false;
    }
}
