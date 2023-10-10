import java.util.Scanner;
import java.util.ArrayList;
public class Game {
    private Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen kullanıcı adınızı giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " Bu karanlık ve sisli dünyaya Hoşgeldiniz! Burada yaşanan herşey gerçek!");
        System.out.println("Lütfen bir karakter seçiniz !");
        System.out.println("------------------------------------------");
        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            if (player.getInventory().isWater() && player.getInventory().isFirewood() && player.getInventory().isFood()){
                System.out.println("------------------------------------------------------------------------------------------------------------");
                System.out.println("##########################################TEBRİKLER BU MACERADAN BAŞARIYLA KURTULDUNUZ !##########################################");
                System.out.println("---------------------------------------------YENİ MACERALAR İÇİN SENİ TEKRAR OYUNA BEKLİYORUZ!!---------------------------------------------------------------");
                break;
            }
            
            System.out.println();
            System.out.println("--------Bölgeler------");
            System.out.println();
            System.out.println("1-Güvenli Ev----> Burası Sizin için güvenli ev");
            System.out.println("2-Eşya Dükkanı--->Silah veya Zırh alabilirsin");
            System.out.println("3-Mağara--->Ödül <Yemek > , dikkatli ol Zombi çıkabilir!!");
            System.out.println("4-Orman--->Ödül <Odun > , dikkatli ol Vampir çıkabilir!!");
            System.out.println("5-Nehir--->Ödül <Su> , dikkatli ol Ayı çıkabilir!!");
            System.out.println("6-Maden--->Ödül <Para, Silah veya Zırh > , dikkatli ol Yılan çıkabilir!!");
            System.out.println("0-Çıkış Yap-->Oyunu Sonlandır");
            System.out.println("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0 :
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInventory().isFood()) {
                        System.out.println("--------------------------------------------------------------------------------------------");
                        System.out.println("Bu bölüm ödülünü daha önce kazandınız ! Güvenli eve gidiyorsunuz !");
                        location=new SafeHouse(player);
                        break;
                    }
                    location=new Cave(player);
                        break;
                case 4:
                    if (player.getInventory().isFirewood()){
                        System.out.println("--------------------------------------------------------------------------------------------");
                        System.out.println("Bu bölüm ödülünü daha önce kazandınız ! Güvenli eve gidiyorsunuz !");
                        location=new SafeHouse(player);
                        break;
                    }
                    location=new Forest(player);
                    break;
                case 5:
                    if (player.getInventory().isWater()){
                        System.out.println("--------------------------------------------------------------------------------------------");
                        System.out.println("Bu bölüm ödülünü daha önce kazandınız ! Güvenli eve gidiyorsunuz !");
                        location=new SafeHouse(player);
                        break;
                    }
                    location=new River(player);
                    break;
                case 6:
                    location = new Maden(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz!");
            }
            if (location ==null) {
                System.out.println("Oyun bitti Yeni Maceralarda Görüşmek Üzere");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
