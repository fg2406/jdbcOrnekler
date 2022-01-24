package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
     Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "12345");
		
		
	 Statement st=  con.createStatement();
	 
	 /*========================================
	  * SORU1)ogrenciler(ogr) tablosundaki tum kayitlari listeleyen bir sorgu yaziniz
	  ======================================= */
		
		//ResultSet kayt=st.executeQuery("SELECT*from ogr");
		
		/*while (kayt.next()) {
			System.out.println(kayt.getInt(1)+" "+kayt.getString(2)+" "+kayt.getString(3)+" "+kayt.getInt(4));
		}
		*/
		/*con.close();  silemek icin close yapilir
	       st.close();
	       kayt.close(); */
		//===============Isim ve yazili notlarini listeleyen bir sorgu yaziniz
		

     /*SORU2)satis ve muhasebe bolumlerinde calisan personelin isimlerini,masslarini ters sirali
      * olarak listeleyin*/
      
	  /*  ResultSet liste=st.executeQuery("select isim,maas "
	 		+ " from bolumler"
	 		+ " where bolum_id in(10 ,30)"
	 		+ " order by maas desc;");
	 
	while (liste.next()) {
		System.out.println(liste.getString(1)+" \t"+liste.getDouble("maas"));
	}
	
	/*Tum bolumlerde calisan personelin isimlerini,bolum isimlerini Ve maaslarini, 
	  bolum  ve maas sirali listeleyiniz.Not:calisani olmasa bile 
	  bolum ismi gosterilsin */
	
	/*ResultSet veri=st.executeQuery("select b.bolum_isim,p.personel_isim, p.maas "
			+ " from personel p right join bolumler b "  //MUHASEBE	EBRU	1300
			 + " on p.bolum_id=b.bolum_id");                                         //MUHASEBE	SEHER	5000
			                                              //MUHASEBE	HARUN	2450
			         + " order by b.bolum_isim, p.maas");*/
	
	//order by da ayni olanlari listeler,ama asil sira select sonraya gore cikar
	
	
	
	   
	  ResultSet veri=st.executeQuery("select b.bolum_isim,p.personel_isim, p.maas "
				+ " from personel p left join bolumler b "  
				 + " on p.bolum_id=b.bolum_id");                                         //MUHASEBE	SEHER	5000
			
	   
	   while (veri.next()) {
			System.out.println(veri.getString(1)+"\t"+veri.getString(2)+"\t"+veri.getInt(3));
		
		
		   } 
		
	   st.close();
	   veri.close();
	   con.close();
	  
	   /*
	 	A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
	 	   dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
	 	    1) execute() metodu 
	 	    2) excuteUpdate() metodu.  
	 	    
	 	B) - execute() metodu hertur SQL ifadesiyle kullanibilen genel bir komuttur. 
	 	   - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken, 
	 	     DML islemlerinde true deger dondurur. 
	 	   - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
	 	     durumlarda tercih edilmektedir.  
	 	     
	 	C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
	 	   - bu islemlerde islemden etkilenen satir sayisini dondurur.
	 	   - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	 */

	    /*=======================================================================
		  ORNEK1:isciler adinda bir tablo olusturunuz id int, 
		  birim VARCHAR(10), maas int		========================================================================*/ 
	   /* String sorgu = "CREATE TABLE isciler"
				 + " (id int primary key,"
		         + " birim VARCHAR(10),"
		         + " maas int)";
	    
	  st.execute(sorgu);
	  System.out.println("isciler tablosu oluşturuldu"); */
    
    //	    boolean s1=st.execute(sorgu);
      //    
     //	    System.out.println("isciler tablosu oluşturuldu" +s1);
    
      // execute() metodu DDL komutlarinda hep false deger dondurdugu icin 
	 		// donus degerine bakmak gerekli degildir. Zaten komutun calismasi ile 	 		// ilgili bir sorun var ise SQL EXception olusacaktir.  
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}

}
