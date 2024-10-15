package wallet;
 import java.lang.invoke.MethodHandles; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Money class
 */
public class Money {
	private Currency_t currency=Currency_t.BRL;
	private double amount;
	private static Logger moneyLogger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
	
	/**
	 * Class constructor specifying the amount of money and the currency 
	 * @param amount
	 * @param currency
	 */
	public Money(double amount, Currency_t currency) {		
		setAmount(amount);
		this.currency = currency;
		moneyLogger.info("A new money was created!");
	}

	public Currency_t getCurrency() {return currency;}
	
	public void setCurrency(Currency_t currency) {this.currency=currency;}
	
	public double getAmount() {return this.amount;}
	
	/**
	 * Change the amount of money. The value must be between 0.01 and 2 billion
	 * @param amount
	 */
	protected void setAmount(double amount) {
		if(amount < 0.01) {
			throw new IllegalArgumentException("Amount of monye cannot be lesser then 1 cent ($0.01)");
		}
		else if(amount > 2000000000) {
			throw new IllegalArgumentException("Amount of monye cannot be bigger then 2 billion($2000000000.00)");
		}
		this.amount=((int)Math.round(amount*100))/100;
	}
	
	/**
	 * Check if given currency match that of the current money
	 * @param currencyToCheck
	 * @return true if matches
	 */
	public boolean currencyMatch(Currency_t currencyToCheck) {
		if(this.getCurrency() == currencyToCheck) {
			return true;
		}
		return false;
	}
}
