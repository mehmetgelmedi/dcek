package classes;

public class Main {

	public static void main(String[] args) {
		if (args.length==3) {
		Config config=new Config(args[0],Integer.parseInt(args[1]));
		//String url="https://gui.kentkart.com.tr/images/a.png";
		//String url2="http://www.kc-metro.com/gtf/google_transit.zip";
		Dosya dosya=new Dosya(args[2], config);
		dosya.DosyaCek();
		}
		else{
			System.out.println("Eksik ya da yanliþ parametre duzeni\nParametre sirasini Konum, Sure ve Url olarak giriniz\n");
		}
	}
}
