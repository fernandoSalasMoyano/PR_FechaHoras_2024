package es.studium.IntervaloHoras;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class IntervaloHoras implements WindowListener, ActionListener
{
	Frame ventana = new Frame("Horas");
	Label lblHh1 = new Label("HH");
	TextField txtHh1 = new TextField(2);
	Label lblMm1 = new Label("MM");
	TextField txtMm1 = new TextField(2);
	Label lblHh2 = new Label("HH");
	TextField txtHh2 = new TextField(2);
	Label lblMm2 = new Label("MM");
	TextField txtMm2 = new TextField(2);
	Button btnCalcular = new Button("Calcular");
	TextField txtResultado = new TextField(10);
	IntervaloHoras()
	{
		ventana.setLayout(new GridLayout(3,4));
		ventana.add(lblHh1);
		ventana.add(txtHh1);
		ventana.add(lblMm1);
		ventana.add(txtMm1);
		ventana.add(lblHh2);
		ventana.add(txtHh2);
		ventana.add(lblMm2);
		ventana.add(txtMm2);
		ventana.add(btnCalcular);
		ventana.add(txtResultado);
		// Añadir el Listener a la ventana y al botón
		ventana.addWindowListener(this);
		btnCalcular.addActionListener(this);
		ventana.setSize(250,100);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	public static void main(String[] args)
	{
		new IntervaloHoras();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Cogemos los datos de los cuadros de texto
				int horas1 = Integer.parseInt(txtHh1.getText());
				System.out.println(horas1);
				int minutos1 = Integer.parseInt(txtMm1.getText());
				System.out.println(minutos1);
				int horas2 = Integer.parseInt(txtHh2.getText());
				System.out.println(horas2);
				int minutos2 = Integer.parseInt(txtMm2.getText());
				System.out.println(minutos2);
				String resultado;
				
				if(horas1<=horas2)
				{
					int horas = horas2 - horas1;
					System.out.println(horas);
					int minutos = minutos2 - minutos1;
					System.out.println(minutos);
					if(minutos<0)
					{
						minutos = 60 + minutos;
						horas = horas - 1;
					}
					if(horas<10)
					{
						resultado = "0"+horas+":";
					}
					else
					{
						resultado = horas+":";
					}
					if(minutos<10)
					{
						resultado = resultado + "0"+minutos;
					}
					else
					{
						resultado = resultado + minutos;
					}
					txtResultado.setText(resultado);
				}
	}
	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e)
	{
		// Llamamos al método exit de la clase System,
				// devolviendo como código de salida un 0
				System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
