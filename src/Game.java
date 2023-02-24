import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

public class Game extends JFrame {
    static boolean run_thread = true;
    Thread thread;
    static JLabel timer = new JLabel();
    Computer computer = new Computer();
    static int count = 0;
    char[][] selected = new char[3][3];
    int di = 0;
    JPanel panel = new JPanel(new GridLayout(3, 3));
    JPanel screen = new JPanel(null);

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    JButton btn3 = new JButton();
    JButton btn4 = new JButton();
    JButton btn5 = new JButton();
    JButton btn6 = new JButton();
    JButton btn7 = new JButton();
    JButton btn8 = new JButton();
    JButton btn9 = new JButton();
    Border border = BorderFactory.createLineBorder(Color.black, 1);
    JLabel label = new JLabel();
    JButton reset = new JButton("Reset");
    Game() {
        Toolkit.getDefaultToolkit().beep();
        this.setLocation(650,10);
        thread = new Thread(new Timer());
        thread.start();
        btn1.setText(null);
        btn2.setText(null);
        btn3.setText(null);
        btn4.setText(null);
        btn5.setText(null);
        btn6.setText(null);
        btn7.setText(null);
        btn8.setText(null);
        btn9.setText(null);
        btn1.setBorder(border);
        btn1.setFocusable(false);
        btn1.setFont(new Font("", Font.BOLD, 72));
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.addActionListener(e -> {
            select(btn1, 0, 0);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }

        });
        btn2.setBorder(border);
        btn2.setFocusable(false);
        btn2.setFont(new Font("", Font.BOLD, 72));
        btn2.setBackground(Color.LIGHT_GRAY);
        btn2.addActionListener(e -> {
            select(btn2, 0, 1);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });
        btn3.setBorder(border);
        btn3.setFocusable(false);
        btn3.setFont(new Font("", Font.BOLD, 72));
        btn3.setBackground(Color.LIGHT_GRAY);
        btn3.addActionListener(e -> {
            select(btn3, 0, 2);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });
        btn4.setBorder(border);
        btn4.setFocusable(false);
        btn4.setFont(new Font("", Font.BOLD, 72));
        btn4.setBackground(Color.LIGHT_GRAY);
        btn4.addActionListener(e -> {
            select(btn4, 1, 0);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });
        btn5.setBorder(border);
        btn5.setFocusable(false);
        btn5.setFont(new Font("", Font.BOLD, 72));
        btn5.setBackground(Color.LIGHT_GRAY);
        btn5.addActionListener(e -> {
            select(btn5, 1, 1);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }

        });
        btn6.setBorder(border);
        btn6.setFocusable(false);
        btn6.setFont(new Font("", Font.BOLD, 72));
        btn6.setBackground(Color.LIGHT_GRAY);
        btn6.addActionListener(e -> {
            select(btn6, 1, 2);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });
        btn7.setBorder(border);
        btn7.setFocusable(false);
        btn7.setFont(new Font("", Font.BOLD, 72));
        btn7.setBackground(Color.LIGHT_GRAY);
        btn7.addActionListener(e -> {
            select(btn7, 2, 0);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });
        btn8.setBorder(border);
        btn8.setFocusable(false);
        btn8.setFont(new Font("", Font.BOLD, 72));
        btn8.setBackground(Color.LIGHT_GRAY);
        btn8.addActionListener(e -> {
            select(btn8, 2, 1);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });
        btn9.setBorder(border);
        btn9.setFocusable(false);
        btn9.setFont(new Font("", Font.BOLD, 72));
        btn9.setBackground(Color.LIGHT_GRAY);
        btn9.addActionListener(e -> {
            select(btn9, 2, 2);
            if (!winDraw()){
                System.out.println(computer.finalDecision(selected));
                if(di %2 != 0) selectToAi(computer.finalDecision(selected));
                winDraw();
                drawD();
            }
        });


        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        reset.setBackground(Color.red);
        reset.setFocusable(false);
        reset.addActionListener(e -> reset());
        this.add(reset, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(500, 400));

        screen.setPreferredSize(new Dimension(500, 130));
        screen.setBackground(Color.BLUE);
        screen.setOpaque(true);

        label.setFont(new Font("", Font.BOLD, 62));
        label.setText("Start");
        label.setForeground(Color.white);
        label.setBounds(0,10,500,90);
        timer.setBackground(Color.white);
        timer.setFont(new Font("",Font.BOLD,24));
        timer.setOpaque(true);

        timer.setBounds(350,100,100,30);
        timer.setBorder(border);
        timer.setForeground(Color.black);
        timer.setText("--/--");

        screen.add(timer);
        screen.add(label);


        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);


        panel.setOpaque(true);
        panel.setBackground(Color.BLUE);
        this.add(screen, BorderLayout.NORTH);
        this.add(panel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void select(JButton b, int row, int column) {
        if (Objects.equals(b.getText(), null)) {
            if (di % 2 == 0) {
                if (!winDraw()) {
                    b.setText("X");
                    label.setText("O turn");
                    selected[row][column] = 'x';
                    count++;
                    di++;
                }


            } else {

                if (!winDraw()) {
                    b.setText("O");
                    label.setText("X turn");
                    selected[row][column] = 'o';
                    di++;
                    count++;
                }


            }
        } else {
            label.setText("Already Taken");
        }

    }

    String winCheck(char[][] a) {
        if (!Objects.equals(checkWin('x', a), "null")) {
            stopTread();
            return checkWin('x', a);
        }
        if (!Objects.equals(checkWin('o', a), "null")) {
            stopTread();
            return checkWin('o', a);
        }
        else return "null";
    }

    String checkWin(char c, char[][] a) {
        if ((a[0][0] == c || a[0][1] == c || a[0][2] == c) && a[0][0] == a[0][1] && a[0][0] == a[0][2]) {
            label.setText(c + " Win");
            return "1" + c;
        } else if ((a[1][0] == c || a[1][1] == c || a[1][2] == c) && a[1][0] == a[1][1] && a[1][0] == a[1][2]) {
            label.setText(c + " Win");
            return "2" + c;
        } else if ((a[2][0] == c || a[2][1] == c || a[2][2] == c) && a[2][0] == a[2][1] && a[2][0] == a[2][2]) {
            label.setText(c + " Win");
            return "3" + c;
        } else if ((a[0][0] == c || a[1][0] == c || a[2][0] == c) && a[0][0] == a[1][0] && a[0][0] == a[2][0]) {
            label.setText(c + " Win");
            return "4" + c;
        } else if ((a[0][1] == c || a[1][1] == c || a[2][1] == c) && a[0][1] == a[1][1] && a[0][1] == a[2][1]) {
            label.setText(c + " Win");
            return "5" + c;
        } else if ((a[0][2] == c || a[1][2] == c || a[2][2] == c) && a[0][2] == a[1][2] && a[0][2] == a[2][2]) {
            label.setText(c + " Win");
            return "6" + c;
        } else if ((a[0][0] == c || a[1][1] == c || a[2][2] == c) && a[0][0] == a[1][1] && a[0][0] == a[2][2]) {
            label.setText(c + " Win");
            return "7" + c;
        } else if ((a[0][2] == c || a[1][1] == c || a[2][0] == c) && a[0][2] == a[1][1] && a[0][2] == a[2][0]) {
            label.setText(c + " Win");

            return "8" + c;
        } else return "null";
    }

    boolean winDraw() {
        if (winCheck(selected).charAt(1) == 'x') {
            System.out.println("X win");
            switch (winCheck(selected).charAt(0)) {
                case '1' -> {
                    btn1.setBackground(Color.green);
                    btn2.setBackground(Color.green);
                    btn3.setBackground(Color.green);
                }
                case '2' -> {
                    btn4.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn6.setBackground(Color.green);
                }
                case '3' -> {
                    btn7.setBackground(Color.green);
                    btn8.setBackground(Color.green);
                    btn9.setBackground(Color.green);
                }
                case '4' -> {
                    btn1.setBackground(Color.green);
                    btn4.setBackground(Color.green);
                    btn7.setBackground(Color.green);
                }
                case '5' -> {
                    btn2.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn8.setBackground(Color.green);
                }
                case '6' -> {
                    btn3.setBackground(Color.green);
                    btn6.setBackground(Color.green);
                    btn9.setBackground(Color.green);
                }
                case '7' -> {
                    btn1.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn9.setBackground(Color.green);
                }
                case '8' -> {
                    btn3.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn7.setBackground(Color.green);
                }
            }
            return true;
        } else if (winCheck(selected).charAt(1) == 'o') {
            System.out.println("O win");
            switch (winCheck(selected).charAt(0)) {
                case '1' -> {
                    btn1.setBackground(Color.green);
                    btn2.setBackground(Color.green);
                    btn3.setBackground(Color.green);

                }

                case '2' -> {
                    btn4.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn6.setBackground(Color.green);
                }
                case '3' -> {
                    btn7.setBackground(Color.green);
                    btn8.setBackground(Color.green);
                    btn9.setBackground(Color.green);
                }
                case '4' -> {
                    btn1.setBackground(Color.green);
                    btn4.setBackground(Color.green);
                    btn7.setBackground(Color.green);
                }
                case '5' -> {
                    btn2.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn8.setBackground(Color.green);
                }
                case '6' -> {
                    btn3.setBackground(Color.green);
                    btn6.setBackground(Color.green);
                    btn9.setBackground(Color.green);
                }
                case '7' -> {
                    btn1.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn9.setBackground(Color.green);
                }
                case '8' -> {
                    btn3.setBackground(Color.green);
                    btn5.setBackground(Color.green);
                    btn7.setBackground(Color.green);
                }
            }
            return true;
        } else return false;

    }
    void stopTread(){
        run_thread = false;
    }
    void drawD() {
        if (checkDraw()) {
            btn1.setBackground(Color.yellow);
            btn2.setBackground(Color.yellow);
            btn3.setBackground(Color.yellow);
            btn4.setBackground(Color.yellow);
            btn5.setBackground(Color.yellow);
            btn6.setBackground(Color.yellow);
            btn7.setBackground(Color.yellow);
            btn8.setBackground(Color.yellow);
            btn9.setBackground(Color.yellow);
            label.setText("Draw");
            stopTread();

        }
    }

    boolean checkDraw() {
        return count == 9;
    }

    void reset() {

        di = 0;
        count=0;

        for(int i = 0; i<=2;i++){
            for (int j = 0;j<=2;j++){
                selected[i][j] = '\u0000';
            }
        }
        Timer.second = 0;
        btn1.setText(null);
        btn2.setText(null);
        btn3.setText(null);
        btn4.setText(null);
        btn5.setText(null);
        btn6.setText(null);
        btn7.setText(null);
        btn8.setText(null);
        btn9.setText(null);
        btn1.setBackground(Color.LIGHT_GRAY);
        btn2.setBackground(Color.LIGHT_GRAY);
        btn3.setBackground(Color.LIGHT_GRAY);
        btn4.setBackground(Color.LIGHT_GRAY);
        btn5.setBackground(Color.LIGHT_GRAY);
        btn6.setBackground(Color.LIGHT_GRAY);
        btn7.setBackground(Color.LIGHT_GRAY);
        btn8.setBackground(Color.LIGHT_GRAY);
        btn9.setBackground(Color.LIGHT_GRAY);
    }

    void selectToAi(String result) {

        switch (result.charAt(1)) {
            case '0' -> {
                System.out.println(result.charAt(2) +"  "+ result.charAt(1));
                if (result.charAt(2) == '0') select(btn1, 0, 0);
                else if (result.charAt(2) == '1') select(btn2, 0, 1);
                else if (result.charAt(2) == '2') select(btn3, 0, 2);
            }
            case '1'->{
                if (result.charAt(2) == '0') select(btn4, 1, 0);
                else if (result.charAt(2) == '1') select(btn5, 1, 1);
                else if (result.charAt(2) == '2') select(btn6, 1, 2);
            }
            case '2'->{
                if (result.charAt(2) == '0') select(btn7, 2, 0);
                else if (result.charAt(2) == '1') select(btn8, 2, 1);
                else if (result.charAt(2) == '2') select(btn9, 2, 2);
            }

        }
    }
    static class Timer implements Runnable {
        static int  second = 0;
        @Override
        public void run() {
            while(run_thread){
                timer.setText(second+"s");
                second+=1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("I am dead ):");
        }
    }

}
