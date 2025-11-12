package week10.kristian.id.ac.umn;

public class Downcasting {
	public class Pekerja{
		public Pekerja() {}
		
		public void tanyaIdentitas() {
			System.out.println("Saya pekerja biasa");
		}
	}
	
	public class CEO extends Pekerja{
		public CEO() {}
		
		public void tanyaIdentitas() {
			System.out.println("Saya seorang CEO");
		}
		
		public void tanyaPendapat() {
			System.out.println("Pendapatan saya 100 jt");
		}
	}
	
	public class main{
		main(String[] args) {
			CEO c = new CEO();
			Pekerja p = new CEO();
			c = (CEO)p;
			c.tanyaPendapat();
		}
	}
}
