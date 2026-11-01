import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private JFrame frame;

    public Menu(JFrame frame) {
        this.frame = frame;

        setLayout(null);
        setBackground(new Color(174, 218, 245));

        // Judul game
        JLabel title = new JLabel("Flappy Bird", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        title.setForeground(new Color(90, 103, 120));
        title.setBounds(30, 100, 290, 60);
        add(title);

        // Subjudul
        JLabel subtitle = new JLabel(
                "Ready to fly?",
                SwingConstants.CENTER
        );
        subtitle.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
        subtitle.setForeground(new Color(100, 125, 145));
        subtitle.setBounds(30, 155, 290, 30);
        add(subtitle);

        // Dekorasi burung butter yellow
        JLabel bird = new JLabel("🐤", SwingConstants.CENTER);
        bird.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 60));
        bird.setBounds(110, 195, 130, 80);
        add(bird);

        // Tombol START
        JButton startButton = new JButton("START");
        startButton.setBounds(85, 300, 180, 50);
        startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        startButton.setForeground(new Color(115, 88, 65));
        startButton.setBackground(new Color(255, 221, 130));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setOpaque(true);
        add(startButton);

        // Tombol EXIT
        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(85, 365, 180, 50);
        exitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        exitButton.setForeground(new Color(115, 88, 65));
        exitButton.setBackground(new Color(255, 248, 232));
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);
        exitButton.setOpaque(true);
        add(exitButton);

        // Aksi tombol
        startButton.addActionListener(e -> startGame());
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void startGame() {
        View game = new View();

        frame.setContentPane(game);
        frame.revalidate();
        frame.repaint();

        game.requestFocusInWindow();
    }

    // Dekorasi awan dan lingkaran background
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Awan kiri
        g2.setColor(new Color(255, 255, 255, 180));
        g2.fillOval(15, 55, 55, 30);
        g2.fillOval(40, 40, 55, 40);
        g2.fillOval(65, 55, 55, 30);

        // Awan kanan
        g2.fillOval(235, 75, 50, 28);
        g2.fillOval(255, 60, 50, 38);
        g2.fillOval(280, 75, 35, 28);

        // Dekorasi lingkaran kecil
        g2.setColor(new Color(255, 255, 255, 100));
        g2.fillOval(20, 260, 12, 12);
        g2.fillOval(285, 250, 15, 15);
        g2.fillOval(45, 430, 10, 10);
        g2.fillOval(275, 445, 12, 12);

        g2.dispose();
    }
}