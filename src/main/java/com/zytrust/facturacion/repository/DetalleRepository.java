package com.zytrust.facturacion.repository;
/*
 * @(#)DetalleRepository.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta interfaz representa a un DetalleRepository y debe ser usada para
 * almacenar datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import com.zytrust.facturacion.dto.DetalleDTO;
import com.zytrust.facturacion.model.Detalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle,String> {

    List<DetalleDTO> findAllByFacturaId(String id);
}
