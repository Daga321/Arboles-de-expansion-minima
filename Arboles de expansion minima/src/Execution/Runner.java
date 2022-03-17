package Execution;

import Control.Controller;
import View.PrincipalWindow;

public class Runner {

	public static void main(String[] args) {
		
		PrincipalWindow principalWindow = new PrincipalWindow();
		Controller controller = new Controller(principalWindow);
		principalWindow.assignController(controller);
	}

}
