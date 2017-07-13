/**
 * 
 */
package Entity;


public class Goods {
	private int id;
	private double presentprice;
	private String name;
	private double pastprice;
	private String image;
	private String content;//描述
	private String image2;
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPresentprice() {
		return presentprice;
	}

	public void setPresentprice(double presentprice) {
		this.presentprice = presentprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPastprice() {
		return pastprice;
	}

	public void setPastprice(double pastprice) {
		this.pastprice = pastprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Goods() {
		super();
	}

	public Goods(double presentprice, String name, String image) {
		super();
		this.presentprice = presentprice;
		this.name = name;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", presentprice=" + presentprice + ", name=" + name + ", pastprice=" + pastprice
				+ ", image=" + image + ", content=" + content + ", image2=" + image2 + "]";
	}



	

}
