/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class Seleccion {
     public static Gen_Fen_Fit seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
       int pos = ran.nextInt(pob.getPoblacion().size());

       return new Gen_Fen_Fit(pob.getPoblacion().get(pos).getGenotipo()); 
    }
}
