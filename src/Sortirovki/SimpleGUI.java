package Sortirovki;
//импорт библиотек
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;

// главное окно
public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Случайное заполнение");// кнопка случайное заполнение
    private JTextField input = new JTextField("", 2);// текстовые поля
    private JTextField input2 = new JTextField("", 5);
    private JTextField input3 = new JTextField("", 5);
    private JTextField input4 = new JTextField("", 5);
    private JTextField input5 = new JTextField("", 5);

    private JLabel label = new JLabel("Введите 1-ое целое число массива:");//лейблы
    private JLabel label2 = new JLabel("Введите 2-ое целое число массива:");
    private JLabel label3 = new JLabel("Введите 3-е целое число массива:");
    private JLabel label4 = new JLabel("Введите 4-ое целое число массива:");
    private JLabel label5 = new JLabel("Введите 5-ое целое число массива:");
    JLabel label0 = new JLabel();
    JLabel label9 = new JLabel();
    JRadioButton radio1 = new JRadioButton(" Получить сортировку методом Bogosort"); //кнопки выбора
    JRadioButton radio2 = new JRadioButton(" Получить сортировку методом CombSort");
    private static final Random generator = new Random(); //генератор рандом

    public SimpleGUI() {
        super("ПРОГРАММА СОРТИРОВКИ МАССИВА");//название программы
        this.setBounds(100, 100, 600, 250);//место появления окна на экране
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //контейнер
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8, 4, 4, 1));// расстановка кнопок и полей
        container.add(label);// вставляем лейбл в контейнер
        container.add(input);
        container.add(label2);
        container.add(input2);
        container.add(label3);
        container.add(input3);
        container.add(label4);
        container.add(input4);
        container.add(label5);
        container.add(input5);

        // Кнопки переключения
        ButtonGroup group = new ButtonGroup();//создаем группу
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);// вставляем в контейнер наши радио кнопки
        radio1.setSelected(false);
        container.add(radio2);
        radio1.addActionListener(new ButtonEventListener());//слушатель класса
        radio2.addActionListener(new handler());//слушатель класса
        button.addActionListener(new handler2());// слушатель кнопки
        container.add(label0);//вставляем в контейнер лейблы
        container.add(label9);
        container.add(button);

    }
    //слушатель  Комб сорт
    class ButtonEventListener implements ActionListener { //создаем класс слушателя
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == radio1) {// если выбрали радио кнопку, то выполняй следующее..
//объявлем переменные
                int a = 0, b = 0, c = 0, d = 0, e = 0; // инециализируем переменные
                try {                                  //исключение
                    a = Integer.parseInt(input.getText());// присваиваем  переменным числа, которые ввел пользователь
                    b = Integer.parseInt(input2.getText());
                    c = Integer.parseInt(input3.getText());
                    d = Integer.parseInt(input4.getText());
                    e = Integer.parseInt(input5.getText());
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(null, "В поле введено не корректное значение");
                }

                int[] array = new int[]{a, b, c, d, e};
                combSort(array);
                label0.setText(Arrays.toString(array) + "");//вывод в label готового массива
            }
        }
    }
    //метод combsort
    public static void combSort(int[] array) {
        int step = (int) (array.length / 1.247);
        int swapCount = 1;
        for (; step > 1 || swapCount > 0; ) {
            swapCount = 0;
            for (int i = 0; i + step < array.length; i++) {
                if (array[i] > array[i + step]) {
                    int temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                    swapCount++;
                }
            }
            if (step > 1) {
                step = (int) (step / 1.247);
            }
        }
    }

    //метод bogosort
    class handler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            int a = 0, b = 0, c = 0, d = 0, e = 0;
            try {                                      //исключение
                a = Integer.parseInt(input.getText());
                b = Integer.parseInt(input2.getText());
                c = Integer.parseInt(input3.getText());
                d = Integer.parseInt(input4.getText());
                e = Integer.parseInt(input5.getText());
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "В поле введенно не коректное значение");
            }
            //метод Bogosort
            int[] array1 = new int[]{a, b, c, d, e};
            bogoSort(array1);
            label9.setText(Arrays.toString(array1) + "");
        }
        public static void bogoSort(int[] array1) {
            while (!isSorted(array1)) {    //цикл
                for (int i = 0; i < array1.length; i++) {
                    int randomPosition = generator.nextInt(array1.length);
                    int temp = array1[i];
                    array1[i] = array1[randomPosition];
                    array1[randomPosition] = temp;
                }
            }
        }
        private static boolean isSorted(int[] array1) {
            for (int i = 1; i < array1.length; i++) {
                if (array1[i] < array1[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
// случайное заполнение
    class handler2 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // случайное заполнение
            Random rand = new Random(); //создаем
            int mas[] = new int[6];// создаем массив
            for (int i = 0; i < 6; i++) {  //цикл
                mas[i] = rand.nextInt(100);
                input.setText(mas[i] + "");// вывод
            }
            //для каждого текстового поля
            Random rand2 = new Random();
            int mas2[] = new int[7];
            for (int i = 0; i < 7; i++) {
                mas2[i] = rand2.nextInt(100);
                input2.setText(mas2[i] + "");
            }
            Random rand3 = new Random();
            int mas3[] = new int[8];
            for (int i = 0; i < 8; i++) {
                mas3[i] = rand3.nextInt(100);
                input3.setText(mas3[i] + "");
            }
            Random rand4 = new Random();
            int mas4[] = new int[3];
            for (int i = 0; i < 3; i++) {
                mas4[i] = rand4.nextInt(100);
                input4.setText(mas[i] + "");

            }
            Random rand5 = new Random();
            int mas5[] = new int[5];
            for (int i = 0; i < 5; i++) {
                mas5[i] = rand5.nextInt(100);
                input5.setText(mas[i] + "");
            }
        }
    }
}