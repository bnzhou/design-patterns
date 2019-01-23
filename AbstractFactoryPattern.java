// More than one products
// More than one factory to create the product

class AbstractFactoryPattern {
	public static void main(String[] args) {
		// know the factory
		PaymentFacotory pf = new VisaApplePayFactory();
		
		// know what I want
		Card c = pf.getCard();
		POS p = pf.getPOS();
		
		System.out.println(c.getCardNum());
		System.out.println(p.getPosType());
	}
}

// Object interface
interface Card {
	public String getCardNum();
}

interface POS {
	public String getPosType();
}

// Object implementation
class VisaCard implements Card {
	
	@Override
	public String getCardNum() {
		return new String("Visa");
	}
}

class ApplePay implements POS {
	
	@Override
	public String getPosType() {
		return new String("ApplePay");
	}
}

// Abstract Factory (super factory)

interface PaymentFacotory {
	public Card getCard();
	public POS getPOS();
}

// Sub factories
class VisaApplePayFactory implements PaymentFacotory {
	
	@Override
	public Card getCard() {
		return new VisaCard();
	}
	
	@Override
	public POS getPOS() {
		return new ApplePay();
	}
}