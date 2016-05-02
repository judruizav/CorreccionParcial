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
public class Stock extends ShareAsset{
    protected int totalShares;

    public Stock(String symbol, double totalCost, double CurrentPrice, int totalShares) {
        super(symbol, totalCost, CurrentPrice);
        this.totalShares = totalShares;
    }

    public int getTotalShares() {
        return totalShares;
    }
    
    @Override
    public double getProfit(){
      return(this.totalShares*this.CurrentPrice) - this.totalCost;    
    }
    
    @Override
    public double getMarketValue(){
      return this.totalShares * this.CurrentPrice;    
    }

    @Override
    public String toString() {
        return super.toString() + "Stock{" + "totalShares=" + totalShares + '}';
    }
    
    
}
