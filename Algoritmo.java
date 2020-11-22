/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author Issei
 */
public class Algoritmo {
    
    int i,j,temporal;
    
    public Algoritmo(){
        this.i=0;
        this.j=0;
        this.temporal=0;
    }
 
    public void radix(int [] arreglo){
        int x, i, j;
        for(x=Integer.SIZE-1;x>=0;x--){//Integer.SIZE-1 nos da 32 bits 31-0
            int auxiliar[] = new int[arreglo.length];//creamos un vector auxiliar del mismo tamanio que arreglo
            j=0;//contador
            for(i=0;i<arreglo.length;i++){
                boolean mover=arreglo[i]<< x >=0;//si x es >=0 entonces devolvera un true o false que se asignara al arreglo en posisicion i que se llama mover
                //Operador ternario
                //resultado=(condicion)? valor:valor2
                if(x==0 ? !mover:mover){//si x es igual a 0, evalua y niegame mover y comparamelo con mover
                    auxiliar[j]=arreglo[i];//si resulta verdadero
                    j++;//incrementamos j
                }else{//si no resulta verdadero
                    arreglo[i-j]=arreglo[i];
                }
            }
             for(i=j;i<auxiliar.length;i++){//para ir copiando lo que tengamos en el arreglo auxiliar
                auxiliar[i]=arreglo[i-j];
            }
            arreglo=auxiliar;//lo que teniamos en auxiliar lo volvemos a pasar a arreglo
        }
        System.out.print("El arreglo ordenado con Radix es:");
        mostrarArreglo(arreglo);
       
    }
    //Mostrar los datos del vector
    public void mostrarArreglo(int [] arreglo){
        int k;//creamos variable local
        for(k=0;k<arreglo.length;k++){
            System.out.print("["+arreglo[k]+"]");
        }
        System.out.println();
    }
}
