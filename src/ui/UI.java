/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import dao.Dao;
import data.Cash;
import data.ShareAsset;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import Exception.AssetException;
/**
 *
 * @author Julian
 */
public class UI {
    private Dao dao;

    public UI() {
        this.dao = new Dao();
    }
    
    public void menu(Scanner sc){
      int menu = 0;
      String archivo;
      ArrayList<Cash> cash=null;
      ArrayList<ShareAsset> shareAssets= null;
      System.out.println("Bienvenido a el sistema de datos de activos");
      do{
      System.out.println("1.Cargar Assets.\n2.Listar Assets desencriptados.\n3.Ver el valor total en el mercado de Google y Samsung.\n"
              + "4.Ver el valor total en el mercado de todos los Assets\n5.Ver el beneficio total de todos los Assets.\n6.Salir");
      menu=sc.nextInt();
      if(menu==1){
        try{  
          System.out.println("Ingrese el nombre del archivo que va a cargar");
          archivo=sc.next();
          shareAssets= this.dao.cargarShareAssets(archivo);
          cash= this.dao.cargarCashArray(archivo);
          System.out.println("Archivo cargado correctamente");
        }catch(IOException ex){
          System.out.println("El archivo especificado no existe");
        }
      }
      if(menu==2){
      try{
        System.out.println("Ingrese el nombre del archivo que va a cargar");
        archivo=sc.next();
        this.dao.getServicio().escribirDesencriptado(archivo);
      }catch(IOException ex){
          System.out.println("El archivo especificado no existe");
        }     
      }
      if(menu==3||menu==4||menu==5){
      try{  
        if((cash==null)&&(shareAssets==null)){
          throw new AssetException("Actualmente no hay Assets cargados");    
        } 
        if(menu==3){
          System.out.println("Valor total en el mercado de Google y Samsung= " + this.dao.getServicio().valorMercadoGoogleSamsung(shareAssets));
        }  
        if(menu==4){
          System.out.println("Valor total en el mercado de todos los Assets= " + this.dao.getServicio().valorTotalAssets(shareAssets, cash));
        }
        if(menu==5){
          System.out.println("Beneficio total de todos los Assets= " + this.dao.getServicio().beneficioAssets(shareAssets));  
        }
      }catch (AssetException ex){
        System.out.println(ex.getMessage());
      }
      } 
      }while(menu!=6);  
    }
}
