/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate.services;

import java.util.LinkedList;

/**
 *
 * @author 2098325
 */
public interface CalculateDate {
    
    
    public Double Media(LinkedList<Double>datos);
    public Double DesviaEstandar(LinkedList<Double> dat,Double media);
    public void addDato(Double numero);
    public void reset();
    
}
