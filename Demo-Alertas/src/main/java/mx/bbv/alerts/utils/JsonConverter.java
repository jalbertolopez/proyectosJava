package mx.bbv.alerts.utils;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Clase con metodos genericos para serializar objetos a su representacion en JSON y de una representacion JSON a un
 * objeto Java.
 * 
 * @author 
 * 
 */

public final class JsonConverter {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
		mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY, true);
		mapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

	/**
	 * Convierte una instancia de una clase a su representacion JSON.
	 * 
	 * @param obj
	 *            Objeto que sera serializado.
	 * @return Representacion en JSON del objeto recibido como parametro.
	 * @throws IOException
	 */
	public static <T> String toJson(T obj) throws IOException {
		String json = null;

		try {
			json = mapper.writeValueAsString(obj);
		}
		catch (JsonGenerationException jge) {
			throw new IOException(jge);
		}
		catch (JsonMappingException jme) {
			throw new IOException(jme);
		}

		if (json.equals("null"))
			return "";

		return json;
	}

	/**
	 * Convierte una representacion JSON a una instancia de la clase con la que se manda llamar.
	 * 
	 * @param json
	 *            Respresentacion JSON de una instancia de la clase con la que se manda llamar.
	 * @param cl
	 *            Clase de la cual se generara la instancia.
	 * @return Objeto de la clase con la que se manda llamar.
	 * @throws IOException
	 */
	public static <T> T fromJson(String json, Class<T> cl) throws IOException {
		T obj = null;

		try {
			obj = (T) mapper.readValue(json, cl);
		}
		catch (JsonParseException je) {
			throw new IOException(je);
		}

		return obj;
	}

	/**
	 * Convierte una representacion JSON a una instancia de la clase con la que se manda llamar.
	 * 
	 * @param json
	 *            Respresentacion JSON de una instancia de la clase con la que se manda llamar.
	 * @param className
	 *            Nombre de la clase de la cual se generara la instancia.
	 * @return Objeto de la clase con la que se manda llamar.
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String json, String className) throws IOException {
		T obj = null;

		try {
			Class<T> cl = (Class<T>) Class.forName(className);
			obj = (T) mapper.readValue(json, cl);
		}
		catch (JsonParseException je) {
			throw new IOException(je);
		}
		catch (ClassNotFoundException cne) {
			throw new IOException(cne);
		}

		return obj;
	}

	/**
	 * Convierte una representacion JSON a una Mapa.
	 * 
	 * @param json
	 *            Respresentacion JSON de una instancia.
	 * @return Mapa.
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> mapFromJson(String json) throws IOException {
		Map<String, Object> map;

		try {
			map = mapper.readValue(json, Map.class);
		}
		catch (JsonParseException je) {
			throw new IOException(je);
		}

		return map;
	}

}
