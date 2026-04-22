import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class GanttPanel extends JPanel {
    
    
    private List<String> processIds;
    private List<Integer> startTimes;
    private List<Integer> endTimes;

    public GanttPanel() {
        this.processIds = new ArrayList<>();
        this.startTimes = new ArrayList<>();
        this.endTimes = new ArrayList<>();
    }

    
    public void setChartData(List<String> processIds, List<Integer> startTimes, List<Integer> endTimes) {
        this.processIds = processIds;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
       
        if (processIds == null || processIds.isEmpty() || 
            startTimes.size() != processIds.size() || 
            endTimes.size() != processIds.size()) {
            return;
        }

        int firstStartTime = startTimes.get(0);
        int lastEndTime = endTimes.get(endTimes.size() - 1);
        int totalTime =
