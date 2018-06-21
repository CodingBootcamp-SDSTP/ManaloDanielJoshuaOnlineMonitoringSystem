import java.util.ArrayList;
import java.math.BigDecimal;

public class GoodsCollection
{
	private ArrayList<Goods> goods;

	public GoodsCollection() {
		goods = new ArrayList<Goods>();
	}

	public void addGoods(Goods g) {
		goods.add(g);
	}

	public void removeGoods(Goods g) {
		goods.remove(g);
	}

	public ArrayList<Goods> getAllGoods() {
		return(goods);
	}

	public Goods getGoodsByIndex(int n) {
		return(goods.get(n));
	}

	public int getGoodsCount() {
		return(goods.size());
	}

	public Goods getGoodsById(String id) {
		Goods g = null;
		for(int i = 0; i < getGoodsCount(); i++) {
			if(Integer.toString(getGoodsByIndex(i).getGoodsId()).equalsIgnoreCase(id)) {
				g = getGoodsByIndex(i);
				break;
			}
		}
		return(g);
	}

	public ArrayList<Goods> search(String s) {
		Goods g = null;
		ArrayList<Goods> gl = new ArrayList<Goods>();
		String str = s.toLowerCase();
		for(int i=0; i<getGoodsCount(); i++) {
			g = getGoodsByIndex(i);
			if(matches(g, str)) {
				gl.add(g);
			}
		}
		return(gl);
	}

	public boolean matches(Goods go, String st) {
		String gId = Integer.toString(go.getGoodsId()).toLowerCase();
		String qty = Integer.toString(go.getQuantity()).toLowerCase();
		String name = go.getName()!=null ? go.getName().toLowerCase() : "";
		String cname = go.getCodeName()!=null ? go.getCodeName().toLowerCase() : "";
		String branchcode = go.getBranchCode()!=null ? go.getBranchCode().toLowerCase() : "";
		String brand = go.getBrand()!=null ? go.getBrand().toLowerCase() : "";
		String batchcode = go.getBatchCode()!=null ? go.getBatchCode().toLowerCase() : "";
		String up = go.getUnitPrice()!=null ? String.valueOf(go.getUnitPrice()).toLowerCase() : "";
		String type = go.getType()!=null ? go.getType().toLowerCase() : "";
		String details = go.getDetails()!=null ? go.getDetails().toLowerCase() : "";
		if(gId.contains(st) || qty.contains(st) || name.contains(st) || cname.contains(st) || branchcode.contains(st) || brand.contains(st) || batchcode.contains(st) || up.contains(st) || type.contains(st) || details.contains(st)) {
			return(true);
		}
		return(false);
	}
}
