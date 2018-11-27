
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JPanel;


public class Graficas {
    JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    
    String titulo, elemento,Tiempo;
    
    final static int LINEAL = 1;
    final static int DISPERSION = 2;
    final static int LOGARITMICA = 3;
    
    public Graficas (int tipo, String titulo){
        this.titulo = titulo;
        tipoGrafica(tipo);
    }

    Graficas(String mi_grafica, String x, String y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void tipoGrafica(int tipo){
        switch(tipo){
            case LINEAL:
                grafica = ChartFactory.createXYLineChart(titulo, elemento, Tiempo, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case DISPERSION:
                grafica = ChartFactory.createScatterPlot(titulo, elemento,Tiempo, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case LOGARITMICA:
                grafica = ChartFactory.createXYLineChart(titulo, elemento, Tiempo, datos, PlotOrientation.VERTICAL, true, true, true);
                XYPlot ejes=grafica.getXYPlot();
                NumberAxis rango = new LogarithmicAxis(Tiempo);
                ejes.setRangeAxis(rango);
                break;
                
        }
            
    }
        
    public void agregarGrafica(String id,double [] x,double []y){
        XYSeries s = new XYSeries(id);
        int n = x.length;
        for(int i=0;i<n;i++){
            s.add(x[i],y[i]);
        }
        datos.addSeries(s);
    }
    
    //prueba
    public ChartPanel obtienePanel(){
        return new ChartPanel(grafica);
    }
}
