package util;

import com.google.gson.Gson;

public class JSONUtil {
	
	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> class1) {
		return gson.fromJson(jsonString, class1);
	}

}
