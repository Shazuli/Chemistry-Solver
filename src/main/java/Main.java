package main.java;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.Objects.Element;
import main.java.Objects.Molecule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main extends Application implements EventHandler {
    //References
    private final int width=800,height=500;
    public static final String ResourceLocation = "file:src/main/resources/";

    public static StackPane layout;

    //GUI Elements
    private TextField input;
    private Button format;
    public static Button openPerTab;

    //Objects
    public static List<Element> Elements = new ArrayList<>();
    public static Molecule[][] InputMolecules;


    public static void print(String str) { System.out.println(str); }
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void formatFormula(String formula) {
        //Molecule[][] toRet = new Molecule[2][];
        List[] temp = new List[] {
            new ArrayList<Molecule>(),
            new ArrayList<Molecule>()
        };
        //Arrays.stream(formula.replaceAll("[^ A-z0-9]","").replaceAll(" ", " ").split(" ")).parallel().forEach(el -> temp[0].add(new Molecule(el)));
        List<Element> ell = new ArrayList<>();
        String crnN = null;
        int crnQ=0;
        int side = 0;
        //temp[side].add(new Molecule());
        for (int i=0;i<formula.length()+1;i++) {
            String d;
            try { d = formula.substring(i,i+1); } catch (Exception e) { d = formula.substring(i-1); }
            if (Character.isWhitespace(d.charAt(0))) continue;

            if (isNumber(d)) {
                crnQ = Integer.parseInt(crnQ+d);
            } else if (d == d.toUpperCase()) {
                if (crnN != null)
                    ell.add(new Element(crnN,crnQ));
                crnN = d;
                crnQ = 0;
            } else {
                crnN = crnN + d;
            }
        }
        /*for (Element f: ell) {
            System.out.println(f.getName()+": "+f.getQuantity());
        }*/
        Molecule tempM = new Molecule();
        boolean newMol = false;
        for (Element e:ell) {
            String n = e.getName();

            if (n.charAt(0) == "+".charAt(0)) {
                newMol = true;
                temp[side].add(tempM);
                tempM = new Molecule();
                //continue;
            }
            if (n.charAt(0) == "=".charAt(0)) {
                newMol = true;
                if (side == 0)
                    temp[side].add(tempM);
                side = 1;
                tempM = new Molecule();
                //continue;
            }
            if (n.charAt(0) == ">".charAt(0)) {
                side = 1;
                tempM = new Molecule();
                continue;
            }
            if (newMol) {
                //temp[side].add(tempM);
                //tempM = new Molecule();
                newMol = false;
            } else {
                tempM.addElement(e);
            }
        }
        System.out.println(
                ((Molecule) temp[0].get(0)).getElement(1).getName()
        );
        /*Element e;
        boolean newMol = true;
        for (int i=0;i<ell.size();i++) {
            //System.out.println(temp[0].size());
            e = ell.get(i);
            //print("'"+e.getName()+"'");
            if (newMol) {
                temp[side].add(new Molecule());
                newMol=false;
            } else {
                ((Molecule)temp[side].get(temp[side].size()-1)).addElement(e);
            }
            if (e.getName().charAt(0) == "+".charAt(0)) {
                newMol = true;
                continue;
            }
            if (e.getName().charAt(0) == "=".charAt(0) || e.getName().charAt(0) == ">".charAt(0)) {
                newMol = true;
                side = 1;
            }
        }*/

        //System.out.println(((Molecule) temp[1].get(0)).getElement(0).getName());
        //System.out.println(((Molecule) temp[1].get(0)).getElement(1).getName());
        /*toRet[0] = new Molecule[temp[0].size()];
        toRet[0] = temp[0].toArray(toRet[0]);*/
        //System.out.println(((Molecule) temp[0].get(0)).getElement(0).getName());
    }

    public Element[] separate(String form) {
        List<Element> toRet = new ArrayList<>();
        int t=0;
        String currentN = null;
        int currentQ = 0;
        for (int i=0;i<form.length()+1;i++) {
            String d;
            try {
                d = form.substring(i,i+1);
            } catch (Exception e) {
                break;
            }
            //print("ddd "+d);
            if (d!=" ") {
                if (isNumber(d)) {
                    currentQ = currentQ + Integer.parseInt(d);
                } else if (d == d.toUpperCase()) {
                    if (currentN != null)
                        toRet.add(new Element(currentN,currentQ));
                    currentN = d;
                    currentQ = 0;
                } else {
                    currentN = currentN + d;
                }
            }
        }
        Element[] x = new Element[toRet.size()];
        x = toRet.toArray(x);
        return x;
    }

    public List<Molecule>[] createMolecules(Element[] listRaw) {
        //List<List<Molecule>> toRet = new ArrayList<>();
        List[] toRet = new List[] {
                new ArrayList<Molecule>(),
                new ArrayList<Molecule>()
        };
        //toRet[0] = new ArrayList<Molecule>();
        //toRet[1] = new ArrayList<Molecule>();
        //toRet.get(0) = new ArrayList<>();
        /*toRet[0] = new ArrayList<Molecule>();
        toRet[1] = new ArrayList<Molecule>();*/
        Boolean newMol = true;
        int k = 0;

        for (int i=0;i<listRaw.length;i++) {
            if (newMol) {
                toRet[k].add(new Molecule());
                newMol = false;
            }
            Element e = listRaw[k];
            if (e.getName() == "+") {
                newMol = true;
                continue;
            }
            if (e.getName() == "=") {
                k = 1;
                continue;
            }
            if (e.getName() == ">") {
                k = 1;
                continue;
            }
            //toRet[k].get(toRet[k].size()-1).addElement(e);
            ((Molecule) toRet[k].get(toRet[k].size()-1)).addElement(e);
            //Molecule x = ((Molecule) toRet[k].get(0));
            //toRet[k].get(0);

        }
        return toRet;
    }



    public static void main(String[] args) {
        print("Loading all the elements ..");
        // TODO load in all elements from the JSON file to array.

        Elements.add(new Element("H",1));
        Elements.add(new Element("He",1));

        print("Done.");



        print("Launching program ..");
        launch(args);
        print("Program ended.");
        // TODO save mechanic?
    }

    @Override
    public void start(Stage window) throws Exception {
        layout = new StackPane();
        Scene scene = new Scene(layout,width,height);

        window.setResizable(false);
        window.setTitle("Chemistry Solver");
        window.getIcons().add(new Image(ResourceLocation+"logo.jpg"));



        input = new TextField("C6H14 + O2 => CO2 + H2O");
        format = new Button("Format Text");
        openPerTab = new Button("Periodic Table");

        input.setAlignment(Pos.CENTER);
        input.setTranslateY((-height*0.5)+input.getHeight()+10);
        format.setTranslateX((-width*0.5)+format.getWidth()+49);
        format.setTranslateY((-height*0.5)+input.getHeight()+37);
        //openPerTab.setTranslateX((-width*0.5)-format.getWidth()+49);
        openPerTab.setTranslateY((height*0.5)-13);
        openPerTab.setTranslateX((-width*0.5)+format.getWidth()+55);
        layout.getChildren().add(input);
        layout.getChildren().add(format);
        layout.getChildren().add(openPerTab);

        format.setOnMouseClicked(event -> {
            format.setDisable(true);
            formatFormula(input.getText());
            format.setDisable(false);
        });
        openPerTab.setOnMouseClicked(event -> {
            openPerTab.setDisable(true);
            new PeriodicTable();
        });






        window.setScene(scene);
        window.show();
    }

    @Override
    public void handle(Event event) {
        /*if (event.getSource() == format) {
            format.setDisable(true);
            // TODO Separator of formula goes here, disables the button while processing large values.

            //InputMolecules = createMolecules(separate(input.getText()));
            //System.out.print(separate(input.getText()));
            //System.out.println(InputMolecules[0].get(0).getElement(0).getName());
            formatFormula(input.getText());


            format.setDisable(false);
        }*/

    }
}
