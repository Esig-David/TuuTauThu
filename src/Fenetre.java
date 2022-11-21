import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Fenetre  extends JFrame implements ActionListener {
    JTextArea items;
    JButton fichier, afficher, quitter;
    JScrollPane scroll;
    int cptAfficher = 0;

    Fenetre(String aTitle, Quest questionnaire) {
        JPanel panel = new JPanel(new GridLayout(0,3));
        setTitle(aTitle);
        fichier = new JButton("Choisir un fichier");
        afficher = new JButton("Afficher");
        afficher.addActionListener(this);
        quitter = new JButton("Quitter");
        quitter.addActionListener(this);

        panel.add(fichier, "West");
        panel.add(afficher, "Center");
        panel.add(quitter, "East");
        add(panel, "North");
        items = new JTextArea(10,50);
        for (Item item:questionnaire.getQ()) {
            items.append("Question: " + item.getQuestion() +"\n" + "Réponse: " + item.getRéponse() + "\n" + "\n");
        }
        add(items);
        items.setVisible(false);
        scroll = new JScrollPane(items);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
        scroll.setVisible(false);






    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(afficher)) {
            cptAfficher++;
            if (cptAfficher % 2 == 0){
                items.setVisible(false);
                afficher.setText("Afficher");
                scroll.setVisible(false);
            }else{
                items.setVisible(true);
                afficher.setText("Cacher");
                scroll.setVisible(true);

            }
            this.pack();

        }else if (actionEvent.getSource().equals(quitter)){
            System.exit(0);
        }

    }
}
