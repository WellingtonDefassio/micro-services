package com.microservice.service;

import com.microservice.client.FornecedorClient;
import com.microservice.dto.CompraDTO;
import com.microservice.dto.InfoFornecedorDTO;
import com.microservice.dto.InfoPedidoDTO;
import com.microservice.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
    private FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public Compra realizaCompra(CompraDTO compra) {

        String estado = compra.getEndereco().getEstado();
        LOG.info("buscando informações do fornecedor de {}", estado);
        InfoFornecedorDTO infoPorEstado = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        LOG.info("realizando um pedido");
        InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizaPedido(compra.getItens());

        System.out.println(infoPorEstado.getEndereco());

        return new Compra(infoPedidoDTO.getId(), infoPedidoDTO.getTempoDePreparo(), compra.getEndereco().toString());

    }
}
