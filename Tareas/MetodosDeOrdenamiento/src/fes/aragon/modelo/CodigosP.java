package fes.aragon.modelo;

public class CodigosP {
	private String d_codigo;
	private String d_asenta;
	private String d_tipo_asenta;
	private String D_mnpio;
	private String d_estado;
	private String d_ciudad;
	private String d_CP;
	private String c_estado;
	private String c_oficina;
	private String c_CP;
	private String c_tipo_asenta;
	private String c_mnpio;
	private String id_asenta_cpcons;
	private String d_zona;
	private String c_cve_ciudad;

	public CodigosP(String d_codigo, String d_asenta, String d_tipo_asenta, String d_mnpio, String d_estado,
			String d_ciudad, String d_CP, String c_estado, String c_oficina, String c_CP, String c_tipo_asenta,
			String c_mnpio, String id_asenta_cpcons, String d_zona, String c_cve_ciudad) {
		super();
		this.d_codigo = d_codigo;
		this.d_asenta = d_asenta;
		this.d_tipo_asenta = d_tipo_asenta;
		D_mnpio = d_mnpio;
		this.d_estado = d_estado;
		this.d_ciudad = d_ciudad;
		this.d_CP = d_CP;
		this.c_estado = c_estado;
		this.c_oficina = c_oficina;
		this.c_CP = c_CP;
		this.c_tipo_asenta = c_tipo_asenta;
		this.c_mnpio = c_mnpio;
		this.id_asenta_cpcons = id_asenta_cpcons;
		this.d_zona = d_zona;
		this.c_cve_ciudad = c_cve_ciudad;
	}

	public CodigosP(String d_asenta) {
		this.d_asenta = d_asenta;
	}

	public String getD_codigo() {
		return d_codigo;
	}

	public String getD_asenta() {
		return d_asenta;
	}

	public String getD_tipo_asenta() {
		return d_tipo_asenta;
	}

	public String getD_mnpio() {
		return D_mnpio;
	}

	public String getD_estado() {
		return d_estado;
	}

	public String getD_ciudad() {
		return d_ciudad;
	}

	public String getD_CP() {
		return d_CP;
	}

	public String getC_estado() {
		return c_estado;
	}

	public String getC_oficina() {
		return c_oficina;
	}

	public String getC_CP() {
		return c_CP;
	}

	public String getC_tipo_asenta() {
		return c_tipo_asenta;
	}

	public String getC_mnpio() {
		return c_mnpio;
	}

	public String getId_asenta_cpcons() {
		return id_asenta_cpcons;
	}

	public String getD_zona() {
		return d_zona;
	}

	public String getC_cve_ciudad() {
		return c_cve_ciudad;
	}

	@Override
	public String toString() {
		return d_codigo + "|" + d_asenta + "|" + d_asenta + "|" + d_tipo_asenta + "|" + D_mnpio + "|" + d_estado + "|"
				+ d_ciudad + "|" + d_CP + "|" + c_estado + "|" + c_oficina + "|" + c_CP + "|" + c_tipo_asenta + "|"
				+ c_mnpio + "|" + id_asenta_cpcons + "|" + d_zona + "|" + c_cve_ciudad;
	}
//	@Override
//	public String toString() {
//		return  d_asenta;
//	}

}
