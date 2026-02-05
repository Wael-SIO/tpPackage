package IpPackage;

public class IpPackage {

    // Les 4 octets de l'adresse IP
    private int octet1;
    private int octet2;
    private int octet3;
    private int octet4;

    // Constructeur privé pour forcer l'utilisation de getInstance
    private IpPackage(int o1, int o2, int o3, int o4) {
        this.octet1 = o1;
        this.octet2 = o2;
        this.octet3 = o3;
        this.octet4 = o4;
    }

    // Méthode static pour créer une instance (avec validation)
    public static IpPackage getInstance(int o1, int o2, int o3, int o4) {
        try {
            if (o1 < 0 || o1 > 255 || o2 < 0 || o2 > 255 || o3 < 0 || o3 > 255 || o4 < 0 || o4 > 255) {
                throw new Exception("Valeur impossible pour un octet !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return new IpPackage(o1, o2, o3, o4);
    }

    // Retourne la classe d'adresse (A, B, C)
    public char getClasse() {
        if (octet1 >= 0 && octet1 <= 127) return 'A';
        else if (octet1 >= 128 && octet1 <= 191) return 'B';
        else if (octet1 >= 192 && octet1 <= 223) return 'C';
        else return 'X'; // Classe non standard
    }

    // Retourne l'adresse réseau
    public IpPackage adresseReseau() {
        switch (getClasse()) {
            case 'A':
                return IpPackage.getInstance(octet1, 0, 0, 0);
            case 'B':
                return IpPackage.getInstance(octet1, octet2, 0, 0);
            case 'C':
                return IpPackage.getInstance(octet1, octet2, octet3, 0);
            default:
                return null;
        }
    }

    // Vérifie si deux IP sont dans le même réseau
    public boolean estMemeReseau(IpPackage ip) {
        if (ip == null) return false;
        IpPackage reseau1 = this.adresseReseau();
        IpPackage reseau2 = ip.adresseReseau();
        return reseau1.equals(reseau2);
    }

    // Getters pour les octets
    public int getOctet1() { return octet1; }
    public int getOctet2() { return octet2; }
    public int getOctet3() { return octet3; }
    public int getOctet4() { return octet4; }

    // Méthode de test fournie pour ip1.test()
    public void test() {
        System.out.println("Test de la méthode test() : l'adresse est " + this.toString());
    }

    // Affichage de l'adresse IP
    @Override
    public String toString() {
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }

    // Méthode equals pour comparer deux objets IpPackage
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IpPackage)) return false;
        IpPackage ip = (IpPackage) obj;
        return this.octet1 == ip.octet1 &&
               this.octet2 == ip.octet2 &&
               this.octet3 == ip.octet3 &&
               this.octet4 == ip.octet4;
    }
}
