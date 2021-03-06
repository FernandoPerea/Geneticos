/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Poblacion {
    
 private LinkedList<Gen_Fen_Fit> poblacion;
    private int i;
    private int tam;

    public Poblacion(int i,int tam){
        this.i = i;
        this.tam=tam;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    public Poblacion(LinkedList<Gen_Fen_Fit> muestra, int i){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Gen_Fen_Fit(muestra.get(x).getGenotipo()));
        }
    }

      public Poblacion(){
        this.poblacion = new LinkedList<>();
        
    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        for(Gen_Fen_Fit aux: n.getPoblacion()){
            this.poblacion.add(new Gen_Fen_Fit(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(){

       for(int x=0; x< this.i; x++){
            this.poblacion.add(new Gen_Fen_Fit(this.tam));

       }

    }
    public LinkedList<Gen_Fen_Fit> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Gen_Fen_Fit> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public LinkedList<Gen_Fen_Fit> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Gen_Fen_Fit> muestra = new LinkedList<>();
     return muestra;
    }
   
   public LinkedList<Gen_Fen_Fit> getPoblacion(){

    return poblacion;
   }
}
