package com.intercorp.clienteservice.api;

public class EstadisticaClienteResponse {

    private Double promedio;
    private Double desviacion;

    public void setDesviacion(Double desviacion) {
        this.desviacion = desviacion;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getDesviacion() {
        return desviacion;
    }

    public Double getPromedio() {
        return promedio;
    }
}
