package com.api.consumer.listener;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.consumer.dto.TituloReceberDTO;
import com.api.consumer.model.TituloReceberRep;
import com.api.consumer.model.id.TituloReceberRepId;
import com.api.consumer.service.TituloReceberService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TituloReceberListener {
	
	@Autowired
	TituloReceberService service;
	
	@RabbitListener(queues = "fila_titulo_receber")
	private void incluir(String json) throws Exception {
		TituloReceberDTO tituloReceberDTO = new ObjectMapper().readValue(json, TituloReceberDTO.class);
		
		TituloReceberRepId tituloReceberRepId = new TituloReceberRepId(tituloReceberDTO.cdEmpresa, 
																		tituloReceberDTO.cdFilial, 
																		tituloReceberDTO.nrTitulo, 
																		tituloReceberDTO.nrParcela);
		service.incluir(new TituloReceberRep(tituloReceberRepId, 
											 tituloReceberDTO.cdTipodocumento, 
											 tituloReceberDTO.cdPessoa, 
											 convertStringToDate(tituloReceberDTO.dtEmissao), 
											 convertStringToDate(tituloReceberDTO.dtEntrada), 
											 tituloReceberDTO.ieProvisiona,
											 convertStringToDate(tituloReceberDTO.dtVencimento), 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlTitulo), 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlTtotalNota), 
											 tituloReceberDTO.nrDocumento, 
											 tituloReceberDTO.cdSerie, 
											 tituloReceberDTO.cdPortador, 
											 tituloReceberDTO.cdFuncao, 
											 tituloReceberDTO.cdMoeda, 
											 tituloReceberDTO.ieTitulo, 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlSaldoTitulo), 
											 tituloReceberDTO.nmUsuario, 
											 getDtAtual(), 
											 tituloReceberDTO.ieTipoIncorporacao, 
											 tituloReceberDTO.cdBanco, 
											 tituloReceberDTO.cdAgencia, 
											 tituloReceberDTO.cdOperacaoBancaria, 
											 tituloReceberDTO.dsObservacao, 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlDesconto), 
											 tituloReceberDTO.cdContrato, 
											 tituloReceberDTO.cdTipoContrato, 
											 convertStringToDate(tituloReceberDTO.dtContabilProvisao), 
											 convertStringToDate(tituloReceberDTO.dtDebito), 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlMoedaParcela),
											 covertDoubleToBigDecimal(tituloReceberDTO.vlMoedaNota),
											 tituloReceberDTO.ieRecebimentoAntecipado,
											 tituloReceberDTO.cdCultura,
											 tituloReceberDTO.cdSafra,
											 tituloReceberDTO.cdCtb1,
											 tituloReceberDTO.cdTipoAtividade,
											 tituloReceberDTO.ieEnvioEquifax,
											 tituloReceberDTO.ieEnvioEmailCobranca,
											 tituloReceberDTO.nmUsuarioEmissor,
											 tituloReceberDTO.ieTituloPdd));
	}

	private BigDecimal covertDoubleToBigDecimal(Double vl) {
		if (vl != null)
			return BigDecimal.valueOf(vl);
		
		return null;
	}
	
	private Date convertStringToDate(String dtString) {
		if (dtString != null && !dtString.isEmpty()) {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return formato.parse(dtString);
			} catch (ParseException e) {
				e.printStackTrace();
				return null; 
			}
		} 
		
		return null;
		
	}
	
	private Date getDtAtual() {
		return Calendar.getInstance().getTime();
	}

}
