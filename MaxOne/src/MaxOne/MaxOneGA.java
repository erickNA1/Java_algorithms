package MaxOne;

public class MaxOneGA {

	public static void main(String[] args) {

		GA ga = new GA (100, 0.001, 0.95, 2);
		
		Population pop = ga.populate(50);
		
		ga.avaliaPop(pop);
		
		int gen = 1;
		
		while(ga.TerminationCondition(pop) == false) {
			
			System.out.println("Melhor solu��o: " + pop.getFittest(0).toString());
			
			pop = ga.crossover(pop);
			
			pop = ga.mutate(pop);
			
			ga.avaliaPop(pop);
			
			gen++;
			
		}
		
		System.out.println("Solu��o encontrada em " + gen + "gera��es ");
		System.out.println("Melhor solu��o: " + pop.getFittest(0).toString());

	}

}
