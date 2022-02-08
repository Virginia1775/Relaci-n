package relacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejer1 extends JFrame {

	private JPanel contentPane;
	private JTextField textIntroduce;
	private JButton btnAceptar;
	private JLabel lblVeces;
	private JLabel lblNumeroEs;
	private JLabel lblIntento;
	private int numero;
	private int intentos=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer1 frame = new Ejer1();
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
	public Ejer1() {
		numero = (int) (Math.random()*500+1);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Virginia\\Pictures\\Saved Pictures\\71494590.jfif"));
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("Adinvina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[][][][][][][][]"));
		
		JLabel lblIntroduce = new JLabel("Introduce un numero");
		lblIntroduce.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblIntroduce, "cell 0 3 8 1,alignx center");
		
		textIntroduce = new JTextField();
		textIntroduce.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(textIntroduce, "cell 8 3,growx");
		textIntroduce.setColumns(10);
		
	   btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertaNumero();
				
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnAceptar, "cell 12 3");
		
		lblNumeroEs = new JLabel("");
		lblNumeroEs.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNumeroEs, "cell 2 5 10 1");
		
		lblIntento = new JLabel("Intento");
		lblIntento.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblIntento, "cell 0 7");
		
		lblVeces = new JLabel("");
		lblVeces.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblVeces, "cell 2 7 10 1");
	}

	

	protected void insertaNumero() {
		try {
			int dato = Integer.parseInt(textIntroduce.getText());
			if (numero<dato) {
				lblNumeroEs.setText("El numero es menor");
			}else if(numero>dato) {
				lblNumeroEs.setText("El número es mayor");
			}else {
				lblNumeroEs.setText("Has acertado");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debes introducir un número entero");
		}
		intentos++;
		lblVeces.setText(""+intentos);
	}

}
