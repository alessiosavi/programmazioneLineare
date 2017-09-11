
package programmazionelineare;

import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Graphics;
import java.awt.Polygon;
import java.text.NumberFormat;
import javax.swing.JPanel;


public class Grafico extends JPanel {
    
    public Finestra finestra;
    public double scalaX,scalaY,salta=0;
    final int uguale = 0;
    final int maggiore = 2;
    final int minore = 1;
    NumberFormat formattatore = NumberFormat.getNumberInstance();


    
    public Grafico(){
        
    
        
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        g.drawLine(15, this.getHeight()-15, 15, 15);
        g.drawLine(15, this.getHeight()-15, this.getWidth()-15, this.getHeight()-15);
        g.drawLine(15,15,20,20);
        g.drawLine(15,15,10,20);
        g.drawLine(this.getWidth()-15,this.getHeight()-15,this.getWidth()-20,this.getHeight()-20);
        g.drawLine(this.getWidth()-15,this.getHeight()-15,this.getWidth()-20,this.getHeight()-10);
        g.drawString("0",10, this.getHeight()-4);
        g.drawString("x",this.getWidth()-10,this.getHeight()-5);
        g.drawString("y",10,10);
        if(salta==1){
            if(!finestra.array.isEmpty()){
                int x[]=new int[5];
                int y[]=new int[5];
                
                //disegna tutto
                for(int i=0;i<finestra.array.size();i++){
                    formattatore.setMaximumFractionDigits(2);
                    g.setColor(Color.BLACK);
                    g.drawLine((int)(15+(finestra.array.get(i).intersezioneX0/scalaX)),this.getHeight()-15,15,this.getHeight()-15-(int)((finestra.array.get(i).intersezioneY0/scalaY)));
                    //segno minor
                    if(finestra.array.get(i).operatore==minore){
                        //x<qualcosa
                        if(finestra.array.get(i).par_Y==0){
                            g.setColor(Color.BLACK);
                            g.drawLine(15+(int)(finestra.array.get(i).intersezioneX0/scalaX), 0, 15+(int)(finestra.array.get(i).intersezioneX0/scalaX), this.getHeight()-15);
                            g.setColor(finestra.array.get(i).colore);
                            g.fillRect(15,0,(int)(finestra.array.get(i).intersezioneX0/scalaX),this.getHeight()-15);
                            g.setColor(black);
                            g.drawString(formattatore.format(finestra.array.get(i).intersezioneX0), 13+(int)(finestra.array.get(i).intersezioneX0/scalaX), this.getHeight()-5);
                            g.setColor(finestra.array.get(i).colore);
                        }
                        //y<qualcosa
                        if(finestra.array.get(i).par_X==0){
                            g.setColor(finestra.array.get(i).colore);
                            g.fillRect(15,this.getHeight()-15-(int)(finestra.array.get(i).intersezioneY0/scalaY),this.getWidth()-15,(int)(finestra.array.get(i).intersezioneY0/scalaY));
                        }
                        //completa
                        if(finestra.array.get(i).par_Y!=0 && finestra.array.get(i).par_X!=0){
                            x[0]=15;
                            x[1]=15;
                            x[2]=15+(int)(finestra.array.get(i).intersezioneX0/scalaX);
                            y[0]=this.getHeight()-15;
                            y[1]=this.getHeight()-15-(int)(finestra.array.get(i).intersezioneY0/scalaY);
                            y[2]=this.getHeight()-15;
                            System.out.println("("+x[0]+","+y[0]+")");
                            System.out.println("("+x[1]+","+y[1]+")");
                            System.out.println("("+x[2]+","+y[2]+")");
                            g.setColor(black);
                            g.drawString(formattatore.format(finestra.array.get(i).intersezioneY0), x[1]-2, y[1]+10);
                            g.drawString(formattatore.format(finestra.array.get(i).intersezioneX0), x[2]-2, y[2]+10);
                            g.setColor(finestra.array.get(i).colore);
                            g.fillPolygon(x, y, 3);
                        }
                    }
                    //segno maggiore
                    if(finestra.array.get(i).operatore==maggiore){
                        //x>qualcosa
                        g.setColor(finestra.array.get(i).colore);
                        if(finestra.array.get(i).par_Y==0){
                            g.fillRect(15+(int)(finestra.array.get(i).intersezioneX0/scalaX),0,this.getWidth()-15-(int)(finestra.array.get(i).intersezioneX0/scalaX),this.getHeight()-15);
                        }
                        //y>qualcosa
                        if(finestra.array.get(i).par_X==0){
                            g.fillRect(15,0,this.getWidth()-15,this.getHeight()-15-(int)(finestra.array.get(i).intersezioneY0/scalaY));
                        }
                        //completa
                        if(finestra.array.get(i).par_Y!=0 && finestra.array.get(i).par_X!=0){
                            x[0]=this.getWidth();
                            y[0]=0;
                            x[1]=15;
                            y[1]=0;
                            x[2]=15;
                            y[2]=this.getHeight()-15-(int)(finestra.array.get(i).intersezioneY0/scalaY);
                            x[3]=15+(int)(finestra.array.get(i).intersezioneX0/scalaX);
                            y[3]=this.getHeight()-15;
                            x[4]=this.getWidth();
                            y[4]=this.getHeight()-15;
                            System.out.println("("+x[0]+","+y[0]+")");
                            System.out.println("("+x[1]+","+y[1]+")");
                            System.out.println("("+x[2]+","+y[2]+")");
                            System.out.println("("+x[3]+","+y[3]+")");
                            System.out.println("("+x[4]+","+y[4]+")");
                            g.setColor(finestra.array.get(i).colore);
                            g.fillPolygon(x, y, 5);
                        }
                    }
                    
                    finestra.calcolaIntersezioni();
                    //disegna intersezioni
                    for(int j=0;j<finestra.arrayintx.size();j++){
                        g.setColor(Color.RED);
                        g.fillOval(12+(int)(finestra.arrayintx.get(j).doubleValue()/scalaX), (int) (this.getHeight()-17-(finestra.arrayinty.get(j).doubleValue()/scalaY)), 5, 5);
                    }
                    
                }
            }
            
        }
        

    }
    
    
    public void passaFinestra(Finestra finestra){
        this.finestra=finestra;
    }
    
    
    
    
}
