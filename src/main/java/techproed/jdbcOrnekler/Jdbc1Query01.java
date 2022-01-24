package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		

		
		// 1) ilgili driver ı yüklemeliyiz. tv nin fişini tak, mesela başka alet çalışmasın, ne çalışacağını bilsin
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//2) bağlantı oluşturmalıyız   uydu şifrelerini girmeliyiz,con herhangi bir isim,connection baglanti demek
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "12345");
		
		//3) SQL komutları için bir Statement(aciklama) nesnesi oluştur her kanal için kumanda da yer ayarlamak
	       Statement st=      con.createStatement();
		
	     //4)SQL ifadeleri yazabilir ve calistirabiliriz kumanda da 1e basarim trt1 gelir
	       //verileri SQL den getirdik,executeQuery bunun icine ne istersek yazacaz,birseye atadikki kolay tek isimle kullanalim 
	       
	       ResultSet veri= st.executeQuery("SELECT isim,maas FROM personel WHERE id=123456789"); 
	       
	       
	      // 5) sonuclari aldik ve isledik,burda hep while kullanacaz ve iterator
	       
	       while (veri.next()) {
	    	   System.out.println(veri.getString("isim")  + veri.getInt("maas")  );  //veri ne ise ona gore secim yapilir,getInt,getDouble vs.
	    	   System.out.println("personel adi :"+veri.getString(1)+"Maas:"+veri.getInt(2));//bunun yazmasi boyle olacak
			//1 yazarsan isim algilar cunku yukarda isim 1.sirada,2 yazarsan maas algilar
		}
	       
	    //6)  olusturulan nesneleri bellekten kaldiralim,bellek dolmasin diye
	       
	       con.close();
	       st.close();
	       veri.close();  //artik bundan sonra sql den veri gelmez                     
	       
	      //password hatası alanlar, mysql de use sys yapılmış herhangi bir sayfaya      
	       //ALTER USER ‘root’@‘localhost’ IDENTIFIED BY ‘1234’;   
	       //bu kodu yapıştırıp seçerek run etsin şifresi artık 1234 olur 
	       
	       
	       // BUTUN IMPORTLAR sql den olmali
	       
	      //1,2 ve 3 teki ler hep kopyala yapistir yapilacak,sqp den birsey alinacaksa
	       //executeQuery 4.madde deki bunun icine ne cagiracaksak onu yazacagiz,her zaman executeQuery
	       
	 // select mutlaka executeQuery kullanilir,bunun disirnda
	  // execute,executeUpdate 
	       
	}

}
		
		
		
		
		
		
	


