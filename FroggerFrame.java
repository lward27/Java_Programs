import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.util.Random;
import java.awt.Toolkit;
//import java.awt.event.FocusListener;

public class FroggerFrame extends JFrame
{
  FroggerPanel frogArea;
  int n;
  
  public FroggerFrame(int _n) 
  {
    super("Boxes");
    n = _n;
    frogArea = new FroggerPanel(n);
  }
  
  public void go()
  {
    setSize(971,971);
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    
    JMenuItem reset = new JMenuItem("Reset");
    reset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frogArea.reset(); }
    });
    JMenuItem exit = new JMenuItem("Exit");
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0); }
    });
    fileMenu.add(reset);
    fileMenu.add(exit);
    menuBar.add(fileMenu);
    
    getContentPane().add(frogArea);
    setJMenuBar(menuBar);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  public FroggerFrame() 
  {
    this(40);
  }
  
  public static void main(String[] args)
  {
    FroggerFrame s = new FroggerFrame();
    s.go();
  }
  
  /****************************************************************************/
  
  class ColorPanel2 extends JPanel
  {
    Color boxcolor;
    
    public ColorPanel2(Color color) 
    {
      super();
      boxcolor = color;
      this.setBoxColor(boxcolor);
    }
    
    public ColorPanel2()
    {
      this(Color.blue);
    }
    
    public void setBoxColor(Color color) 
    {
      boxcolor = color;
    }
    /***************************************************************************************/
    
    public void paintComponent(Graphics g) 
    {
      g.setColor(boxcolor);
      g.fillRect(0,0,getWidth(), getHeight());
    }
  }
  
  /******************************************************/
  
  class FroggerPanel extends JPanel implements KeyListener
  {
    Random r = new Random();
    int n;
    ColorPanel2 [][] boxes;
    int xloc = 18;
    int yloc = 39;
    int car1xloc = 0+5;
    int car1yloc = 18;
    int car2xloc = r.nextInt(17)+5;
    int car2yloc = 19;
    int car3xloc = r.nextInt(17)+5;
    int car3yloc = 20;
    int car4xloc = r.nextInt(17)+5;
    int car4yloc = 21;
    int car5xloc = r.nextInt(17)+5;
    int car5yloc = 22;
    int car6xloc = r.nextInt(17)+5;
    int car6yloc = 23;
    int car7xloc = r.nextInt(17)+5;
    int car7yloc = 24;
    int car8xloc = r.nextInt(17)+5;
    int car8yloc = 25;
    int car9xloc = r.nextInt(17)+5;
    int car9yloc = 26;
    int car10xloc = r.nextInt(17)+5;
    int car10yloc = 27;
    int car11xloc = r.nextInt(17)+5;
    int car11yloc = 28;
    int car12xloc = r.nextInt(17)+5;
    int car12yloc = 29;
    int car13xloc = r.nextInt(17)+5;
    int car13yloc = 30;
    int car14xloc = r.nextInt(17)+5;
    int car14yloc = 31;
    int car15xloc = r.nextInt(17)+5;
    int car15yloc = 32;
    int car16xloc = r.nextInt(17)+5;
    int car16yloc = 33;
    int car17xloc = r.nextInt(17)+5;
    int car17yloc = 34;
    int car18xloc = r.nextInt(17)+5;
    int car18yloc = 35;
    int car19xloc = r.nextInt(17)+5;
    int car19yloc = 36;
    int car20xloc = r.nextInt(17)+5;
    int car20yloc = 37;
    int car21xloc = r.nextInt(17)+5;
    int car21yloc = 38;
    int car22xloc = 17+5;
    int car22yloc = 39;
    
    int log1axloc = r.nextInt(17)+5;int log1ayloc = 1;int log1bxloc = log1axloc - 1;int log1byloc = 1;int log1cxloc = log1bxloc -1;int log1cyloc = 1;int log1dxloc = log1cxloc -1;int log1dyloc = 1;
    int log2axloc = r.nextInt(17)+5;int log2ayloc = 2;int log2bxloc = log2axloc - 1;int log2byloc = 2;int log2cxloc = log2bxloc -1;int log2cyloc = 2;int log2dxloc = log2cxloc -1;int log2dyloc = 2;
    int log3axloc = r.nextInt(17)+5;int log3ayloc = 3;int log3bxloc = log3axloc - 1;int log3byloc = 3;int log3cxloc = log3bxloc -1;int log3cyloc = 3;int log3dxloc = log3cxloc -1;int log3dyloc = 3;
    int log4axloc = r.nextInt(17)+5;int log4ayloc = 4;int log4bxloc = log4axloc - 1;int log4byloc = 4;int log4cxloc = log4bxloc -1;int log4cyloc = 4;int log4dxloc = log4cxloc -1;int log4dyloc = 4;
    int log5axloc = r.nextInt(17)+5;int log5ayloc = 5;int log5bxloc = log5axloc - 1;int log5byloc = 5;int log5cxloc = log5bxloc -1;int log5cyloc = 5;int log5dxloc = log5cxloc -1;int log5dyloc = 5;
    int log6axloc = r.nextInt(17)+5;int log6ayloc = 6;int log6bxloc = log6axloc - 1;int log6byloc = 6;int log6cxloc = log6bxloc -1;int log6cyloc = 6;int log6dxloc = log6cxloc -1;int log6dyloc = 6;
    int log7axloc = r.nextInt(17)+5;int log7ayloc = 7;int log7bxloc = log7axloc - 1;int log7byloc = 7;int log7cxloc = log7bxloc -1;int log7cyloc = 7;int log7dxloc = log7cxloc -1;int log7dyloc = 7;
    int log8axloc = r.nextInt(17)+5;int log8ayloc = 8;int log8bxloc = log8axloc - 1;int log8byloc = 8;int log8cxloc = log8bxloc -1;int log8cyloc = 8;int log8dxloc = log8cxloc -1;int log8dyloc = 8;
    int log9axloc = r.nextInt(17)+5;int log9ayloc = 9;int log9bxloc = log9axloc - 1;int log9byloc = 9;int log9cxloc = log9bxloc -1;int log9cyloc = 9;int log9dxloc = log9cxloc -1;int log9dyloc = 9;
    int log10axloc = r.nextInt(17)+5;int log10ayloc = 10;int log10bxloc = log10axloc - 1;int log10byloc = 10;int log10cxloc = log10bxloc -1;int log10cyloc = 10;int log10dxloc = log10cxloc -1;int log10dyloc = 10;
    int log11axloc = r.nextInt(17)+5;int log11ayloc = 11;int log11bxloc = log11axloc - 1;int log11byloc = 11;int log11cxloc = log11bxloc -1;int log11cyloc = 11;int log11dxloc = log11cxloc -1;int log11dyloc = 11;
    int log12axloc = r.nextInt(17)+5;int log12ayloc = 12;int log12bxloc = log12axloc - 1;int log12byloc = 12;int log12cxloc = log12bxloc -1;int log12cyloc = 12;int log12dxloc = log12cxloc -1;int log12dyloc = 12;
    int log13axloc = r.nextInt(17)+5;int log13ayloc = 13;int log13bxloc = log13axloc - 1;int log13byloc = 13;int log13cxloc = log13bxloc -1;int log13cyloc = 13;int log13dxloc = log13cxloc -1;int log13dyloc = 13;
    int log14axloc = r.nextInt(17)+5;int log14ayloc = 14;int log14bxloc = log14axloc - 1;int log14byloc = 14;int log14cxloc = log14bxloc -1;int log14cyloc = 14;int log14dxloc = log14cxloc -1;int log14dyloc = 14;
    int log15axloc = r.nextInt(17)+5;int log15ayloc = 15;int log15bxloc = log15axloc - 1;int log15byloc = 15;int log15cxloc = log15bxloc -1;int log15cyloc = 15;int log15dxloc = log15cxloc -1;int log15dyloc = 15;
    int log16axloc = r.nextInt(17)+5;int log16ayloc = 16;int log16bxloc = log16axloc - 1;int log16byloc = 16;int log16cxloc = log16bxloc -1;int log16cyloc = 16;int log16dxloc = log16cxloc -1;int log16dyloc = 16;
    int log17axloc = r.nextInt(17)+5;int log17ayloc = 17;int log17bxloc = log17axloc - 1;int log17byloc = 17;int log17cxloc = log17bxloc -1;int log17cyloc = 17;int log17dxloc = log17cxloc -1;int log17dyloc = 17;
    
    
    public FroggerPanel(int _n) 
    {
      super();
      reset();
      n = _n;
      boxes = new ColorPanel2[n][n];
      this.setLayout(new GridLayout(n,n));
      for(int k = 0; k < n; k++){
        for (int l = 0; l < n; l++){
          boxes[k][l] = new ColorPanel2();
          this.add(boxes[k][l]);
        }
      }
      boxes[yloc][xloc].setBoxColor(Color.red);
      setFocusable(true);
      addKeyListener(this);
    }
    
    public void paintComponent(Graphics g)
    {
      g.setColor(Color.black);
      g.fillRect(0,0,getWidth(), getHeight());
    }
    
    private boolean isBetween (int a, int b, int c)
    {
      return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
    
    public void reset() 
    {
      for(int k = 0; k < n; k++){
        for (int l = 0; l < n; l++){
          boxes[l][k].setBoxColor(Color.black);
        }
      }
      for(int k = 0; k < n; k++){
        for (int l = 0; l < 18 ; l++){
          boxes[l][k].setBoxColor(Color.blue);
        }
      }
      repaint();
    }
    
    public void moveBoxLocation(int xchange, int ychange)
    {
      reset();
      crash();
      xloc = xchange;
      yloc = ychange;
      crash();
      if (f <= 8)
      {
      boxes[car1yloc][car1xloc+=2].setBoxColor(Color.green);
      boxes[car2yloc][car2xloc++].setBoxColor(Color.green);
      boxes[car3yloc][car3xloc+=2].setBoxColor(Color.green);
      boxes[car4yloc][car4xloc++].setBoxColor(Color.green);
      boxes[car5yloc][car5xloc+=2].setBoxColor(Color.green);
      boxes[car6yloc][car6xloc++].setBoxColor(Color.green);
      boxes[car7yloc][car7xloc+=2].setBoxColor(Color.green);
      boxes[car8yloc][car8xloc++].setBoxColor(Color.green);
      boxes[car9yloc][car9xloc+=2].setBoxColor(Color.green);
      boxes[car10yloc][car10xloc++].setBoxColor(Color.green);
      boxes[car11yloc][car11xloc+=2].setBoxColor(Color.green);
      boxes[car12yloc][car12xloc++].setBoxColor(Color.green);
      boxes[car13yloc][car13xloc+=2].setBoxColor(Color.green);
      boxes[car14yloc][car14xloc++].setBoxColor(Color.green);
      boxes[car15yloc][car15xloc+=2].setBoxColor(Color.green);
      boxes[car16yloc][car16xloc++].setBoxColor(Color.green);
      boxes[car17yloc][car17xloc+=2].setBoxColor(Color.green);
      boxes[car18yloc][car18xloc++].setBoxColor(Color.green);
      boxes[car19yloc][car19xloc+=2].setBoxColor(Color.green);
      boxes[car20yloc][car20xloc++].setBoxColor(Color.green);
      boxes[car21yloc][car21xloc+=2].setBoxColor(Color.green);
      boxes[car22yloc][car22xloc++].setBoxColor(Color.green);
      
      boxes[log1ayloc][log1axloc++].setBoxColor(Color.orange);boxes[log1byloc][log1bxloc++].setBoxColor(Color.orange);boxes[log1cyloc][log1cxloc++].setBoxColor(Color.orange);boxes[log1dyloc][log1dxloc++].setBoxColor(Color.orange);
      boxes[log2ayloc][log2axloc++].setBoxColor(Color.orange);boxes[log2byloc][log2bxloc++].setBoxColor(Color.orange);boxes[log2cyloc][log2cxloc++].setBoxColor(Color.orange);boxes[log2dyloc][log2dxloc++].setBoxColor(Color.orange);
      boxes[log3ayloc][log3axloc++].setBoxColor(Color.orange);boxes[log3byloc][log3bxloc++].setBoxColor(Color.orange);boxes[log3cyloc][log3cxloc++].setBoxColor(Color.orange);boxes[log3dyloc][log3dxloc++].setBoxColor(Color.orange);
      boxes[log4ayloc][log4axloc++].setBoxColor(Color.orange);boxes[log4byloc][log4bxloc++].setBoxColor(Color.orange);boxes[log4cyloc][log4cxloc++].setBoxColor(Color.orange);boxes[log4dyloc][log4dxloc++].setBoxColor(Color.orange);
      boxes[log5ayloc][log5axloc++].setBoxColor(Color.orange);boxes[log5byloc][log5bxloc++].setBoxColor(Color.orange);boxes[log5cyloc][log5cxloc++].setBoxColor(Color.orange);boxes[log5dyloc][log5dxloc++].setBoxColor(Color.orange);
      boxes[log6ayloc][log6axloc++].setBoxColor(Color.orange);boxes[log6byloc][log6bxloc++].setBoxColor(Color.orange);boxes[log6cyloc][log6cxloc++].setBoxColor(Color.orange);boxes[log6dyloc][log6dxloc++].setBoxColor(Color.orange);
      boxes[log7ayloc][log7axloc++].setBoxColor(Color.orange);boxes[log7byloc][log7bxloc++].setBoxColor(Color.orange);boxes[log7cyloc][log7cxloc++].setBoxColor(Color.orange);boxes[log7dyloc][log7dxloc++].setBoxColor(Color.orange);
      boxes[log8ayloc][log8axloc++].setBoxColor(Color.orange);boxes[log8byloc][log8bxloc++].setBoxColor(Color.orange);boxes[log8cyloc][log8cxloc++].setBoxColor(Color.orange);boxes[log8dyloc][log8dxloc++].setBoxColor(Color.orange);
      boxes[log9ayloc][log9axloc++].setBoxColor(Color.orange);boxes[log9byloc][log9bxloc++].setBoxColor(Color.orange);boxes[log9cyloc][log9cxloc++].setBoxColor(Color.orange);boxes[log9dyloc][log9dxloc++].setBoxColor(Color.orange);
      boxes[log10ayloc][log10axloc++].setBoxColor(Color.orange);boxes[log10byloc][log10bxloc++].setBoxColor(Color.orange);boxes[log10cyloc][log10cxloc++].setBoxColor(Color.orange);boxes[log10dyloc][log10dxloc++].setBoxColor(Color.orange);
      boxes[log11ayloc][log11axloc++].setBoxColor(Color.orange);boxes[log11byloc][log11bxloc++].setBoxColor(Color.orange);boxes[log11cyloc][log11cxloc++].setBoxColor(Color.orange);boxes[log11dyloc][log11dxloc++].setBoxColor(Color.orange);
      boxes[log12ayloc][log12axloc++].setBoxColor(Color.orange);boxes[log12byloc][log12bxloc++].setBoxColor(Color.orange);boxes[log12cyloc][log12cxloc++].setBoxColor(Color.orange);boxes[log12dyloc][log12dxloc++].setBoxColor(Color.orange);
      boxes[log13ayloc][log13axloc++].setBoxColor(Color.orange);boxes[log13byloc][log13bxloc++].setBoxColor(Color.orange);boxes[log13cyloc][log13cxloc++].setBoxColor(Color.orange);boxes[log13dyloc][log13dxloc++].setBoxColor(Color.orange);
      boxes[log14ayloc][log14axloc++].setBoxColor(Color.orange);boxes[log14byloc][log14bxloc++].setBoxColor(Color.orange);boxes[log14cyloc][log14cxloc++].setBoxColor(Color.orange);boxes[log14dyloc][log14dxloc++].setBoxColor(Color.orange);
      boxes[log15ayloc][log15axloc++].setBoxColor(Color.orange);boxes[log15byloc][log15bxloc++].setBoxColor(Color.orange);boxes[log15cyloc][log15cxloc++].setBoxColor(Color.orange);boxes[log15dyloc][log15dxloc++].setBoxColor(Color.orange);
      boxes[log16ayloc][log16axloc++].setBoxColor(Color.orange);boxes[log16byloc][log16bxloc++].setBoxColor(Color.orange);boxes[log16cyloc][log16cxloc++].setBoxColor(Color.orange);boxes[log16dyloc][log16dxloc++].setBoxColor(Color.orange);
      boxes[log17ayloc][log17axloc++].setBoxColor(Color.orange);boxes[log17byloc][log17bxloc++].setBoxColor(Color.orange);boxes[log17cyloc][log17cxloc++].setBoxColor(Color.orange);boxes[log17dyloc][log17dxloc++].setBoxColor(Color.orange);
      }
      if (f >= 8)
      {
      boxes[car1yloc][car1xloc-=2].setBoxColor(Color.green);
      boxes[car2yloc][car2xloc--].setBoxColor(Color.green);
      boxes[car3yloc][car3xloc-=2].setBoxColor(Color.green);
      boxes[car4yloc][car4xloc--].setBoxColor(Color.green);
      boxes[car5yloc][car5xloc-=2].setBoxColor(Color.green);
      boxes[car6yloc][car6xloc--].setBoxColor(Color.green);
      boxes[car7yloc][car7xloc-=2].setBoxColor(Color.green);
      boxes[car8yloc][car8xloc--].setBoxColor(Color.green);
      boxes[car9yloc][car9xloc-=2].setBoxColor(Color.green);
      boxes[car10yloc][car10xloc--].setBoxColor(Color.green);
      boxes[car11yloc][car11xloc-=2].setBoxColor(Color.green);
      boxes[car12yloc][car12xloc--].setBoxColor(Color.green);
      boxes[car13yloc][car13xloc-=2].setBoxColor(Color.green);
      boxes[car14yloc][car14xloc--].setBoxColor(Color.green);
      boxes[car15yloc][car15xloc-=2].setBoxColor(Color.green);
      boxes[car16yloc][car16xloc--].setBoxColor(Color.green);
      boxes[car17yloc][car17xloc-=2].setBoxColor(Color.green);
      boxes[car18yloc][car18xloc--].setBoxColor(Color.green);
      boxes[car19yloc][car19xloc-=2].setBoxColor(Color.green);
      boxes[car20yloc][car20xloc--].setBoxColor(Color.green);
      boxes[car21yloc][car21xloc-=2].setBoxColor(Color.green);
      boxes[car22yloc][car22xloc--].setBoxColor(Color.green);
      
      boxes[log1ayloc][log1axloc--].setBoxColor(Color.orange);boxes[log1byloc][log1bxloc--].setBoxColor(Color.orange);boxes[log1cyloc][log1cxloc--].setBoxColor(Color.orange);boxes[log1dyloc][log1dxloc--].setBoxColor(Color.orange);
      boxes[log2ayloc][log2axloc--].setBoxColor(Color.orange);boxes[log2byloc][log2bxloc--].setBoxColor(Color.orange);boxes[log2cyloc][log2cxloc--].setBoxColor(Color.orange);boxes[log2dyloc][log2dxloc--].setBoxColor(Color.orange);
      boxes[log3ayloc][log3axloc--].setBoxColor(Color.orange);boxes[log3byloc][log3bxloc--].setBoxColor(Color.orange);boxes[log3cyloc][log3cxloc--].setBoxColor(Color.orange);boxes[log3dyloc][log3dxloc--].setBoxColor(Color.orange);
      boxes[log4ayloc][log4axloc--].setBoxColor(Color.orange);boxes[log4byloc][log4bxloc--].setBoxColor(Color.orange);boxes[log4cyloc][log4cxloc--].setBoxColor(Color.orange);boxes[log4dyloc][log4dxloc--].setBoxColor(Color.orange);
      boxes[log5ayloc][log5axloc--].setBoxColor(Color.orange);boxes[log5byloc][log5bxloc--].setBoxColor(Color.orange);boxes[log5cyloc][log5cxloc--].setBoxColor(Color.orange);boxes[log5dyloc][log5dxloc--].setBoxColor(Color.orange);
      boxes[log6ayloc][log6axloc--].setBoxColor(Color.orange);boxes[log6byloc][log6bxloc--].setBoxColor(Color.orange);boxes[log6cyloc][log6cxloc--].setBoxColor(Color.orange);boxes[log6dyloc][log6dxloc--].setBoxColor(Color.orange);
      boxes[log7ayloc][log7axloc--].setBoxColor(Color.orange);boxes[log7byloc][log7bxloc--].setBoxColor(Color.orange);boxes[log7cyloc][log7cxloc--].setBoxColor(Color.orange);boxes[log7dyloc][log7dxloc--].setBoxColor(Color.orange);
      boxes[log8ayloc][log8axloc--].setBoxColor(Color.orange);boxes[log8byloc][log8bxloc--].setBoxColor(Color.orange);boxes[log8cyloc][log8cxloc--].setBoxColor(Color.orange);boxes[log8dyloc][log8dxloc--].setBoxColor(Color.orange);
      boxes[log9ayloc][log9axloc--].setBoxColor(Color.orange);boxes[log9byloc][log9bxloc--].setBoxColor(Color.orange);boxes[log9cyloc][log9cxloc--].setBoxColor(Color.orange);boxes[log9dyloc][log9dxloc--].setBoxColor(Color.orange);
      boxes[log10ayloc][log10axloc--].setBoxColor(Color.orange);boxes[log10byloc][log10bxloc--].setBoxColor(Color.orange);boxes[log10cyloc][log10cxloc--].setBoxColor(Color.orange);boxes[log10dyloc][log10dxloc--].setBoxColor(Color.orange);
      boxes[log11ayloc][log11axloc--].setBoxColor(Color.orange);boxes[log11byloc][log11bxloc--].setBoxColor(Color.orange);boxes[log11cyloc][log11cxloc--].setBoxColor(Color.orange);boxes[log11dyloc][log11dxloc--].setBoxColor(Color.orange);
      boxes[log12ayloc][log12axloc--].setBoxColor(Color.orange);boxes[log12byloc][log12bxloc--].setBoxColor(Color.orange);boxes[log12cyloc][log12cxloc--].setBoxColor(Color.orange);boxes[log12dyloc][log12dxloc--].setBoxColor(Color.orange);
      boxes[log13ayloc][log13axloc--].setBoxColor(Color.orange);boxes[log13byloc][log13bxloc--].setBoxColor(Color.orange);boxes[log13cyloc][log13cxloc--].setBoxColor(Color.orange);boxes[log13dyloc][log13dxloc--].setBoxColor(Color.orange);
      boxes[log14ayloc][log14axloc--].setBoxColor(Color.orange);boxes[log14byloc][log14bxloc--].setBoxColor(Color.orange);boxes[log14cyloc][log14cxloc--].setBoxColor(Color.orange);boxes[log14dyloc][log14dxloc--].setBoxColor(Color.orange);
      boxes[log15ayloc][log15axloc--].setBoxColor(Color.orange);boxes[log15byloc][log15bxloc--].setBoxColor(Color.orange);boxes[log15cyloc][log15cxloc--].setBoxColor(Color.orange);boxes[log15dyloc][log15dxloc--].setBoxColor(Color.orange);
      boxes[log16ayloc][log16axloc--].setBoxColor(Color.orange);boxes[log16byloc][log16bxloc--].setBoxColor(Color.orange);boxes[log16cyloc][log16cxloc--].setBoxColor(Color.orange);boxes[log16dyloc][log16dxloc--].setBoxColor(Color.orange);
      boxes[log17ayloc][log17axloc--].setBoxColor(Color.orange);boxes[log17byloc][log17bxloc--].setBoxColor(Color.orange);boxes[log17cyloc][log17cxloc--].setBoxColor(Color.orange);boxes[log17dyloc][log17dxloc--].setBoxColor(Color.orange);
     
      }
      
      System.out.println(f);
      if (f == 15)
      {
        f = 0;
      }
      boxes[ychange][xchange].setBoxColor(Color.red);
      repaint();
    }
    public void crash()
    {
      if (xloc == car1xloc){ if (yloc == car1yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car2xloc){ if (yloc == car2yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car3xloc){ if (yloc == car3yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car4xloc){ if (yloc == car4yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car5xloc){ if (yloc == car5yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car6xloc){ if (yloc == car6yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car7xloc){ if (yloc == car7yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car8xloc){ if (yloc == car8yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car9xloc){ if (yloc == car9yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car10xloc){ if (yloc == car10yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car11xloc){ if (yloc == car11yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car12xloc){ if (yloc == car12yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car13xloc){ if (yloc == car13yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car14xloc){ if (yloc == car14yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car15xloc){ if (yloc == car15yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car16xloc){ if (yloc == car16yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car17xloc){ if (yloc == car16yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car18xloc){ if (yloc == car18yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car19xloc){ if (yloc == car19yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car20xloc){ if (yloc == car20yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car21xloc){ if (yloc == car21yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      if (xloc == car22xloc){ if (yloc == car22yloc){System.err.println("YOUR SQUASHED!!");try{Thread.sleep(1000);}catch(Exception ex){};Toolkit.getDefaultToolkit().beep();System.exit(0); }}
      
      if (yloc == 17){if (xloc != log17axloc){if (yloc != log17ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 17){if (xloc != log17bxloc){if (yloc != log17byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 17){if (xloc != log17cxloc){if (yloc != log17cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 17){if (xloc != log17dxloc){if (yloc != log17dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 16){if (xloc != log16axloc){if (yloc != log16ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 16){if (xloc != log16bxloc){if (yloc != log16byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 16){if (xloc != log16cxloc){if (yloc != log16cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 16){if (xloc != log16dxloc){if (yloc != log16dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 15){if (xloc != log15axloc){if (yloc != log15ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 15){if (xloc != log15bxloc){if (yloc != log15byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 15){if (xloc != log15cxloc){if (yloc != log15cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 15){if (xloc != log15dxloc){if (yloc != log15dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 14){if (xloc != log14axloc){if (yloc != log14ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 14){if (xloc != log14bxloc){if (yloc != log14byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 14){if (xloc != log14cxloc){if (yloc != log14cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 14){if (xloc != log14dxloc){if (yloc != log14dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 13){if (xloc != log13axloc){if (yloc != log13ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 13){if (xloc != log13bxloc){if (yloc != log13byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 13){if (xloc != log13cxloc){if (yloc != log13cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 13){if (xloc != log13dxloc){if (yloc != log13dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 12){if (xloc != log12axloc){if (yloc != log12ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 12){if (xloc != log12bxloc){if (yloc != log12byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 12){if (xloc != log12cxloc){if (yloc != log12cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 12){if (xloc != log12dxloc){if (yloc != log12dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 11){if (xloc != log11axloc){if (yloc != log11ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 11){if (xloc != log11bxloc){if (yloc != log11byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 11){if (xloc != log11cxloc){if (yloc != log11cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 11){if (xloc != log11dxloc){if (yloc != log11dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 10){if (xloc != log10axloc){if (yloc != log10ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 10){if (xloc != log10bxloc){if (yloc != log10byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 10){if (xloc != log10cxloc){if (yloc != log10cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 10){if (xloc != log10dxloc){if (yloc != log10dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 9){if (xloc != log9axloc){if (yloc != log9ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 9){if (xloc != log9bxloc){if (yloc != log9byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 9){if (xloc != log9cxloc){if (yloc != log9cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 9){if (xloc != log9dxloc){if (yloc != log9dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 8){if (xloc != log8axloc){if (yloc != log8ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 8){if (xloc != log8bxloc){if (yloc != log8byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 8){if (xloc != log8cxloc){if (yloc != log8cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 8){if (xloc != log8dxloc){if (yloc != log8dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 7){if (xloc != log7axloc){if (yloc != log7ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 7){if (xloc != log7bxloc){if (yloc != log7byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 7){if (xloc != log7cxloc){if (yloc != log7cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 7){if (xloc != log7dxloc){if (yloc != log7dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 6){if (xloc != log6axloc){if (yloc != log6ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 6){if (xloc != log6bxloc){if (yloc != log6byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 6){if (xloc != log6cxloc){if (yloc != log6cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 6){if (xloc != log6dxloc){if (yloc != log6dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 5){if (xloc != log5axloc){if (yloc != log5ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 5){if (xloc != log5bxloc){if (yloc != log5byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 5){if (xloc != log5cxloc){if (yloc != log5cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 5){if (xloc != log5dxloc){if (yloc != log5dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 4){if (xloc != log4axloc){if (yloc != log4ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 4){if (xloc != log4bxloc){if (yloc != log4byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 4){if (xloc != log4cxloc){if (yloc != log4cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 4){if (xloc != log4dxloc){if (yloc != log4dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 3){if (xloc != log3axloc){if (yloc != log3ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 3){if (xloc != log3bxloc){if (yloc != log3byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 3){if (xloc != log3cxloc){if (yloc != log3cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 3){if (xloc != log3dxloc){if (yloc != log3dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 2){if (xloc != log2axloc){if (yloc != log2ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 2){if (xloc != log2bxloc){if (yloc != log2byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 2){if (xloc != log2cxloc){if (yloc != log2cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 2){if (xloc != log2dxloc){if (yloc != log2dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 1){if (xloc != log1axloc){if (yloc != log1ayloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 1){if (xloc != log1bxloc){if (yloc != log1byloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 1){if (xloc != log1cxloc){if (yloc != log1cyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      if (yloc == 1){if (xloc != log1dxloc){if (yloc != log1dyloc){System.err.println("Your drowning");Toolkit.getDefaultToolkit().beep();System.exit(0);}}}
      System.out.println(yloc);
    }
    
    /********************************************************************/       
    
    
    
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }
    int f;
    public void keyReleased(KeyEvent e)
    {
      f++;      
      if (e.getKeyCode() == 37) 
      {
        if (xloc != 0) 
        {
          moveBoxLocation(xloc-1, yloc);
        }
      }
      if (e.getKeyCode() == 38) 
      {
        if (yloc != 0) 
        {
          moveBoxLocation(xloc, yloc-1);
        }
      }
      if (e.getKeyCode() == 39) 
      {
        if (xloc != n-1) 
        {
          moveBoxLocation(xloc+1, yloc);
        }
      }
      
      if (e.getKeyCode() == 40) 
      {
        if (yloc != n-1) 
        {
          moveBoxLocation(xloc, yloc+1);
        }
      }
    }
  }
}
