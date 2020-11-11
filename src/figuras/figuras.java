package figuras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;


public class figuras {
	   private final String SEPARATOR = ",";          //se declara una variable
	    private ArrayList<String[]> datos;          //creamos un arreglo

	    
public void extraerDatos(String absolutePath) {
	// TODO Auto-generated method stub

    datos = new ArrayList<>();         
    BufferedReader br = null;          //lee el archivo csv

    try {

        br = new BufferedReader(new FileReader(absolutePath));          //creacion de una clase para lectura de un archivo
        String line = br.readLine();                  //declaracion de variables tipo texto
        while (null != line) {                 //ciclo repetitivo hasta que acabe la operacion
            String[] fields = line.split(SEPARATOR);
            datos.add(fields);
            line = br.readLine();
        }

    } catch (Exception e) {                //contiene sentencias 
        System.out.println(e);                //metodo para imprimir
    } finally {
        if (null != br) {                //metodo que proporciona instrucciones al programa
            try {    //se utiliza para tener escepciones en el programa
                br.close();      //cierre de operacion
            } catch (IOException ex) {              //contiene sentencias 
                Logger.getLogger(figuras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	
}


public void calcularAreas(JTextArea txa) {
	int i = 0;							//se declaran variables

	double base[]=new double[2];
    double altura[]=new double[2];
    double Rectangulo[]=new double[1];
    double circulo[]=new double[1];
    double Radio[]=new double[1];
    float sr=0;
    float sc = 0;
    
	for (String[] x : datos) {     //ciclo repetitivo que recorre el programa hasta acabar todas las sentencias
       if (x[0].equals("Rectangulo")){ //se pone un condicional que separa los rectangulos de los circulos
               base[i] = Float.parseFloat(x[1]);//se guarda la primera dimension del archivo csv en una variable 
               altura[i] = Float.parseFloat(x[2]);
               Rectangulo[i]=base[i]*altura[i];//se saca el area del rectangulo la cual es b*h
               sr+= Rectangulo[i];
           }
       if(x[0].equals("Circulo")){ //se pone condicional para identificar si es un circulo
           Radio[i] = Float.parseFloat(x[1]);
           circulo[i]=(Radio[i]*Radio[i]*Math.PI); //se saca el area del circulo
           sc+= circulo[i];
           }
       }
   
txa.append("Suma de Areas de rectangulos: "+sr+" m^2"+"\n"); //se imprime
txa.append("Suma de Areas de circulos: "+sc+" m^2"+"\n");

}
} 