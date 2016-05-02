/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import Servicio.Servicio;
import data.Asset;
import data.DividentStock;
import data.Stock;
import data.MutualFund;
import data.ShareAsset;
import data.Cash;
import java.util.*;
import java.io.*;
/**
 *
 * @author Julian
 */
public class Dao {
    private Servicio servicio;

    public Dao() {
      this.servicio= new Servicio();
    }  

    public Servicio getServicio() {
        return servicio;
    }
    
    
    
    public Cash cargarCash(String[] lineaLectura){
      Cash cash = new Cash(Integer.parseInt(lineaLectura[1]));
      return cash;
    }
    
    public Stock cargarStock(String[] lineaLectura){
      Stock stock= new Stock(this.servicio.desencriptar(lineaLectura[1]), Double.parseDouble(lineaLectura[2]),
              Double.parseDouble(lineaLectura[3]),Integer.parseInt(lineaLectura[4]));
      return stock;
    }
    
    public DividentStock cargarDividentStock(String[] lineaLectura){
      DividentStock dividentStock= new DividentStock(this.servicio.desencriptar(lineaLectura[1]),Double.parseDouble(lineaLectura[2]), 
        Double.parseDouble(lineaLectura[3]), Integer.parseInt(lineaLectura[4]), Double.parseDouble(lineaLectura[5]));
      return dividentStock;
    }
    
    public ArrayList<ShareAsset> cargarShareAssets(String archivo) throws IOException{
      ArrayList<ShareAsset> shareAssets= new ArrayList<ShareAsset>();
      FileReader lectura=null;
      try{
        lectura=new FileReader(archivo);
        BufferedReader bf= new BufferedReader(lectura);
        String temp;
        while((temp= bf.readLine())!=null){
          if(this.servicio.desencriptar(temp.split(",")[0]).equals("STOCK")){
            Stock stock= cargarStock(temp.split(","));
            shareAssets.add(stock);
          }
          if(this.servicio.desencriptar(temp.split(",")[0]).equals("DIVSTOCK")){
            DividentStock dividentStock= cargarDividentStock(temp.split(","));
            shareAssets.add(dividentStock);
          }
          
        }
      }finally{
        if(lectura!=null){
          lectura.close();
         }
       }
      return shareAssets;
    }
  
        
    public ArrayList<Cash> cargarCashArray(String archivo) throws IOException{
      ArrayList<Cash> cashArray= new ArrayList<Cash>();
      FileReader lectura=null;
      try{
        lectura=new FileReader(archivo);
        BufferedReader bf= new BufferedReader(lectura);
        String temp;
        while((temp= bf.readLine())!=null){
          if(this.servicio.desencriptar(temp.split(",")[0]).equals("CASH")){
            Cash cash= cargarCash(temp.split(","));
            cashArray.add(cash);
          }   
        }
      }finally{
        if(lectura!=null){
          lectura.close();
         }
       }
      return cashArray;
    }
    
}
