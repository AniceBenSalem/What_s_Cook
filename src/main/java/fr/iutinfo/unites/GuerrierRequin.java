package fr.iutinfo.unites;

public class GuerrierRequin extends Unite{

	
		public GuerrierRequin () {
			super();
			this.nombre=0;
			this.force = 30;
			this.pv = 70;
			this.vitesseDeplacement = 2;
			this.tempsFabrication = 50;
			this.niveauCaserneNecessaire = 3;
			this.initialiseCoutFabrication();
		

		}
		
		@Override
		public void initialiseCoutFabrication() {
			this.coutFabrication.put("Coquillage", new Integer(50));
			
		}

		@Override
		public String getNom() {
			return "Guerrier-Requin";
		}

		@Override
		public String getDescription() {
			return "Unité amphibienne issue du mariage d'un grand requin blanc et d'un guerrier d'une tribut du nord";
		}

		@Override
		public void up() {
			this.nombre++;
			
		}
				
		
	}


