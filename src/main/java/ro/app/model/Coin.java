package ro.app.model;

import java.io.Serializable;

public class Coin implements Serializable {
	private static final long serialVersionUID = -1896442016965636804L;
	
	private int denomination;

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denomination;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		if (denomination != other.denomination)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coin [denomination=" + denomination + "]";
	}
	
	
}
