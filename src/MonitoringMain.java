import java.util.Scanner;
import java.math.BigDecimal;

public class MonitoringMain
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MonitoringManagerDatabase mmd = MonitoringManagerDatabase.instance();
		System.out.println("Codes: <all> <search> <add> <delete>");
		System.out.println("Enter code:");
		String code = sc.nextLine();
		if("all".equals(code)) {
			System.out.println("enter type: ");
			String t = sc.nextLine();
			if("goods".equals(t)) {
				System.out.println(mmd.getAllGoods());
			}
			else if("employees".equals(t)) {
				System.out.println(mmd.getAllEmployees());
			}
			else if("branches".equals(t)) {
				System.out.println(mmd.getAllBranches());
			}
		}
		else if("delete".equals(code)) {
		String del = new Scanner(System.in).nextLine();
			System.out.println("");
			if("goods".equals(del)) {
				
			}
			else if("employee".equals(del)) {
				
			}
			else if("branch".equals(del)) {
				
			}
		}
		else if("add".equals(code)) {
			System.out.println("what to add?");
			String srch = new Scanner(System.in).nextLine();
			if("goods".equals(srch)) {
				System.out.println("Enter id :");
					int id = sc.nextInt();
				System.out.println("Enter quantity :");
					int qty = sc.nextInt();
				System.out.println("Enter name :");
					String name = new Scanner(System.in).nextLine();
					sc.nextLine();
				System.out.println("Enter brand :");
					String brand = new Scanner(System.in).nextLine();
				System.out.println("Enter batchcode :");
					String batchCode = sc.nextLine();
				System.out.println("Enter price :");
					BigDecimal price = sc.nextBigDecimal();
				System.out.println("Enter type :");
					String type = new Scanner(System.in).nextLine();
				System.out.println("Enter details :");
					String details = new Scanner(System.in).nextLine();
				Goods g = new Goods(id, qty, name, brand, batchCode, price, type, details);
				if(mmd.addGoods(g)) {
					System.out.println("added..");
				}
				else if(!mmd.addGoods(g)) {
					System.out.println("DI PUMASOK..");
				}
			}
			else if("employee".equals(srch)) {
				System.out.println("Enter id :");
					int id = sc.nextInt();
				System.out.println("Enter fname :");
					String fn = new Scanner(System.in).nextLine();
				System.out.println("Enter lname :");
					String ln = new Scanner(System.in).nextLine();
					sc.nextLine();
				System.out.println("Enter address :");
					String add = new Scanner(System.in).nextLine();
				System.out.println("Enter assignedto :");
					int at = sc.nextInt();
				System.out.println("Enter sss :");
					int sss = sc.nextInt();
				System.out.println("Enter philhealth :");
					int ph = sc.nextInt();
				System.out.println("Enter position :");
					String pos = new Scanner(System.in).nextLine();
				System.out.println("Enter details :");
					String details = new Scanner(System.in).nextLine();
				Employee e = new Employee(id, fn, ln, add, at, sss, ph, pos, details);
				if(mmd.addEmployee(e)) {
					System.out.println("added..");
				}
				else if(!mmd.addEmployee(e)) {
					System.out.println("DI PUMASOK..");
				}
			}
			else if("branch".equals(srch)) {
				System.out.println("Enter id :");
					int id = sc.nextInt();
				System.out.println("Enter address :");
					String add = new Scanner(System.in).nextLine();
				System.out.println("Enter name :");
					String name = new Scanner(System.in).nextLine();
					sc.nextLine();
				System.out.println("Enter details :");
					String details = new Scanner(System.in).nextLine();
				Branch b = new Branch(id, add, name, details);
				if(mmd.addBranch(b)) {
					System.out.println("added..");
				}
				else if(!mmd.addBranch(b)) {
					System.out.println("DI PUMASOK..");
				}
			}
		}
	}
}
