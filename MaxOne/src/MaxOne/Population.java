package MaxOne;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Population {

	private Model pop[];
	private double popFitness = -1;
	
	public Population(int popsize) {
		this.pop = new Model[popsize];
	}
	
	public Population(int popsize, int chromosomesize) {
		
		this.pop = new Model[popsize];
		
		for(int i = 0; i < popsize; i++) {
			Model individuo = new Model(chromosomesize);
			this.pop[i] = individuo;
		}
		
	}
	
	public Model getFittest(int i) {
		
		Arrays.sort(this.pop, new Comparator<Model>() {
			@Override
			public int compare(Model o1, Model o2) {
				if(o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});
		return this.pop[i];
	}
	
	public void Randomiza() {
		
		Random r = new Random();
		
		for(int i = pop.length - 1; i > 0; i--) {
			int indice = r.nextInt(i+1);
			Model m = pop[indice];
			pop[indice] = pop[i];
			pop[i] = m;
		}
		
	}
	
	public Model setIndividuo(int offset, Model individuo) {
		return pop[offset] = individuo;
	}
	
	public Model getIndividuo(int offset) {
		return pop[offset];
	}
	
	public Model[] getIndividuos() {
		return this.pop;
	}
	
	public Model[] getPop() {
		return pop;
	}
	
	public void setPop(Model[] pop) {
		this.pop = pop;
	}
	
	public double getPopFitness() {
		return popFitness;
	}
	
	public void setPopFitness(double popFitness) {
		this.popFitness = popFitness;
	}
	
	public int size() {
		return this.pop.length;
	}
	
}
