import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class CatalogoCD {
	private ArrayList<CD> listaCD= new ArrayList<CD>();
	
	
	public CatalogoCD() {	
	}
	
	public CD buscarPorTitulo(String titulo) {
		CD	cdBuscado=null;
		for (CD cd:listaCD) {
			if(cd.getTituloAlbum().equals(titulo)) {
				cdBuscado=cd;
			}
		}
	return cdBuscado;
	}
	
	public void meterCD(CD cd) {
		listaCD.add(cd);
	}
	
	public void eliminarCD(String titulo) {
		if(buscarPorTitulo(titulo)!=null) {
			listaCD.remove(buscarPorTitulo(titulo));
		}
	}
	
	public void cambiarAtributos(String titulo) {
		CD cdtrabajado=buscarPorTitulo(titulo);
		if(cdtrabajado!=null) {
			int seleccion=JOptionPane.showOptionDialog(null,"¿Que desea editar?","DVD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Artista","Canciones","Duracion","Stock","Comentario","Genero","Nada"}, "Nada");
			if(seleccion!=-1) {
				if(seleccion==0) {
					cdtrabajado.setTituloAlbum(JOptionPane.showInputDialog("Nuevo titulo:"));
				}else if(seleccion==1) {
					int cantidadCanciones= Integer.parseInt(JOptionPane.showInputDialog("Cantidad de canciones:"));
					cdtrabajado.setCanciones(cantidadCanciones);
				}else if(seleccion==2) {
					double duracion= Double.parseDouble(JOptionPane.showInputDialog("Duración:"));
					cdtrabajado.setDuracion(duracion);
				}else if(seleccion==3) {
					boolean stock= Boolean.parseBoolean(JOptionPane.showInputDialog("Stock:"));
					cdtrabajado.setStock(stock);
				}else if(seleccion==4) {
					cdtrabajado.setComentario(JOptionPane.showInputDialog("Comentario:"));
				}else if(seleccion==5) {
					cdtrabajado.setGenero(JOptionPane.showInputDialog("Genero:"));
				}else if(seleccion==6) {
					System.out.println("No desea cambiar nada");
				}
			}
		}	
	}
	
	public void listarCDs() {
		for(CD cd:listaCD) {
			System.out.println(cd.getTituloAlbum()+"-"+cd.getArtista());
		}
	}
	
	public void listarDVDEnStock() {
		for(CD cd:listaCD) {
			if(cd.isStock()==true) {
				System.out.println(cd.getTituloAlbum()+"-"+cd.getArtista());
			}else {
				;
			}	
		}
	}
	public void listarCDPorDuracion(double duracion) {
		for(CD cd:listaCD) {
			if(cd.getDuracion()<duracion) {
				System.out.println(cd.getTituloAlbum()+"-"+cd.getArtista());
			}else {
				;
			}	
		}
	}
	public void listarCDPorDuracion(String autor) {
		for(CD cd:listaCD) {
			if(cd.getArtista().equals(autor)) {
				System.out.println(cd.getTituloAlbum());
			}else {
				;
			}	
		}
	}
	public void listarCDsPorTitulo() {
		Collections.sort(listaCD,new Comparator<CD>(){
			public int compare(CD cd1,CD cd2) {
				return cd1.getTituloAlbum().compareTo(cd2.getTituloAlbum());
			}});
			for(CD cd:listaCD) {
				System.out.println(cd.getTituloAlbum()+"-"+cd.getArtista());
			}
		}
	
	public void cuantosCD() {
		int contadorcd=0;
		for(@SuppressWarnings("unused") CD cd:listaCD) {
			contadorcd+=1;
		}System.out.println("la cantida de DVDs es de : "+contadorcd);
	}
	
	public void cuantosCDenStock() {
		int contadorcd=0;
		for(CD cd:listaCD) {
			if(cd.isStock()==true) {
				contadorcd+=1;
			}System.out.println("la cantida de DVDs en stock es de : "+contadorcd);
		}
	}
	public void buscarPorArtista(String artista) {
		for (CD cd:listaCD) {
			if(cd.getArtista().equals(artista)) {
				System.out.println(cd.getTituloAlbum());
			}
		}
	}
	
	public void cuantosTemas(String titulo) {
		System.out.println("El cd tiene: "+buscarPorTitulo(titulo).getCanciones()+" canciones");
	}
	}