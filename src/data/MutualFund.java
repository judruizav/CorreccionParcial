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
public class MutualFund extends ShareAsset{
    protected double totalShares;

    public MutualFund(double totalShares, String symbol, double totalCost, double CurrentPrice) {
        super(symbol, totalCost, CurrentPrice);
        this.totalShares = totalShares;
    }
       
    @Override
    public double getMarketValue(){
      return this.totalShares * this.CurrentPrice;      
    }

    @Override
    public double getProfit() {
      return(this.totalShares*this.CurrentPrice) - this.totalCost;         
    }
}
