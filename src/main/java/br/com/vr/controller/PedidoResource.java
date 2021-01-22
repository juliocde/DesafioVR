package br.com.vr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.vr.model.*;
import br.com.vr.repository.PedidoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/pedidos")
@Api("Api REST Pedidos")
@CrossOrigin(origins = "*")
public class PedidoResource {

	@Autowired
	private PedidoRepository pedidoRepository;


   @GetMapping("/consultar/{idPedido}")
   @ApiOperation(value = "Método para consulta de um pedido específico")
   public ResponseEntity<PedidoVO> consultar(@PathVariable(value = "idPedido") String idPedido) {
	   Optional<PedidoVO> pedido = pedidoRepository.findById(idPedido);
       if(pedido.isPresent())
           return new ResponseEntity<PedidoVO>(pedido.get(), HttpStatus.OK);
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);	   
	   
	}

   @GetMapping(value = "/listar")   
   @ApiOperation(value = "Método para listar pedidos")
   public ResponseEntity<List<PedidoVO>> listar(PedidoListarDto pedidoListarDto) {
		//Pode ser paginado...
	   List<PedidoVO> listaPedido = pedidoRepository.findAll();
       if(!listaPedido.isEmpty())
    	// HttpStatus.PARTIAL_CONTENT pode ser usado para respostas com paginação
           return new ResponseEntity<List<PedidoVO>>(listaPedido, HttpStatus.PARTIAL_CONTENT);
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
	
   @PostMapping(value = "/criar")
   @ApiOperation(value = "Método para criar de um pedido")
   @ResponseStatus(HttpStatus.CREATED)
	public PedidoVO criar(@RequestBody PedidoVO pedido) {
		return pedidoRepository.save(pedido);
	}
	
   
   @PutMapping(value = "/alterar/{idPedido}")
   @ApiOperation(value = "Método para alterar de um pedido específico")
	public ResponseEntity<PedidoVO> alterar(@PathVariable(value = "idPedido") String idPedido, @RequestBody PedidoVO novoPedido) {
	   
	   Optional<PedidoVO> oldPedido = pedidoRepository.findById(idPedido);
       if(oldPedido.isPresent()){
    	   PedidoVO pedido = oldPedido.get();
           pedido.setValor(novoPedido.getValor());
           pedidoRepository.save(pedido);
           return new ResponseEntity<PedidoVO>(pedido, HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
   @DeleteMapping(value = "/excluir/{id}")
   @ApiOperation(value = "Método para excluir de um pedido específico")
   public ResponseEntity<Object> Delete(@PathVariable(value = "id") String idPedido)
   {
       Optional<PedidoVO> pessoa = pedidoRepository.findById(idPedido);
       if(pessoa.isPresent()){
           pedidoRepository.delete(pessoa.get());
           return new ResponseEntity<>(HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
	
   @PutMapping(value = "/atualizarStatus/{idPedido}")
   @ApiOperation(value = "Método para atualizar status")   
	public ResponseEntity<PedidoVO> atualizarStatus(@PathVariable(value = "idPedido") String idPedido, 
			@RequestBody Status status) {
	   Optional<PedidoVO> oldPedido = pedidoRepository.findById(idPedido);
       if(oldPedido.isPresent()){
    	   PedidoVO pedido = oldPedido.get();
    	   
           pedido.setStatus(status.getDescricao());
           
           pedidoRepository.save(pedido);
           return new ResponseEntity<PedidoVO>(pedido, HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
   
   @PutMapping(value = "/atualizarVencimentoPedido/{idPedido}")
   @ApiOperation(value = "Método para atualizar data de vencimento")
	public ResponseEntity<PedidoVO> atualizarVencimentoPedido(@PathVariable(value = "idPedido") String idPedido, 
			@RequestBody VencimentoPedidoDto vencimentoPedidoDto) {
	   Optional<PedidoVO> oldPedido = pedidoRepository.findById(idPedido);
       if(oldPedido.isPresent()){
    	   PedidoVO pedido = oldPedido.get();
    	   
           pedido.setDataVencimento(vencimentoPedidoDto.getData());
           
           pedidoRepository.save(pedido);
           return new ResponseEntity<PedidoVO>(pedido, HttpStatus.OK);
       }
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
  

}

