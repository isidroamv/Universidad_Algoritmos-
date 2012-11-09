

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package recursion;

/**
 *
 * @author Isidro
 */
public class Kicksort {

    /*Regresa un arreglo ordenado
     por medio del algoritmo quicksort
    */
    public int[] quicksort(int numeros[])
    {
        
        return quicksort(numeros,0,numeros.length-1);

    }
    public int[] quicksort(int[] numeros,int izq,int der)
    {
        if(izq>=der)
            return numeros;
        int i=izq,d=der;
        if(izq!=der)
        {
        int pivote;
        int aux;
        pivote = izq;
        while(izq!=der)
        {//imprimeArreglo(numeros);

         while(numeros[der]>=numeros[pivote] && izq<der)
               der--;
           while(numeros[izq]<numeros[pivote] && izq<der)
               izq++;
           
         if(der!=izq)
         {
             aux = numeros[der];
            numeros[der]= numeros[izq];
            numeros[izq]=aux;}
        }
        if(izq==der){
            quicksort(numeros,i,izq-1);
            quicksort(numeros,izq+1,d);
        }
        }
        else
            return numeros;
       return numeros;
    }




    public void imprimeArreglo(int[] integers){
        String imp="";
        for(int i=1;i<integers.length;i++){
            if(i!=integers.length-1)
            imp=imp+integers[i]+",";
            else
                imp=imp+integers[i]+"";
        }
        System.out.println(imp);
    }
}
