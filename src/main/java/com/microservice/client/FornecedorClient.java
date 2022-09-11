package com.microservice.client;

import com.microservice.dto.InfoFornecedorDTO;
import com.microservice.dto.InfoPedidoDTO;
import com.microservice.dto.ItemDaCompraDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @PostMapping("pedido")
    InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
