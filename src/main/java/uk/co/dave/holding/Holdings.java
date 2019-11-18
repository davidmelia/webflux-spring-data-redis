
package uk.co.dave.holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Holdings", propOrder = { "holding" })
public class Holdings {

	protected List<Holding> holding;

	public List<Holding> getHolding() {
		if (holding == null) {
			holding = new ArrayList<Holding>();
		}
		return this.holding;
	}

	public Holdings withHolding(Holding... values) {
		if (values != null) {
			for (Holding value : values) {
				getHolding().add(value);
			}
		}
		return this;
	}

	public Holdings withHolding(Collection<Holding> values) {
		if (values != null) {
			getHolding().addAll(values);
		}
		return this;
	}
}
