import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuOptions{
    //private static boolean Bolden = false;

    public static void main(String[] args) {
        paintCompOverride.temp = paintCompOverride.fin_array.clone();

        JFrame frame = new JFrame("Setup to get the visualizer working");

        JMenuBar menuBar = new JMenuBar();

        JMenu setupMenu = new JMenu("Setup");
        JMenuItem runMenu = new JMenuItem("Run");
        JMenu iterSpeed = new JMenu("Iteration Speed");

        JMenuItem randomizer = new JMenuItem("Randomize Array");

        JMenuItem bSort = new JMenuItem("Bubble Sort");
        JMenuItem sSort = new JMenuItem("Selection Sort");
        JMenuItem iSort = new JMenuItem("Insertion Sort");
        JMenuItem qSort = new JMenuItem("Quick Sort");
        JMenuItem mSort = new JMenuItem("Merge Sort");
        JMenuItem hSort = new JMenuItem("Heap Sort (Ascending only)");

        JMenuItem asc = new JMenuItem("Ascending (Default)");
        JMenuItem desc = new JMenuItem("Descending");

        JMenuItem reset = new JMenuItem("Reset Array");

        JMenuItem x1 = new JMenuItem("x1 (1000 ms)");
        JMenuItem x2 = new JMenuItem("x2 (750 ms)");
        JMenuItem x3 = new JMenuItem("x3 (Default : 500 ms)");
        JMenuItem x4 = new JMenuItem("x4 (250 ms)");

        setupMenu.add(randomizer);

        setupMenu.addSeparator();

        setupMenu.add(asc);
        setupMenu.add(desc);

        setupMenu.addSeparator();

        setupMenu.add(bSort);
        setupMenu.add(sSort);
        setupMenu.add(iSort);
        setupMenu.add(qSort);
        setupMenu.add(mSort);
        setupMenu.add(hSort);

        setupMenu.addSeparator();

        setupMenu.add(reset);

        
        iterSpeed.add(x1);
        iterSpeed.add(x2);
        iterSpeed.add(x3);
        iterSpeed.add(x4);


        menuBar.add(setupMenu);
        menuBar.add(runMenu);
        menuBar.add(iterSpeed);

        // Initialize action listeners
        randomizer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                paintCompOverride.fin_array = Arr_randomizer.rand_logic(paintCompOverride.fin_array);
                paintCompOverride.temp = paintCompOverride.fin_array.clone();
                //for(int i = 0; i < paintCompOverride.temp.length; i++){
                //    System.out.print(paintCompOverride.temp[i] + " ");
                //}
                //paintCompOverride.barWindow();
                //System.out.println("Hello");

            }
        });

        asc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                paintCompOverride.ascending = true;

            }
        });

        desc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.ascending = false;

            }
        });

        bSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.sortChoice = 1;

            }
        });

        sSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.sortChoice = 2;

            }
        });

        iSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.sortChoice = 3;

            }
        });

        qSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.sortChoice = 4;

            }
        });

        mSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.sortChoice = 5;

            }
        });

        hSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.sortChoice = 6;

            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                for(int i = 0 ; i < paintCompOverride.temp.length; i++){
                    paintCompOverride.fin_array[i] = paintCompOverride.temp[i];
                }
                paintCompOverride.shiftCount = 0;
                paintCompOverride.compCount = 0;
                paintCompOverride.swapCount = 0;

            }
        });

        runMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){

                paintCompOverride.shiftCount = 0;
                paintCompOverride.compCount = 0;
                paintCompOverride.swapCount = 0;
                paintCompOverride.barWindow();

            }
        });

        x1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){
                
                paintCompOverride.iterSpeed = 1000;

            }
        });

        x2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){
                
                paintCompOverride.iterSpeed = 750;

            }
        });

        x3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){
                
                paintCompOverride.iterSpeed = 500;

            }
        });

        x4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f){
                
                paintCompOverride.iterSpeed = 250;

            }
        });

        frame.setJMenuBar(menuBar);
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}