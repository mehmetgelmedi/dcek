package classes;
public class Config {
	private String konum;
	private int sure;
	
	public Config(String konum,int sure) {
		this.konum=konum;
		this.sure=sure;
	}
	public String getKonum(){
		return konum;
	}
	public int getGecikme(){
		return sure;
	}
}
