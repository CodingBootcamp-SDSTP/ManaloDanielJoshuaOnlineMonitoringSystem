import java.math.BigDecimal;

public class Goods
{
	private int gid;
	private int quantity;
	private String name;
	private String brand;
	private String batchCode;
	private BigDecimal unitPrice;
	private String type;
	private String details;

	public Goods(int gid, int quantity, String name, String brand, String batchCode, BigDecimal unitPrice, String type, String details) {
		this.gid = gid;
		this.quantity = quantity;
		this.name = name;
		this.brand = brand;
		this.batchCode = batchCode;
		this.unitPrice = unitPrice;
		this.type = type;
		this.details = details;
	}
//SETTER
	public void setGId(int id) {
		gid = id;
	}

	public void setQuantity(int qty) {
		quantity = qty;
	}

	public void setName(String n) {
		name = n;
	}

	public void setBrand(String b) {
		brand = b;
	}

	public void setBatchCode(String bc) {
		batchCode = bc;
	}

	public void setUnitPrice(BigDecimal up) {
		unitPrice = up;
	}

	public void setType(String t) {
		type = t;
	}

	public void setDetails(String d) {
		details = d;
	}
//GETTER
	public int getGId() {
		return(gid);
	}

	public int getQuantity() {
		return(quantity);
	}

	public String getName() {
		return(name);
	}

	public String getBrand() {
		return(brand);
	}

	public String getBatchCode() {
		return(batchCode);
	}

	public BigDecimal getUnitPrice() {
		return(unitPrice);
	}

	public String getType() {
		return(type);
	}

	public String getDetails() {
		return(details);
	}
//METHODS
	public String toString() {
		return("<product><gid>"+getGId()+"</gid><quantity>"+getQuantity()+"</quantity><name>"+getName()+"</name><batchnumber>"+getBatchCode()+"</batchnumber><unitprice>"+getUnitPrice()+"</unitprice><type>"+getType()+"</type><details>"+getDetails()+"</details></product>");
	}
}
