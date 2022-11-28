import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class FileChooser extends JFrame implements ActionListener {
    JFileChooser fc;
    JButton fichier, quitter;

    FileChooser() {
        setLayout(new FlowLayout());
        fc = new JFileChooser("J:\\Semestre 1\\Cours\\APO_\\Exercice_1");
        fichier = new JButton("Choisir un fichier");
        fichier.addActionListener(this);
        add(fichier);
        quitter = new JButton("Quitter");
        quitter.addActionListener(this);
        add(quitter);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(fichier)) {
            int returnVal = fc.showOpenDialog(this);//null centre sur l'écran
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                ArrayList<Item> liste = new ArrayList<>();
                Quest quest = new Quest(liste, file);
                Fenetre f = new Fenetre("Questionnaire", quest);
                this.setVisible(false);
                f.pack();
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
        }else if (actionEvent.getSource().equals(quitter)) {
            System.exit(0);
        }
    }
}
