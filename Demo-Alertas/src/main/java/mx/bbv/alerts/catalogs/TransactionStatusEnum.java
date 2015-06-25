package mx.bbv.alerts.catalogs;

/*
 * CATÁLOGO PARA ETIQUETAR EL GRADO DE RIESGO
 * */
public enum TransactionStatusEnum {
	UNKNOWN(0), OK(1), WARNING(2), DANGER(3);

	private int id;

	TransactionStatusEnum (int id) {
		this.id = id;
	}

	/**
	 * @see Metodo para evaluar el valor del enum de un numerico
	 * @param id
	 * @return
	 */
	public static TransactionStatusEnum fromInt(int id) {

		if (id == OK.id)
			return OK;
		else if (id == WARNING.id)
			return WARNING;
		else if (id == DANGER.id)
			return DANGER;
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
