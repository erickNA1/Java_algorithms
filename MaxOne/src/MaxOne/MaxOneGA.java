package MaxOne;

public class MaxOneGA {

	public static void main(String[] args) {

		GA ga = new GA (100, 0.001, 0.95, 2);
		
		Population pop = ga.populate(50);
		
		ga.avaliaPop(pop);
		
		int gen = 1;
		
		while(ga.TerminationCondition(pop) == false) {
			
			System.out.println("Melhor solução: " + pop.getFittest(0).toString());
			
			pop = ga.crossover(pop);
			
			pop = ga.mutate(pop);
			
			ga.avaliaPop(pop);
			
			gen++;
			
		}
		
		System.out.println("Solução encontrada em " + gen + "gerações ");
		System.out.println("Melhor solução: " + pop.getFittest(0).toString());

	}

}
