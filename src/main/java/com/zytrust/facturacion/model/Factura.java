package com.zytrust.facturacion.model;
/*
 * @(#)Factura.java
 *
 * Copyright 2019 ZyTrust SA, Todos los derechos reservados.
 * ZT PROPRIETARIO/CONFIDENTIALIDAD. Su uso está sujeto a los
 * términos de la licencia adquirida a ZyTrust SA.
 * No se permite modificar, copiar ni difundir sin autorización
 * expresa de ZyTrust SA.
 */
/**
 * Esta clase representa a una factura y debe ser usada para almacenar
 * datos e intercambiarlos con otros objetos.
 *
 * @author Sergio Alva
 * @version 1.00, 04/02/2022
 */

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@Entity
@Table (name = "FAC_Facturas")
public class Factura {

    @Id
    @Column(name = "FACT_ID")
    /**Identificador de la factura*/
    private String id;

    @ManyToOne
    @JoinColumn(name="CLI_ID")
    @JsonIgnoreProperties({"nombres","apellidos","dni","telefono","ruc",
            "razonSocial","direccion"})
    /**Identificador del cliente*/
    private Cliente cliente;

    @Column(name = "FACT_ESTADO")
    /**Estado de la factura*/
    private String estado = "ingresado";

    @Column(name = "FACT_FECHA_EMISION")
    /**Fecha de emision de la factura*/
    private LocalDate fechaEmision = LocalDate.now();

    @Column(name = "FACT_FECHA_VENCIMIENTO")
    /**Fecha de vencimiento de la factura*/
    private LocalDate fechaVencimiento;

    @Column(name = "FACT_FECHA_PAGO")
    /**Fecha de pago de la factura*/
    private LocalDate fechaPago;

    @Column(name = "FACT_TIPO_PAGO")
    /**Tipo de pago de la factura*/
    private String tipoPago;

    @Column(name = "FACT_SUBTOTAL", precision = 7,scale = 2,nullable = false)
    /**Subtotal de la factura*/
    private BigDecimal subtotal= BigDecimal.valueOf(0);

    @Column(name = "FACT_IMPUESTO", precision = 7,scale = 2,nullable = false)
    /**Impuesto de la factura*/
    private BigDecimal impuesto= BigDecimal.valueOf(0);

    @Column(name = "FACT_TOTAL", precision = 7,scale = 2,nullable = false)
    /**Total de la factura*/
    private BigDecimal total = BigDecimal.valueOf(0);

}
