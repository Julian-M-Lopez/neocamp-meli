
import model.SuperHeroe;

public class Main {
    public static void main(String[] args) {

        SuperHeroe aquaman = new SuperHeroe("Aquaman");
        aquaman.setDescripcion("Rey de los oceanos");
        aquaman.setCapa(true);

        System.out.println(aquaman.toString());
    }
}