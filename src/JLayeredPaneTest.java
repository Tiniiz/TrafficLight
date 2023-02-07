import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;


//класс рисования двух типов фигур
class Figure extends JComponent {
    private Color color;
    private int type;

    public int[] getArrayx(){
        int[] array = new int[80];
        for (int i=0; i< 41; i++){
            array[i] = 0;
        }
        int c = 1;
        for (int i=40; i<array.length; i++ ){
            array[i] = c;
            c++;
        }
        return array;
    }
    public int[] getArrayy(){
        int[] arrayy = new int[80];
        for (int i = 0; i < 41; i++){
            arrayy[i] = i;
        }
        for (int i=40; i<arrayy.length; i++){
            arrayy[i] = 40;
        }
        return arrayy;
    }
    public int[] getArx(){
        int[] array = new int[80];
        for (int i=0; i< 41; i++){
            array[i] = i;
        }
        for (int i=40; i<array.length; i++ ){
            array[i] = 40;
        }
        return array;
    }
    public int[] getAry(){
        int[] array = getArx();
        int[] arrayy = new int[80];
        int c = 40;
        for (int i = 0; i < 41; i++){
            arrayy[i] = c;
            c--;
        }
        for (int i=40; i<arrayy.length; i++){
            arrayy[i] = i;
        }
        return arrayy;
    }


    // параметры: цвет и тип фигуры
    Figure(Color color, int type) {
        this.color = color;
        this.type = type;
        setOpaque(false);
    }
    public void paintComponent(Graphics g) {
        // прорисовка фигуры
        g.setColor(color);
        switch (type) {
            case 0: g.fillOval(0, 0, 50, 50); break;
            case 1: g.fillRoundRect(0, 0, 80, 200, 20, 20); break;
            case 2: g.drawArc(0, 0, 60, 60, 0, 180); break;
            case 3: g.drawArc(0, 0, 60, 55, 0, 180); break;
            case 4: g.fillOval(0, 0, 60, 60); break;
            case 5: g.fillOval(0, 0, 60, 55); break;
            case 6: g.fillRoundRect(0, 0, 35, 40, 10, 10); break;
            case 7: g.fillRoundRect(0, 0, 40, 40, 10, 10); break;
            case 8: g.fillPolygon(getArrayx(), getArrayy(), 80);
            case 9: g.fillPolygon(getArx(), getAry(), 80);

        }
    }
}
public class JLayeredPaneTest extends JFrame {

    public JLayeredPaneTest() {
        // создание окна
        super("Светофор");
        // выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // определение многослойной панели
        JLayeredPane lp = getLayeredPane();
        lp.setBackground(Color.WHITE);
        // создание трех фигур
        Figure figure1 = new Figure(Color.darkGray , 1);
        Figure figure2 = new Figure(Color.red , 0);
        Figure figure3 = new Figure(Color.yellow , 0);
        Figure figure4 = new Figure(Color.green , 0);
        Figure figure5 = new Figure(Color.white , 4);
        Figure figure6 = new Figure(Color.darkGray , 5);
        Figure figure7 = new Figure(Color.white , 4);
        Figure figure8 = new Figure(Color.darkGray , 5);
        Figure figure9 = new Figure(Color.white , 4);
        Figure figure10 = new Figure(Color.darkGray , 5);
        Figure figure11 = new Figure(Color.darkGray , 6);
        Figure figure12 = new Figure(Color.darkGray , 7);
        Figure figure13 = new Figure(Color.WHITE , 8);
        Figure figure14 = new Figure(Color.darkGray , 7);
        Figure figure15 = new Figure(Color.WHITE , 8);
        Figure figure16 = new Figure(Color.darkGray , 7);
        Figure figure17 = new Figure(Color.WHITE , 8);
        Figure figure18 = new Figure(Color.darkGray , 7);
        Figure figure19 = new Figure(Color.WHITE , 9);
        Figure figure20 = new Figure(Color.darkGray , 7);
        Figure figure21 = new Figure(Color.WHITE , 9);
        Figure figure22 = new Figure(Color.darkGray , 7);
        Figure figure23 = new Figure(Color.WHITE , 9);
        // определение местоположения фигур в окне
        // прямоугольник
        figure1.setBounds(150, 100, 80, 200);
        // круги
        figure2.setBounds(164, 116, 90, 90);
        figure3.setBounds(164, 178, 90, 90);
        figure4.setBounds(164, 242, 90, 90);
        // белые линии над кругами
        figure5.setBounds(159, 106, 60, 60);
        figure6.setBounds(159, 113, 60, 55);
        figure7.setBounds(159, 168, 60, 60);
        figure8.setBounds(159, 175, 60, 55);
        figure9.setBounds(159, 232, 60, 60);
        figure10.setBounds(159, 239, 60, 55);
        // серая полуокружность
        // серый маленький прямоугольник
        figure11.setBounds(172, 305, 40, 100);
        // серые треугольники
        figure12.setBounds(100, 120, 40, 40);
        figure13.setBounds(100, 122, 40, 40);
        figure14.setBounds(100, 180, 40, 40);
        figure15.setBounds(100, 182, 40, 40);
        figure16.setBounds(100, 240, 40, 40);
        figure17.setBounds(100, 242, 40, 40);
        figure18.setBounds(240, 120, 40, 40);
        figure19.setBounds(241, 122, 40, 40);
        figure20.setBounds(240, 180, 40, 40);
        figure21.setBounds(241, 182, 40, 40);
        figure22.setBounds(240, 240, 40, 40);
        figure23.setBounds(241, 242, 40, 40);
        // добавление фигур в различные слои
        lp.add(figure1, JLayeredPane.DEFAULT_LAYER  );
        lp.add(figure2, JLayeredPane.DRAG_LAYER  );
        lp.add(figure3, JLayeredPane.DRAG_LAYER  );
        lp.add(figure4, JLayeredPane.DRAG_LAYER  );
        lp.add(figure5, JLayeredPane.PALETTE_LAYER  );
        lp.add(figure6, JLayeredPane.POPUP_LAYER  );
        lp.add(figure7, JLayeredPane.PALETTE_LAYER  );
        lp.add(figure8, JLayeredPane.POPUP_LAYER  );
        lp.add(figure9, JLayeredPane.PALETTE_LAYER  );
        lp.add(figure10, JLayeredPane.POPUP_LAYER  );
        lp.add(figure11, JLayeredPane.DEFAULT_LAYER  );
        lp.add(figure12, JLayeredPane.POPUP_LAYER  );
        lp.add(figure13, JLayeredPane.DRAG_LAYER  );
        lp.add(figure14, JLayeredPane.POPUP_LAYER  );
        lp.add(figure15, JLayeredPane.DRAG_LAYER  );
        lp.add(figure16, JLayeredPane.POPUP_LAYER  );
        lp.add(figure17, JLayeredPane.DRAG_LAYER  );
        lp.add(figure18, JLayeredPane.DEFAULT_LAYER  );
        lp.add(figure19, JLayeredPane.PALETTE_LAYER  );
        lp.add(figure20, JLayeredPane.DEFAULT_LAYER  );
        lp.add(figure21, JLayeredPane.PALETTE_LAYER  );
        lp.add(figure22, JLayeredPane.DEFAULT_LAYER  );
        lp.add(figure23, JLayeredPane.PALETTE_LAYER  );


        // определение размера и открытие окна
        setSize(400, 400);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JLayeredPaneTest();
    }
}