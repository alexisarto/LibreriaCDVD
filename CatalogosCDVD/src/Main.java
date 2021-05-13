
public class Main {

	public static void main(String[] args) {
		CatalogoDVD catalogo= new CatalogoDVD();
		DVD dvd= new DVD("EL INDIO","asd",3,25.7,true,"asd","asd");
		DVD dvd1= new DVD("AL INDIO","asd",3,25.7,true,"asd","asd");
		DVD dvd2= new DVD("BL INDIO","asd",3,25.7,true,"asd","asd");
		
		catalogo.meterDVD(dvd);
		catalogo.meterDVD(dvd1);
		catalogo.meterDVD(dvd2);
	}

}
