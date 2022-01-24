package techproed.jdbcOrnekler;

import java.awt.color.ICC_Profile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "12345");
				
				
	  Statement st=  con.createStatement();
			 
		/* ornek;isciler adinda bir tablo olusturunuz,id int,birim Varchar(10)
		 * maas int
		 */
	 /* String sorgu = "CREATE TABLE isciler"
				 + " (id int primary key,"
		         + " birim VARCHAR(10),"
		         + " maas int)";
	  
	  
	  st.execute(sorgu);   // select te executeOuary,digerlerinde execute kullanmak gerek
	  System.out.println("isciler tablosu olustu");  */
	  
	  
	  
	 //boolean s1=execute(sorgu); bu cok tercih edilmez 
	  //execute() metodu DDL komutlarinda hep false deger dondurdugu icin 
	// donus degerine bakmak gerekli degildir. Zaten komutun calismasi ile 
	// ilgili bir sorun var ise SQL EXception olusacaktir.
	

	  /*======================================================================
//	  ORNEK2:isciler tablosunu siliniz 		
////	========================================================================*/
	  
	 // st.execute("drop table isciler");
	 // System.out.println("isciler tablosu silindi");
	  
	
	  
	  /*=======================================================================
		  ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar(20)} ekleyiniz.   
	========================================================================*/
	  //st.execute("alter table isciler ADD isim varchar(20)");
	   //System.out.println("sütun eklendi");
	  
	  //sutun eklemek alter table ile  yapilir
	  /*=======================================================================
//	  ORNEK4:isciler tablosuna soyisim VARCHAR(20) ve sehir VARCHAR(10)) 
//	  adinda 2 yeni sutun ekleyiniz.  
//	========================================================================*/  
	  
	//  st.execute("alter table isciler ADD (soyisim VARCHAR(20),sehir VARCHAR(10))");
	 // System.out.println("ikinci sutun eklendi");
	  
	  // sutun eklememk alter tabele add ile yapilir
	  
	  /*=======================================================================
////  ORNEK5:isciler tablosundaki birim sutunu siliniz.
////========================================================================*/ 
	  
	  //st.execute("alter table isciler drop column birim");
	 // System.out.println("isciler tablosundan birim sutunu silindi");
	  
	  /*=======================================================================
	  ORNEK6:isciler tablosunun adini calisanlar5 olarak degistiriniz.  
	========================================================================*/
	 // st.execute("alter table isciler rename to calisanlar");
	 // System.out.println("isciler ismi calisanlar oldu");
	  
	  
	  /*=======================================================================
//	  ORNEK7:calisanlar5 tablosunu siliniz.  
//	========================================================================*/
	 
	//  st.execute("DROP table calisanlar5");
	//  System.out.println("calisanlar tablosu silindi");
	  
	  
	  st.close();
	  con.close();
	  
	  
	  
	}

}
