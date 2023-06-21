package add.product;

public class Product {
	private int id;
	private String image;
	private String name;
	private String price;
	private String code;
	private String description;
	
	public Product(int id, String image, String name, String price, String code, String description) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.price = price;
		this.code = code;
		this.description = description;
	}



	public Product() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public static void add(Product p) {
		// TODO Auto-generated method stub
		
	}





	
}
