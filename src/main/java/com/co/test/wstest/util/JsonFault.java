package com.co.test.wstest.util;

import java.io.Serializable;

public class JsonFault implements Serializable{


		/**
		 * En cada servicio se debe cambiar!!!!
		 */
		private static final long serialVersionUID = 1L;

		private String identificador;

		private String fecha;

		private String nombre;

		private String operacion;

		private String canalLlamada;

		private transient Object request;

		private transient ErrorDetalle error;

		public String getIdentificador() {
			return identificador;
		}

		public void setIdentificador(String identificador) {
			this.identificador = identificador;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getOperacion() {
			return operacion;
		}

		public void setOperacion(String operacion) {
			this.operacion = operacion;
		}

		public String getCanalLlamada() {
			return canalLlamada;
		}

		public void setCanalLlamada(String canalLlamada) {
			this.canalLlamada = canalLlamada;
		}

		public Object getRequest() {
			return request;
		}

		public void setRequest(Object request) {
			this.request = request;
		}

		public ErrorDetalle getError() {
			return error;
		}

		public void setError(ErrorDetalle error) {
			this.error = error;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		static class ErrorDetalle {

			private Integer codigo;

			private String mensaje;

			private String detalle;

			public Integer getCodigo() {
				return codigo;
			}

			public void setCodigo(Integer codigo) {
				this.codigo = codigo;
			}

			public String getMensaje() {
				return mensaje;
			}

			public void setMensaje(String mensaje) {
				this.mensaje = mensaje;
			}

			public String getDetalle() {
				return detalle;
			}

			public void setDetalle(String detalle) {
				this.detalle = detalle;
			}
		}
}
