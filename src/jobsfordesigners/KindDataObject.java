/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

import java.text.DecimalFormat;

/**
 *
 * @author Nezhdanoff
 */
public class KindDataObject {
    private String  Kind = null;
    private float Volume = 0;
    private String  Unit = null;

  KindDataObject(
            String  K,
            float   V,
            String  N
    ) {
        this.Kind       = K;
        this.Volume     = V;
        this.Unit       = N;
    }

  KindDataObject(String  K) {
        this.Kind       = K;
    }


    public void setVolume(float V) {
        this.Volume = V;
    }
    public void setKind(String K) {
        this.Kind = K;
    }

    public void setUnit(String U) {
        this.Unit = U;
    }

    public float getVolume() {
        return this.Volume;
    }

    public String getVolume_toString() {
        String patt = "### ###.###";
        DecimalFormat myFormatter = new DecimalFormat(patt);
        return myFormatter.format(this.Volume);
    }

    public String getKind() {
        return this.Kind;
    }

    public String getUnit() {
        return this.Unit;
    }
    @Override
    public String toString() {
        if (this.Unit != null) {
            String patt = "### ###.###";
            DecimalFormat myFormatter = new DecimalFormat(patt);
            String str = myFormatter.format(this.Volume);
            return this.Kind + " " + str + this.Unit;
        } else {
            return this.Kind;
        }
    }
}

