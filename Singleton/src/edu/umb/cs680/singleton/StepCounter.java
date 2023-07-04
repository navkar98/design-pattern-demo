package edu.umb.cs680.singleton;

public class StepCounter {
	protected long step;

	private StepCounter(){
		this.step = 0;
	}

	private static StepCounter instance = null;

	public static StepCounter getInstance(){
		if(instance==null)
			instance = new StepCounter ();
		return instance;
	}

	public void increaseStep(){
		this.step++;
	}

	public void decreaseStep(){
		this.step--;
	}

	public long getStepCount(){
		return this.step;
	}
	
	public static void main(String[] args) {
		StepCounter counter = StepCounter.getInstance();

		System.out.println("Counter at: " + counter.getStepCount());

		counter.increaseStep();
		System.out.println("Counter at: " + counter.getStepCount());

		counter.decreaseStep();
		System.out.println("Counter at: " + counter.getStepCount());

		counter.increaseStep();
		StepCounter counter_new = StepCounter.getInstance();
		System.out.println("New variable (Same instance) Counter at: " + counter_new.getStepCount());
	}
}

