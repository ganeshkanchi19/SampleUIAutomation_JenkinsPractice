package p2;

import org.testng.annotations.Test;

public class DependsOnGroupsTest {
	
	@Test(dependsOnGroups  = {"SignIn"})
	public void ViewAcc()
	{
		 System.out.println("SignIn Successful");
	}
	
	
	@Test(groups = {"SignIn"})
	public void Login()
	{
		System.out.println("Logging In Success");
	}

}
