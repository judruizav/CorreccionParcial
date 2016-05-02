/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Estudiante
 */
public class DividentStock extends Stock {
    protected double dividends;

    public DividentStock(String symbol, double totalCost, double CurrentPrice, int totalShares,double dividends) {
        super(symbol, totalCost, CurrentPrice, totalShares);
        this.dividends = dividends;
    }

    public double getDividends() {
        return dividends;
    }
        
    @Override
    public double getMarketValue(){
      return super.getMarketValue() + this.dividends;    
    }

    @Override
    public String toString() {
        return super.toString() + "DividentStock{" + "dividends=" + dividends + '}';
    }
    
}
