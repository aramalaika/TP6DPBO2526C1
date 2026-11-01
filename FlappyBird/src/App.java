import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");

        frame.setSize(360, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Menu menu = new Menu(frame);
        frame.setContentPane(menu);

        frame.setVisible(true);
    }
}
