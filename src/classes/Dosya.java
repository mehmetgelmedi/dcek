package classes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Timer;
import java.util.TimerTask;

public class Dosya {
	private URI url;
	private Path path;
	private Config config;
	private Timer timer;
	
	public Dosya(String url,Config config) {
		try {
			this.url=new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		this.config=config;
		path=Paths.get(config.getKonum()+getUzanti());
		timer =new Timer();
	}

	public void DosyaCek() {
		System.out.println("Ýndirilmeye baþlandi.");
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try (InputStream in = url.toURL().openStream()) {
				    Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
				    in.close();
				    System.out.println("Dosya belirtilen konuma indirildi.");
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 1, 1000*60*config.getGecikme()); //kaç defa , ne kadar surede
	}
	public String getUzanti(){
		String dosyaAdi_uzanti = "";

		int i = url.toString().lastIndexOf('/');
		if (i > 0) {
			dosyaAdi_uzanti = url.toString().substring(i+1);
		}
		return dosyaAdi_uzanti;
	}
	
	
}
