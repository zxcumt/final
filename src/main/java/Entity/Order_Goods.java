package Entity;


public class Order_Goods {
	private int id;
	private Orders order;
	private Goods good;
	private int number;
	private int size;
	private double sinplePrice;
    private int tier;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getSinplePrice() {
		return sinplePrice;
	}

	public void setSinplePrice(double sinplePrice) {
		this.sinplePrice = sinplePrice;
	}

	public Order_Goods() {
		super();
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public Order_Goods(Orders order,ShoppingCart shoppingCart) {
		super();
		this.order = order;
		this.good = shoppingCart.getGood();
		this.number= shoppingCart.getNumber();
		this.sinplePrice = shoppingCart.getSinplePrice();
		this.size=shoppingCart.getSize();
		this.tier=shoppingCart.getTier();
	}

}
