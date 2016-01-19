import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;


public class Processar extends DefaultHandler {
    private static final String NOMCLUB = "club";
    private static final String NOM = "nom";
    private static final String RESULTAT = "resultat";
    private static final String NOMPARTIT = "partit";
    private static final String NOMEQUIP = "equip";
    boolean club_ok = false;
    boolean nom_ok = false;
    boolean resultat_ok = false;
    boolean equip_ok = false;
    boolean partit_ok = false;

    ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    ArrayList<Partido> resultado = new ArrayList<Partido>();
    String nombreequipo;


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(NOMCLUB)) {
            club_ok = true;
        }
        if (qName.equalsIgnoreCase(NOM)) {
            nom_ok = true;
        }
        if (qName.equalsIgnoreCase(NOMEQUIP)) {
            equip_ok = true;
        }
        if (qName.equalsIgnoreCase(NOMPARTIT)) {
            partit_ok = true;
        }
        if (qName.equalsIgnoreCase(RESULTAT)) {
            resultat_ok = true;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (club_ok && nom_ok) {
            String nombre= new String(ch, start, length);
            Equipo equipo = new Equipo(nombre);
            equipos.add(equipo);
        }else if (partit_ok && equip_ok && nom_ok) {
            nombreequipo = new String(ch, start, length);
        }else if (partit_ok && equip_ok && resultat_ok) {
            Partido partit= new Partido();
            String gols = new String(ch,start,length);
            resultado.add(partit);
            partit.setNombre(nombreequipo);
            partit.setGols(Integer.parseInt(gols));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(NOMCLUB)) {
            club_ok = false;
        }else if (qName.equalsIgnoreCase(NOM)) {
            nom_ok = false;
        }else if (qName.equalsIgnoreCase(NOMPARTIT)) {
            if(resultado.get(0).getGols()==resultado.get(1).getGols()){
                for(int i=0;i<equipos.size();i++){
                    if(resultado.get(0).getNombre().equals(equipos.get(i).getNombre())){
                        equipos.get(i).setEmpate(equipos.get(i).getEmpate()+1);
                    }if(resultado.get(1).getNombre().equals(equipos.get(i).getNombre())){
                        equipos.get(i).setEmpate(equipos.get(i).getEmpate()+1);
                    }
                }
            }else if(resultado.get(0).getGols()<resultado.get(1).getGols()) {
                for (int i = 0; i < equipos.size(); i++) {
                    if (resultado.get(1).getNombre().equals(equipos.get(i).getNombre())) {
                        equipos.get(i).setVictoria(equipos.get(i).getVictoria() + 1);
                    }if(resultado.get(0).getNombre().equals(equipos.get(i).getNombre())){
                        equipos.get(i).setDerrota(equipos.get(i).getDerrota()+1);
                    }
                }
            }else if(resultado.get(0).getGols()>resultado.get(1).getGols()){
                for (int i = 0; i < equipos.size(); i++) {
                    if (resultado.get(0).getNombre().equals(equipos.get(i).getNombre())) {
                        equipos.get(i).setVictoria(equipos.get(i).getVictoria() + 1);
                    }if(resultado.get(1).getNombre().equals(equipos.get(i).getNombre())){
                        equipos.get(i).setDerrota(equipos.get(i).getDerrota()+1);
                    }
                }
            }
            resultado.clear();
            partit_ok = false;
        }else if (qName.equalsIgnoreCase(NOMEQUIP)) {
            equip_ok = false;
        }else if (qName.equalsIgnoreCase(RESULTAT)) {
            resultat_ok = false;
        }
    }

    public void endDocument() throws SAXException {
        for (int i = 0; i < equipos.size(); i++) {
            int puntuacion = equipos.get(i).getVictoria()*3+equipos.get(i).getEmpate();
            equipos.get(i).setPuntuacion(puntuacion);
            //System.out.println(equipos.get(i));
        }
        Collections.sort(equipos);
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println(equipos.get(i));
        }
        System.out.println("");
    }


}
