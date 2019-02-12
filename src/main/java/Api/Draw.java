package main.java.Api;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.java.Main;
import main.java.Objects.Element;
import main.java.Objects.Molecule;


public class Draw {
    public static void drawMolecule(Molecule molecule, double xOffset, double yOffset) {
        for (int i=0;i<molecule.getElements().length;i++) {
            Element e = molecule.getElement(i);
            String n = e.getName();
            int q = e.getQuantity();

            Text nT = new Text();
            nT.setText(n);
            //qT.setTextAlignment(TextAlignment.RIGHT);
            nT.setTranslateX((i*39)+xOffset);
            nT.setTranslateY(yOffset);
            nT.setFont(new Font(42));
            Main.layout.getChildren().add(nT);
            //Main.Texts.add(nT);
            if (q > 1) {
                Text qT = new Text();
                qT.setText(q+"");
                qT.setTranslateX((i*39+19)+xOffset);
                qT.setTranslateY(16+yOffset);
                qT.setFont(new Font(15));
                Main.layout.getChildren().add(qT);
                //Main.Texts.add(qT);
            }

        }

    }
    public static void drawFormula(Molecule[][] formula, int x, int y) {

    }
}