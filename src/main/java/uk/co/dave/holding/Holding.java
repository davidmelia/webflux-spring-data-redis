package uk.co.dave.holding;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Holding", propOrder = { "instrument", "quantity", "depotQuantity" })
public class Holding {

	protected Instrument instrument;

	@XmlAttribute(name = "quantity")
	protected BigDecimal quantity;
	@XmlAttribute(name = "availableSettledQuantity")
	protected BigDecimal availableSettledQuantity;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument value) {
		this.instrument = value;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal value) {
		this.quantity = value;
	}

	public BigDecimal getAvailableSettledQuantity() {
		return availableSettledQuantity;
	}

	public void setAvailableSettledQuantity(BigDecimal value) {
		this.availableSettledQuantity = value;
	}

}
