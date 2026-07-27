package dto;

public class ProductDto {
	
	private String p_code;
	private String p_name;
	private int price;
	private int stock;
	
	public ProductDto(String p_code, String p_name, int price, int stock) {
		this.p_code = p_code;
		this.p_name = p_name;
		this.price = price;
		this.stock = stock;
	}

	public ProductDto() {
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
