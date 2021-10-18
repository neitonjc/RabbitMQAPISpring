package com.api.consumer.listener;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.rabbitmq.dto.TituloReceberDTO;
import com.rmq.demoConsumer.model.TituloReceberRep;
import com.rmq.demoConsumer.model.id.TituloReceberRepId;
import com.rmq.demoConsumer.service.TituloReceberService;

@Component
public class TituloReceberListener {
	
	@Autowired
	TituloReceberService service;
	
	@RabbitListener(queues = "fila_teste")
	private void incluir(TituloReceberDTO tituloReceberDTO) throws Exception {
		TituloReceberRepId tituloReceberRepId = new TituloReceberRepId(tituloReceberDTO.cdEmpresa, 
																		tituloReceberDTO.cdFilial, 
																		tituloReceberDTO.nrTitulo, 
																		tituloReceberDTO.nrParcela);
		service.incluir(new TituloReceberRep(tituloReceberRepId, 
											 tituloReceberDTO.cdTipoDocumento, 
											 tituloReceberDTO.cdPessoa, 
											 convertStringToDate(tituloReceberDTO.dtEmissao), 
											 convertStringToDate(tituloReceberDTO.dtEntrada), 
											 tituloReceberDTO.ieProvisiona,
											 convertStringToDate(tituloReceberDTO.dtVencimento), 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlTitulo), 
											 covertDoubleToBigDecimal(tituloReceberDTO.vlTotalNota), 
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
