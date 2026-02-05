import IpPackage.*;
class IpTest {
		public static void main (String args[]) {
			// int y = 100;
			IpPackage ip1 = IpPackage.getInstance(192,168,0,7);
			ip1.test();
			System.out.println("\nLa suite ...");
			int x = 257;
			
			IpPackage ip2 = IpPackage.getInstance(10,50,41,77);		
			System.out.println("Valeur de l'octet 2 = " + ip2.getOctet2());
			
			// Affichage de la classe ?
			System.out.println("Classe de l'adresse ip1  " + ip1.getClasse());
			System.out.println("Classe de l'adresse ip2  " + ip2.getClasse());
			System.out.println("\n\n");
			
			// Adresse réseau des deux réseaux
			System.out.println("Adresse reseau de l'adresse ip1  " + ip1.adresseReseau().ToString());
			System.out.println("Adresse reseau de l'adresse ip2  " + ip2.adresseReseau().ToString());
			System.out.println("\n\n");
			
			// est même réseau ?
			System.out.println("ip1 et ip2 meme reseau ? " + ip1.estMemeReseau(ip2));
			System.out.println("ip1 et ip1 meme reseau ? " + ip1.estMemeReseau(ip1));
			System.out.println("ip2 et ip2 meme reseau ? " + ip2.estMemeReseau(ip2));
			}
	
}
