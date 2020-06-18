package ernest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;

import javafx.scene.input.KeyCode;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;

public class Driver
{
    //TODO: 3 of a kind not working
    //TODO: 4 of a kind not working
    private JFrame frame;
    private GameManager gameManager;
    private JButton btnDice_1;
    private JButton btnDice_2;
    private JButton btnDice_3;
    private JButton btnDice_4;
    private JButton btnDice_5;
    private JTextField txtAces;
    private JTextField txtTwos;
    private JTextField txtThrees;
    private JTextField txtFours;
    private JTextField txtFives;
    private JTextField txtSixes;
    private JTextField txtTotalUpper;
    private JTextField txtBonus;
    private JTextField txtBigtotalupper;
    private JTextField txtofakind;
    private JTextField txtofakind_1;
    private JTextField txtFullhouse;
    private JTextField txtSstraight;
    private JTextField txtLstraight;
    private JTextField txtYahtzee;
    private JTextField txtYahtzeebonus;
    private JTextField txtLowertotal;
    private JTextField txtUppertotal;
    private JTextField txtGrandtotal;
    private JTextField txtChance;
    private JLabel lblThrowsleftcount;
    private JButton btnAces;
    private JButton btnTwos;
    private JButton btnThrees;
    private JButton buttonFours;
    private JButton buttonFives;
    private JButton buttonSixes;
    private JButton btn_3ofAKind;
    private JButton btn_4ofAKind;
    private JButton btnFullHouse;
    private JButton btnSmallStraight;
    private JButton btnLargeStraight;
    private JButton btnYahtzee;
    private JButton btnChances;
    private JButton btnBonus;
    private JButton btnBonus_1;
    private JButton btnBonus_2;
    private JButton btnThrow;

    private int upperCount = 0;
    private int lowerCount = 0;
    private int grandTotalCount = 0;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                try
                {
                    Driver window = new Driver();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Driver()
    {
        initialize();
        gameManager = new GameManager();
        newGame();
    }

    private void newGame()
    {
        initializeThrows();
        
        txtAces.setText("");
        txtTwos.setText("");
        txtThrees.setText("");
        txtFours.setText("");
        txtFives.setText("");
        txtSixes.setText("");
        txtTotalUpper.setText("");
        txtBonus.setText("");
        txtBigtotalupper.setText("");
        txtofakind.setText("");
        txtofakind_1.setText("");
        txtFullhouse.setText("");
        txtSstraight.setText("");
        txtLstraight.setText("");
        txtYahtzee.setText("");
        txtYahtzeebonus.setText("");
        txtLowertotal.setText("");
        txtUppertotal.setText("");
        txtGrandtotal.setText("");
        txtChance.setText("");
        
        btnAces.setEnabled(true);
        btnTwos.setEnabled(true);
        btnThrees.setEnabled(true);
        buttonFours.setEnabled(true);
        buttonFives.setEnabled(true);
        buttonSixes.setEnabled(true);
        btn_3ofAKind.setEnabled(true);
        btn_4ofAKind.setEnabled(true);
        btnFullHouse.setEnabled(true);
        btnSmallStraight.setEnabled(true);
        btnLargeStraight.setEnabled(true);
        btnYahtzee.setEnabled(true);
        btnChances.setEnabled(true);
        btnBonus.setEnabled(true);
        btnBonus_1.setEnabled(true);
        btnBonus_2.setEnabled(true);
    }

    private void initializeThrows()
    {
        btnThrow.setEnabled(true);
        int[] dices = gameManager.resetGame();

        lblThrowsleftcount.setText("3");

        btnDice_1.setBackground(Color.WHITE);
        btnDice_2.setBackground(Color.WHITE);
        btnDice_3.setBackground(Color.WHITE);
        btnDice_4.setBackground(Color.WHITE);
        btnDice_5.setBackground(Color.WHITE);

        btnDice_1.setText(String.valueOf("?"));
        btnDice_2.setText(String.valueOf("?"));
        btnDice_3.setText(String.valueOf("?"));
        btnDice_4.setText(String.valueOf("?"));
        btnDice_5.setText(String.valueOf("?"));
        
        btnDice_1.setEnabled(false);
        btnDice_2.setEnabled(false);
        btnDice_3.setEnabled(false);
        btnDice_4.setEnabled(false);
        btnDice_5.setEnabled(false);
    }
    
    private JButton[] dices()
    {
        JButton[] btnArray = new JButton[5];
        btnArray[0] = btnDice_1;
        btnArray[1] = btnDice_2;
        btnArray[2] = btnDice_3;
        btnArray[3] = btnDice_4;
        btnArray[4] = btnDice_5;
        
        return btnArray;
    }
    
    private void keepDices()
    {
        int throwsLeft = Integer.parseInt(lblThrowsleftcount.getText());
        btnDice_1.setEnabled(true);
        btnDice_2.setEnabled(true);
        btnDice_3.setEnabled(true);
        btnDice_4.setEnabled(true);
        btnDice_5.setEnabled(true);
        
        if (!lblThrowsleftcount.getText().equals("0"))
        {
            int count = 0;
            
            JButton[]btnArray = dices();
            
            for (int i = 0; i < btnArray.length; i++)
                if (btnArray[i].getBackground().equals(Color.WHITE))
                    count++;

            int[] dicesVal = gameManager.randomizeDices(count);
            int indexValue = 0;
            
            for(int i = 0; i < btnArray.length; i++)
                if (btnArray[i].getBackground().equals(Color.WHITE))
                    btnArray[i].setText(String.valueOf(dicesVal[indexValue++]));
            throwsLeft--;
            lblThrowsleftcount.setText(String.valueOf(throwsLeft));
            if (throwsLeft == 0)
            {
                btnThrow.setEnabled(false);
            }
        }
    }

    private String calcResult(int diceValue)
    {
        JButton[]btnArray = dices();
        int count = 0;
        
        for (int i = 0; i < btnArray.length; i++)
        {
            if (btnArray[i].getText().equals(String.valueOf(diceValue)))
            {
                count++;
            }
        }
        
        initializeThrows();
        upperCount++;

        return String.valueOf(diceValue * count);
    }
    
    private boolean checkCondition(int type)
    {
        JButton[] btnArray = dices();
        int [] array = getDiceVal(btnArray);
        
        for (int i = 0; i < btnArray.length; i++)
            array[i] = Integer.valueOf(btnArray[i].getText());
            
        return gameManager.checkCondition(array, type);
    }
    
    private int calcDicesTotal(JButton[] btnArray)
    {
        int total = 0;
        
        for (int i = 0; i < btnArray.length; i++)
        {
            total += Integer.valueOf(btnArray[i].getText());
        }
        
        return total;
    }

    private boolean isDiceValid(JButton[] btnArray)
    {
        boolean isValid = true;
        for (int i = 0; i < btnArray.length; i++)
            if (btnArray[i].getText().equals("?"))
                isValid = false;
        return isValid;
    }

    private int[] getDiceVal(JButton[] btnArray)
    {
        int[] array = new int[btnArray.length];
        
        for (int i = 0; i < btnArray.length; i++)
        {
            array[i] = Integer.valueOf(btnArray[i].getText());
        }
        
        return array;
    }

    private boolean checkFullHouseCondition(int[] array)
    {
        return gameManager.checkFullHouse(array);
    }
    
    private boolean checkStraightCondition(int[] array, int type)
    {
        return gameManager.checkStraight(array, type);
    }
    
    private boolean checkYahtzeeCondition(int [] array)
    {
        return gameManager.checkYahtzee(array);
    }
    
    private int calcChance(int[] dices)
    {
        return gameManager.calcChance(dices);
    }
    
    private void checkBonus(int[] array)
    {
        String txt = txtYahtzeebonus.getText();
        if (txt.equals(""))
            txt = "0";
        int currentBonus = Integer.parseInt(txt);
        
        if (txtYahtzee.getText().equals(null))
        {
            if (checkYahtzeeCondition(array))
            {
                currentBonus += 100;
                txtYahtzeebonus.setText(String.valueOf(currentBonus));
            } 
            else
            {
                txtYahtzeebonus.setText(String.valueOf(currentBonus));
            }
            
            initializeThrows();
        }
        else 
        {
            
        }

    }
    
    private void calcTotalUpper()
    {
        int total = 0;
        if (upperCount == 6)
        {
            total = Integer.parseInt(txtAces.getText()) + Integer.parseInt(txtTwos.getText()) + 
                    Integer.parseInt(txtThrees.getText()) + Integer.parseInt(txtFours.getText()) + 
                    Integer.parseInt(txtFives.getText()) + Integer.parseInt(txtSixes.getText());
            txtTotalUpper.setText(String.valueOf(total));
            
            if (total >= 63)
            {
                total += 35;
                txtBonus.setText("35");
            }
            else
                txtBonus.setText("0");
            
            txtBigtotalupper.setText(String.valueOf(total));
            txtUppertotal.setText(String.valueOf(total));
            
            grandTotalCount++;
        }
        
        calcGrandTotal();
    }
    
    private void calcTotalLower()
    {
        int total = 0;
        lowerCount++;
        if (lowerCount == 10)
        {
            total = Integer.parseInt(txtofakind.getText()) + Integer.parseInt(txtofakind_1.getText()) + 
                    Integer.parseInt(txtFullhouse.getText()) + Integer.parseInt(txtSstraight.getText()) + 
                    Integer.parseInt(txtLstraight.getText()) + Integer.parseInt(txtYahtzee.getText()) + 
                    Integer.parseInt(txtChance.getText()) + Integer.parseInt(txtYahtzeebonus.getText());
            txtLowertotal.setText(String.valueOf(total));
            
            txtLowertotal.setText(String.valueOf(total));
            grandTotalCount++;
        }
        
        calcGrandTotal();
    }
    
    private void calcGrandTotal()
    {
        if (grandTotalCount == 2) 
        {
            int valUpper = Integer.parseInt(txtBigtotalupper.getText());
            int valLower = Integer.parseInt(txtBigtotalupper.getText());
            txtGrandtotal.setText(String.valueOf(valUpper + valLower));
        }
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 439, 749);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel_dices = new JPanel();
        frame.getContentPane().add(panel_dices, BorderLayout.NORTH);
        panel_dices.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_dices.add(panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        btnDice_1 = new JButton("DICE1");
        panel_2.add(btnDice_1);
        btnDice_1.setBackground(Color.WHITE);
        btnDice_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnDice_1.getBackground().equals(Color.lightGray))
                    btnDice_1.setBackground(Color.WHITE);
                else
                    btnDice_1.setBackground(Color.lightGray);
            }
        });
        btnDice_1.setPreferredSize(new Dimension(45, 45));
        
        btnDice_2 = new JButton("DICE2");
        panel_2.add(btnDice_2);
        btnDice_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnDice_2.getBackground().equals(Color.lightGray))
                    btnDice_2.setBackground(Color.WHITE);
                else
                    btnDice_2.setBackground(Color.lightGray);
            }
        });
        btnDice_2.setBackground(Color.WHITE);
        btnDice_2.setPreferredSize(new Dimension(45, 45));
        
        btnDice_3 = new JButton("DICE3");
        panel_2.add(btnDice_3);
        btnDice_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnDice_3.getBackground().equals(Color.lightGray))
                    btnDice_3.setBackground(Color.WHITE);
                else
                    btnDice_3.setBackground(Color.lightGray);
            }
        });
        btnDice_3.setBackground(Color.WHITE);
        btnDice_3.setPreferredSize(new Dimension(45, 45));
        
        btnDice_4 = new JButton("DICE4");
        panel_2.add(btnDice_4);
        btnDice_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnDice_4.getBackground().equals(Color.lightGray))
                    btnDice_4.setBackground(Color.WHITE);
                else
                    btnDice_4.setBackground(Color.lightGray);
            }
        });
        btnDice_4.setBackground(Color.WHITE);
        btnDice_4.setPreferredSize(new Dimension(45, 45));
        
        btnDice_5 = new JButton("DICE5");
        panel_2.add(btnDice_5);
        btnDice_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnDice_5.getBackground().equals(Color.lightGray))
                    btnDice_5.setBackground(Color.WHITE);
                else
                    btnDice_5.setBackground(Color.lightGray);
            }
        });
        btnDice_5.setBackground(Color.WHITE);
        btnDice_5.setPreferredSize(new Dimension(45, 45));
        
        JPanel panel_btns = new JPanel();
        panel_dices.add(panel_btns, BorderLayout.SOUTH);
        
        btnThrow = new JButton("Throw");
        btnThrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                keepDices();
            }
        });
        btnThrow.setPreferredSize(new Dimension(70, 30));
        panel_btns.add(btnThrow);
        
        JPanel panel_3 = new JPanel();
        panel_dices.add(panel_3, BorderLayout.NORTH);
        
        JLabel lblThrowsLeft = new JLabel("Throws left:");
        panel_3.add(lblThrowsLeft);
        
        lblThrowsleftcount = new JLabel("2");
        panel_3.add(lblThrowsleftcount);
        
        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{104, 0, 110, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 26, 16, 16, 16, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalStrut_1.setMinimumSize(new Dimension(0, 10));
        GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
        gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut_1.gridx = 0;
        gbc_verticalStrut_1.gridy = 0;
        panel.add(verticalStrut_1, gbc_verticalStrut_1);
        
        JLabel lblUpperSection = new JLabel("UPPER SECTION");
        lblUpperSection.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblUpperSection = new GridBagConstraints();
        gbc_lblUpperSection.insets = new Insets(0, 0, 5, 5);
        gbc_lblUpperSection.gridx = 0;
        gbc_lblUpperSection.gridy = 1;
        panel.add(lblUpperSection, gbc_lblUpperSection);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalStrut.setPreferredSize(new Dimension(5, 0));
        horizontalStrut.setMinimumSize(new Dimension(5, 0));
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
        gbc_horizontalStrut.gridx = 1;
        gbc_horizontalStrut.gridy = 1;
        panel.add(horizontalStrut, gbc_horizontalStrut);
        
        JLabel lblChoose = new JLabel("CHOOSE");
        lblChoose.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblChoose = new GridBagConstraints();
        gbc_lblChoose.insets = new Insets(0, 0, 5, 5);
        gbc_lblChoose.gridx = 2;
        gbc_lblChoose.gridy = 1;
        panel.add(lblChoose, gbc_lblChoose);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        horizontalStrut_1.setMinimumSize(new Dimension(44, 0));
        horizontalStrut_1.setPreferredSize(new Dimension(50, 0));
        GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
        gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
        gbc_horizontalStrut_1.gridx = 3;
        gbc_horizontalStrut_1.gridy = 1;
        panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
        
        JLabel lblScore = new JLabel("SCORE");
        lblScore.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblScore = new GridBagConstraints();
        gbc_lblScore.insets = new Insets(0, 0, 5, 5);
        gbc_lblScore.gridx = 4;
        gbc_lblScore.gridy = 1;
        panel.add(lblScore, gbc_lblScore);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalStrut_2.setMinimumSize(new Dimension(10, 0));
        GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
        gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut_2.gridx = 5;
        gbc_horizontalStrut_2.gridy = 1;
        panel.add(horizontalStrut_2, gbc_horizontalStrut_2);
        
        JLabel lblAces = new JLabel("Aces");
        GridBagConstraints gbc_lblAces = new GridBagConstraints();
        gbc_lblAces.insets = new Insets(0, 0, 5, 5);
        gbc_lblAces.gridx = 0;
        gbc_lblAces.gridy = 2;
        panel.add(lblAces, gbc_lblAces);
        
        btnAces = new JButton("\u2192");
        btnAces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                for (int i = 0; i < btnArray.length; i++)
                {
                    if (!btnArray[i].getText().equals("?"))
                    {
                        String score = calcResult(1);
                        btnAces.setEnabled(false);
                        txtAces.setText(score);
                        calcTotalUpper();
                    }
                }
            }
        });
        btnAces.setToolTipText("Count and Add All Aces");
        btnAces.setMinimumSize(new Dimension(63, 16));
        btnAces.setPreferredSize(new Dimension(63, 16));
        GridBagConstraints gbc_btnAces = new GridBagConstraints();
        gbc_btnAces.insets = new Insets(0, 0, 5, 5);
        gbc_btnAces.gridx = 2;
        gbc_btnAces.gridy = 2;
        panel.add(btnAces, gbc_btnAces);
        
        txtAces = new JTextField();
        txtAces.setHorizontalAlignment(SwingConstants.CENTER);
        txtAces.setEditable(false);
        txtAces.setMinimumSize(new Dimension(20, 20));
        txtAces.setMaximumSize(new Dimension(20, 20));
        txtAces.setSize(new Dimension(20, 20));
        txtAces.setPreferredSize(new Dimension(20, 20));
        GridBagConstraints gbc_txtAces = new GridBagConstraints();
        gbc_txtAces.insets = new Insets(0, 0, 5, 5);
        gbc_txtAces.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAces.gridx = 4;
        gbc_txtAces.gridy = 2;
        panel.add(txtAces, gbc_txtAces);
        txtAces.setColumns(10);
        
        JLabel lblTwos = new JLabel("Twos");
        GridBagConstraints gbc_lblTwos = new GridBagConstraints();
        gbc_lblTwos.insets = new Insets(0, 0, 5, 5);
        gbc_lblTwos.gridx = 0;
        gbc_lblTwos.gridy = 3;
        panel.add(lblTwos, gbc_lblTwos);
        
        btnTwos = new JButton("\u2192");
        btnTwos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                for (int i = 0; i < btnArray.length; i++)
                {
                    if (!btnArray[i].getText().equals("?"))
                    {
                        String score = calcResult(2);
                        btnTwos.setEnabled(false);
                        txtTwos.setText(score);
                        calcTotalUpper();
                    }
                }
            }
        });
        btnTwos.setToolTipText("Count and Add All Twos");
        btnTwos.setMaximumSize(new Dimension(63, 16));
        btnTwos.setMinimumSize(new Dimension(63, 16));
        btnTwos.setPreferredSize(new Dimension(63, 16));
        btnTwos.setSize(new Dimension(63, 16));
        GridBagConstraints gbc_btnTwos = new GridBagConstraints();
        gbc_btnTwos.insets = new Insets(0, 0, 5, 5);
        gbc_btnTwos.gridx = 2;
        gbc_btnTwos.gridy = 3;
        panel.add(btnTwos, gbc_btnTwos);
        
        txtTwos = new JTextField();
        txtTwos.setHorizontalAlignment(SwingConstants.CENTER);
        txtTwos.setEditable(false);
        GridBagConstraints gbc_txtTwos = new GridBagConstraints();
        gbc_txtTwos.insets = new Insets(0, 0, 5, 5);
        gbc_txtTwos.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTwos.gridx = 4;
        gbc_txtTwos.gridy = 3;
        panel.add(txtTwos, gbc_txtTwos);
        txtTwos.setColumns(10);
        
        JLabel lblThrees = new JLabel("Threes");
        GridBagConstraints gbc_lblThrees = new GridBagConstraints();
        gbc_lblThrees.insets = new Insets(0, 0, 5, 5);
        gbc_lblThrees.gridx = 0;
        gbc_lblThrees.gridy = 4;
        panel.add(lblThrees, gbc_lblThrees);
        
        btnThrees = new JButton("\u2192");
        btnThrees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                for (int i = 0; i < btnArray.length; i++)
                {
                    if (!btnArray[i].getText().equals("?"))
                    {
                        String score = calcResult(3);
                        btnThrees.setEnabled(false);
                        txtThrees.setText(score);
                        calcTotalUpper();
                    }
                }
            }
        });
        btnThrees.setToolTipText("Count and Add All Threes");
        btnThrees.setPreferredSize(new Dimension(63, 16));
        btnThrees.setMinimumSize(new Dimension(63, 16));
        btnThrees.setMaximumSize(new Dimension(63, 16));
        GridBagConstraints gbc_btnThrees = new GridBagConstraints();
        gbc_btnThrees.insets = new Insets(0, 0, 5, 5);
        gbc_btnThrees.gridx = 2;
        gbc_btnThrees.gridy = 4;
        panel.add(btnThrees, gbc_btnThrees);
        
        txtThrees = new JTextField();
        txtThrees.setHorizontalAlignment(SwingConstants.CENTER);
        txtThrees.setEditable(false);
        GridBagConstraints gbc_txtThrees = new GridBagConstraints();
        gbc_txtThrees.insets = new Insets(0, 0, 5, 5);
        gbc_txtThrees.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtThrees.gridx = 4;
        gbc_txtThrees.gridy = 4;
        panel.add(txtThrees, gbc_txtThrees);
        txtThrees.setColumns(10);
        
        JLabel lblFours = new JLabel("Fours");
        GridBagConstraints gbc_lblFours = new GridBagConstraints();
        gbc_lblFours.insets = new Insets(0, 0, 5, 5);
        gbc_lblFours.gridx = 0;
        gbc_lblFours.gridy = 5;
        panel.add(lblFours, gbc_lblFours);
        
        buttonFours = new JButton("\u2192");
        buttonFours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                for (int i = 0; i < btnArray.length; i++)
                {
                    if (!btnArray[i].getText().equals("?"))
                    {
                        String score = calcResult(4);
                        buttonFours.setEnabled(false);
                        txtFours.setText(score);
                        calcTotalUpper();
                    }
                }
            }
        });
        buttonFours.setToolTipText("Count and Add All Fours");
        buttonFours.setPreferredSize(new Dimension(63, 16));
        buttonFours.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonFours = new GridBagConstraints();
        gbc_buttonFours.insets = new Insets(0, 0, 5, 5);
        gbc_buttonFours.gridx = 2;
        gbc_buttonFours.gridy = 5;
        panel.add(buttonFours, gbc_buttonFours);
        
        txtFours = new JTextField();
        txtFours.setHorizontalAlignment(SwingConstants.CENTER);
        txtFours.setEditable(false);
        GridBagConstraints gbc_txtFours = new GridBagConstraints();
        gbc_txtFours.insets = new Insets(0, 0, 5, 5);
        gbc_txtFours.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFours.gridx = 4;
        gbc_txtFours.gridy = 5;
        panel.add(txtFours, gbc_txtFours);
        txtFours.setColumns(10);
        
        JLabel lblFives = new JLabel("Fives");
        GridBagConstraints gbc_lblFives = new GridBagConstraints();
        gbc_lblFives.insets = new Insets(0, 0, 5, 5);
        gbc_lblFives.gridx = 0;
        gbc_lblFives.gridy = 6;
        panel.add(lblFives, gbc_lblFives);
        
        buttonFives = new JButton("\u2192");
        buttonFives.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                for (int i = 0; i < btnArray.length; i++)
                {
                    if (!btnArray[i].getText().equals("?"))
                    {
                        String score = calcResult(5);
                        buttonFives.setEnabled(false);
                        txtFives.setText(score);
                        calcTotalUpper();
                    }
                }
            }
        });
        buttonFives.setToolTipText("Count and Add All Fives");
        buttonFives.setPreferredSize(new Dimension(63, 16));
        buttonFives.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonFives = new GridBagConstraints();
        gbc_buttonFives.insets = new Insets(0, 0, 5, 5);
        gbc_buttonFives.gridx = 2;
        gbc_buttonFives.gridy = 6;
        panel.add(buttonFives, gbc_buttonFives);
        
        txtFives = new JTextField();
        txtFives.setHorizontalAlignment(SwingConstants.CENTER);
        txtFives.setEditable(false);
        GridBagConstraints gbc_txtFives = new GridBagConstraints();
        gbc_txtFives.insets = new Insets(0, 0, 5, 5);
        gbc_txtFives.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFives.gridx = 4;
        gbc_txtFives.gridy = 6;
        panel.add(txtFives, gbc_txtFives);
        txtFives.setColumns(10);
        
        JLabel lblSixes = new JLabel("Sixes");
        GridBagConstraints gbc_lblSixes = new GridBagConstraints();
        gbc_lblSixes.insets = new Insets(0, 0, 5, 5);
        gbc_lblSixes.gridx = 0;
        gbc_lblSixes.gridy = 7;
        panel.add(lblSixes, gbc_lblSixes);
        
        buttonSixes = new JButton("\u2192");
        buttonSixes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                for (int i = 0; i < btnArray.length; i++)
                {
                    if (!btnArray[i].getText().equals("?"))
                    {
                        String score = calcResult(6);
                        buttonSixes.setEnabled(false);
                        txtSixes.setText(score);
                        calcTotalUpper();
                    }
                }
            }
        });
        buttonSixes.setToolTipText("Count and Add All Sixes");
        buttonSixes.setPreferredSize(new Dimension(63, 16));
        buttonSixes.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonSixes = new GridBagConstraints();
        gbc_buttonSixes.insets = new Insets(0, 0, 5, 5);
        gbc_buttonSixes.gridx = 2;
        gbc_buttonSixes.gridy = 7;
        panel.add(buttonSixes, gbc_buttonSixes);
        
        txtSixes = new JTextField();
        txtSixes.setHorizontalAlignment(SwingConstants.CENTER);
        txtSixes.setEditable(false);
        GridBagConstraints gbc_txtSixes = new GridBagConstraints();
        gbc_txtSixes.insets = new Insets(0, 0, 5, 5);
        gbc_txtSixes.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSixes.gridx = 4;
        gbc_txtSixes.gridy = 7;
        panel.add(txtSixes, gbc_txtSixes);
        txtSixes.setColumns(10);
        
        JLabel lblTotalScore = new JLabel("TOTAL SCORE");
        GridBagConstraints gbc_lblTotalScore = new GridBagConstraints();
        gbc_lblTotalScore.insets = new Insets(0, 0, 5, 5);
        gbc_lblTotalScore.gridx = 0;
        gbc_lblTotalScore.gridy = 8;
        panel.add(lblTotalScore, gbc_lblTotalScore);
        
        JLabel lblu = new JLabel("\u2192");
        GridBagConstraints gbc_lblu = new GridBagConstraints();
        gbc_lblu.insets = new Insets(0, 0, 5, 5);
        gbc_lblu.gridx = 2;
        gbc_lblu.gridy = 8;
        panel.add(lblu, gbc_lblu);
        
        txtTotalUpper = new JTextField();
        txtTotalUpper.setHorizontalAlignment(SwingConstants.CENTER);
        txtTotalUpper.setEditable(false);
        GridBagConstraints gbc_txtTotalupper = new GridBagConstraints();
        gbc_txtTotalupper.insets = new Insets(0, 0, 5, 5);
        gbc_txtTotalupper.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTotalupper.gridx = 4;
        gbc_txtTotalupper.gridy = 8;
        panel.add(txtTotalUpper, gbc_txtTotalupper);
        txtTotalUpper.setColumns(10);
        
        JLabel lblBonus = new JLabel("BONUS");
        GridBagConstraints gbc_lblBonus = new GridBagConstraints();
        gbc_lblBonus.insets = new Insets(0, 0, 5, 5);
        gbc_lblBonus.gridx = 0;
        gbc_lblBonus.gridy = 9;
        panel.add(lblBonus, gbc_lblBonus);
        
        JLabel label = new JLabel("\u2192");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 9;
        panel.add(label, gbc_label);
        
        txtBonus = new JTextField();
        txtBonus.setHorizontalAlignment(SwingConstants.CENTER);
        txtBonus.setEditable(false);
        GridBagConstraints gbc_txtBonus = new GridBagConstraints();
        gbc_txtBonus.insets = new Insets(0, 0, 5, 5);
        gbc_txtBonus.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBonus.gridx = 4;
        gbc_txtBonus.gridy = 9;
        panel.add(txtBonus, gbc_txtBonus);
        txtBonus.setColumns(10);
        
        JLabel lblUpperSectionTotal = new JLabel("UPPER SECTION TOTAL");
        GridBagConstraints gbc_lblUpperSectionTotal = new GridBagConstraints();
        gbc_lblUpperSectionTotal.insets = new Insets(0, 0, 5, 5);
        gbc_lblUpperSectionTotal.gridx = 0;
        gbc_lblUpperSectionTotal.gridy = 10;
        panel.add(lblUpperSectionTotal, gbc_lblUpperSectionTotal);
        
        JLabel lblu_1 = new JLabel("\u2192");
        GridBagConstraints gbc_lblu_1 = new GridBagConstraints();
        gbc_lblu_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblu_1.gridx = 2;
        gbc_lblu_1.gridy = 10;
        panel.add(lblu_1, gbc_lblu_1);
        
        txtBigtotalupper = new JTextField();
        txtBigtotalupper.setHorizontalAlignment(SwingConstants.CENTER);
        txtBigtotalupper.setEditable(false);
        GridBagConstraints gbc_txtBigtotalupper = new GridBagConstraints();
        gbc_txtBigtotalupper.insets = new Insets(0, 0, 5, 5);
        gbc_txtBigtotalupper.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBigtotalupper.gridx = 4;
        gbc_txtBigtotalupper.gridy = 10;
        panel.add(txtBigtotalupper, gbc_txtBigtotalupper);
        txtBigtotalupper.setColumns(10);
        
        JLabel lblLowerSection = new JLabel("LOWER SECTION");
        lblLowerSection.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblLowerSection = new GridBagConstraints();
        gbc_lblLowerSection.insets = new Insets(0, 0, 5, 5);
        gbc_lblLowerSection.gridx = 0;
        gbc_lblLowerSection.gridy = 11;
        panel.add(lblLowerSection, gbc_lblLowerSection);
        
        JLabel lblOfA = new JLabel("3 of a kind");
        GridBagConstraints gbc_lblOfA = new GridBagConstraints();
        gbc_lblOfA.insets = new Insets(0, 0, 5, 5);
        gbc_lblOfA.gridx = 0;
        gbc_lblOfA.gridy = 12;
        panel.add(lblOfA, gbc_lblOfA);
        
        btn_3ofAKind = new JButton("\u2192");
        btn_3ofAKind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    if (checkCondition(3))
                    {
                        if (calcDicesTotal(btnArray) != 0)
                            txtofakind.setText(String.valueOf(calcDicesTotal(btnArray)));
                    }
                    else
                        txtofakind.setText("0");

                    btn_3ofAKind.setEnabled(false);
                    calcTotalLower();
                    initializeThrows();
                }
            }
        });
        btn_3ofAKind.setToolTipText("Add Total of All Dices");
        btn_3ofAKind.setPreferredSize(new Dimension(63, 16));
        btn_3ofAKind.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_button_3ofAKind = new GridBagConstraints();
        gbc_button_3ofAKind.insets = new Insets(0, 0, 5, 5);
        gbc_button_3ofAKind.gridx = 2;
        gbc_button_3ofAKind.gridy = 12;
        panel.add(btn_3ofAKind, gbc_button_3ofAKind);
        
        txtofakind = new JTextField();
        txtofakind.setHorizontalAlignment(SwingConstants.CENTER);
        txtofakind.setEditable(false);
        GridBagConstraints gbc_txtofakind = new GridBagConstraints();
        gbc_txtofakind.insets = new Insets(0, 0, 5, 5);
        gbc_txtofakind.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtofakind.gridx = 4;
        gbc_txtofakind.gridy = 12;
        panel.add(txtofakind, gbc_txtofakind);
        txtofakind.setColumns(10);
        
        JLabel lblOfA_1 = new JLabel("4 of a kind");
        GridBagConstraints gbc_lblOfA_1 = new GridBagConstraints();
        gbc_lblOfA_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblOfA_1.gridx = 0;
        gbc_lblOfA_1.gridy = 13;
        panel.add(lblOfA_1, gbc_lblOfA_1);
        
        btn_4ofAKind = new JButton("\u2192");
        btn_4ofAKind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    if (checkCondition(4))
                    {
                        if (calcDicesTotal(btnArray) != 0)
                            txtofakind_1.setText(String.valueOf(calcDicesTotal(btnArray)));
                    }
                    else
                        txtofakind_1.setText("0");

                    btn_4ofAKind.setEnabled(false);
                    calcTotalLower();
                    initializeThrows();
                }
            }
        });
        btn_4ofAKind.setToolTipText("Add Total of All Dices");
        btn_4ofAKind.setPreferredSize(new Dimension(63, 16));
        btn_4ofAKind.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_button_4ofAKind = new GridBagConstraints();
        gbc_button_4ofAKind.insets = new Insets(0, 0, 5, 5);
        gbc_button_4ofAKind.gridx = 2;
        gbc_button_4ofAKind.gridy = 13;
        panel.add(btn_4ofAKind, gbc_button_4ofAKind);
        
        txtofakind_1 = new JTextField();
        txtofakind_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtofakind_1.setEditable(false);
        GridBagConstraints gbc_txtofakind_1 = new GridBagConstraints();
        gbc_txtofakind_1.insets = new Insets(0, 0, 5, 5);
        gbc_txtofakind_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtofakind_1.gridx = 4;
        gbc_txtofakind_1.gridy = 13;
        panel.add(txtofakind_1, gbc_txtofakind_1);
        txtofakind_1.setColumns(10);
        
        JLabel lblFullHouse = new JLabel("Full House");
        GridBagConstraints gbc_lblFullHouse = new GridBagConstraints();
        gbc_lblFullHouse.insets = new Insets(0, 0, 5, 5);
        gbc_lblFullHouse.gridx = 0;
        gbc_lblFullHouse.gridy = 14;
        panel.add(lblFullHouse, gbc_lblFullHouse);
        
        btnFullHouse = new JButton("\u2192");
        btnFullHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    if (checkFullHouseCondition(getDiceVal(btnArray)))
                        txtFullhouse.setText("25");
                    else
                        txtFullhouse.setText("0");

                    btnFullHouse.setEnabled(false);
                    calcTotalLower();
                    initializeThrows();
                }
            }
        });
        btnFullHouse.setToolTipText("Three of a Kind and A Pair\r\n<\\br>Score 25");
        btnFullHouse.setPreferredSize(new Dimension(63, 16));
        btnFullHouse.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonFullHouse = new GridBagConstraints();
        gbc_buttonFullHouse.insets = new Insets(0, 0, 5, 5);
        gbc_buttonFullHouse.gridx = 2;
        gbc_buttonFullHouse.gridy = 14;
        panel.add(btnFullHouse, gbc_buttonFullHouse);
        
        txtFullhouse = new JTextField();
        txtFullhouse.setHorizontalAlignment(SwingConstants.CENTER);
        txtFullhouse.setEditable(false);
        GridBagConstraints gbc_txtFullhouse = new GridBagConstraints();
        gbc_txtFullhouse.insets = new Insets(0, 0, 5, 5);
        gbc_txtFullhouse.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFullhouse.gridx = 4;
        gbc_txtFullhouse.gridy = 14;
        panel.add(txtFullhouse, gbc_txtFullhouse);
        txtFullhouse.setColumns(10);
        
        JLabel lblSmallStraight = new JLabel("Small Straight");
        GridBagConstraints gbc_lblSmallStraight = new GridBagConstraints();
        gbc_lblSmallStraight.insets = new Insets(0, 0, 5, 5);
        gbc_lblSmallStraight.gridx = 0;
        gbc_lblSmallStraight.gridy = 15;
        panel.add(lblSmallStraight, gbc_lblSmallStraight);
        
        btnSmallStraight = new JButton("\u2192");
        btnSmallStraight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    if (checkStraightCondition(getDiceVal(btnArray), 3))
                        txtSstraight.setText("30");
                    else
                        txtSstraight.setText("0");

                    btnSmallStraight.setEnabled(false);
                    calcTotalLower();
                    initializeThrows();
                }
            }
        });
        btnSmallStraight.setPreferredSize(new Dimension(63, 16));
        btnSmallStraight.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonSmallStraight = new GridBagConstraints();
        gbc_buttonSmallStraight.insets = new Insets(0, 0, 5, 5);
        gbc_buttonSmallStraight.gridx = 2;
        gbc_buttonSmallStraight.gridy = 15;
        panel.add(btnSmallStraight, gbc_buttonSmallStraight);
        
        txtSstraight = new JTextField();
        txtSstraight.setHorizontalAlignment(SwingConstants.CENTER);
        txtSstraight.setEditable(false);
        GridBagConstraints gbc_txtSstraight = new GridBagConstraints();
        gbc_txtSstraight.insets = new Insets(0, 0, 5, 5);
        gbc_txtSstraight.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSstraight.gridx = 4;
        gbc_txtSstraight.gridy = 15;
        panel.add(txtSstraight, gbc_txtSstraight);
        txtSstraight.setColumns(10);
        
        JLabel lblLargeStraight = new JLabel("Large Straight");
        GridBagConstraints gbc_lblLargeStraight = new GridBagConstraints();
        gbc_lblLargeStraight.insets = new Insets(0, 0, 5, 5);
        gbc_lblLargeStraight.gridx = 0;
        gbc_lblLargeStraight.gridy = 16;
        panel.add(lblLargeStraight, gbc_lblLargeStraight);
        
        btnLargeStraight = new JButton("\u2192");
        btnLargeStraight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    if (checkStraightCondition(getDiceVal(btnArray), 4))
                        txtLstraight.setText("40");
                    else
                        txtLstraight.setText("0");

                    btnLargeStraight.setEnabled(false);
                    calcTotalLower();
                    initializeThrows();
                }

            }
        });
        btnLargeStraight.setPreferredSize(new Dimension(63, 16));
        btnLargeStraight.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonLargeStraight = new GridBagConstraints();
        gbc_buttonLargeStraight.insets = new Insets(0, 0, 5, 5);
        gbc_buttonLargeStraight.gridx = 2;
        gbc_buttonLargeStraight.gridy = 16;
        panel.add(btnLargeStraight, gbc_buttonLargeStraight);
        
        txtLstraight = new JTextField();
        txtLstraight.setHorizontalAlignment(SwingConstants.CENTER);
        txtLstraight.setEditable(false);
        GridBagConstraints gbc_txtLstraight = new GridBagConstraints();
        gbc_txtLstraight.insets = new Insets(0, 0, 5, 5);
        gbc_txtLstraight.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLstraight.gridx = 4;
        gbc_txtLstraight.gridy = 16;
        panel.add(txtLstraight, gbc_txtLstraight);
        txtLstraight.setColumns(10);
        
        JLabel lblYahtzee = new JLabel("YAHTZEE");
        GridBagConstraints gbc_lblYahtzee = new GridBagConstraints();
        gbc_lblYahtzee.insets = new Insets(0, 0, 5, 5);
        gbc_lblYahtzee.gridx = 0;
        gbc_lblYahtzee.gridy = 17;
        panel.add(lblYahtzee, gbc_lblYahtzee);
        
        btnYahtzee = new JButton("\u2192");
        btnYahtzee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    if (checkYahtzeeCondition(getDiceVal(btnArray)))
                    {
                        txtYahtzee.setText("50");
                    }
                    else
                    {
                        txtYahtzee.setText("0");
                    }
                    btnYahtzee.setEnabled(false);
                    calcTotalLower();
                    initializeThrows();
                }
            }
        });
        btnYahtzee.setPreferredSize(new Dimension(63, 16));
        btnYahtzee.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonYahtzee = new GridBagConstraints();
        gbc_buttonYahtzee.insets = new Insets(0, 0, 5, 5);
        gbc_buttonYahtzee.gridx = 2;
        gbc_buttonYahtzee.gridy = 17;
        panel.add(btnYahtzee, gbc_buttonYahtzee);
        
        txtYahtzee = new JTextField();
        txtYahtzee.setHorizontalAlignment(SwingConstants.CENTER);
        txtYahtzee.setEditable(false);
        GridBagConstraints gbc_txtYahtzee = new GridBagConstraints();
        gbc_txtYahtzee.insets = new Insets(0, 0, 5, 5);
        gbc_txtYahtzee.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtYahtzee.gridx = 4;
        gbc_txtYahtzee.gridy = 17;
        panel.add(txtYahtzee, gbc_txtYahtzee);
        txtYahtzee.setColumns(10);
        
        JLabel lblChance = new JLabel("Chance");
        GridBagConstraints gbc_lblChance = new GridBagConstraints();
        gbc_lblChance.insets = new Insets(0, 0, 5, 5);
        gbc_lblChance.gridx = 0;
        gbc_lblChance.gridy = 18;
        panel.add(lblChance, gbc_lblChance);
        
        btnChances = new JButton("\u2192");
        btnChances.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    txtChance.setText(String.valueOf(calcChance(getDiceVal(btnArray))));
                    calcTotalLower();
                    btnChances.setEnabled(false);
                    initializeThrows();
                }
            }
        });
        btnChances.setPreferredSize(new Dimension(63, 16));
        btnChances.setMinimumSize(new Dimension(63, 16));
        GridBagConstraints gbc_buttonChances = new GridBagConstraints();
        gbc_buttonChances.insets = new Insets(0, 0, 5, 5);
        gbc_buttonChances.gridx = 2;
        gbc_buttonChances.gridy = 18;
        panel.add(btnChances, gbc_buttonChances);
        
        txtChance = new JTextField();
        txtChance.setHorizontalAlignment(SwingConstants.CENTER);
        txtChance.setEditable(false);
        GridBagConstraints gbc_txtChance = new GridBagConstraints();
        gbc_txtChance.insets = new Insets(0, 0, 5, 5);
        gbc_txtChance.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtChance.gridx = 4;
        gbc_txtChance.gridy = 18;
        panel.add(txtChance, gbc_txtChance);
        txtChance.setColumns(10);
        
        JLabel lblYahtzeeBonus = new JLabel("YAHTZEE BONUS");
        GridBagConstraints gbc_lblYahtzeeBonus = new GridBagConstraints();
        gbc_lblYahtzeeBonus.insets = new Insets(0, 0, 5, 5);
        gbc_lblYahtzeeBonus.gridx = 0;
        gbc_lblYahtzeeBonus.gridy = 19;
        panel.add(lblYahtzeeBonus, gbc_lblYahtzeeBonus);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.gridx = 2;
        gbc_panel_1.gridy = 19;
        panel.add(panel_1, gbc_panel_1);
        
        btnBonus = new JButton("\u2192");
        btnBonus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    checkBonus(getDiceVal(btnArray));
                    calcTotalLower();
                    btnBonus.setEnabled(false);
                }
            }
        });
        btnBonus.setPreferredSize(new Dimension(46, 16));
        btnBonus.setMinimumSize(new Dimension(46, 16));
        
        btnBonus_1 = new JButton("\u2192");
        btnBonus_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    checkBonus(getDiceVal(btnArray));
                    calcTotalLower();
                    btnBonus_1.setEnabled(false);
                }
            }
        });
        btnBonus_1.setPreferredSize(new Dimension(46, 16));
        btnBonus_1.setMinimumSize(new Dimension(46, 16));
        
        btnBonus_2 = new JButton("\u2192");
        btnBonus_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton[] btnArray = dices();
                boolean isValid = isDiceValid(btnArray);
                if (isValid)
                {
                    checkBonus(getDiceVal(btnArray));
                    calcTotalLower();
                    btnBonus_2.setEnabled(false);
                }
            }
        });
        btnBonus_2.setPreferredSize(new Dimension(46, 16));
        btnBonus_2.setMinimumSize(new Dimension(46, 16));
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));
        panel_1.add(btnBonus);
        panel_1.add(btnBonus_1);
        panel_1.add(btnBonus_2);
        
        txtYahtzeebonus = new JTextField();
        txtYahtzeebonus.setHorizontalAlignment(SwingConstants.CENTER);
        txtYahtzeebonus.setEditable(false);
        GridBagConstraints gbc_txtYahtzeebonus = new GridBagConstraints();
        gbc_txtYahtzeebonus.insets = new Insets(0, 0, 5, 5);
        gbc_txtYahtzeebonus.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtYahtzeebonus.gridx = 4;
        gbc_txtYahtzeebonus.gridy = 19;
        panel.add(txtYahtzeebonus, gbc_txtYahtzeebonus);
        txtYahtzeebonus.setColumns(10);
        
        JLabel lblLowerSectionTotal = new JLabel("LOWER SECTION \nTOTAL");
        GridBagConstraints gbc_lblLowerSectionTotal = new GridBagConstraints();
        gbc_lblLowerSectionTotal.insets = new Insets(0, 0, 5, 5);
        gbc_lblLowerSectionTotal.gridx = 0;
        gbc_lblLowerSectionTotal.gridy = 20;
        panel.add(lblLowerSectionTotal, gbc_lblLowerSectionTotal);
        
        JLabel lblu_2 = new JLabel("\u2192");
        GridBagConstraints gbc_lblu_2 = new GridBagConstraints();
        gbc_lblu_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblu_2.gridx = 2;
        gbc_lblu_2.gridy = 20;
        panel.add(lblu_2, gbc_lblu_2);
        
        txtLowertotal = new JTextField();
        txtLowertotal.setHorizontalAlignment(SwingConstants.CENTER);
        txtLowertotal.setEditable(false);
        GridBagConstraints gbc_txtLowertotal = new GridBagConstraints();
        gbc_txtLowertotal.insets = new Insets(0, 0, 5, 5);
        gbc_txtLowertotal.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLowertotal.gridx = 4;
        gbc_txtLowertotal.gridy = 20;
        panel.add(txtLowertotal, gbc_txtLowertotal);
        txtLowertotal.setColumns(10);
        
        JLabel lblUpperSectionTotal_1 = new JLabel("UPPER SECTION TOTAL");
        GridBagConstraints gbc_lblUpperSectionTotal_1 = new GridBagConstraints();
        gbc_lblUpperSectionTotal_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblUpperSectionTotal_1.gridx = 0;
        gbc_lblUpperSectionTotal_1.gridy = 21;
        panel.add(lblUpperSectionTotal_1, gbc_lblUpperSectionTotal_1);
        
        JLabel lblu_3 = new JLabel("\u2192");
        GridBagConstraints gbc_lblu_3 = new GridBagConstraints();
        gbc_lblu_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblu_3.gridx = 2;
        gbc_lblu_3.gridy = 21;
        panel.add(lblu_3, gbc_lblu_3);
        
        txtUppertotal = new JTextField();
        txtUppertotal.setHorizontalAlignment(SwingConstants.CENTER);
        txtUppertotal.setEditable(false);
        GridBagConstraints gbc_txtUppertotal = new GridBagConstraints();
        gbc_txtUppertotal.insets = new Insets(0, 0, 5, 5);
        gbc_txtUppertotal.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUppertotal.gridx = 4;
        gbc_txtUppertotal.gridy = 21;
        panel.add(txtUppertotal, gbc_txtUppertotal);
        txtUppertotal.setColumns(10);
        
        JLabel lblGrandTotal = new JLabel("GRAND TOTAL");
        GridBagConstraints gbc_lblGrandTotal = new GridBagConstraints();
        gbc_lblGrandTotal.insets = new Insets(0, 0, 5, 5);
        gbc_lblGrandTotal.gridx = 0;
        gbc_lblGrandTotal.gridy = 22;
        panel.add(lblGrandTotal, gbc_lblGrandTotal);
        
        JLabel lblu_4 = new JLabel("\u2192");
        GridBagConstraints gbc_lblu_4 = new GridBagConstraints();
        gbc_lblu_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblu_4.gridx = 2;
        gbc_lblu_4.gridy = 22;
        panel.add(lblu_4, gbc_lblu_4);
        
        txtGrandtotal = new JTextField();
        txtGrandtotal.setHorizontalAlignment(SwingConstants.CENTER);
        txtGrandtotal.setEditable(false);
        GridBagConstraints gbc_txtGrandtotal = new GridBagConstraints();
        gbc_txtGrandtotal.insets = new Insets(0, 0, 5, 5);
        gbc_txtGrandtotal.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtGrandtotal.gridx = 4;
        gbc_txtGrandtotal.gridy = 22;
        panel.add(txtGrandtotal, gbc_txtGrandtotal);
        txtGrandtotal.setColumns(10);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalGlue.setPreferredSize(new Dimension(10, 0));
        horizontalGlue.setSize(new Dimension(10, 0));
        horizontalGlue.setMinimumSize(new Dimension(10, 0));
        frame.getContentPane().add(horizontalGlue, BorderLayout.WEST);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        horizontalGlue_1.setSize(new Dimension(10, 0));
        horizontalGlue_1.setPreferredSize(new Dimension(10, 0));
        horizontalGlue_1.setMinimumSize(new Dimension(10, 0));
        frame.getContentPane().add(horizontalGlue_1, BorderLayout.EAST);
        
        Component verticalStrut = Box.createVerticalStrut(10);
        frame.getContentPane().add(verticalStrut, BorderLayout.SOUTH);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem mntmNewGame = new JMenuItem("New Game");
        mntmNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        mntmNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        mnFile.add(mntmNewGame);
       
        // use only for debugging
//         JMenu mnSpecialCondition = new JMenu("Special Condition");
//         menuBar.add(mnSpecialCondition);
//        
//        JMenuItem mntmYahtzee = new JMenuItem("Yahtzee");
//        mntmYahtzee.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                btnDice_1.setText("6");
//                btnDice_2.setText("6");
//                btnDice_3.setText("6");
//                btnDice_4.setText("6");
//                btnDice_5.setText("6");
//            }
//        });
//        mnSpecialCondition.add(mntmYahtzee);
    }

}
