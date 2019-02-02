package Assessment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class HealthGraph extends JPanel implements Observer{
    private List<Double> weights;
    private List<Double> BMIs;
    private List<Double> BFPs;
    private static final int BORDER_GAP = 30;
    private static final int MAX_WEIGHT = 100;
    private static final int MAX_BMI = 500;
    private static final int MAX_BFP = 200;
    private static final int Y_HATCH_CNT = 10;
    private static final int GRAPH_POINT_WIDTH = 12;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final Color GRAPH_COLOR_w = Color.green;
    private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
    private static final Color GRAPH_COLOR_B = Color.red;
    private static final Color GRAPH_COLOR_F = Color.yellow;
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;

    public HealthGraph(List<Double> weights,List<Double> BMIs,List<Double> BFPs){
        this.weights = weights;
        this.BMIs = BMIs;
        this.BFPs = BFPs;
    }

    @Override
    public void update(Observable o, Object arg) {
        HealthHistory history = (HealthHistory) o;
        createAndShowGraph(history);
    }

    private void createAndShowGraph(HealthHistory history) {
        List<Double> weights = history.getWeights();
        HealthGraph mainPanel = new HealthGraph(weights,BMIs,BFPs);

        JFrame frame = new JFrame("HealGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void graphPoints(List<Double> elements,final int max,Graphics2D g2,final Color graphColor,final Color pointColor,String string){
        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (elements.size() - 1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (max - 1);
        List<Point> graphPoints = new ArrayList<Point>();
        for (int i = 0; i < elements.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((max - weights.get(i)) * yScale + BORDER_GAP);
            graphPoints.add(new Point(x1, y1));
        }
        Stroke oldStroke = g2.getStroke();
        g2.setColor(graphColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
            int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
            int ovalW = GRAPH_POINT_WIDTH;
            int ovalH = GRAPH_POINT_WIDTH;
            g2.fillOval(x, y, ovalW, ovalH);

            int fontSize = 20;
            g2.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            g2.setColor(Color.black);
            g2.drawString(string+": "+elements.get(i).toString(), x, y);
        }
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphPoints(weights,MAX_WEIGHT,g2,GRAPH_COLOR_w,GRAPH_POINT_COLOR,"Weight");
        graphPoints(BMIs,MAX_BMI,g2,GRAPH_COLOR_B,GRAPH_POINT_COLOR,"BMI");
        graphPoints(BFPs,MAX_BFP,g2,GRAPH_COLOR_F,GRAPH_POINT_COLOR,"BFP");

        // create x and y axes
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

        // create hatch marks for y axis.
        for (int i = 0; i < Y_HATCH_CNT; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
            int y1 = y0;
            g2.drawLine(x0, y0, x1, y1);
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
}
