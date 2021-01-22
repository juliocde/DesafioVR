package br.com.vr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VencimentoPedidoDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idVencimentoPedido;
	
	private String idPedido;
	
	private String  data;

	public String getIdVencimentoPedido() {
		return idVencimentoPedido;
	}

	public void setIdVencimentoPedido(String idVencimentoPedido) {
		this.idVencimentoPedido = idVencimentoPedido;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((idVencimentoPedido == null) ? 0 : idVencimentoPedido.hashCode());
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
		VencimentoPedidoDto other = (VencimentoPedidoDto) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		if (idVencimentoPedido == null) {
			if (other.idVencimentoPedido != null)
				return false;
		} else if (!idVencimentoPedido.equals(other.idVencimentoPedido))
			return false;
		return true;
	}

	
	
	
	
}
