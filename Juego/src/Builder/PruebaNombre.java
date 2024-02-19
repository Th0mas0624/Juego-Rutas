package Builder;

public class PruebaNombre {
	public String nombreClase() {
		return this.getClass().getSimpleName();
	}
	public static void main(String[] args) {
		PruebaNombre prueba = new PruebaNombre();
		System.out.print(prueba.nombreClase());
	}
}