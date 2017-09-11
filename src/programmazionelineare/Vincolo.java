
package programmazionelineare;

import java.awt.Color;

public class Vincolo {
    final int uguale=0;
    final int maggiore=2;
    final int minore=1;
    public Color colore = new Color((int)(Math.random()*255)%255,(int)(Math.random()*255)%255,(int)(Math.random()*255)%255,85);
    public double par_X,par_Y,val;
    public int operatore;
    public double intersezioneX0,intersezioneY0;

    
    public Vincolo(double par_X,double par_Y,double val,int operatore){
        
        this.par_X=par_X;
        this.par_Y=par_Y;
        this.val=val;
        this.operatore=operatore;
        if(this.par_X!=0 && this.par_Y!=0){
            this.intersezioneX0=(double)(this.val/this.par_Y);
            this.intersezioneY0=(double)(this.val/this.par_X);
        }
        if(this.par_X==0){
            this.intersezioneY0=(double)(this.val/this.par_Y);
        }
        if(this.par_Y==0){
            this.intersezioneX0=(double)(this.val/this.par_X);
        }
    }
    
    
    
}
