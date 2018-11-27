
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import static java.lang.Math.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


public class GraficasTest extends JFrame implements ActionListener {
        JFreeChart grafica;

    
    
    
    public GraficasTest(){
        
        
        Graficas migrafica=new Graficas(Graficas.DISPERSION, "Comparador de Algoritmos AA-ESPOL");
        
        double [] x = rango(1,100,8);
        double [] y = f(x);
        

        final ButtonGroup grupo = new ButtonGroup();
        JFreeChart chart = null;
        final ChartPanel chartPanel = new ChartPanel(chart);
        
        
        /*final JButton button = new JButton("Algoritmo 1");
        //button.setPreferredSize(new Dimension(50, 50)); esta expresion no va
        button.setBounds(10, 20, 200, 100);
        //button.setActionCommand("ADD_DATA");
        button.addActionListener(this);*/
        
        final JButton button2 = new JButton("Algoritmo 2");
        button2.setPreferredSize(new Dimension(50, 50));
        //button2.setActionCommand("AdD");
        button2.addActionListener(this);
        
        final JButton button3 = new JButton("Algoritmo 3");
        button3.setPreferredSize(new Dimension(50, 50));
        //button3.setActionCommand("AdA");
        button3.addActionListener(this);
        
        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        //content.add(button);
        //content.add(button, BorderLayout.NORTH);
        content.add(button2,BorderLayout.PAGE_END);
        content.add(button3,BorderLayout.PAGE_START);
        //chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(content);
        
       /////////////////////////////////////////////////////////////////////////  
        migrafica.agregarGrafica("Algoritmo X", x, y);
        JPanel panel = migrafica.obtienePanel();
        
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
    
    public double [] rango(double xi, double xn,double d){
        int n = (int)((xn-xi)/d);
        double [] r = new double [n];
        for(int i=0;i<n;i++){
            r[i]=xi+d*i;
        }
        return r;
    }
    
    public double [] f(double [] x){
        int n = x.length;
        double [] y = new double [n];
        
        for(int i =0;i<n;i++){
            //double radianes = x[i]*PI/180;
            //y[i]=sin(radianes);
            y[i]=pow(x[i],2);
            
        }
        
        return y;
    }
    
    public JPanel obtenerPanel(){
        
        return new CharPanel(grafica);
    }
            
    public static void main(String[] args) {
        new GraficasTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
