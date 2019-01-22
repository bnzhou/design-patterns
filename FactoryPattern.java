class FactoryPattern {
	
	public static void main(String[] args) {
		// use the factory to create the object
		SaleFactory factory = new SaleFactory();
		Sale sale = factory.getSale("Thanksgiving");
				
		// use the newly created object using a common interface
		System.out.println("Sale discount is: " + (100 - sale.getDiscount() * 100) + "%"); 
	}
}

// Factory - to create the object

class SaleFactory {
	
	public Sale getSale(String type) {
		switch (type) {
			case "Thanksgiving":
				return new ThanksgivingSale();
			default:
				return new RegularSale();
		}
	}
}

// Common interface - describe the object that we want to create

interface Sale {
	double getDiscount();
}

// Interface implementations

class RegularSale implements Sale {
	
	@Override
	public double getDiscount() {
		return 0.9;
	}
}

class MemberSale implements Sale {
	
	@Override
	public double getDiscount() {
		return 0.85;
	}
	
}

class ThanksgivingSale implements Sale {
	
	@Override
	public double getDiscount() {
		return 0.6;
	}
}

