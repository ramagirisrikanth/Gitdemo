package Resources;

import java.util.ArrayList;

import Resources.Xls_Reader;

public class dataproviderutility {
	static Xls_Reader reader;
//this class is mainly for data provider it is a utility class 
	public static ArrayList<Object[]> getdatafromexcell() {
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("E:Testdata.xlsx");
		} catch (Exception e) {
			e.printStackTrace();

		}
		for (int rownum = 2; rownum <= reader.getRowCount("Employyedetails"); rownum++) {
			String employeename = reader.getCellData("Employeedetails", "Employeename", 2);
			String loginpassword = reader.getCellData("Employeedetails", "Loginpassword", 2);
			String role = reader.getCellData("Employeedetails", "Role", 2);
			String branch = reader.getCellData("Employeedetails", "branch", 2);
			Object ab[] = { employeename, loginpassword, role, branch };
			mydata.add(ab);

		}
		return mydata;

	}
}
