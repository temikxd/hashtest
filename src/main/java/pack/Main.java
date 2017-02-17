package pack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    static  long run(int n){
        int c = 10000;
        long t0 = System.currentTimeMillis();
        MyHashTable t = new MyHashTable(n);
        for (int i = 0; i<c; i++){
            t.put("table"+i, "стол"+i);
        }
        for (int i = 0; i<100; i++){
            for (int j = 0; j<c; j++){
                t.get("table"+j);
            }
        }
        long t1 = System.currentTimeMillis();
        return t1-t0;
    }

    public static void main(String[] args) throws IOException {

    XYSeries s=new XYSeries("1");
        int []ns= {100,500,1000};
        for (int n:ns){
            long t = run(n);
            s.add(n,t);

        }

        XYSeriesCollection c=new XYSeriesCollection(s);
        JFreeChart ch= ChartFactory.createXYLineChart("Hach","n","T",c);
        BufferedImage im=ch.createBufferedImage(800,600);
        File f=new File ("chart.png");
        ImageIO.write(im,"png",f);

    }









}
