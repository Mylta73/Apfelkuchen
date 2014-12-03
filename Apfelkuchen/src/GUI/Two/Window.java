package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Main Window
 * @author Yuri Kalinin, Florian Then, Dominik Hofmann
 * @version 1.0.3
 */
public class Window extends JFrame {

	JScrollPane scrollpane;
	private JTextField textPointer;
	private JTextField textPointerUnit;
	private JButton buttonRemove;
	private JButton buttonOptimize;
	private JButton buttonNewField;
	private JLabel labelName;
	private JLabel labelLow;
	private JLabel labelHigh;
	private JLabel labelRolle;
	private JLabel labelUnit;
	private JLabel labelM;
	private JLabel labelK;
	private JLabel labelS;
	private JLabel labelKel;
	private JLabel labelMol;
	private JLabel labelAmp;
	private JLabel labelCand;
	private JLabel expTitle;
	private JLabel labelAbbreviation;
	private JLabel labelMinMaxSi;
	private JLabel labelDimension;

	private ArrayList<JTextField> textFieldName = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldM = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldK = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldS = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldKel = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMol = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldAmp = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldCand = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldLow = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldHigh = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldResultSILow = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldResultSIHigh = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldAbbreviation = new ArrayList<JTextField>();
	private ArrayList<JTextField> fieldExpon = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldDimension = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldUnit = new ArrayList<JTextField>();
	//save information from Name and Abr fields
	private ArrayList<String> dateFromFieldString = new ArrayList<String>();
	private ArrayList<int[]> dateFromFieldInteger = new ArrayList<int[]>();
	private JComboBox<String> comboBoxRolle;
	

	public Window() {
		super(XMLDate.dateLabels("title"));
		setSize(1194, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		init();
		setVisible(true);
	}

	public void init() {
		// setVisible(false);
		dispose();

		JPanel contentPanel = new JPanel();
		contentPanel.setSize(100, 100);

		// ======== contentPanel ========

		contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.setLayout(new GridBagLayout());
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {
				80, 80, 80, 80, 80, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

		JMenuBar mb = new JMenuBar();

		// ---- label Name ----
		labelName = new JLabel();
		labelName.setText(XMLDate.dateLabels("nameFeld"));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelName, new GridBagConstraints(0, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Abbreviation ----
		labelAbbreviation = new JLabel();
		labelAbbreviation.setText(" " + "Abkuerzung");
		labelAbbreviation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAbbreviation.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelAbbreviation, new GridBagConstraints(1, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Rolle ----
		labelRolle = new JLabel();
		labelRolle.setText(XMLDate.dateLabels("labelRolle"));
		labelRolle.setHorizontalAlignment(SwingConstants.CENTER);
		labelRolle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelRolle, new GridBagConstraints(2, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Dimension ----
		labelDimension = new JLabel();
		labelDimension.setText(XMLDate.dateLabels("labelDimension"));
		labelDimension.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDimension.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelDimension, new GridBagConstraints(3, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label Unit----
		labelUnit = new JLabel();
		labelUnit.setText(XMLDate.dateLabels("labelSIUnit"));
		labelUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUnit.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelUnit, new GridBagConstraints(4, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label Low ----
		labelLow = new JLabel();
		labelLow.setText(XMLDate.dateLabels("labelLow") + " ");
		labelLow.setHorizontalAlignment(SwingConstants.CENTER);
		labelLow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelLow, new GridBagConstraints(5, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label High ----
		labelHigh = new JLabel();
		labelHigh.setText(XMLDate.dateLabels("labelHigh") + " ");
		labelHigh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelHigh.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelHigh, new GridBagConstraints(6, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label m ----
		labelM = new JLabel();
		labelM.setText("m" + "  ");
		labelM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelM.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelM, new GridBagConstraints(7, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label k ----
		labelK = new JLabel();
		labelK.setText("k");
		labelK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelK.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelK, new GridBagConstraints(8, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label s ----
		labelS = new JLabel();
		labelS.setText("s" + "  ");
		labelS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelS, new GridBagConstraints(9, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label kel ----
		labelKel = new JLabel();
		labelKel.setText("kel" + "  ");
		labelKel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelKel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelKel, new GridBagConstraints(10, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label mol ----
		labelMol = new JLabel();
		labelMol.setText("mol" + "  ");
		labelMol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMol.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMol, new GridBagConstraints(11, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label amp ----
		labelAmp = new JLabel();
		labelAmp.setText("amp" + "  ");
		labelAmp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAmp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelAmp, new GridBagConstraints(12, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label cand ----
		labelCand = new JLabel();
		labelCand.setText("cand" + "  ");
		labelCand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCand.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelCand, new GridBagConstraints(13, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label SI Min ----
		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText(XMLDate.dateLabels("labelSIMin") + " ");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelMinMaxSi, new GridBagConstraints(14, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		
		// --- label SI Max
		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText(XMLDate.dateLabels("labelSIMax") + " ");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelMinMaxSi, new GridBagConstraints(15, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		for (int i = 0; i < Run.rows; i++) {

			// ---- TextField Name ----
			JTextField textFieldNameTemp = new JTextField();
			textFieldNameTemp.setMinimumSize(new Dimension(80, 20));
			textFieldNameTemp.setMaximumSize(new Dimension(80, 20));
			contentPanel.add(textFieldNameTemp, new GridBagConstraints(0,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldName.add(textFieldNameTemp);

			// ---- TextField Abbreviation ----
			JTextField fieldAbbreviationTemp = new JTextField();
			fieldAbbreviationTemp.setMinimumSize(new Dimension(80, 20));
			fieldAbbreviationTemp.setMaximumSize(new Dimension(80, 20));
			contentPanel.add(fieldAbbreviationTemp, new GridBagConstraints(1,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldAbbreviation.add(fieldAbbreviationTemp);

			// --- JComboBox Rolle------
			comboBoxRolle = new JComboBox(Run.getRolle());
			comboBoxRolle.setEnabled(true);
			comboBoxRolle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object selectedItem = comboBoxRolle.getSelectedItem();
				}
			});
			contentPanel.add(comboBoxRolle, new GridBagConstraints(2, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
			
			// --- TextField Unit------
			JTextField textFieldUnitTemp = new JTextField();
			textFieldUnitTemp.setMinimumSize(new Dimension(30, 20));
			textPointerUnit = textFieldUnitTemp;
			textFieldUnitTemp.setPreferredSize(new Dimension(20, 20));
			
			textFieldUnitTemp.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					TreeWindow windowTree = new TreeWindow(textFieldUnitTemp);
					//mouseClick();
					repaint();
					setVisible(true);
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}
				
			});
			
			contentPanel.add(textFieldUnitTemp, new GridBagConstraints(4, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
			textFieldUnit.add(textFieldUnitTemp);

			// --- JTextFiel Dimension with mouse event------
			JTextField textFieldDimensionTemp = new JTextField();
			textPointer = textFieldDimensionTemp;
			textFieldDimensionTemp.setMinimumSize(new Dimension(40, 20));
			textFieldDimensionTemp.setPreferredSize(new Dimension(40, 20));
			textFieldDimensionTemp.setMaximumSize(new Dimension(50, 20));
			textFieldDimensionTemp.setEnabled(true);

			textFieldDimensionTemp.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TreeWindow windowTree = new TreeWindow(textFieldDimensionTemp, textFieldUnitTemp); // textPointer, textPointerUnit
					//mouseClick();
					repaint();
					setVisible(true);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}

			});

			contentPanel.add(textFieldDimensionTemp, new GridBagConstraints(3,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
			textFieldDimension.add(textFieldDimensionTemp);

			

			// ---- TextField Low- ----
			JTextField textFieldLowTemp = new JTextField();
			textFieldLowTemp.setMinimumSize(new Dimension(40, 20));
			textFieldLowTemp.setMaximumSize(new Dimension(40, 20));
			textFieldLowTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldLowTemp, new GridBagConstraints(5,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
			textFieldLow.add(textFieldLowTemp);

			// ---- TextField High----
			JTextField textFieldHighTemp = new JTextField();
			textFieldHighTemp.setMaximumSize(new Dimension(40, 20));
			textFieldHighTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldHighTemp, new GridBagConstraints(6,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
			textFieldHigh.add(textFieldHighTemp);

			// ---- TextField m----
			JTextField textFieldMTemp = new JTextField();
			textFieldMTemp.setMaximumSize(new Dimension(40, 20));
			textFieldMTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldMTemp, new GridBagConstraints(7, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldM.add(textFieldMTemp);

			// ---- TextField k----
			JTextField textFieldKTemp = new JTextField();
			textFieldKTemp.setMaximumSize(new Dimension(20, 20));
			textFieldKTemp.setPreferredSize(new Dimension(20, 20));
			contentPanel.add(textFieldKTemp, new GridBagConstraints(8, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldK.add(textFieldKTemp);

			// ---- TextField s----
			JTextField textFieldSTemp = new JTextField();
			textFieldSTemp.setMaximumSize(new Dimension(40, 20));
			textFieldSTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldSTemp, new GridBagConstraints(9, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldS.add(textFieldSTemp);

			// ---- TextField kel----
			JTextField textFieldKelTemp = new JTextField();
			textFieldKelTemp.setMaximumSize(new Dimension(40, 20));
			textFieldKelTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldKelTemp, new GridBagConstraints(10,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldKel.add(textFieldKelTemp);

			// ---- TextField mol----
			JTextField textFieldMolTemp = new JTextField();
			textFieldMolTemp.setMaximumSize(new Dimension(40, 20));
			textFieldMolTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldMolTemp, new GridBagConstraints(11,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldMol.add(textFieldMolTemp);

			// ---- TextField amp----
			JTextField textFieldAmpTemp = new JTextField();
			textFieldAmpTemp.setMaximumSize(new Dimension(40, 20));
			textFieldAmpTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldAmpTemp, new GridBagConstraints(12,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldAmp.add(textFieldAmpTemp);

			// ---- TextField cand----
			JTextField textFieldCandTemp = new JTextField();
			textFieldCandTemp.setMaximumSize(new Dimension(40, 20));
			textFieldCandTemp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldCandTemp, new GridBagConstraints(13,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			textFieldCand.add(textFieldCandTemp);

			JTextField fieldSILowTemp = new JTextField();
			fieldSILowTemp.setMaximumSize(new Dimension(40, 20));
			fieldSILowTemp.setPreferredSize(new Dimension(40, 20));

			textFieldResultSILow.add(fieldSILowTemp);

			contentPanel.add(fieldSILowTemp, new GridBagConstraints(14, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			JTextField fieldSIHighTemp = new JTextField();
			fieldSIHighTemp.setMaximumSize(new Dimension(40, 20));
			textFieldKelTemp.setPreferredSize(new Dimension(40, 20));

			textFieldResultSIHigh.add(fieldSIHighTemp);

			contentPanel.add(fieldSIHighTemp, new GridBagConstraints(15,
					14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			// ---- end of contentpanel Centre ------
		}

		JPanel p2 = new JPanel();

		buttonNewField = new JButton(XMLDate.dateLabels("buttonNewField"));
		buttonNewField.setFocusPainted(false);
		buttonNewField.setSize(110, 20);
		buttonNewField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNewField) {
					Run.addRow();
					dispose();
					Window windowTwo = new Window();
				}
			}
		});

		p2.add(buttonNewField);

		buttonRemove = new JButton(XMLDate.dateLabels("buttonRemove"));
		buttonRemove.setFocusPainted(false);
		buttonRemove.setSize(110, 20);
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonRemove) {
					Run.removeRow();
					// setVisible(false);
					dispose();
					Window window = new Window();
				}
			}
		});
		p2.add(buttonRemove);

		buttonOptimize = new JButton(XMLDate.dateLabels("buttonNext"));
		buttonOptimize.setFocusPainted(false);
		buttonOptimize.setSize(110, 20);
		buttonOptimize.setLocation(16, 16);
		buttonOptimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOptimize) {
					// --- check field Abbreviation---
					String message = XMLDate.dateLabels("errorTextDialog")
							+ " f�r ";
					String title = XMLDate.dateLabels("errorTitleDialog");
					for (int i = 0; i < textFieldAbbreviation.size(); i++) {
						String input = textFieldAbbreviation.get(i).getText();

						// Shows an error dialog if false
						if ((new StringCheck().abbreviationCheck(input)) == false) {
							JOptionPane.showMessageDialog(new JFrame(), message
									+ labelAbbreviation.getText(), title,
									JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							setVisible(false);
							WindowOptim window = new WindowOptim();
							window.setWindow();
						}
					}
					for (int i = 0; i < Run.rows; i++) {
						dateFromFieldString.add(textFieldName.get(i).getText());
						dateFromFieldString.add(textFieldAbbreviation.get(i).getText());
						dateFromFieldString.add(textFieldM.get(i).getText());
						dateFromFieldString.add(textFieldK.get(i).getText());
						dateFromFieldString.add(textFieldS.get(i).getText());
						dateFromFieldString.add(textFieldKel.get(i).getText());
						dateFromFieldString.add(textFieldMol.get(i).getText());
						dateFromFieldString.add(textFieldAmp.get(i).getText());
						dateFromFieldString.add(textFieldCand.get(i).getText());
						dateFromFieldString.add(textFieldLow.get(i).getText());
						dateFromFieldString.add(textFieldHigh.get(i).getText());
						dateFromFieldString.add(textFieldResultSILow.get(i).getText());
						dateFromFieldString.add(textFieldResultSIHigh.get(i).getText());
					}
				}

			}
		});
		p2.add(buttonOptimize);
		getContentPane().add(p2, BorderLayout.NORTH);

		scrollpane = new JScrollPane(contentPanel);

		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}
	
	public static void setSelectionItem(String newSelectionItemParent, String newSelectionItem, JTextField fieldDimension, JTextField fieldUnit) {
		fieldDimension.setText(newSelectionItemParent);
		fieldUnit.setText(newSelectionItem);
	}
	
	public static void setSelectionItem(String newSelectionItem, JTextField fieldUnit) {
		//fieldDimension.setText(newSelectionItemParent);
		fieldUnit.setText(newSelectionItem);
	}
	
	public ArrayList<String> getDateFromFields() {
		return dateFromFieldString;
	}
	
	/*public void mouseClick() {
		TreeWindow windowTree = new TreeWindow(textPointer, textPointerUnit);
	}*/
}
