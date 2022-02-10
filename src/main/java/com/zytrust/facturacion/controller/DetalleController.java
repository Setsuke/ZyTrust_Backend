package com.zytrust.facturacion.controller;
/*
 * @(#)DetalleController.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a un DetalleController y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.model.Detalle;
import com.zytrust.facturacion.model.Factura;
import com.zytrust.facturacion.model.Producto;
import com.zytrust.facturacion.repository.DetalleRepository;
import com.zytrust.facturacion.service.DetalleService;
import com.zytrust.facturacion.service.FacturaService;
import com.zytrust.facturacion.service.ProductoService;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;

    @PostMapping("/detalle")
    private ResponseEntity<Detalle> guardaDetalle (
            @RequestBody Detalle detalle){
        Detalle temp = detalleService.create(detalle);
        try{
            return ResponseEntity.created(
                            new URI("/detalle"+temp.getNumero()))
                    .body(temp);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/detalles")
    private ResponseEntity<List<Detalle>> listaDetalles (){
        return ResponseEntity.ok(detalleService.getAllDetalles());
    }

    @DeleteMapping("/detalle")
    private ResponseEntity<List<Detalle>> eliminaDetalle (
            @RequestBody Detalle detalle){
        detalleService.delete(detalle);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detalle/{numero}")
    private ResponseEntity<Optional<Detalle>> buscaDetalle (
            @PathVariable ("numero") String numero){
        return ResponseEntity.ok(detalleService.findById(numero));
    }
}
