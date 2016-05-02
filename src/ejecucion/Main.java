/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;
import Servicio.Servicio;
import java.io.*;
import java.util.Scanner;
import data.Asset;
import data.Cash;
import data.DividentStock;
import data.MutualFund;
import data.ShareAsset;
import data.Stock;
import java.util.ArrayList;
import dao.Dao;
import ui.UI;
/**
 *
 * @author Julian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      UI ui= new UI();
      Scanner sc= new Scanner(System.in);
      int main=1;
      while(main==1){
        ui.menu(sc);
        System.out.println("1.Continuar 0.Salir");
        main=sc.nextInt();
      }
    }
    
}