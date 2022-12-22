package training.week3;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableTestClass {
	private final String property1;
	private final int property2;
	private final Map<String, String> property3;

	public ImmutableTestClass(String property1, int property2, Map<String, String> property3) {
		super();
		this.property1 = property1;
		this.property2 = property2;

		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : property3.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.property3 = tempMap;
	}

	public String getProperty1() {
		return property1;
	}

	public int getProperty2() {
		return property2;
	}

	public Map<String, String> getProperty3() {
		Map<String, String> tempMap = new HashMap<>();

		for (Map.Entry<String, String> entry : this.property3.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}

}
