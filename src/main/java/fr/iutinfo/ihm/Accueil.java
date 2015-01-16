package fr.iutinfo.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutinfo.Ile;
import fr.iutinfo.Univers;
import fr.iutinfo.exceptions.PlacementOccupeException;

public class Accueil extends JFrame {
	
	public Accueil () throws PlacementOccupeException, SQLException {
		setContentPane(new Background());
		this.setSize(1280, 800);
		this.setLayout(new BorderLayout());
		this.setTitle("VINLAND");
		setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
		Univers univ = new Univers("Omega");
		Ile ileA = new Ile(univ, "LeonLeBrave");
		ileA.getGenerateurCoquillage().genererRessource();
		
		JLabel nomIle = new JLabel();
		nomIle.setText(ileA.getProprietaire());
		nomIle.setForeground(Color.WHITE);
		nomIle.setLocation(200, 200);
		nomIle.setOpaque(false);
		nomIle.setPreferredSize(new Dimension(100,100));
		nomIle.setVisible(true);
		
		
		JPanel info = new JPanel();
		info.setOpaque(false);
		info.setLayout(new FlowLayout());
		
		//Partie 1
		JPanel NbCoquillage = new JPanel();
		NbCoquillage.setLayout(new BoxLayout(NbCoquillage,BoxLayout.Y_AXIS));
		JLabel label = new JLabel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		label.setText("Entrepot\n\n"); 
		label.setVisible(true);
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		label1.setText("Coquillage : "+ileA.nombreCoquillageEntrepot()+"                \n\n"); 
		label1.setVisible(true);
		label1.setOpaque(false);
		label1.setForeground(Color.WHITE);
		label2.setText("Time"); 
		label2.setVisible(true);
		label2.setOpaque(false);
		label2.setForeground(Color.WHITE);
		NbCoquillage.setOpaque(false);
		NbCoquillage.add(label);
		NbCoquillage.add(label1);
		NbCoquillage.add(label2);
		info.add(NbCoquillage);
		
		//Partie 2
		JPanel generateur = new JPanel();
		generateur.setLayout(new BoxLayout(generateur,BoxLayout.Y_AXIS));
		JLabel gen = new JLabel();
		JLabel gen1 = new JLabel();
		JLabel gen2 = new JLabel();
		gen.setText("Generateur\n\n"); 
		gen.setVisible(true);
		gen.setOpaque(false);
		gen.setForeground(Color.WHITE);
		gen1.setText("Generateur : "+ileA.nombreCoquillageEntrepot()+"                \n\n"); 
		gen1.setVisible(true);
		gen1.setOpaque(false);
		gen1.setForeground(Color.WHITE);
		gen2.setText("Time : "+ileA.getGenerateurCoquillage().getNombre()); 
		gen2.setVisible(true);
		gen2.setOpaque(false);
		gen2.setForeground(Color.WHITE);
		generateur.setOpaque(false);
		generateur.add(gen);
		generateur.add(gen1);
		generateur.add(gen2);
		info.add(generateur);
		
		//Partie 3
		JPanel defense = new JPanel();
		defense.setLayout(new BoxLayout(defense,BoxLayout.Y_AXIS));
		JLabel def = new JLabel();
		JLabel def1 = new JLabel();
		JLabel def2 = new JLabel();
		def.setText("defense"+"                \n\n"); 
		def.setVisible(true);
		def.setOpaque(false);
		def.setForeground(Color.WHITE);
		def1.setText("Cococanon : "+ileA.getCococanon().getNombre()+"                \n\n"); 
		def1.setVisible(true);
		def1.setOpaque(false);
		def1.setForeground(Color.WHITE);
		def2.setText("Time : "+ileA.getGenerateurCoquillage().getNombre()); 
		def2.setVisible(true);
		def2.setOpaque(false);
		def2.setForeground(Color.WHITE);
		defense.setOpaque(false);
		defense.add(def);
		defense.add(def1);
		defense.add(def2);
		info.add(defense);
		
		//Partie 4
		JPanel caserne = new JPanel();
		caserne.setLayout(new BoxLayout(caserne,BoxLayout.Y_AXIS));
		JLabel cas = new JLabel();
		JLabel cas1 = new JLabel();
		JLabel cas2 = new JLabel();
		cas.setText("Caserne"+"                \n\n"); 
		cas.setVisible(true);
		cas.setOpaque(false);
		cas.setForeground(Color.WHITE);
		cas1.setText("SurfeurCroMagnon : "+ileA.getSurfeur().getNombre()+"                \n\n"); 
		cas1.setVisible(true);
		cas1.setOpaque(false);
		cas1.setForeground(Color.WHITE);
		cas2.setText("Time : "+ileA.getSurfeur().getNombre()); 
		cas2.setVisible(true);
		cas2.setOpaque(false);
		cas2.setForeground(Color.WHITE);
		caserne.setOpaque(false);
		caserne.add(cas);
		caserne.add(cas1);
		caserne.add(cas2);
		info.add(caserne);
		
		add(nomIle,BorderLayout.NORTH);
		add(info,BorderLayout.CENTER);
		
		revalidate();
		repaint();
	}
	
	
	public class Background extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {

				Image img = ImageIO.read(new File("src/main/webapp/image/fond.jpg"));
				
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws PlacementOccupeException, SQLException {
		new Accueil();
	}
	
	
}
