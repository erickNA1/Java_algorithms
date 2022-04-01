package MaxOne;

public class Model {

	private int[] chromosome;
	private double fitness;
	
	public Model (int[] chromosome) {
		this.chromosome = chromosome;
	}
	
	public Model(int chromosomesize) {
		
		this.chromosome = new int[chromosomesize];
		
		for(int gene = 0; gene < chromosomesize; gene++) {
			if(0.5 < Math.random()) {
				this.setGene(gene, 1);
			} else {
				this.setGene(gene, 0);
			}
		}
		
	}
	
	public void setGene(int x, int gene) {
		this.chromosome[x] = gene;
	}
	
	public int getGene(int i) {
		return this.chromosome[i];
	}
	
	public int[] getChromosome() {
		return this.chromosome;
	}
	
	public int getChromosomesize() {
		return this.chromosome.length;
	}
	
	public void setChromosome(int[] chromosome) {
		this.chromosome = chromosome;
	}
	
	public double getFitness() {
		return fitness;
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public String toString() {
		
		String saida = "";
		for(int gene = 0; gene < this.chromosome.length; gene++) {
			saida += this.chromosome[gene];
		}
		return saida;
		
	}
	
}
