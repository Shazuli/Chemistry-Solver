package main.java.Api;

import main.java.Objects.Element;
import main.java.Objects.Molecule;

import java.util.ArrayList;
import java.util.List;

public class Methods {
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void print(String str) { System.out.println(str); }

    public static Element[] ParseString(String formula) {
        List<Element> ell = new ArrayList<>();
        String crnN = null;
        int crnQ=0;
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
        return ell.toArray(new Element[ell.size()]);
    }


    public static Molecule[][] ParseElementsForm(String formula) {
        int side = 0;
        List[] temp = new List[] {
                new ArrayList<Molecule>(),
                new ArrayList<Molecule>()
        };
        Element[] ell = ParseString(formula);

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
        temp[1].add(tempM);

        return new Molecule[][]{
                ((Molecule[]) temp[0].toArray(new Molecule[temp[0].size()])),
                ((Molecule[]) temp[1].toArray(new Molecule[temp[1].size()]))
        };

        /*Molecule[][] toRet = new Molecule[2][];
        toRet[0] = ((Molecule[]) temp[0].toArray(new Molecule[temp[0].size()]));
        toRet[1] = ((Molecule[]) temp[1].toArray(new Molecule[temp[1].size()]));*/
        //return toRet;
    }
}
