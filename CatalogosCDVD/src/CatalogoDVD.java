import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class CatalogoDVD {
	private ArrayList<DVD> listaDVD= new ArrayList<DVD>();
	
	
	public CatalogoDVD() {	
	}
	
	public DVD buscarPorTitulo(String titulo) {
		DVD	dvdBuscado=null;
		for (DVD dvd:listaDVD) {
			if(dvd.getTituloAlbum().equals(titulo)) {
				dvdBuscado=dvd;
			}
		}
	return dvdBuscado;
	}
	
	public void meterDVD(DVD dvd) {
		listaDVD.add(dvd);
	}
	
	public void eliminarDVD(String titulo) {
		if(buscarPorTitulo(titulo)!=null) {
			listaDVD.remove(buscarPorTitulo(titulo));
		}
	}
	
	public void cambiarAtributos(String titulo) {
		DVD dvdtrabajado=buscarPorTitulo(titulo);
		if(dvdtrabajado!=null) {
			int seleccion=JOptionPane.showOptionDialog(null,"¿Que desea editar?","DVD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Artista","Canciones","Duracion","Stock","Comentario","Genero","Nada"}, "Nada");
			if(seleccion!=-1) {
				if(seleccion==0) {
					dvdtrabajado.setTituloAlbum(JOptionPane.showInputDialog("Nuevo titulo:"));
				}else if(seleccion==1) {
					int cantidadCanciones= Integer.parseInt(JOptionPane.showInputDialog("Cantidad de canciones:"));
					dvdtrabajado.setCanciones(cantidadCanciones);
				}else if(seleccion==2) {
					double duracion= Double.parseDouble(JOptionPane.showInputDialog("Duración:"));
					dvdtrabajado.setDuracion(duracion);
				}else if(seleccion==3) {
					boolean stock= Boolean.parseBoolean(JOptionPane.showInputDialog("Stock:"));
					dvdtrabajado.setStock(stock);
				}else if(seleccion==4) {
					dvdtrabajado.setComentario(JOptionPane.showInputDialog("Comentario:"));
				}else if(seleccion==5) {
					dvdtrabajado.setGenero(JOptionPane.showInputDialog("Genero:"));
				}else if(seleccion==6) {
					System.out.println("No desea cambiar nada");
				}
			}
		}	
	}
	
	public void listarDVDs() {
		for(DVD dvd:listaDVD) {
			System.out.println(dvd.getTituloAlbum()+"-"+dvd.getArtista());
		}
	}
	
	public void listarDVDEnStock() {
		for(DVD dvd:listaDVD) {
			if(dvd.isStock()==true) {
				System.out.println(dvd.getTituloAlbum()+"-"+dvd.getArtista());
			}else {
				;
			}	
		}
	}
	public void listarDVDPorDuracion(double duracion) {
		for(DVD dvd:listaDVD) {
			if(dvd.getDuracion()<duracion) {
				System.out.println(dvd.getTituloAlbum()+"-"+dvd.getArtista());
			}else {
				;
			}	
		}
	}
	public void listarDVDPorDuracion(String autor) {
		for(DVD dvd:listaDVD) {
			if(dvd.getArtista().equals(autor)) {
				System.out.println(dvd.getTituloAlbum());
			}else {
				;
			}	
		}
	}
	public void listarDVDsPorTitulo() {
		Collections.sort(listaDVD,new Comparator<DVD>(){
			public int compare(DVD dvd1,DVD dvd2) {
				return dvd1.getTituloAlbum().compareTo(dvd2.getTituloAlbum());
			}});
			for(DVD dvd:listaDVD) {
				System.out.println(dvd.getTituloAlbum()+"-"+dvd.getArtista());
			}
		}
	
	public void cuantosDVD() {
		int contadordvd=0;
		for(@SuppressWarnings("unused") DVD dvd:listaDVD) {
			contadordvd+=1;
		}System.out.println("la cantida de DVDs es de : "+contadordvd);
	}
	
	public void cuantosDVDenStock() {
		int contadordvd=0;
		for(DVD dvd:listaDVD) {
			if(dvd.isStock()==true) {
				contadordvd+=1;
			}System.out.println("la cantida de DVDs en stock es de : "+contadordvd);
		}
	}
	}


	
	
	
	
	
	
	

	


