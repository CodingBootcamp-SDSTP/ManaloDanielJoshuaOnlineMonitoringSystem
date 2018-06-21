import java.math.BigDecimal;

public class Goods
{
	private final int GOODSID;
	private int quantity;
	private String name;
	private String codeName;
	private String branchCode;
	private String brand;
	private String batchCode;
	private BigDecimal unitPrice;
	private String type;
	private String details;

	public Goods(int goodsId, int quantity, String name, String codeName, String branchCode, String brand, String batchCode, BigDecimal unitPrice, String type, String details) {
		GOODSID = goodsId;
		this.quantity = quantity;
		this.name = name;
		this.codeName = codeName;
		this.branchCode = branchCode;
		this.brand = brand;
		this.batchCode = batchCode;
		this.unitPrice = unitPrice;
		this.type = type;
		this.details = details;
	}
//SETTER
	public void setQuantity(int qty) {
		quantity = qty;
	}

	public void setName(String n) {
		name = n;
	}

	public void setCodeName(String code) {
		codeName = code;
	}

	public void setBranchCode(String bc) {
		branchCode = bc;
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
	public int getGoodsId() {
		return(GOODSID);
	}

	public int getQuantity() {
		return(quantity);
	}

	public String getName() {
		return(name);
	}

	public String getCodeName() {
		return(codeName);
	}

	public String getBranchCode() {
		return(branchCode);
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
		return("<product><goodsid>"+getGoodsId()+"</goodsid><quantity>"+getQuantity()+"</quantity><name>"+getName()+"</name><codename>"+getCodeName()+"</codename><branchcode>"+getBranchCode()+"</branchcode><batchnumber>"+getBatchCode()+"</batchnumber><unitprice>"+getUnitPrice()+"</unitprice><type>"+getType()+"</type><details>"+getDetails()+"</details></product>");
	}
}
