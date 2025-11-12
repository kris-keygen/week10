package week10.kristian.id.ac.umn;

public class Upcasting {
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
	}
	
	public class karyawan extends Pekerja{
		public karyawan() {}
		
		public void tanyaIdentitas() {
			System.out.println("Saya seorang karyawan");
		}
	}
	
	public class main{
		main(String[] args) {
			
			Pekerja pekerja = new Pekerja();
			pekerja.tanyaIdentitas();
			
			pekerja = new CEO();
			pekerja.tanyaIdentitas();
			
			karyawan karyawan = new karyawan();
			pekerja = (Pekerja)karyawan;
			pekerja.tanyaIdentitas();
		}
	}
}
