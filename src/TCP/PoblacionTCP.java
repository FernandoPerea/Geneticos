/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class PoblacionTCP {
        
 private LinkedList<IndividuoTCP> poblacion;
    private int i;
    private int tam;

    public PoblacionTCP(int i,int tam, int[][]Matriz, int [][] Matrizi){
        this.i = i;
        this.tam=tam;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente( Matriz, Matrizi);
    }

    public PoblacionTCP(LinkedList<IndividuoTCP> muestra, int[][]Matriz, int [][] Matrizi){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new IndividuoTCP(muestra.get(x).getGenotipo(),Matriz,Matrizi));
        }
    }

      public PoblacionTCP(){
        this.poblacion = new LinkedList<>();
        
    }

    public PoblacionTCP(PoblacionTCP n, int[][] Matriz,int[][] MatrizI){
        this.poblacion = new LinkedList<>();
        for(IndividuoTCP aux: n.getPoblacion()){
            this.poblacion.add(new IndividuoTCP(aux.getGenotipo(),Matriz,MatrizI));

        }

    }

    public void inicializarAleatorimente( int[][]Matriz, int [][] Matrizi){

       for(int x=0; x< this.i; x++){
            this.poblacion.add(new IndividuoTCP(this.tam, Matriz, Matrizi));

       }

    }
    public LinkedList<IndividuoTCP> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<IndividuoTCP> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public LinkedList<IndividuoTCP> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<IndividuoTCP> muestra = new LinkedList<>();
     return muestra;
    }
   
   public LinkedList<IndividuoTCP> getPoblacion(){

    return poblacion;
   }
   
  
   
   public void mostrarPob(){
       System.out.println("# de Individuos : "+poblacion.size());
   for(int z=0;z<poblacion.size();z++){
     String aux = "Genotipo: ";
        for (int i = 0; i < poblacion.get(z).getGenotipo().length; i++) {
           
            if (i <= poblacion.get(z).getGenotipo().length - 1) {
                 aux += poblacion.get(z).getGenotipo()[i] + ",";
                

            }else{aux += poblacion.get(z).getGenotipo()[i];}
        }
        aux += " Fenotipo => " + poblacion.get(z).getFitness();
        System.out.println(aux);
   }
   }
}
