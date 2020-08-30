public class BeforeLambdaExpression {

	public static void main(String[] args) {
		BeforeLambdaExpression le = new BeforeLambdaExpression();
		Executor executor = null;
		
		executor = new CreateExecutor();
		le.execute(executor);
		
		executor = new DeleteExecutor();
		le.execute(executor);
	}
	
	public void execute(Executor executor) {
		executor.execute();
	}

}
