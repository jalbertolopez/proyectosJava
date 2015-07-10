package mx.bbv.alerts.rest.transforms;

import org.springframework.stereotype.Component;

import mx.bbv.alerts.rest.dto.*;
import mx.bbv.alerts.rest.model.*;

@Component
public class Transform2DTO {
	/*Metodo para obener una alerta pasándole el número de operaciones y si dentro de esas operaciones alguna es relevante */
	public AlertasDTO alertPOJO2AlertasDTO(AlertPOJO alert, int noOperaciones, boolean relevantes){
		AlertasDTO dto = new AlertasDTO();	
		dto.setIdAlerta(alert.getIdAlerta());
		dto.setFechaGen(alert.getFechaGen());
		dto.setIdCliente(alert.getIdCliente());
		dto.setCuenta(alert.getCuenta());
		dto.setMotivo(alert.getMotivo());
		dto.setMontoAcumulado(alert.getMontoAcumulado());
		dto.setEstatus(alert.getEstatus());
		dto.setRelevante(relevantes);
		dto.setNoOperaciones("" + noOperaciones);
		return dto;
	}
	
	/*Metodo para generar un objeto OperacionesDTO que será enviado al Front */
	public OperacionesDTO operationPOJO2OperacionDTO(OperationPOJO op){
		OperacionesDTO dto = new OperacionesDTO();	
		dto.setIdOperacion(op.getIdOperacion());
		dto.setFechaGen(op.getFechaGen());
		dto.setCuenta(op.getCuenta());
		dto.setMonto("" + op.getMonto());
		dto.setCrOp(op.getCr());
		dto.setTipo(op.getTipo());
		dto.setIdAlerta(op.getIdAlerta());
		return dto;
	}
	
	/*Metodo para generar un objeto tipo CuentasDTO que será enviado al Front */
	public CuentasDTO accountPOJO2CuentasDTO(AccountPOJO ac, CrPOJO cr){
		CuentasDTO dto = new CuentasDTO();			
		
		dto.setIdCuenta(ac.getCuenta());
		dto.setIdCliente(ac.getIdCliente());
		dto.setFechaGen(ac.getFechaGen());
		dto.setCrGestor(ac.getCr());
		dto.setNomSucursal(cr.getNomSucursal());
		dto.setCenSup(cr.getCenSup());
		dto.setDivision(cr.getDivision());
		dto.setEstado(cr.getEstado());
		
		return dto;
	}
	
	/*Metodo para generar un objeto tipo OperacionesRelevantesDTO que será enviado al Front */
	public OperacionesRelevantesDTO relevantOpPOJO2OperacionesRelevantesDTO(RelevantOpPOJO rOp , OperationPOJO op){
		OperacionesRelevantesDTO dto = new OperacionesRelevantesDTO();			
		
		dto.setIdCuenta(op.getCuenta());
		dto.setFechaGen(op.getFechaGen());
		dto.setFolio(rOp.getFolio());
		dto.setTipo(op.getTipo());
		dto.setOficina(op.getCr());
		dto.setIdOperacion(rOp.getIdOperacion());
		dto.setClasificacion(rOp.getClasificacion());
		dto.setMonto("" + op.getMonto());
		
		return dto;
	}
	
	/*Metodo para generar un objeto tipo CrsDTO que será enviado al Front */
	public CrInfoDTO crPOJO2CrInfoDTO(CrPOJO cr){
		CrInfoDTO dto = new CrInfoDTO();			
		dto.setIdCr(cr.getCr());
		dto.setNomSucursal(cr.getNomSucursal());
		dto.setCenSup(cr.getCenSup());
		dto.setDivision(cr.getDivision());
		dto.setEstado(cr.getEstado());		
		return dto;
	}
	
	/*Metodo para generar un objeto tipo ClientesDTO que será enviado al Front */
	public ClientesDTO clientPOJO2CrInfoDTO(ClientPOJO c){
		ClientesDTO dto = new ClientesDTO();			
		dto.setIdCliente(c.getIdCliente());
		dto.setNombres(c.getNombres());
		dto.setApellidos(c.getApellidos());
		dto.setTipoPersona(c.getTipoPersona());
		dto.setFechaAlta(c.getFechaAlta());
		return dto;
	}
}
