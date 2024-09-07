import java.awt.*;
import javax.swing.*;

class paintCompOverride extends JPanel{
    
    public static int[] fin_array = {50, 80, 120, 200, 150, 100, 204, 32, 1, 182, 238, 2, 192, 283, 4, 21, 25, 43, 123, 88, 53, 81, 129, 250, 100, 10, 4, 323, 1};
    public static int[] temp = new int[29];
    public static boolean ascending = true;
    public static int sortChoice = 0;
    public static int compCount = 0;
    public static int shiftCount = 0;
    public static int swapCount = 0;
    public static int iterSpeed = 500;
    public static int currElemIndex = 0;
    public static int compareElemIndex = 0;

    public void update(int[] array){
        fin_array = array;
        this.revalidate();
        this.repaint();

        try {
            Thread.sleep(iterSpeed); // Adds a delay of n milliseconds between swaps
        } catch (InterruptedException e) {
            System.out.println("Process thread cannot be put to sleep, exiting...");
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int barWidth = 30;
        int barpadding = 25;
        int startY = getHeight() - 50;
        int max = findMaxValue(fin_array);

        for (int i = 0; i < fin_array.length; i++) {
            switch(sortChoice){
                case 1:{
                    g.drawString("Bubble Sort", 10, 20);
                    break;
                }
                default:{
                    g.drawString("Insertion Sort", 10, 20);
                    break;
                }
                case 2:{
                    g.drawString("Selection Sort", 10, 20);
                    break;
                }
                case 3:{
                    g.drawString("Insertion Sort", 10, 20);
                    break;
                }
                case 4:{
                    g.drawString("Quick Sort", 10, 20);
                    break;
                }
                case 5:{
                    g.drawString("Merge Sort", 10, 20);
                    break;
                }
                case 6:{
                    g.drawString("Heap Sort", 10, 20);
                    break;
                }
            }
            String temp = "No. of comparisions : " + String.valueOf(compCount);
            g.drawString(temp ,10 , 40);

            temp = "No. of shifts : " + String.valueOf(shiftCount);
            g.drawString(temp ,10 , 60);

            temp = "No. of swaps : " + String.valueOf(swapCount);
            g.drawString(temp ,10 , 80);

            temp = "Blue Bar : Currently traversed index";
            g.drawString(temp , 650 , 20);

            temp = "Yellow Bar : Currently compared / swapped / shifted element";
            g.drawString(temp ,1250 , 20);

            int barHeight = (int) ((double) fin_array[i] / max * (getHeight() - 100));
            int startX = i * (barWidth + barpadding) + 150;
            if(i == currElemIndex){
                g.setColor(Color.BLUE);
                g.fillRect(startX, startY - barHeight, barWidth, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(startX, startY - barHeight, barWidth, barHeight);
            }
            else if(i == compareElemIndex){
                g.setColor(Color.ORANGE);
                g.fillRect(startX, startY - barHeight, barWidth, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(startX, startY - barHeight, barWidth, barHeight);
            }
            else{
                g.setColor(Color.DARK_GRAY);
                g.fillRect(startX, startY - barHeight, barWidth, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(startX, startY - barHeight, barWidth, barHeight);
            }

            // Display the value above the bar
            g.drawString(String.valueOf(fin_array[i]), startX + barWidth / 2 - 10, startY - barHeight - 12);
        }

    }
    private int findMaxValue(int[] fin_array) {
        int a = Integer.MIN_VALUE;
        for(int i = 0; i < fin_array.length; i++){
            if(fin_array[i] > a){
                a = fin_array[i];
            }
        }
        return a;
    }
    public static void barWindow() {

        JFrame frame = new JFrame("Algorithm Visualizer");
        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.setSize(1800, 1000);

            paintCompOverride graphPanel = new paintCompOverride();
            frame.add(graphPanel);

            frame.setVisible(true);
            graphPanel.update(fin_array);

            new Thread(() -> {
                graphPanel.performSort(fin_array , ascending, sortChoice);

            }).start();
        });

    }

    private void performSort(int[] data, boolean b, int choice) {
        switch(choice){
            case 1:{
                sortingAlgorithms.bubbleSort(data ,b , this::update);
                break;
            }
            case 2:{
                sortingAlgorithms.selectionSort(data, b, this::update);
                break;
            }
            case 3:{
                sortingAlgorithms.insertionSort(data, b, this::update);
                break;
            }
            case 4:{
                sortingAlgorithms.quickSort(data, 0, data.length - 1, b, this::update);
                break;
            }
            case 5:{
                sortingAlgorithms.mergeSort(data, 0, data.length - 1, b, this::update);
                break;
            }
            case 6:{
                sortingAlgorithms.heapSort(data, this::update);
                break;
            }
            default:{
                sortingAlgorithms.insertionSort(data, b, this::update);
                break;
            }
        }
    }
}