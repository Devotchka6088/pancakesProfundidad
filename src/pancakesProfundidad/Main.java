package pancakesProfundidad;

import java.util.LinkedList;

public class Main {
	
	static String ordenPrin = "";

	public static void main(String[] args){
		
		char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		String ordenRan = "";
		int nDiscos = 5;
		
		for(int i=0;i<=nDiscos-1;i++) {
			ordenPrin+=letras[i];
		}
		System.out.println("Inicio     > "+ordenPrin);
		
		ordenRan = shuffle();
		
		busquedaProfundidad(ordenRan);

	}
	
	private static String shuffle() {

		char[] pos = ordenPrin.toCharArray();
		String orden = "";
		for(int i=0;i<ordenPrin.length();i++) {
			int ran = (int)(Math.random()*ordenPrin.length());
			if(pos[ran]!=0) {
				orden+=pos[ran];
				pos[ran]=0;
			}else {
				i--;
			}
		}
		System.out.println("Aleatorio  > "+orden);
		return orden;
	}
	
	private static void busquedaProfundidad(String ordenRan){
		
		char[] pos = ordenRan.toCharArray();
		String orden = "";
		LinkedList<String> PilaDiscos= new LinkedList<String>();
		LinkedList<String> noRepDiscos= new LinkedList<String>();
		int contador = 0;
		int regreso = 0;
		PilaDiscos.add(ordenRan);
		
		while(!veriSol(orden)) {
			
			pos = PilaDiscos.getFirst().toCharArray();
			noRepDiscos.add(PilaDiscos.getFirst());
			PilaDiscos.clear();
			for(int i=1;i<pos.length;i++) {
				
				if(regreso!=i) {
					contador++;	
					for(int j=i;j>=0;j--) {
						orden+=pos[j];
					}
					
					for(int j=i+1;j<pos.length;j++) {
						orden+=pos[j];
					}
					
					if(veriSol(orden)) {
						break;
					}

					if(!noRepDiscos.contains(orden)) {
						PilaDiscos.add(orden);
					}
					orden = "";	
				}else {
					regreso=i;
				}
			}
		}
		System.out.println("\nSolucion encontrada");
		System.out.println("Nodos visitados > " + contador);
	}
	
	private static boolean veriSol(String ordenRan) {
		
		return ordenPrin.equals(ordenRan);
		
	}
}