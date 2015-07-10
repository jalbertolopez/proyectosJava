package mx.bbv.alerts.catalogs;

/*
 * CATÁLOGO PARA ETIQUETAR EL GRADO DE RIESGO
 * */
public enum AlertStatusEnum {
	UNKNOWN(0), UNRESOLVED(1), RESOLVED(2);

	private int id;

	AlertStatusEnum (int id) {
		this.id = id;
	}

	/**
	 * @see Metodo para evaluar el valor del enum de un numerico
	 * @param id
	 * @return
	 */
	public static AlertStatusEnum fromInt(int id) {

		if (id == UNRESOLVED.id)
			return UNRESOLVED;
		else if (id == RESOLVED.id)
			return RESOLVED;
		else
			return UNKNOWN;
	}

	/**
	 * @see MEtodo para obtener su valor numerico 
	 * @return
	 */
	public int toInt() {
		return this.id;
	}

}
