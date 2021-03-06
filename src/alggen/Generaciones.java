/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

/**
 *
 * @author Dell
 */
public class Generaciones {
      private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;

    public Generaciones(int num_G,double pMuta,int tamPob,int tamg){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.pobActual = new Poblacion(tamPob,tamg);

    }

    public void evolucionar(){
        int mascara [] = new int[]{1,0,1,0,1,0,1,0};
        Gen_Fen_Fit mejor;
        for(int g=0; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            mejor = new Gen_Fen_Fit(new int[mascara.length]);
            for(int i=0; i<this.tamPob;i++){
                Gen_Fen_Fit madre = Seleccion.seleccionAleatoria(this.pobActual);
                Gen_Fen_Fit padre = Seleccion.seleccionAleatoria(this.pobActual);
                Gen_Fen_Fit hijo = Cruza.op_cruza(madre,padre,mascara);
            
                if(Math.random()<this.pMuta){
                    Muta.aplicarMutaAleatoria(hijo);
                }
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness()>mejor.getFitness()){
                    mejor = new Gen_Fen_Fit(hijo.getGenotipo());
                }
            }
            System.out.println("Generación #"+g+":"+mejor.toString());
            this.pobActual = new Poblacion(nueva);

        }
        System.out.println();

    }


}
