package MaxOne;

public class GA {

	private int tampop;
	private double taxademutacao;
	private double taxadecruzamento;
	private int elitismo;
	
	public GA(int i, double d, double e, int j) {
		this.tampop = i;
		this.taxademutacao = d;
		this.taxadecruzamento = e;
		this.elitismo = j;
	}
	
	public Population populate(int chromosomesize) {
		Population pop = new Population(this.tampop, chromosomesize);
		return pop;
	}
	
	public double calcFitness(Model model) {
		int genecerto = 0;
		
		for(int i = 0; i < model.getChromosomesize(); i++) {
			if(model.getGene(i) == 1) {
				genecerto++;
			}
		}
		
		double fitness = (double)genecerto / model.getChromosomesize();
		model.setFitness(fitness);
		return fitness;
		
	}
	
	public void avaliaPop(Population pop) {
		
		double popFitness = 0;
		
		for(Model model : pop.getIndividuos()) {
			popFitness += calcFitness(model);
		}
		pop.setPopFitness(popFitness);
		
	}
	
	public boolean TerminationCondition(Population pop) {
		for(Model model : pop.getIndividuos()) {
			if(model.getFitness() == 1) 
				return true;
		}
		return false;
	}
	
	public Model selectAncestors(Population pop) {
		Model model[] = pop.getIndividuos();
		
		double popFitness = pop.getPopFitness();
		double getpos = Math.random() * popFitness;
		
		double pin = 0;
		for(Model m : model) {
			pin += m.getFitness();
			if(pin >= getpos) {
				return m;
			}
		}
		return model[pop.size() -1];
	}
	
	public Population crossover(Population pop) {
		
		Population newpop = new Population(pop.size());
		
		for(int i = 0; i < pop.size(); i++) {
			
			Model ancestor1 = pop.getFittest(i);
			
			if(this.taxadecruzamento > Math.random() && i>= this.elitismo) {
				
				Model o = new Model(ancestor1.getChromosomesize());
				
				Model ancestor2 = selectAncestors(pop);
				
				for(int j = 0 ; j < ancestor1.getChromosomesize(); j++) {
					
					if(0.5 > Math.random()) {
						o.setGene(j,  ancestor1.getGene(j));
					} else {
						o.setGene(j,  ancestor2.getGene(j));
					}
					
				}
				newpop.setIndividuo(i, o);
			} else {
				newpop.setIndividuo(i, ancestor1);
			}
		}
		return newpop;
	}
	
	public Population mutate(Population pop) {
		
		Population newpop = new Population(this.tampop);
		
		for(int i = 0; i < pop.size(); i++) {
			
			Model model = pop.getFittest(i);
			for(int j = 0; j < model.getChromosomesize(); j++) {
				if(i > this.elitismo) {
					if(this.taxademutacao > Math.random()) {
						int newgene = 1;
						if(model.getGene(j) == 1) {
							newgene = 0;
						}
						model.setGene(j, newgene);
					}
				}
			}
			newpop.setIndividuo(i, model);
		}
		return newpop;
	}
	
}
