package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {
	
	private String[] choices;

	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		//Hint: 1 point per choice
		super(prompt, answer, 4, choices);
		
	}
	
	public int checkAnswer(String givenAnswer) {
		int point = 4;
		String answer = getAnswer();
		for (int i=0; i<answer.length(); i++) {
			if (givenAnswer.indexOf(answer.charAt(i)) == -1) {
				point--;
			}
		}
		for (int j=0; j<givenAnswer.length(); j++) {
			if (answer.indexOf(givenAnswer.charAt(j)) == -1) {
				point--;
			}
		}
		return point;
	}

	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("13")); //full credit
		System.out.println(selectAll.checkAnswer("31")); //full credit
		System.out.println(selectAll.checkAnswer("1")); //3 points
		System.out.println(selectAll.checkAnswer("3")); //3 points
		System.out.println(selectAll.checkAnswer("23")); //2 points
		System.out.println(selectAll.checkAnswer("34")); //2 points
		System.out.println(selectAll.checkAnswer("4")); //1 point
		System.out.println(selectAll.checkAnswer("124")); //1 point
		System.out.println(selectAll.checkAnswer("24")); //0 points
		
	}
}
