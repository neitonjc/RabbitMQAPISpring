package com.api.consumer.model.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TituloReceberRepId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="CD_EMPRESA")
	private Long cdEmpresa;
	
	@Column(name="CD_FILIAL")
	private Long cdFilial;
	
	@Column(name="NR_TITULO")
	private Long nrTitulo;
	
	@Column(name="NR_PARCELA")
	private Long nrParcela;
	
	public TituloReceberRepId() {
		super();
	}
	
	public TituloReceberRepId(Long cdEmpresa, Long cdFilial, Long nrTitulo, Long nrParcela) {
		super();
		this.cdEmpresa = cdEmpresa;
		this.cdFilial = cdFilial;
		this.nrTitulo = nrTitulo;
		this.nrParcela = nrParcela;
	}
	public Long getCdEmpresa() {
		return cdEmpresa;
	}
	public void setCdEmpresa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	public Long getCdFilial() {
		return cdFilial;
	}
	public void setCdFilial(Long cdFilial) {
		this.cdFilial = cdFilial;
	}
	public Long getNrTitulo() {
		return nrTitulo;
	}
	public void setNrTitulo(Long nrTitulo) {
		this.nrTitulo = nrTitulo;
	}
	public Long getNrParcela() {
		return nrParcela;
	}
	public void setNrParcela(Long nrParcela) {
		this.nrParcela = nrParcela;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEmpresa == null) ? 0 : cdEmpresa.hashCode());
		result = prime * result + ((cdFilial == null) ? 0 : cdFilial.hashCode());
		result = prime * result + ((nrParcela == null) ? 0 : nrParcela.hashCode());
		result = prime * result + ((nrTitulo == null) ? 0 : nrTitulo.hashCode());
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
		TituloReceberRepId other = (TituloReceberRepId) obj;
		if (cdEmpresa == null) {
			if (other.cdEmpresa != null)
				return false;
		} else if (!cdEmpresa.equals(other.cdEmpresa))
			return false;
		if (cdFilial == null) {
			if (other.cdFilial != null)
				return false;
		} else if (!cdFilial.equals(other.cdFilial))
			return false;
		if (nrParcela == null) {
			if (other.nrParcela != null)
				return false;
		} else if (!nrParcela.equals(other.nrParcela))
			return false;
		if (nrTitulo == null) {
			if (other.nrTitulo != null)
				return false;
		} else if (!nrTitulo.equals(other.nrTitulo))
			return false;
		return true;
	}
	
	
}
