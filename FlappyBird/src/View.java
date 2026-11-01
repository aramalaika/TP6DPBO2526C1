import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.*;

public class View extends JPanel implements KeyListener {
    private Player player;
    private Logic logic;
    private Timer gameLoop;
    private ArrayList<Pipe> pipes;
    private JLabel scoreLabel;
    private Sound sound = new Sound();

    private int velocityY = 0;
    private int pipeCooldown = 0;
    private int score = 0;
    private boolean gameOver = false;

    public View() {
        setLayout(null);
        setBackground(new Color(174, 218, 245));
        setFocusable(true);

        player = new Player(100, 200, 40, 40, null);
        logic = new Logic(player);
        pipes = new ArrayList<>();

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        scoreLabel.setForeground(new Color(90, 103, 120));
        scoreLabel.setBounds(20, 14, 115, 28);
        scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        scoreLabel.setForeground(new Color(115, 88, 65));
        add(scoreLabel);

        addKeyListener(this);

        gameLoop = new Timer(20, e -> updateGame());
        gameLoop.start();
    }

    private void updateGame() {
        if (gameOver) {
            repaint();
            return;
        }

        velocityY += 1;
        player.setY(player.getY() + velocityY);

        pipeCooldown++;

        if (pipeCooldown >= 100) {
            pipes.add(new Pipe(360, 0, 50, 220,
                    new Color(137, 204, 130)));
            pipes.add(new Pipe(360, 350, 50, 250,
                    new Color(137, 204, 130)));
            pipeCooldown = 0;
        }

        for (Pipe pipe : pipes) {
            pipe.setX(pipe.getX() - 3);
        }

        // Cek tabrakan dengan pipa
        for (Pipe pipe : pipes) {
            if (player.getX() < pipe.getX() + pipe.getWidth()
                    && player.getX() + player.getWidth() > pipe.getX()
                    && player.getY() < pipe.getY() + pipe.getHeight()
                    && player.getY() + player.getHeight() > pipe.getY()) {
                endGame();
            }
        }

        // Cek jika burung jatuh ke bawah
        if (player.getY() + player.getHeight() >= getHeight()) {
            endGame();
        }

        // Skor bertambah sekali per pasangan pipa
        for (Pipe pipe : pipes) {
            if (pipe.getY() == 0
                    && !pipe.isPassed()
                    && pipe.getX() + pipe.getWidth() < player.getX()) {
                pipe.setPassed(true);
                score++;
                scoreLabel.setText("Score: " + score);
                sound.playSFX("score.wav");
            }
        }
        pipes.removeIf(pipe -> pipe.getX() + pipe.getWidth() < 0);

        repaint();
    }

    private void restartGame() {
        player.setX(100);
        player.setY(200);

        velocityY = 0;
        pipeCooldown = 0;
        score = 0;
        gameOver = false;
        pipes.clear();
        scoreLabel.setText("Score: 0");

        repaint();
        requestFocusInWindow();
    }

    private void endGame() {
        if (!gameOver) {
            gameOver = true;
            sound.playSFX("gameover.wav");
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        // Supaya gambar lebih halus
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // =========================
        // BACKGROUND SOFT BLUE
        // =========================
        g2.setColor(new Color(174, 218, 245));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // =========================
        // AWAN-AWAN PUTIH
        // =========================
        g2.setColor(new Color(255, 255, 255, 210));

        // Awan kiri atas
        g2.fillOval(15, 75, 55, 28);
        g2.fillOval(35, 60, 45, 40);
        g2.fillOval(60, 75, 55, 28);

        // Awan kanan atas
        g2.fillOval(220, 145, 50, 25);
        g2.fillOval(240, 125, 45, 38);
        g2.fillOval(260, 145, 50, 25);

        // Awan kiri bawah
        g2.fillOval(20, 350, 55, 28);
        g2.fillOval(40, 330, 45, 38);
        g2.fillOval(65, 350, 50, 28);

        // =========================
        // GAMBAR BURUNG
        // =========================
        int x = player.getX();
        int y = player.getY();

        // Badan burung
        g2.setColor(new Color(255, 221, 130));
        g2.fillOval(x, y, 40, 35);

        // Sayap burung
        g2.setColor(new Color(255, 195, 95));
        g2.fillOval(x + 5, y + 15, 19, 13);

        // Bulu kecil di sayap
        g2.setColor(new Color(255, 232, 170));
        g2.fillOval(x + 8, y + 18, 10, 5);

        // Mata putih
        g2.setColor(Color.WHITE);
        g2.fillOval(x + 25, y + 6, 11, 12);

        // Pupil mata
        g2.setColor(new Color(70, 65, 60));
        g2.fillOval(x + 30, y + 10, 5, 6);

        // Kilau mata
        g2.setColor(Color.WHITE);
        g2.fillOval(x + 31, y + 10, 2, 2);

        // Paruh burung
        g2.setColor(new Color(255, 145, 75));
        int[] paruhX = {x + 36, x + 45, x + 36};
        int[] paruhY = {y + 16, y + 19, y + 23};
        g2.fillPolygon(paruhX, paruhY, 3);

        // Pipi pink
        g2.setColor(new Color(255, 165, 160));
        g2.fillOval(x + 25, y + 22, 7, 5);

        // =========================
        // PIPA PASTEL GREEN
        // =========================
        for (Pipe pipe : pipes) {
            int px = pipe.getX();
            int py = pipe.getY();
            int pw = pipe.getWidth();
            int ph = pipe.getHeight();

            // Badan pipa
            g2.setColor(new Color(137, 204, 130));
            g2.fillRect(px, py, pw, ph);

            // Highlight di sisi kiri
            g2.setColor(new Color(190, 235, 145));
            g2.fillRect(px + 7, py, 9, ph);

            // Garis pinggir pipa
            g2.setColor(new Color(80, 155, 85));
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(px, py, pw, ph);

            // Bibir pipa
            g2.setColor(new Color(165, 220, 135));
            g2.fillRect(px - 4, py, pw + 8, 12);

            g2.setColor(new Color(80, 155, 85));
            g2.drawRect(px - 4, py, pw + 8, 12);
        }

        // =========================
        // BACKGROUND SCORE
        // =========================
            g2.setColor(new Color(255, 248, 232));
            g2.fillRoundRect(10, 10, 130, 38, 20, 20);

            // Border score
            g2.setColor(new Color(190, 155, 125));
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(10, 10, 130, 38, 20, 20);

            // Warna tulisan score
            scoreLabel.setForeground(new Color(115, 88, 65));

        // =========================
        // PETUNJUK / GAME OVER
        // =========================
        if (gameOver) {
            g2.setColor(new Color(90, 80, 85));
            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

            String gameOverText = "GAME OVER";
            FontMetrics fm = g2.getFontMetrics();
            int gameOverX = (getWidth() - fm.stringWidth(gameOverText)) / 2;

            g2.drawString(gameOverText, gameOverX, 280);

            g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

            String restartText = "Tekan R untuk restart";
            FontMetrics fm2 = g2.getFontMetrics();
            int x2 = (getWidth() - fm2.stringWidth(restartText)) / 2;

            g2.drawString(restartText, x2, 320);
        }else {
            g2.setColor(new Color(75, 100, 120));
            g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
            g2.drawString("SPACE untuk terbang", 80, 80);
        }

        g2.dispose();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
            return;
        }

        if (!gameOver && e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -10;
            sound.playSFX("flap.wav");
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
