package cs4230.pedestrian.math;

/**
 * Linear Congruential Random Number Generator
 * @author Nathan
 *
 */
public class LinCogRandom {
	
	private long m;
	private long a;
	private long c;
	private long x;
	
	public LinCogRandom(long seed) {
		x = seed;
		a = 1103515245L;
		m = 1L << 32L;
		c = 12345;
	}
	
	public LinCogRandom() {
		this(10);
	}
	
	public int nextInt(int upper) {
		x = (a*x + c) % m;
		return (int)((x >> 16) % upper);
	}

}
