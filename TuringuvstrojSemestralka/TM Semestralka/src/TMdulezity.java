import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.HashMap;
import java.io.*;
import java.net.*;

// TM dulezity - nejvetší peklo
public class TMdulezity extends JFrame {

	// attrributy
	private TMhl turingstroj;
	private Timer casovac;
	private TMmenu menuView;
	private TMnacti nacitaciView;
	private TMstartovaci startovaciview;
	private TMprechodovy prechodovyView;
	private TMzadej vstupniView;
	private TMvykreslovanistroje simulace;
	private CardLayout cards;
	private JPanel hlpanel;
	private JMenuBar menuBar;
	private JMenu fileMenu, helpMenu;
	private JMenuItem mainItem, aboutItem, exitItem;
	private JFrame hlokno;
	private boolean overeni;

	// konstruktor
	public TMdulezity(String title, boolean status, TMhl model, TMmenu view0, TMnacti view1, TMstartovaci view2,
			TMprechodovy view3, TMzadej view4, TMvykreslovanistroje view5) {
		super(title);

		overeni = status;
		turingstroj = model;
		cards = new CardLayout();
		hlpanel = new JPanel();
		hlpanel.setLayout(cards);
		menuView = view0;
		nacitaciView = view1;
		startovaciview = view2;
		prechodovyView = view3;
		vstupniView = view4;
		simulace = view5;
		hlokno = this;

		hlpanel.add(menuView, "0");
		hlpanel.add(nacitaciView, "1");
		hlpanel.add(startovaciview, "2");
		hlpanel.add(prechodovyView, "3");
		hlpanel.add(vstupniView, "4");
		hlpanel.add(simulace, "5");
		add(hlpanel);
		cards.show(hlpanel, "0");

		// listener v menu
		menuView.getLoadButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadButton();
			}
		});

		menuView.getLoadButton().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menuView.setCurrentButton(1);
			}
		});

		menuView.getCreateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCreateButton();
			}
		});

		menuView.getCreateButton().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menuView.setCurrentButton(2);
			}
		});

		// listener v lnacteni
		nacitaciView.getLoadMachineButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadMachineButton();
			}
		});

		nacitaciView.getRemoveMachineButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveMachineButton();
			}
		});

		nacitaciView.getLoadBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadBackButton();
			}
		});

		// listener v uvodu
		startovaciview.getAddTapeAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddTapeAlphabetButton();
			}
		});

		startovaciview.getAddInputAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddInputAlphabetButton();
			}
		});

		startovaciview.getAddStateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddStateButton();
			}
		});

		startovaciview.getRemoveTapeAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveTapeAlphabetButton();
			}
		});

		startovaciview.getRemoveInputAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveInputAlphabetButton();
			}
		});

		startovaciview.getRemoveStateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveStateButton();
			}
		});

		startovaciview.getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleNextButton();
			}
		});

		startovaciview.getStartBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleStartBackButton();
			}
		});

		// listener v prechodu
		prechodovyView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBackButton();
			}
		});

		prechodovyView.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSaveButton();
			}
		});

		prechodovyView.getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSecondNextButton();
			}
		});

		prechodovyView.getTransitionList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				handleSelectedListItem();
			}
		});

		prechodovyView.getStateComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleComboBoxSelection();
			}
		});

		// listener na zadavani znaku
		vstupniView.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddInputButton();
			}
		});

		vstupniView.getRemoveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleDeleteInputButton();
			}
		});

		vstupniView.getClearButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleClearInputButton();
			}
		});

		vstupniView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSecondBackButton();
			}
		});

		vstupniView.getBuildButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuildButton();
			}
		});

		// listener ve vykreslovani se speedem
		simulace.getRunButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRunButton();
			}
		});

		simulace.getSaveMachineButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSaveMachineButton();
			}
		});

		simulace.getChangeInputButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleChangeInputButton();
			}
		});

		simulace.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleResetButton();
			}
		});

		simulace.getSlider().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				handleSlider((JSlider) e.getSource());
			}
		});

		simulace.getSpinner().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				handleSpinner((JSpinner) e.getSource());
			}
		});

		// listener casu
		casovac = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleTimerTick();
			}
		});

		// pridani menu
		menuBar = new JMenuBar();
		fileMenu = new JMenu("soubor");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		mainItem = new JMenuItem("menu", KeyEvent.VK_M);
		mainItem.setEnabled(false);
		fileMenu.add(mainItem);

		exitItem = new JMenuItem("exit", KeyEvent.VK_X);
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);

		helpMenu = new JMenu("helf");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		aboutItem = new JMenuItem("o appce", KeyEvent.VK_A);
		helpMenu.add(aboutItem);

		menuBar.add(helpMenu);
		setJMenuBar(menuBar);

		// listener na menu
		mainItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSecondBackButton();
				handleBackButton();
				handleStartBackButton();
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(hlokno, "opravdu chces skoncit?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop()
								.browse(new URL("https://github.com/Sikous/TMukol").toURI());
					} catch (Exception ex) {
					}
				}
			}
		});

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (overeni) {
					JFrame frame = (JFrame) e.getSource();
					int result = JOptionPane.showConfirmDialog(frame, "opravdu chces zavrit?", "zavri okno",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION)
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} else {
					int result = JOptionPane.showConfirmDialog(hlokno, "opravdu chces odejit?", "Exit",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION)
						setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});

		setSize(1000, 720);
		setResizable(false);
		
	}

	

	public void handleLoadButton() {
		nacitaciView.getFileItems().clear();
		File adr = new File("Saved");
		if (adr.exists()) {
			File[] fileList = adr.listFiles();
			for (File aFile : fileList) {
				nacitaciView.getFileItems().addElement(aFile.getName());
			}
		}
		cards.show(hlpanel, "1");
		mainItem.setEnabled(true);
	}

	public void handleCreateButton() {
		cards.show(hlpanel, "2");
		mainItem.setEnabled(true);
	}


	public void handleLoadMachineButton() {
		if ((nacitaciView.getFileList().getSelectedIndex() >= 0)
				&& (nacitaciView.getFileList().getSelectedValue() != null)) {
			String masinka = (String) nacitaciView.getFileList().getSelectedValue();
			File adr = new File("Saved/" + masinka);
			File model = new File(adr + "/" + masinka + ".model");
			File start = new File(adr + "/" + masinka + ".start");
			File transition = new File(adr + "/" + masinka + ".transition");
			File input = new File(adr + "/" + masinka + ".input");
			if ((model.exists()) && (start.exists()) && (transition.exists()) && (input.exists())) {
				try {
					TMhl novyTM = new TMhl();
					TMstartovaci novystartview = new TMstartovaci();
					TMprechodovy novyprechodovyview = new TMprechodovy();
					TMzadej novyviewvstupu = new TMzadej();
					ObjectInputStream masinain;
					masinain = new ObjectInputStream(new FileInputStream(adr + "/" + masinka + ".model"));
					novyTM = (TMhl) masinain.readObject();
					masinain.close();
					ObjectInputStream startik;
					startik = new ObjectInputStream(new FileInputStream(adr + "/" + masinka + ".start"));
					novystartview = (TMstartovaci) startik.readObject();
					startik.close();
					ObjectInputStream tranzit;
					tranzit = new ObjectInputStream(
							new FileInputStream(adr + "/" + masinka + ".transition"));
					novyprechodovyview = (TMprechodovy) tranzit.readObject();
					tranzit.close();
					ObjectInputStream inputIn;
					inputIn = new ObjectInputStream(new FileInputStream(adr + "/" + masinka + ".input"));
					novyviewvstupu = (TMzadej) inputIn.readObject();
					inputIn.close();
					new TMdulezity(masinka, true, novyTM, new TMmenu(), new TMnacti(), novystartview,
							novyprechodovyview, novyviewvstupu, new TMvykreslovanistroje());

				} catch (ClassNotFoundException e) {
					System.out.println("Chyba trida se neshoduje");
				} catch (FileNotFoundException e) {
					System.out.println("Chyba nemuzu zapsat do souboru");
				} catch (IOException e) {
					System.out.println("Chyba nemuzu cisc ze souboru");
				}
			}
		}
	}

	public void handleRemoveMachineButton() {
		if ((nacitaciView.getFileList().getSelectedIndex() >= 0)
				&& (nacitaciView.getFileList().getSelectedValue() != null)) {
			String masinka = (String) nacitaciView.getFileList().getSelectedValue();
			int result = JOptionPane.showConfirmDialog(hlokno,
					"Opravdu chcs odstanit ".concat(masinka.trim()).concat("?"), "Odstraneni",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				File adr = new File("Saved/" + masinka);
				if (adr.exists()) {
					File[] fileList = adr.listFiles();
					for (File aFile : fileList) {
						aFile.delete();
					}
					adr.delete();
					handleLoadButton();
				}
			}
		}
	}

	public void handleLoadBackButton() {
		cards.show(hlpanel, "0");
		mainItem.setEnabled(false);
	}

	public void handleAddTapeAlphabetButton() {
		String abeceda = startovaciview.getTapeAlphabetTextField().getText().trim();
		if ((abeceda.length() > 0) && (startovaciview.getTapeAlphabetItems().contains(abeceda) == false)) {
			startovaciview.getTapeAlphabetItems().addElement(abeceda);
			startovaciview.getTapeAlphabetTextField().setText("");
		}
		if ((startovaciview.getTapeAlphabetItems().getSize() > 1) && (startovaciview.getInputAlphabetItems().getSize() > 0)
				&& (startovaciview.getStateItems().getSize() > 2)) {
			startovaciview.getNextButton().setEnabled(true);
		}
	}

	public void handleAddInputAlphabetButton() {
		String abeceda = startovaciview.getInputAlphabetTextField().getText().trim();
		if ((abeceda.length() > 0) && (startovaciview.getInputAlphabetItems().contains(abeceda) == false)) {
			startovaciview.getInputAlphabetItems().addElement(abeceda);
			startovaciview.getInputAlphabetTextField().setText("");
			if (startovaciview.getTapeAlphabetItems().contains(abeceda) == false) {
				startovaciview.getTapeAlphabetItems().addElement(abeceda);
			}
		}
		if ((startovaciview.getTapeAlphabetItems().getSize() > 1) && (startovaciview.getInputAlphabetItems().getSize() > 0)
				&& (startovaciview.getStateItems().getSize() > 2)) {
			startovaciview.getNextButton().setEnabled(true);
		}
	}

	public void handleAddStateButton() {
		String state = startovaciview.getStateTextField().getText().trim();
		if ((state.length() > 0) && (startovaciview.getStateItems().contains(state) == false)) {
			startovaciview.getStateItems().addElement(state);
			startovaciview.getStateTextField().setText("");
			startovaciview.getStartItems().addElement(state);
		}
		if (startovaciview.getStateItems().getSize() == 3) {
			startovaciview.getStartComboBox().setSelectedIndex(0);
		}
		if ((startovaciview.getTapeAlphabetItems().getSize() > 1) && (startovaciview.getInputAlphabetItems().getSize() > 0)
				&& (startovaciview.getStateItems().getSize() > 2)) {
			startovaciview.getNextButton().setEnabled(true);
		}
	}

	public void handleRemoveTapeAlphabetButton() {
		Object abeceda = startovaciview.getTapeAlphabetList().getSelectedValue();
		if (startovaciview.getTapeAlphabetList().getSelectedIndex() > 0) {
			startovaciview.getTapeAlphabetItems().removeElement(abeceda);
			if (startovaciview.getInputAlphabetItems().contains(abeceda)) {
				startovaciview.getInputAlphabetItems().removeElement(abeceda);
			}
		}
		if (startovaciview.getTapeAlphabetItems().getSize() < 2) {
			startovaciview.getNextButton().setEnabled(false);
		}
	}

	public void handleRemoveInputAlphabetButton() {
		Object abeceda = startovaciview.getInputAlphabetList().getSelectedValue();
		if (startovaciview.getInputAlphabetList().getSelectedIndex() != -1) {
			startovaciview.getInputAlphabetItems().removeElement(abeceda);
			if (startovaciview.getTapeAlphabetItems().contains(abeceda)) {
				startovaciview.getTapeAlphabetItems().removeElement(abeceda);
			}
		}
		if (startovaciview.getInputAlphabetItems().getSize() < 1) {
			startovaciview.getNextButton().setEnabled(false);
		}
	}

	public void handleRemoveStateButton() {
		Object state = startovaciview.getStateList().getSelectedValue();
		if (startovaciview.getStateList().getSelectedIndex() > 1) {
			startovaciview.getStateItems().removeElement(state);
			startovaciview.getStartItems().removeElement(state);
		}
		if (startovaciview.getStateItems().getSize() < 3) {
			startovaciview.getNextButton().setEnabled(false);
		}
	}

	public void handleNextButton() {
		if (!overeni) {
			ListModel<String> listabecedypasky = startovaciview.getTapeAlphabetList().getModel();
			ListModel<String> listvstupniabecedy = startovaciview.getInputAlphabetList().getModel();
			ListModel<String> liststavu = startovaciview.getStateList().getModel();

			for (int i = 0; i < listvstupniabecedy.getSize(); i++) {
				turingstroj.getInputAlphabet().add((String) listvstupniabecedy.getElementAt(i));
			}

			for (int i = 0; i < listabecedypasky.getSize(); i++) {
				turingstroj.getTapeAlphabet().add((String) listabecedypasky.getElementAt(i));
				prechodovyView.getSymbolItems().addElement((String) listabecedypasky.getElementAt(i));
			}

			for (int i = 0; i < liststavu.getSize() - 2; i++) {
				turingstroj.getStates().add((String) liststavu.getElementAt(i + 2));
				prechodovyView.getStateItems().addElement((String) liststavu.getElementAt(i + 2));
				turingstroj.getTransitions().put((String) liststavu.getElementAt(i + 2),
						new HashMap<String, HashMap<String, String>>());
				for (Object a : turingstroj.getTapeAlphabet()) {
					turingstroj.getTransitions().get((String) liststavu.getElementAt(i + 2)).put((String) a,
							new HashMap<String, String>());
					prechodovyView.getTransitionItems().addElement(
							"[" + (String) liststavu.getElementAt(i + 2) + "]" + " [" + (String) a + "]" + " => ");
				}
			}
			turingstroj.setStartState((String) startovaciview.getStartComboBox().getSelectedItem());
			turingstroj.setCurrentState(turingstroj.getStartState());
			prechodovyView.getStateItems().addElement("prijat");
			prechodovyView.getStateItems().addElement("odmitnut");
			prechodovyView.getTransitionList().setSelectedIndex(0);
			prechodovyView.getNextButton().setEnabled(false);
		}
		cards.show(hlpanel, "3");
	}

	public void handleStartBackButton() {
		turingstroj = new TMhl();
		startovaciview.getInputAlphabetItems().clear();
		startovaciview.getTapeAlphabetItems().clear();
		startovaciview.getTapeAlphabetItems().addElement("_");
		startovaciview.getStateItems().clear();
		startovaciview.getStateItems().addElement("prijat");
		startovaciview.getStateItems().addElement("odmitnut");
		startovaciview.getStartItems().removeAllElements();
		startovaciview.getNextButton().setEnabled(false);
		cards.show(hlpanel, "0");
		mainItem.setEnabled(false);
	}

	// prechodovyView 
	public void handleBackButton() {
		if (!overeni) {
			turingstroj.getInputAlphabet().clear();
			turingstroj.getTapeAlphabet().clear();
			turingstroj.getStates().clear();
			turingstroj.getTransitions().clear();
			prechodovyView.getStateItems().removeAllElements();
			prechodovyView.getSymbolItems().removeAllElements();
			prechodovyView.getTransitionItems().removeAllElements();
		}
		cards.show(hlpanel, "2");
	}

	public void handleSecondNextButton() {
		if (!overeni) {
			vstupniView.getInputSymbols().addElement("_");
			for (Object a : turingstroj.getInputAlphabet()) {
				vstupniView.getInputSymbols().addElement((String) a);
			}
			vstupniView.getInputList().setSelectedIndex(0);
		}
		cards.show(hlpanel, "4");
	}

	public void handleSaveButton() {
		int index = prechodovyView.getTransitionList().getSelectedIndex();
		if (index != -1) {
			String currentState = prechodovyView.getCurrentState().getText();
			String currentSymbol = prechodovyView.getCurrentAlphabet().getText();
			String switchTo = (String) prechodovyView.getStateComboBox().getSelectedItem();
			String write = (String) prechodovyView.getSymbolComboBox().getSelectedItem();
			String move = (String) prechodovyView.getDirectionComboBox().getSelectedItem();
			String currentTransition = new String("[" + currentState + "] " + "[" + currentSymbol + "] => ");

			turingstroj.getTransitions().get(currentState).get(currentSymbol).put("prepni", switchTo);
			currentTransition += new String("[" + switchTo + "] ");
			if ((switchTo == "prijat") || (switchTo == "odmitnut")) {
				turingstroj.getTransitions().get(currentState).get(currentSymbol).put("zapis", write);
				turingstroj.getTransitions().get(currentState).get(currentSymbol).put("posun", "neutral");
			} else {
				turingstroj.getTransitions().get(currentState).get(currentSymbol).put("zapis", write);
				currentTransition += new String("[" + write + "] ");
				turingstroj.getTransitions().get(currentState).get(currentSymbol).put("posun", move);
				currentTransition += new String("[" + move + "] ");
			}
			prechodovyView.getTransitionItems().add(index, (String) currentTransition);
			prechodovyView.getTransitionItems().remove(index + 1);
			boolean button = true;
			for (Object a : turingstroj.getStates()) {
				for (Object b : turingstroj.getTapeAlphabet()) {
					if (turingstroj.getTransitions().get(a).get(b).isEmpty())
						button = false;
				}
			}
			prechodovyView.getNextButton().setEnabled(button);

			if (index < prechodovyView.getTransitionItems().size()) {
				prechodovyView.getTransitionList().setSelectedIndex(index + 1);
			}
		}
	}

	public void handleSelectedListItem() {
		int index = prechodovyView.getTransitionList().getSelectedIndex();
		if (index != -1) {
			String currentState = (String) turingstroj.getStates().get(index / turingstroj.getTapeAlphabet().size());
			String currentSymbol = (String) turingstroj.getTapeAlphabet()
					.get(index % turingstroj.getTapeAlphabet().size());
			prechodovyView.getCurrentState().setText(currentState);
			prechodovyView.getCurrentAlphabet().setText(currentSymbol);

			if (turingstroj.getTransitions().get(currentState).get(currentSymbol).isEmpty()) {
				prechodovyView.getStateComboBox().setSelectedIndex(0);
				prechodovyView.getSymbolComboBox().setSelectedIndex(0);
				prechodovyView.getDirectionComboBox().setSelectedIndex(0);
			} else {
				prechodovyView.getStateComboBox().setSelectedItem(
						(String) turingstroj.getTransitions().get(currentState).get(currentSymbol).get("prepni"));
				prechodovyView.getSymbolComboBox().setSelectedItem(
						(String) turingstroj.getTransitions().get(currentState).get(currentSymbol).get("zapis"));
				prechodovyView.getDirectionComboBox().setSelectedItem(
						(String) turingstroj.getTransitions().get(currentState).get(currentSymbol).get("posun"));
			}
		}
	}

	public void handleComboBoxSelection() {
		if ((prechodovyView.getStateComboBox().getSelectedItem() == "prijat")
				|| (prechodovyView.getStateComboBox().getSelectedItem() == "odmitnut")) {
			prechodovyView.getSymbolComboBox().setEnabled(false);
			prechodovyView.getDirectionComboBox().setEnabled(false);
		} else {
			if (!overeni) {
				prechodovyView.getSymbolComboBox().setEnabled(true);
				prechodovyView.getDirectionComboBox().setEnabled(true);
			}
		}
	}

	// vstupniView 
	public void handleAddInputButton() {
		if (vstupniView.getInputList().getSelectedIndex() != -1) {
			String symbol = (String) vstupniView.getInputList().getSelectedValue();
			if (symbol.equals("_"))
				symbol = "|_|";
			int cell = vstupniView.getSlider().getValue();
			vstupniView.getInputLabels(cell - 1).setText(symbol);
			if (cell < 31) {
				vstupniView.getSlider().setValue(cell + 1);
			}
		}
	}

	public void handleDeleteInputButton() {
		int cell = vstupniView.getSlider().getValue();
		vstupniView.getInputLabels(cell - 1).setText("");
	}

	public void handleClearInputButton() {
		for (int i = 0; i < 31; i++) {
			vstupniView.getInputLabels(i).setText("");
		}
		vstupniView.getSlider().setValue(1);
	}

	public void handleSecondBackButton() {
		if (!overeni) {
			for (int i = 0; i < 31; i++) {
				vstupniView.getInputLabels(i).setText("");
			}
			vstupniView.getInputSymbols().clear();
			vstupniView.getSlider().setValue(1);
		}
		cards.show(hlpanel, "3");
	}

	public void handleBuildButton() {
		turingstroj.getInput().clear();
		turingstroj.getInput().add("_");
		for (int i = 0; i < 31; i++) {
			if ((vstupniView.getInputLabels(i).getText().trim().equals(""))
					|| (vstupniView.getInputLabels(i).getText().trim().equals("|_|"))) {
				turingstroj.getInput().add("_");
			} else {
				turingstroj.getInput().add(vstupniView.getInputLabels(i).getText().trim());
			}
		}
		turingstroj.getInput().add("_");
		simulace.setInput(turingstroj.getInput());
		cards.show(hlpanel, "5");
		simulace.getSaveMachineButton().setEnabled(true);
		simulace.getRunButton().setText("start");
		simulace.getSlider().setEnabled(true);
		simulace.getState().setText(turingstroj.getCurrentState());
		simulace.getState().setFont(new Font("arial", Font.BOLD, 12));
		simulace.getState().setForeground(Color.black);
		simulace.getPrintError().setText("");
		simulace.setPrintOrder(-1);
		simulace.repaint();
	}

	// simulace
	public void handleChangeInputButton() {
		turingstroj.setCurrentCell((int) simulace.getSpinner().getValue());
		turingstroj.setCurrentState(turingstroj.getStartState());
		turingstroj.getInput().clear();
		cards.show(hlpanel, "4");
	}

	public void handleResetButton() {
		if (casovac.isRunning()) {
			casovac.stop();
		}
		turingstroj.getInput().clear();
		turingstroj.getInput().add("_");
		simulace.getPrintError().setText("");
		for (int i = 0; i < 31; i++) {
			if ((vstupniView.getInputLabels(i).getText().equals(""))
					|| (vstupniView.getInputLabels(i).getText().equals("|_|"))) {
				turingstroj.getInput().add("_");
			} else {
				turingstroj.getInput().add(vstupniView.getInputLabels(i).getText());
			}
		}
		turingstroj.getInput().add("_");
		simulace.setInput(turingstroj.getInput());
		turingstroj.setCurrentCell(turingstroj.getStartCell());
		turingstroj.setCurrentState(turingstroj.getStartState());
		simulace.getState().setText(turingstroj.getCurrentState());
		simulace.getState().setFont(new Font("arial", Font.BOLD, 12));
		simulace.getState().setForeground(Color.black);
		simulace.setTapeHeadCell(turingstroj.getCurrentCell());
		simulace.getChangeInputButton().setEnabled(true);
		simulace.getSpinner().setEnabled(true);
		simulace.getSlider().setEnabled(true);
		simulace.getRunButton().setText("start");
		simulace.getRunButton().setEnabled(true);
		simulace.getSaveMachineButton().setEnabled(true);
		simulace.setPrintOrder(-1);
		simulace.repaint();
	}

	public void handleRunButton() {
		if (simulace.getRunButton().getText().equals("start")) {
			turingstroj.setStartCell((int) simulace.getSpinner().getValue());
			turingstroj.setCurrentCell(turingstroj.getStartCell());
			casovac.setDelay((11 - simulace.getSlider().getValue()) * 100);
			simulace.getChangeInputButton().setEnabled(false);
			simulace.getRunButton().setText("Pozastav");
			simulace.getSlider().setEnabled(false);
			simulace.getSpinner().setEnabled(false);
			simulace.getSaveMachineButton().setEnabled(false);
			simulace.setPrintOrder(-1);
			casovac.start();
		} else if (simulace.getRunButton().getText().equals("pokracuj")) {
			casovac.start();
			simulace.getRunButton().setText("Pozastav");
		} else {
			casovac.stop();
			simulace.getRunButton().setText("pokracuj");
		}
	}

	// ukladani taky sem nasel an netu
	public void handleSaveMachineButton() {
		String name = JOptionPane.showInputDialog(this, "jmeno stroje?", null);
		if (name == null) {
		} else if (name.trim().length() > 0) {
			File savingDir = new File("Saved");
			if (!savingDir.exists()) {
				savingDir.mkdirs();
			}
			File savingMachine = new File("Saved/" + name);
			int result;
			if (savingMachine.exists()) {
				result = JOptionPane.showConfirmDialog(hlokno, name.concat(" Soubor jiz existuje mam jej prepsat?"),
						"potvrd", JOptionPane.YES_NO_OPTION);
			} else {
				result = -5;
			}
			if ((result == JOptionPane.YES_OPTION) || (result == -5)) {
				try {
					savingMachine.mkdirs();

					ObjectOutputStream modelOut;
					modelOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".model"));
					modelOut.writeObject(turingstroj);
					modelOut.close();

					ObjectOutputStream startOut;
					startOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".start"));
					startOut.writeObject(startovaciview);
					startOut.close();

					ObjectOutputStream transitionOut;
					transitionOut = new ObjectOutputStream(
							new FileOutputStream("Saved/" + name + "/" + name + ".transition"));
					transitionOut.writeObject(prechodovyView);
					transitionOut.close();

					ObjectOutputStream inputOut;
					inputOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".input"));
					inputOut.writeObject(vstupniView);
					inputOut.close();

					JOptionPane.showMessageDialog(this, name + " ulozen.");
				} catch (FileNotFoundException e) {
					System.out.println("Chyba nelze otevrit soubor k zapisu");
					JOptionPane.showMessageDialog(this, "Chyba soubor nemuze byt ulozen", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					System.out.println("Chyba nelze zapsat do souboru");
					JOptionPane.showMessageDialog(this, "Chyba soubor nemuze byt ulozen", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				handleSaveMachineButton();
			}
		} else {
			handleSaveMachineButton();
		}
	}

	public void handleSlider(JSlider source) {
		if (source.getValueIsAdjusting()) {
			int delay = source.getValue();
			if (delay > 0) {
				casovac.setDelay(100 * (11 - delay));
				if (casovac.isRunning()) {
					casovac.restart();
				}
			} else {
				casovac.restart();
			}
		}
	}

	public void handleSpinner(JSpinner source) {
		turingstroj.setStartCell((int) source.getValue());
		turingstroj.setCurrentCell(turingstroj.getStartCell());
		simulace.setTapeHeadCell(turingstroj.getCurrentCell());
		simulace.repaint();
	}

	// timer
	public void handleTimerTick() {
		if ((turingstroj.getCurrentState().equals("prijat")) || (turingstroj.getCurrentState().equals("odmitnut"))) {
			casovac.stop();
			simulace.getState().setFont(new Font("arial", Font.BOLD, 14));
			if (turingstroj.getCurrentState().equals("prijat")) {
				simulace.getState().setForeground(new Color(38, 106, 46));
			} else {
				simulace.getState().setForeground(Color.red);
			}
			simulace.getRunButton().setEnabled(false);
		}
		if (((turingstroj.getCurrentCell() < 0) && (turingstroj.getMoveTo().equals("vlevo")))
				|| ((turingstroj.getCurrentCell() == turingstroj.getInput().size())
						&& (turingstroj.getMoveTo().equals("Right")))) {
			casovac.stop();
			simulace.getRunButton().setEnabled(false);
			if ((turingstroj.getCurrentCell() < 0) && (turingstroj.getMoveTo().equals("vlevo"))) {
				simulace.setTapeHeadCell(simulace.getTapeHeadCell() - 1);
			} else {
				simulace.setTapeHeadCell(simulace.getTapeHeadCell() + 1);
			}
			simulace.repaint();
			simulace.getPrintError().setText("Chyba: mimo hranice pasky");
			JOptionPane.showMessageDialog(this, "pozastaveno byl prekrocen limit pasky", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		int order = simulace.getPrintOrder();
		if (order == -1) {
			simulace.setPrintOrder(0);
		}
		if (order == 0) {
			simulace.setPrintOrder(1);
			turingstroj.processSymbol();
		}
		if (order == 2) {
			simulace.setTapeHeadCell(turingstroj.getCurrentCell());
			simulace.setPrintOrder(-1);
		} else if (order == 1) {
			simulace.setInput(turingstroj.getInput());
			simulace.getState().setText(turingstroj.getCurrentState());
			simulace.setPrintOrder(2);
		}
		simulace.repaint();
	}

	// HLfce
	public static void main(String[] args) {
		TMhl aModel = new TMhl();
		new TMdulezity("Turinguv stroj", false, aModel, new TMmenu(), new TMnacti(), new TMstartovaci(),
				new TMprechodovy(), new TMzadej(), new TMvykreslovanistroje()).setVisible(true);
	}
}
