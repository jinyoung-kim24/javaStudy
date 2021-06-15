package cafe.ui.food;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyboardFrame frame = new KeyboardFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KeyboardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD0A4\uBCF4\uB4DC \uC774\uBCA4\uD2B8 \uD14C\uC2A4\uD2B8");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("Ű ����...");	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int code = e.getKeyCode();
				System.out.println("Ű ����... Ű�ڵ尪: " + code);
				// ī�� ���̾ƿ� Ž��
				switch (code) {
				case KeyEvent.VK_LEFT:
					System.out.println("���� Ŀ������ Ű");
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("������ Ŀ������ Ű");
					break;
				case KeyEvent.VK_UP:
					System.out.println("���� Ŀ������ Ű");
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("�Ʒ��� Ŀ������ Ű");
					break;
				case KeyEvent.VK_SPACE:
					System.out.println("�����̽� Ű");
					break;
				default:
					break;
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
//				char c = e.getKeyChar();
//				System.out.println("Ű Ÿ����..." + c);
			}
		});
		textArea.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}
