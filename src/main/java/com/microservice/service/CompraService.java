package com.microservice.service;

import com.microservice.client.FornecedorClient;
import com.microservice.dto.CompraDTO;
import com.microservice.dto.InfoFornecedorDTO;
import com.microservice.dto.InfoPedidoDTO;
import com.microservice.model.Compra;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    private FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public Compra realizaCompra(CompraDTO compra) {

        InfoFornecedorDTO infoPorEstado = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizaPedido(compra.getItens());

        System.out.println(infoPorEstado.getEndereco());

        return new Compra(infoPedidoDTO.getId(), infoPedidoDTO.getTempoDePreparo(), compra.getEndereco().toString());

    }
}
