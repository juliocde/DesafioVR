package br.com.vr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vr.model.PedidoVO;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoVO, String>{

}
