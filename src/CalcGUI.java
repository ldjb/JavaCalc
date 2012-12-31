/*******************************************************************************
** CalcGUI.java [work in progress]                                            **
** -------------------------------------------------------------------------- **
** •••                                                                        **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: •••                                                         **
** -------------------------------------------------------------------------- **
** [To do]                                                                    **
** • Documentation.                                                           **
*******************************************************************************/

import javax.swing.*;
public class CalcGUI extends JFrame {

	public CalcGUI() {
		initComponents();
	}

	private void initComponents() {

		TextField = new JTextField();
		Button = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Java Calculator");
		setResizable(false);

		TextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		TextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FormSubmitted();
			}
		});

		Button.setText("Calculate");
		Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		Button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FormSubmitted();
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(
						  GroupLayout.Alignment.CENTER)
					.addComponent(Button)
					.addComponent(TextField, GroupLayout.DEFAULT_SIZE,
								  388, Short.MAX_VALUE))
				.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(TextField, GroupLayout.PREFERRED_SIZE,
							  GroupLayout.DEFAULT_SIZE,
							  GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(Button)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}
	
	private void FormSubmitted() {
		String result = CalcIO.process(TextField.getText());
		if (result != null) {
			TextField.setText(result);
		}
		else {
			TextField.setText("Error. Please try again.");
		}
		TextField.requestFocus();
		TextField.selectAll();
	}

	public static void initAll() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CalcGUI().setVisible(true);
			}
		});
	}

	private JButton Button;
	private JTextField TextField;

}