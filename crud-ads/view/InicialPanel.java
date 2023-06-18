package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InicialPanel extends JPanel{
    private AppFrame frame;
	private JButton cadastrosBtn;

	public InicialPanel(AppFrame appFrame) {
		SwingUtilities.invokeLater(() -> {
		
		frame = appFrame;
       
		
	    cadastrosBtn = new JButton("Cadastro");
		cadastrosBtn.setBounds(129, 73, 77, 23);
		
		cadastrosBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaCadastros();
			}
		});
		add(cadastrosBtn);
	});
}
}
