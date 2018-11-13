
public class TestPolynomial {

	public static void main(String[] args) {
		Polynomial m1 = new Polynomial(3, 4, 5);
		Polynomial m2 = new Polynomial(2, 3, 4, 3);
		//System.out.println(m1 + "\n" + m1.getDegree());
		//System.out.println(m1.evaluate(1) + " " + m2.evaluate(2));
		System.out.println(m1.add(m2));
		System.out.println(m1);
		//System.out.println(m1.multiply(m2));

	}

}
