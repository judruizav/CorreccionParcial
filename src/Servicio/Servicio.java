/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;
import java.io.*;
import java.util.*;
import data.Asset;
import data.Cash;
import data.DividentStock;
import data.MutualFund;
import data.ShareAsset;
import data.Stock;
/**
 *
 * @author Estudiante
 */
public class Servicio {

    public Servicio() {
    }
    
    public String desencriptar(String encriptado){
      String desencriptado= "";
      char[] encriptChar= encriptado.toCharArray();
      char[] c= new char[encriptChar.length];
      for(int i=0; i<encriptChar.length; i++){
        int temp= (int) encriptChar[i];
        int des = ((temp - 3) % 255);
        c[i]= (char) des;
        desencriptado+=c[i];
      }
      return desencriptado;    
    }
    
    
    public void escribirDesencriptado(String archivo) throws IOException{
      FileReader lectura= null;
      try{
         lectura = new FileReader(archivo);
         BufferedReader bf= new BufferedReader(lectura);
         String temp;
         String[] tempString;
         while((temp = bf.readLine()) != null){
          if(desencriptar(temp.split(",")[0]).equals("CASH")){
            tempString= temp.split(",");
            tempString[0]=desencriptar(temp.split(",")[0]);
            System.out.println(Arrays.toString(tempString));
          }
          if((desencriptar(temp.split(",")[0]).equals("STOCK"))||(desencriptar(temp.split(",")[0]).equals("DIVSTOCK"))){
            tempString= temp.split(",");
            tempString[0]=desencriptar(temp.split(",")[0]);
            tempString[1]=desencriptar(temp.split(",")[1]);
            System.out.println(Arrays.toString(tempString));  
          }
        } 
      }finally{
        if(lectura!=null){
          lectura.close();
         }
       }
      
    }
    
    public double valorMercadoGoogleSamsung(ArrayList<ShareAsset> shareAssets){
       double c=0;
       for(int i=0; i<shareAssets.size();i++){
        if((shareAssets.get(i) instanceof Stock)||(shareAssets.get(i) instanceof DividentStock)){
          if(shareAssets.get(i).getSymbol().equals("GOOGLE")||shareAssets.get(i).getSymbol().equals("SAMSUMG")){
            c+=shareAssets.get(i).getMarketValue();
          } 
        }    
       }
       return c;
    }
    
    public double valorTotalAssets(ArrayList<ShareAsset> shareAssets, ArrayList<Cash> cash){
      double c=0;
      for(int i=0; i<shareAssets.size();i++){
        c+=shareAssets.get(i).getMarketValue();
      }
      for(int i=0; i<cash.size(); i++){
        c+=cash.get(i).getMarketValue();
      }
      return c;
    }
    
    public double beneficioAssets(ArrayList<ShareAsset> shareAssets){
      double c=0;
      for(int i=0; i<shareAssets.size();i++){
        c+=shareAssets.get(i).getProfit();
      }
      return c;
    }
}
