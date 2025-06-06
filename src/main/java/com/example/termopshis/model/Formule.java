package com.example.termopshis.model;

import org.springframework.stereotype.Component;

@Component
public class Formule {
    public final double UniverGasConst = 8.31;
    private double Presser;
    private double Amount_substans = 1;
    private double Valume;
    private double Tempeture = 293 ;

    public double getTempeture() {
        return Tempeture;
    }
    public double getAmount_substans() {
        return Amount_substans;
    }
    public double getValume () {
        return Valume;
    }
    public double getPresser() {
        return Presser;
    }

    public void setPresser(double presser) {this.Presser = presser;}

    public void setAmount_substans(double amount_substans) {
        this.Amount_substans = amount_substans;
    }
    public void setValume(double valume) {this.Valume = valume;}
    public void setTempeture(double tempeture) {this.Tempeture = tempeture;}

    public double mend_Clap_press(double valume) {
        return UniverGasConst * Amount_substans * Tempeture / valume;
    }
    public double mend_Clap_press(double valume, double amount_substans) {
        return UniverGasConst * amount_substans * Tempeture / valume;
    }
    public  double mend_Clap_val (double press) {
        return UniverGasConst * Amount_substans * Tempeture / press;
    }
    public Formule(double val_) {
        Valume = val_;
        Presser = mend_Clap_press(val_);
    }
    public Formule(double val_, double amount_) {
        Valume = val_;
        Presser = mend_Clap_press(val_, amount_);
    }
    public Formule(double val_, double amount_, double tempeture_) {
        Valume = val_;
        Tempeture = tempeture_;
        Presser = mend_Clap_press(val_, amount_);
    }
    public void reset(double val_) {
        Presser = mend_Clap_val(val_);
        Valume = val_;
    }
    public Formule() {};
}