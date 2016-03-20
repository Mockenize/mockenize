package org.mockenize.model;

import java.util.Collections;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.mockenize.repository.Cacheable;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class MockBean implements Cacheable {

	private static final String _ = "_";

	private static final String SLASH = "/";

	@NotNull
	private String key;

	@NotNull
	private String path;

	@NotNull
	private String method;

	private Map<String, String> headers = Collections.emptyMap();

	private JsonNode body;

	@NotNull
	private Integer status = 200;

	private int timeout = 0;

	private int minTimeout = 0;

	private int maxTimeout = 0;

	private String scriptName;

	public String getKey() {
		return method.concat(path.replaceAll(SLASH, _));
	}

	public void setPath(String path) {
		if (path != null && !path.startsWith(SLASH)) {
			path = SLASH + path;
		}
		this.path = path;
	}

}
