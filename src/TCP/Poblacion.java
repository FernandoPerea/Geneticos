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
public class Poblacion {
        
 private LinkedList<IndividuoTCP> poblacion;
    private int i;
    private int tam;

    public Poblacion(int i,int tam){
        this.i = i;
        this.tam=tam;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    public Poblacion(LinkedList<IndividuoTCP> muestra){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new IndividuoTCP(muestra.get(x).getGenotipo()));
        }
    }

      public Poblacion(){
        this.poblacion = new LinkedList<>();
        
    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        for(IndividuoTCP aux: n.getPoblacion()){
            this.poblacion.add(new IndividuoTCP(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(){

       for(int x=0; x< this.i; x++){
            this.poblacion.add(new IndividuoTCP(this.tam));

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
   
   public int getFitnessTotal(){
   int fitT=0;
   
   for(int i=0;i<poblacion.size();i++){
    fitT+=poblacion.get(i).getFitness();
   
   }
   return fitT;
   }
   
   public void mostrarPob(){
       System.out.println("HOLA"+poblacion.size());
   for(int z=0;z<poblacion.size();z++){
     String aux = "Genotipo: ";
        for (int i = 0; i < poblacion.get(z).getGenotipo().length; i++) {
            aux += poblacion.get(z).getGenotipo()[i] + ",";
            if (i == poblacion.get(z).getGenotipo().length - 1) {
                aux += poblacion.get(z).getGenotipo()[i];

            }
        }
        aux += " Fenotipo => " + poblacion.get(z).getFitness();
        System.out.println(aux);
   }
   }
}
