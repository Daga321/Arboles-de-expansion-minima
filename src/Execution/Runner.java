package Execution;

import java.awt.Toolkit;

import Control.Controller;
import View.PrincipalWindow;

public class Runner {

	public static void main(String[] args) {
		
		Toolkit t = Toolkit.getDefaultToolkit();
//		System.out.println(t.getScreenSize().width);
//		System.out.println(t.getScreenSize().height);
		
		PrincipalWindow principalWindow = new PrincipalWindow();
		Controller controller = new Controller(principalWindow);
		principalWindow.assignController(controller);
	}

}
